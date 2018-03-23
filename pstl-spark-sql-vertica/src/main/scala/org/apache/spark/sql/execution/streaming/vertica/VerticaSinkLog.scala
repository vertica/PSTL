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

import java.io.Closeable
import java.sql.{Connection, SQLIntegrityConstraintViolationException}

import com.microfocus.pstl.utils.CloseableUtils
import org.apache.avro.SchemaBuilder

import scala.collection.mutable
import org.apache.spark.internal.Logging
import org.apache.spark.sql.avro.AvroSchemaConverter
import org.apache.spark.sql.execution.streaming.MetadataLog
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.utils.StructTypeUtils

object VerticaSinkLog {
  def addQuery(transactionTable: String): String =
    s"""
       |INSERT INTO $transactionTable(
       |  job_id,sink_id, batch_id, kafka_topic, kafka_partition, kafka_offset_from, kafka_offset_until)
       |VALUES(?, ?, ?, ?, ?, ?, ?)
     """.stripMargin

  def getQuery(transactionTable: String): String =
    s"""
       |SELECT
       |  kafka_topic,
       |  kafka_partition,
       |  kafka_offset_from,
       |  kafka_offset_until
       |FROM $transactionTable
       |WHERE job_id=? AND sink_id=? AND batch_id=?
     """.stripMargin

  def getLatestQuery(transactionTable: String): String =
    s"""
       |SELECT
       |  batch_id,
       |  kafka_topic,
       |  kafka_partition,
       |  kafka_offset_from,
       |  kafka_offset_until
       |FROM(
       |  SELECT
       |    batch_id,
       |    kafka_topic,
       |    kafka_partition,
       |    kafka_offset_from,
       |    kafka_offset_until,
       |    ROW_NUMBER() OVER(PARTITION BY batch_id ORDER BY batch_id DESC) rank
       |  FROM $transactionTable
       |  WHERE job_id=? AND sink_id=?
       |) foo
       |WHERE rank = 1
     """.stripMargin

  def purgeQuery(transactionTable: String): String =
    s"""
       |DELETE FROM $transactionTable
       |WHERE job_id=? AND sink_id=? AND batch_id <= ?
     """.stripMargin
}

case class SinkVerticaStatus(kafkaTopic: String,
                             kafkaPartition: Int,
                             kafkaOffsetFrom: Long,
                             kafkaOffsetUntil: Long) {
  def messagesProduced: Long = kafkaOffsetUntil - kafkaOffsetFrom
}

