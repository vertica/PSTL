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



//package org.apache.spark.sql.execution.streaming.vertica
//
//import kafka.admin.AdminUtils
//import kafka.utils.ZkUtils
//import org.apache.spark.sql.{DataFrame, Row}
//import org.apache.spark.sql.execution.streaming.MemoryStream
//import org.apache.spark.sql.streaming.{DataStreamWriter, OutputMode, StreamTest, StreamingQuery}
//import org.scalatest._
//import org.scalatest.time.Span
//import org.scalatest.time.SpanSugar._
//
//trait VerticaSinkIntegrationSuite extends StreamTest
//  with VerticaDatabaseKit
//  with VerticaEnvironmentVariables
//  with BeforeAndAfterAll {
//
//  import testImplicits._
//
//  override def beforeAll(): Unit = {
//    super.beforeAll()
//
//    AdminUtils.createTopic(zkUtils, "vertica_public_data", 1, 1)
//  }
//
//  override def afterAll(): Unit = {
//    super.afterAll()
//  }
//
//  override val streamingTimeout: Span = 30.seconds
//
//  test("vertica - add data in Append output mode") {
//    val input = MemoryStream[String]
//
//    val reader = createVerticaReader("public.data")
//      .selectExpr("value")
//      .as[Long]
//
//    val writer = createVerticaWriter(
//      input.toDF(),
//      "public.data",
//      "vertica_public_data",
//      outputMode = Option(OutputMode.Append()))()
//
//    try {
//      input.addData("1", "2", "3", "4", "5")
//      failAfter(streamingTimeout) {
//        writer.processAllAvailable()
//      }
//      checkDatasetUnorderly(reader, 1L, 2L, 3L, 4L, 5L)
//
//      input.addData("6", "7", "8", "9", "10")
//      failAfter(streamingTimeout) {
//        writer.processAllAvailable()
//      }
//      checkDatasetUnorderly(reader, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)
//    }
//    finally {
//      writer.stop()
//    }
//  }
//
//  override def configureDatabase(): Seq[String] = Seq(
//    "CREATE SCHEMA IF NOT EXISTS pstl",
//    "CREATE USER pstl IDENTIFIED BY 'changeit' MEMORYCAP NONE RUNTIMECAP NONE TEMPSPACECAP NONE",
//    "GRANT pseudosuperuser TO pstl",
//    "GRANT ALL ON DATABASE docker TO pstl",
//    "ALTER USER pstl DEFAULT ROLE pseudosuperuser",
//    "CREATE SCHEMA IF NOT EXISTS pstl",
//    """
//      |CREATE TABLE IF NOT EXISTS pstl.vertica_sink_batch(
//      |  job_id varchar(128) not null,
//      |  sink_id varchar(128) not null,
//      |  batch_id int not null,
//      |  kafka_topic varchar(128) not null,
//      |  kafka_partition int not null,
//      |  kafka_offset_from int not null,
//      |  kafka_offset_until int not null,
//      |  batch_loaded timestamp default current_timestamp not null,
//      |  batch_date_id int default to_char(current_timestamp, 'YYYYMMDD')::int not null,
//      |  PRIMARY KEY(job_id, sink_id, batch_id, kafka_topic, kafka_partition) ENABLED
//      |)
//      |PARTITION BY batch_date_id;
//    """.stripMargin,
//    "CREATE TABLE IF NOT EXISTS public.data(value int)"
//  )
//
//  private def createVerticaReader(table: String): DataFrame = {
//    spark.read
//      .format("jdbc")
//      .option("url", verticaJdbcUrl)
//      .option("dbtable", table)
//      .option("user", "dbadmin")
//      .option("password", "")
//      .load()
//  }
//
//  private def createVerticaWriter(input: DataFrame,
//                                  table: String,
//                                  topic: String,
//                                  options: Map[String, String] = Map.empty,
//                                  outputMode: Option[OutputMode])(selectExpr: String*): StreamingQuery = {
//    var stream: DataStreamWriter[Row] = null
//
//    withTempDir { checkpointDir =>
//      var df = input.toDF()
//      if(selectExpr.nonEmpty) {
//        df = df.selectExpr(selectExpr: _*)
//      }
//
//      stream = df.writeStream
//        .format("vertica")
//        .option("checkpointLocation", checkpointDir.getCanonicalPath)
//        .option("url", verticaJdbcUrl)
//        .option("table", table)
//        .option("vertica.jdbc.user", "dbadmin")
//        .option("vertica.jdbc.password", "")
//        .option("topic", topic)
//        .option("kafka.bootstrap.servers", kafkaBootstrapServers)
//        .option("__pstl_job_id", "integrationTest")
//        .queryName("verticaStream")
//
//      options.foreach(o => stream.option(o._1, o._2))
//      outputMode.foreach(stream.outputMode)
//    }
//
//    stream.start()
//  }
//}
