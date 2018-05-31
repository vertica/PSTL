/*
 * (c) Copyright [2018] Micro Focus or one of its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 



package org.apache.spark.sql.execution.streaming.vertica

import java.sql.{Connection, ResultSet}

import com.microfocus.pstl.utils.CloseableUtils

import scala.collection.mutable
import org.apache.avro.{Schema, SchemaBuilder}
import org.apache.kafka.common.TopicPartition
import org.apache.spark.internal.Logging
import org.apache.spark.sql.avro.AvroSchemaConverter
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.utils.StructTypeUtils

object VerticaCopyManager {
  case class CopyContext(offsets: Map[TopicPartition, Long],
                         schema: StructType,
                         state: IncrementalLoadState) {
    def avroSchema: Schema = {
      StructTypeUtils.assertDistinctColumnNames(schema)
      AvroSchemaConverter.convertStructToAvro(
        schema, SchemaBuilder.record("record"), "pstl")
    }
  }

  object KafkaOffsetRow {
    def fromResultSet(rs: ResultSet): KafkaOffsetRow = {
      KafkaOffsetRow(
        rs.getString("ktopic"),
        rs.getInt("kpartition"),
        rs.getLong("start_offset"),
        rs.getLong("end_offset"),
        rs.getLong("msg_count"),
        rs.getLong("bytes_read"),
        rs.getString("ending")
      )
    }
  }

  case class KafkaOffsetRow(topic: String,
                            partition: Int,
                            startOffset: Long,
                            endOffset: Long,
                            msgCount: Long,
                            bytesRead: Long,
                            ending: String)

  case class IncrementalLoadState(initialOffsets: Map[TopicPartition, Long],
                                  rows: Map[TopicPartition, KafkaOffsetRow]) {
    def +=(row: KafkaOffsetRow): IncrementalLoadState = {
      val partition = new TopicPartition(row.topic, row.partition)

      // shift end offset for scenarios where first batch loads no data and end offset
      // may be reported as an arbitrary number like -2 from vertica, we subtract 1
      // since callers will use findNextStartingOffset which accounts for the correct
      // end offset for the next copy command, etc.
      val adjustedRow = row.copy(
        endOffset = Math.max(initialOffsets(partition) - 1L, row.endOffset))

      if(rows.contains(partition)) {
        val existingRow = rows(partition)

        val newRow = existingRow.copy(
          endOffset = adjustedRow.endOffset,
          msgCount =  existingRow.msgCount + adjustedRow.msgCount,
          bytesRead = existingRow.bytesRead + adjustedRow.bytesRead,
          ending = adjustedRow.ending
        )

        copy(rows = rows + (partition -> newRow))
      }
      else {
        copy(rows = rows + (partition -> adjustedRow))
      }
    }

    def findStartingOffset(partition: TopicPartition): Long = {
      findRow(partition).startOffset
    }

    def findEndingOffset(partition: TopicPartition): Long = {
      findRow(partition).endOffset
    }

    def findNextStartingOffset(partition: TopicPartition): Long = {
      findRow(partition).endOffset + 1L
    }

    private def findRow(partition: TopicPartition): KafkaOffsetRow = {
      rows.getOrElse(partition,
        throw new IllegalStateException(s"row not found for $partition"))
    }
  }

  case class OffsetState(initialOffsets: Map[TopicPartition, Long],
                         loadedOffsets: Map[TopicPartition, Long]) {
    def +=(partition: TopicPartition, offset: Long): OffsetState = {
      copy(loadedOffsets = loadedOffsets + (partition -> offset))
    }
  }
}

class VerticaCopyManager(connection: Connection,
                         options: VerticaSinkOptions) extends Logging {

  import VerticaCopyManager._

  def finalizeCopy(context: CopyContext): IncrementalLoadState = {
    doCopy(generateCopySql(context)).foldLeft(context.state) {
      case (state, row) =>
        state += row
    }
  }

  def incrementalCopy(context: CopyContext): IncrementalLoadState = {
    doCopy(generateIncrementalCopySql(context)).foldLeft(context.state) {
      case (state, row) =>
        state += row
    }
  }

  private def doCopy(sql: String): Seq[KafkaOffsetRow] = {
    withCopy(sql) {
      withKafkaOffsets(KafkaOffsetRow.fromResultSet)
    }
  }

  private def withCopy[T](sql: String)(f: => T): T = {
    val copyStmt = connection.prepareStatement(sql)

    try {
      copyStmt.execute()
      f
    }
    finally {
      CloseableUtils.close(copyStmt)
    }
  }

  private def withKafkaOffsets[T](f: ResultSet => T): Seq[T] = {
    val sql = "SELECT KafkaOffsets() OVER()"
    val stmt = connection.prepareStatement(sql)

    try {
      val rs = stmt.executeQuery()

      try {
        val r = mutable.ArrayBuffer[T]()
        while(rs.next()) {
          r += f(rs)
        }
        r
      }
      finally {
        CloseableUtils.close(rs)
      }
    }
    finally {
      CloseableUtils.close(stmt)
    }
  }

  private def generateCopySql(context: CopyContext): String = {
    val stream = context.offsets.map(x =>
      s"${x._1.topic()}|${x._1.partition()}|${x._2}").mkString(",")

    s"""
       |COPY ${options.table}
       |SOURCE KafkaSource(
       |  brokers='${options.bootstrapServers}',
       |  stream='$stream',
       |  stop_on_eof=true,
       |  eof_timeout=INTERVAL'${options.copyEofTimeoutMs} milliseconds'
       |)
       |PARSER KafkaAvroParser(
       |  external_schema='${context.avroSchema}',
       |  flatten_records=true,
       |  flatten_maps=true,
       |  flatten_arrays=true
       |)
       |${options.copyOptions} NO COMMIT;
     """.stripMargin
  }

  private def generateIncrementalCopySql(context: CopyContext): String = {
    val stream = context.offsets.map(x =>
      s"${x._1.topic()}|${x._1.partition()}|${x._2}").mkString(",")

    s"""
       |COPY ${options.table}
       |SOURCE KafkaSource(
       |  brokers='${options.bootstrapServers}',
       |  stream='$stream',
       |  duration=INTERVAL'${options.copyDurationMs} milliseconds'
       |)
       |PARSER KafkaAvroParser(
       |  external_schema='${context.avroSchema}',
       |  flatten_records=true,
       |  flatten_maps=true,
       |  flatten_arrays=true
       |)
       |${options.copyOptions} NO COMMIT;
     """.stripMargin
  }
}