class VerticaSinkLog(connection: Connection,
                     options: VerticaSinkOptions,
                     metrics: VerticaMetrics)
  extends MetadataLog[Seq[SinkVerticaStatus]] with Logging with Closeable {

  private var avroSchema: String = _
  private var sparkSchema: StructType = _

  private var latestBatchId = Option.empty[(Long, Seq[SinkVerticaStatus])]

  private val addQuery = connection.prepareStatement(VerticaSinkLog.addQuery(options.commitLogTable))
  private val getQuery = connection.prepareStatement(VerticaSinkLog.getQuery(options.commitLogTable))
  private val getLatestQuery = connection.prepareStatement(VerticaSinkLog.getLatestQuery(options.commitLogTable))
  private val purgeQuery = connection.prepareStatement(VerticaSinkLog.purgeQuery(options.commitLogTable))

  override def add(batchId: Long, metadata: Seq[SinkVerticaStatus]): Boolean = {
    val timer = metrics.copyDurationHistogram("").startTimer()

    try {
      maybePurge(batchId)

      if(addMetadata(batchId, metadata)) {
        latestBatchId = Option((batchId, metadata))
        true
      }
      else {
        false
      }
    }
    finally {
      timer.close()
    }
  }

  private def addMetadata(batchId: Long, metadata: Seq[SinkVerticaStatus]): Boolean = {
    val timer = metrics.copyDurationHistogram("addMetadata").startTimer()

    try {
      metadata.foreach { status =>
        addQuery.clearParameters()
        addQuery.setString(1, options.jobId)
        addQuery.setString(2, options.sinkId)
        addQuery.setLong(3, batchId)
        addQuery.setString(4, status.kafkaTopic)
        addQuery.setLong(5, status.kafkaPartition)
        addQuery.setLong(6, status.kafkaOffsetFrom)
        addQuery.setLong(7, status.kafkaOffsetUntil)
        addQuery.addBatch()
      }

      if(addQuery.executeBatch().forall(_ == 1)) {
        true
      }
      else {
        false
      }
    }
    catch {
      case e: SQLIntegrityConstraintViolationException =>
        logWarning(s"VerticaSinkLog#addBatch failed", e)
        false
    }
    finally {
      timer.observeDuration()
    }
  }

  override def get(batchId: Long): Option[Seq[SinkVerticaStatus]] = {
    getQuery.clearParameters()
    getQuery.setString(1, options.jobId)
    getQuery.setString(2, options.sinkId)
    getQuery.setLong(3, batchId)

    if(getQuery.execute()) {
      val rs = getQuery.getResultSet

      try {
        val response = mutable.ArrayBuffer[SinkVerticaStatus]()

        while(rs.next()) {
          response += SinkVerticaStatus(
            rs.getString("kafka_topic"),
            rs.getInt("kafka_partition"),
            rs.getLong("kafka_offset_from"),
            rs.getLong("kafka_offset_until"))
        }

        if(response.isEmpty) {
          None
        }
        else {
          Option(response)
        }
      }
      finally {
        CloseableUtils.close(rs)
      }
    }
    else {
      None
    }
  }

  // return metadata between startId + endId (inclusive)
  // if startId is none, return all before endId (inclusive)
  override def get(startId: Option[Long], endId: Option[Long]): Array[(Long, Seq[SinkVerticaStatus])] = {
    throw new UnsupportedOperationException("range query is not supported")
  }

  // return latest batch id and metadata if exists
  // otherwise return none
  override def getLatest(): Option[(Long, Seq[SinkVerticaStatus])] = {
    if(latestBatchId.nonEmpty) {
      latestBatchId
    }
    else {
      getLatestQuery.clearParameters()
      getLatestQuery.setString(1, options.jobId)
      getLatestQuery.setString(2, options.sinkId)

      if(getLatestQuery.execute()) {
        val rs = getLatestQuery.getResultSet

        try {
          var batchId = Long.MinValue
          val response = mutable.Seq[SinkVerticaStatus]()

          while(rs.next()) {
            batchId = rs.getLong("batch_id")

            response :+ SinkVerticaStatus(
              rs.getString("kafka_topic"),
              rs.getInt("kafka_partition"),
              rs.getLong("kafka_offset_from"),
              rs.getLong("kafka_offset_until"))
          }

          Some((batchId, response))
        }
        finally {
          CloseableUtils.close(rs)
        }
      }
      else {
        None
      }
    }
  }

  private def maybePurge(currentBatchId: Long): Unit = {
    if(options.commitLogCompactionEnabled) {
      if(currentBatchId % options.commitLogCompactionInterval == 0) {
        purge(currentBatchId - options.commitLogCompactionInterval)
      }
    }
  }

  override def purge(thresholdBatchId: Long): Unit = {
    val timer = metrics.copyDurationHistogram("purge").startTimer()

    try {
      purgeQuery.clearParameters()
      purgeQuery.setString(1, options.jobId)
      purgeQuery.setString(2, options.sinkId)
      purgeQuery.setLong(3, thresholdBatchId)
      purgeQuery.execute()
    }
    finally {
      timer.observeDuration()
    }
  }

  private[vertica] def offerSchema(schema: StructType): Unit = {
    if(sparkSchema == null || sparkSchema != schema) {
      StructTypeUtils.assertDistinctColumnNames(schema)

      sparkSchema = schema

      avroSchema = AvroSchemaConverter.convertStructToAvro(
        schema, SchemaBuilder.record("record"), "pstl").toString
    }
  }

  override def close(): Unit = {
    CloseableUtils.close(addQuery)
    CloseableUtils.close(getQuery)
    CloseableUtils.close(getLatestQuery)
    CloseableUtils.close(purgeQuery)
  }
}
