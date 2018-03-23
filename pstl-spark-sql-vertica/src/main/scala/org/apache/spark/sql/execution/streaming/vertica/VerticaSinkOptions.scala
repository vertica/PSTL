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

import java.util.{Properties, UUID}
import java.{util => ju}

import com.microfocus.pstl.utils.ModuleConfig
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.{ByteArrayDeserializer, ByteArraySerializer}
import org.apache.spark.internal.Logging
import org.apache.spark.network.util.JavaUtils
import org.apache.spark.sql.catalyst.util.CaseInsensitiveMap
import org.apache.spark.sql.internal.SQLConf

import scala.util.Try

class VerticaSinkOptions(parameters: CaseInsensitiveMap[String], sqlConf: SQLConf)
  extends Logging with Serializable {

  import VerticaSQLConf._

  // primarily for tests
  def this(parameters: Map[String, String]) = {
    this(CaseInsensitiveMap(parameters), new SQLConf)
  }

  def this(parameters: Map[String, String], sqlConf: SQLConf) = {
    this(CaseInsensitiveMap(parameters), sqlConf)
  }

  // ==========================================================================
  // pstl specific configuration
  // ==========================================================================

  val jobId: String = parameters.get("__pstl_job_id").getOrElse("<unknown>")
  val sinkId: String = parameters.get("queryName").getOrElse("<unknown>")

  // ==========================================================================
  // vertica options
  // ==========================================================================

  val commitLogCompactionEnabled: Boolean = {
    val key = queryOption(CommitLogCompactionEnabled)

    parameters.get(key).map { str =>
      Try(str.toBoolean).toOption.getOrElse {
        throw new IllegalArgumentException(
          s"Vertica option '$key' must be a boolean, but received '$str'")
      }
    }.getOrElse(sqlConf.getConf(CommitLogCompactionEnabled))
  }

  val commitLogCompactionInterval: Long = {
    val key = queryOption(CommitLogCompactionInterval)

    parameters.get(key).map { str =>
      Try(str.toLong).toOption.getOrElse {
        throw new IllegalArgumentException(
          s"Vertica option '$key' must be a long, but received '$str'")
      }
    }.getOrElse(sqlConf.getConf(CommitLogCompactionInterval))
  }

  val commitLogTable: String = {
    parameters.get(queryOption(CommitLogTable))
      .getOrElse(sqlConf.getConf(CommitLogTable))
  }

  val copyDurationMs: Long = {
    val key = queryOption(CopyDurationMs)

    parameters.get(key).map { str =>
      Try(JavaUtils.timeStringAsMs(str)).toOption.getOrElse {
        throw new IllegalArgumentException(
          s"Vertica option '$key' must be specified as seconds (s), milliseconds (ms), " +
            s"microseconds (us), minutes (m or min), hour (h), or day (d). Examples include " +
            s"50s, 100ms, or 250us. However, '$str' was provided, which is invalid.")
      }
    }.getOrElse(sqlConf.getConf(CopyDurationMs))
  }

  val copyEofTimeoutMs: Long = {
    val key = queryOption(CopyEofTimeoutMs)

    parameters.get(key).map { str =>
      Try(JavaUtils.timeStringAsMs(str)).toOption.getOrElse {
        throw new IllegalArgumentException(
          s"Vertica option '$key' must be specified as seconds (s), milliseconds (ms), " +
            s"microseconds (us), minutes (m or min), hour (h), or day (d). Examples include " +
            s"50s, 100ms, or 250us. However, '$str' was provided, which is invalid.")

      }
    }.getOrElse(sqlConf.getConf(CopyEofTimeoutMs))
  }

  val copyOptions: String = {
    parameters.get(queryOption(CopyOptions))
      .getOrElse(sqlConf.getConf(CopyOptions))
  }

  val jdbcUrl: String = {
    parameters.get(queryOption(JdbcUrl))
      .getOrElse(sqlConf.getConf(JdbcUrl))
  }

  val jdbcProperties: Properties = {
    val userConfig = extract(parameters, "jdbc.").filterKeys(_ != "url")

    val systemConfig = extract(
      parameters, "spark.sql.streaming.vertica.jdbc.").filterKeys(_ != "url")

    val finalConfig = systemConfig ++ userConfig

    finalConfig.foldLeft(new Properties) {
      case (props, (key, value)) =>
        props.setProperty(key, value)
        props
    }
  }

  val table: String = parameters.get("table").getOrElse {
    throw new IllegalArgumentException(
      "Vertica option 'table' is required to specify the target table to load processed data to")
  }

  // ==========================================================================
  // kafka options
  // ==========================================================================

  private val groupId: String =
    s"pstl-$jobId-$sinkId-${UUID.randomUUID()}"

  val bootstrapServers: String = {
    parameters.get(queryOption(BootstrapServers))
      .getOrElse(sqlConf.getConf(BootstrapServers))
  }

  val topic: String = parameters.get("topic").getOrElse {
    throw new IllegalArgumentException(
      "Vertica option 'topic' is required to specify the target topic for processed data")
  }

  private val defaultConsumerProperties: Map[String, String] = {
    val userConfig = extract(parameters, "kafka.consumer.")
    val systemConfig = extract(sqlConf.getAllConfs, "spark.sql.streaming.vertica.kafka.consumer.")
    Map("bootstrap.servers" -> bootstrapServers) ++ systemConfig ++ userConfig
  }

  val driverConsumerProperties: ju.Map[String, Object] = {
    ModuleConfig[Object]("VerticaSink#driverConsumerProperties", defaultConsumerProperties)
      .set(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[ByteArrayDeserializer].getName)
      .set(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[ByteArrayDeserializer].getName)
      .set(ConsumerConfig.GROUP_ID_CONFIG, s"$groupId-driver")
      .set(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
      .set(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false")
      .set(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1: java.lang.Integer)
      .setIfUnset(ConsumerConfig.RECEIVE_BUFFER_CONFIG, 65536: java.lang.Integer)
      .asJava
  }

  val executorConsumerProperties: ju.Map[String, Object] = {
    ModuleConfig[Object]("VerticaSink#executorConsumerProperties", defaultConsumerProperties)
      .set(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[ByteArrayDeserializer].getName)
      .set(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[ByteArrayDeserializer].getName)
      .set(ConsumerConfig.GROUP_ID_CONFIG, s"$groupId-executor")
      .set(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "none")
      .set(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false")
      .set(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1: java.lang.Integer)
      .setIfUnset(ConsumerConfig.RECEIVE_BUFFER_CONFIG, 65536: java.lang.Integer)
      .asJava
  }

  private val defaultProducerProperties: Map[String, String] = {
    val userConfig = extract(parameters, "kafka.producer.")
    val systemConfig = extract(sqlConf.getAllConfs, "spark.sql.streaming.vertica.kafka.producer.")
    Map("bootstrap.servers" -> bootstrapServers) ++ systemConfig ++ userConfig
  }

  val executorProducerProperties: ju.Map[String, Object] = {
    ModuleConfig[Object]("VerticaSink#executorProducerProperties", defaultProducerProperties)
      .set(ProducerConfig.ACKS_CONFIG, "1")
      .set(ProducerConfig.RETRIES_CONFIG, "0")
      .set(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[ByteArraySerializer].getName)
      .set(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[ByteArraySerializer].getName)
      .asJava
  }

  val producerParallelism: Int = {
    val key = queryOption(ProducerParallelism)

    parameters.get(key).map { str =>
      Try(str.toInt).toOption.getOrElse {
        throw new IllegalArgumentException(
          s"Vertica option '$key' must be an int, but received '$str'")
      }
    }.getOrElse(sqlConf.getConf(ProducerParallelism))
  }

  private def extract(data: Map[String, String], prefix: String): Map[String, String] = {
    data.filterKeys(_.startsWith(prefix)).map { case (key, value) =>
      key.drop(prefix.length) -> value
    }
  }
}
