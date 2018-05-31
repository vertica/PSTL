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

import java.util.Locale

import com.microfocus.pstl.vertica._
import kafka.admin.AdminUtils
import kafka.common.TopicExistsException
import org.apache.spark.sql.execution.streaming.MemoryStream
import org.apache.spark.sql.{AnalysisException, DataFrame, Row}
import org.apache.spark.sql.catalyst.encoders.RowEncoder
import org.apache.spark.sql.streaming.{DataStreamWriter, OutputMode, StreamTest, StreamingQuery}
import org.apache.spark.sql.types.{LongType, StructType}
import org.scalatest._
import org.scalatest.time._
import org.scalatest.time.SpanSugar._

import scala.util.Random

class VerticaSuite extends StreamTest
  with BeforeAndAfterAll
  with Matchers
  with KafkaKit
  with KafkaEnvironmentVariables
  with VerticaDatabaseKit
  with VerticaAutomatedSetup
  with VerticaEnvironmentVariables
  with ZookeeperKit
  with ZookeeperEnvironmentVariables {

  import testImplicits._

  override val streamingTimeout: Span = 30.seconds

  override def beforeAll(): Unit = {
    super.beforeAll()

    try {
      AdminUtils.createTopic(zkUtils, "vertica_public_data", 1, 1)
      AdminUtils.createTopic(zkUtils, "vertica_pstl_many_columns", 1, 1)
    }
    catch {
      case _: TopicExistsException => // ignore
    }
  }

  ignore("vertica - add data in Append output mode") {
    val input = MemoryStream[String]

    val reader = createVerticaReader("pstl.messages")
      .selectExpr("value")
      .as[Long]

    val writer = createVerticaWriter(
      input.toDF(),
      "pstl.messages",
      "vertica_public_data",
      outputMode = Option(OutputMode.Append()))()

    try {
      input.addData("1", "2", "3", "4", "5")
      failAfter(streamingTimeout) {
        writer.processAllAvailable()
      }

      checkDatasetUnorderly(reader, 1L, 2L, 3L, 4L, 5L)

      input.addData("6", "7", "8", "9", "10")
      failAfter(streamingTimeout) {
        writer.processAllAvailable()
      }
      checkDatasetUnorderly(reader, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)
    }
    finally {
      writer.stop()
    }
  }

  ignore("vertica sink interrupts") {
    val input = MemoryStream[String]

    val writer = createVerticaWriter(
      input.toDF(),
      "pstl.messages",
      "vertica_public_data",
      outputMode = Option(OutputMode.Append()))()

    try {
      input.addData("1", "2", "3", "4", "5")

      val processThread = new Thread() {
        override def run(): Unit = {
          writer.processAllAvailable()
        }
      }

      val stopThread = new Thread() {
        override def run(): Unit = {
          writer.stop()
        }
      }

      failAfter(5.seconds) {
        processThread.start()
        stopThread.start()

        processThread.join()
        stopThread.join()
      }

      input.stop()
    }
    finally {
      writer.stop()
    }
  }

  ignore("vertica sink incorrect options") {
    val input = MemoryStream[String]

    def testBadOptions(options: (String, String)*)(expectedMsgs: String*): Unit = {
      val ex = intercept[IllegalArgumentException] {
        val writer = input.toDF().writeStream.format("vertica")
        options.foreach { case(k, v) => writer.option(k, v) }
        writer.start()
      }

      expectedMsgs.foreach { m =>
        assert(ex.getMessage.toLowerCase(Locale.ROOT).contains(m.toLowerCase(Locale.ROOT)))
      }
    }

    // todo: test bad options
  }

  ignore("vertica sink unsupported output modes") {
    val input = MemoryStream[String]
    val writer = input.toDF().writeStream.format("vertica")

    for(outputMode <- Seq("update", "complete")) {
      val e = intercept[AnalysisException](writer.outputMode(outputMode).start())
      assert(e.getMessage().toLowerCase(Locale.ROOT).contains(s"does not support $outputMode"))
    }
  }

  ignore("vertica sink unsupported partition columns") {
    val input = MemoryStream[String]
    val writer = input.toDF().writeStream.format("vertica").partitionBy("value")
    val e = intercept[AnalysisException](writer.start())
    assert(e.getMessage().toLowerCase(Locale.ROOT).contains("does not support partition columns"))
  }

  ignore("vertica sink process many columns") {
    val schema = (0 until 1000).foldLeft(new StructType()) { (struct, i) =>
      struct.add(s"col$i", LongType, false)
    }
    implicit val encoder = RowEncoder(schema)
    val input = MemoryStream[Row]

    val reader = createVerticaReader("pstl.many_columns")

    val writer = createVerticaWriter(
      input.toDF(),
      "pstl.many_columns",
      "vertica_pstl_many_columns",
      outputMode = Option(OutputMode.Append()))()

    def rowGenerator(): Row = {
      val values = (0 until 1000).map(_ => Random.nextLong())
      Row(values: _*)
    }

    try {
      input.addData(rowGenerator())
      failAfter(streamingTimeout) {
        writer.processAllAvailable()
      }

      reader.count() shouldBe 1L

      for(_ <- 0 until 1000) {
        input.addData(rowGenerator())
      }

      failAfter(streamingTimeout) {
        writer.processAllAvailable()
      }

      reader.count() shouldBe 1001L
    }
    finally {
      writer.stop()
    }
  }

  override def migrations: Seq[VerticaMigration] = Seq(
    CreateUser("pstl", "changeit"),
    GrantRole("pseudosuperuser", "pstl"),
    AlterUserRole("pstl", "pseudosuperuser"),
    CreateSchema("pstl", authorization = Option("pstl")),
    CreateTable(
      "pstl",
      "commit_log",
      List(
        "job_id varchar(128) not null",
        "sink_id varchar(128) not null",
        "batch_id int not null",
        "kafka_topic varchar(128) not null",
        "kafka_partition int not null",
        "kafka_offset_from int not null",
        "kafka_offset_until int not null",
        "batch_loaded timestamp default current_timestamp not null",
        "batch_date_id int default to_char(current_timestamp 'YYYYMMDD')::int not null",
        "PRIMARY KEY(job_id, sink_id, batch_id, kafka_topic, kafka_partition) ENABLED"
      ),
      partitionby = Option("batch_date_id")
    ),
    CreateTable("pstl", "messages", List(
      "value int"
    )),
    CreateTable("pstl", "many_columns", (0 until 1000).map(i => s"col$i int").toList)
  )

  private def createVerticaReader(table: String): DataFrame = {
    spark.read
      .format("jdbc")
      .option("url", verticaJdbcUrl)
      .option("dbtable", table)
      .option("user", "pstl")
      .option("password", "changeit")
      .load()
  }

  private def createVerticaWriter(input: DataFrame,
                                  table: String,
                                  topic: String,
                                  options: Map[String, String] = Map.empty,
                                  outputMode: Option[OutputMode])(selectExpr: String*): StreamingQuery = {
    var stream: DataStreamWriter[Row] = null

    withTempDir { checkpointDir =>
      var df = input.toDF()
      if(selectExpr.nonEmpty) {
        df = df.selectExpr(selectExpr: _*)
      }

      stream = df.writeStream
        .format("vertica")
        .option("checkpointLocation", checkpointDir.getCanonicalPath)
        .option("url", verticaJdbcUrl)
        .option("table", table)
        .option("vertica.jdbc.username", "pstl")
        .option("vertica.jdbc.password", "changeit")
        .option("topic", topic)
        .option("kafka.bootstrap.servers", kafkaBootstrapServers)
        .option("__pstl_job_id", "integrationTest")
        .queryName("verticaStream")

      options.foreach(o => stream.option(o._1, o._2))
      outputMode.foreach(stream.outputMode)
    }

    stream.start()
  }
}
