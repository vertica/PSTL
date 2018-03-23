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

import java.util.concurrent.TimeUnit

import org.apache.spark.internal.config.ConfigEntry
import org.apache.spark.sql.internal.SQLConf

/**
 * Defines configuration options for spark.sql.streaming.vertica
 */
object VerticaSQLConf {

  import SQLConf.buildConf

  // ==========================================================================
  // commit log options
  // ==========================================================================

  val CommitLogCompactionEnabled: ConfigEntry[Boolean] =
    buildConf("spark.sql.streaming.vertica.commitLog.compaction.enabled")
      .doc(
        "When true, compact the vertica commit log periodically by purging entries which " +
        "are older than spark.sql.streaming.vertica.commitLog.compaction.interval. Age is " +
        "based on the batch_id of each structured streaming micro batch.")
      .booleanConf
      .createWithDefault(false)

  val CommitLogCompactionInterval: ConfigEntry[Long] =
    buildConf("spark.sql.streaming.vertica.commitLog.compaction.interval")
      .doc(
        "When spark.sql.streaming.vertica.commitLog.compaction.enabled is true, specifies " +
        "the frequency at which the commit log is compacted. The frequency is measured in " +
        "number of elapsed micro batches.")
      .longConf
      .createWithDefault(Long.MaxValue)

  val CommitLogTable: ConfigEntry[String] =
    buildConf("spark.sql.streaming.vertica.commitLog.table")
      .doc(
        "Specifies which table to use for the commit log in vertica. Should be in the format " +
        "<schema.table> (eg. pstl.commit_log). You should not need to change this typically. " +
        "It is important to ensure the commit log schema is deployed in vertica before " +
        "deploying any vertica streaming queries on your cluster, otherwise they will fail.")
      .stringConf
      .createWithDefault("pstl.commit_log")

  // ==========================================================================
  // copy options
  // ==========================================================================

  val CopyDurationMs: ConfigEntry[Long] =
    buildConf("spark.sql.streaming.vertica.copy.durationMs")
      .doc(
        "Specifies how long each incremental copy within a micro batch is given to load " +
        "data from Kafka. Provided in milliseconds, eg. 1000 = 1000ms. Larger values will " +
        "improve throughput for high(er) throughput applications. Smaller values will reduce " +
        "latency for low(er) throughput applications.")
      .timeConf(TimeUnit.MILLISECONDS)
      .createWithDefault(1000L)

  val CopyEofTimeoutMs: ConfigEntry[Long] =
    buildConf("spark.sql.streaming.vertica.copy.eofTimeoutMs")
      .doc(
        "Specifies how long the final copy within a micro batch is given to begin receiving " +
        "messages from Kafka. Provided in milliseconds, eg. 1000 = 1000ms. The final copy will " +
        "be terminated after this timeout has elapsed if no data is received. Modifying this " +
        "configuration is a tradeoff between failing fast and failing prematurely if there " +
        "is congestion surrounding infrastructure.")
      .timeConf(TimeUnit.MILLISECONDS)
      .createWithDefault(1000L)

  val CopyOptions: ConfigEntry[String] =
    buildConf("spark.sql.streaming.vertica.copy.options")
      .doc(
        "Specifies additional copy options you would like appended to copy commands triggered " +
        "by your vertica streaming queries. In all cases, NO COMMIT will be appended to your " +
        "copy options with or without your guidance to manage transactional semantics per " +
        "micro batch. This option is typically useful for specifying where to store rejected " +
        "data, whether or not to load WOS or DIRECT, etc.")
      .stringConf
      .createWithDefault("")

  // ==========================================================================
  // jdbc options
  // ==========================================================================

  val JdbcUrl: ConfigEntry[String] =
    buildConf("spark.sql.streaming.vertica.jdbc.url")
      .doc(
        "The jdbc url the vertica sink should use to establish a connection to the vertica " +
        "cluster. Provided in the format jdbc:vertica://host:port/database. Additional JDBC " +
        "options can be provided by specifying spark.sql.streaming.vertica.jdbc.*. For example " +
        "if we wanted to provide basic auth credentials we could specify " +
        "spark.sql.streaming.vertica.jdbc.user and spark.sql.streaming.vertica.jdbc.password.")
      .stringConf
      .createWithDefault("jdbc:vertica://localhost:5433/default")

  // ==========================================================================
  // kafka options
  // ==========================================================================

  val BootstrapServers: ConfigEntry[String] =
    buildConf("spark.sql.streaming.vertica.kafka.bootstrap.servers")
      .doc(
        "Specifies the bootstrap servers to use when connecting to Kafka. These hostnames will " +
        "be used by the driver (consumer), the executors (producer), and vertica (consumer). " +
        "If you have non-trivial networking requirements for upstream vs. downstream you can " +
        "provide driver and executor specific bootstrap servers in " +
        "spark.sql.streaming.vertica.consumer.bootstrap.servers and " +
        "spark.sql.streaming.vertica.producer.bootstrap.servers respectively. In this case, " +
        "vertica consumers will use spark.sql.streaming.vertica.kafka.bootstrap.servers.")
      .stringConf
      .createWithDefault("localhost:9092")

  val ProducerParallelism: ConfigEntry[Int] =
    buildConf("spark.sql.streaming.vertica.kafka.producerParallelism")
      .doc(
        "Dictates the amount of parallelism to allocate on the spark cluster when producing " +
        "processed data to kafka for vertica to load. Parallelism is determined by the number " +
        "of partitions present in the intermediate kafka topic. If the intermediate kafka " +
        "contains 4 partitions, then we will allocate 4 tasks by default. If the producer " +
        "parallelism is increased to 2, then we will allocate 8 tasks. Increasing the producer " +
        "parallelism typically results in the need for a shuffle operation, so care should " +
        "be taken with manipulating the default parallelism of 1.")
      .intConf
      .createWithDefault(1)

  def queryOption(key: String): String = {
    val prefix = "spark.sql.streaming.vertica."
    key.drop(prefix.length)
  }

  def queryOption[T](entry: ConfigEntry[T]): String = {
    queryOption(entry.key)
  }
}
