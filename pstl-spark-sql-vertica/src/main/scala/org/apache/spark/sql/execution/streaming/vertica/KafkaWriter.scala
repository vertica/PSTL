/*
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

import java.{util => ju}

import org.apache.spark.internal.Logging
import org.apache.spark.sql.execution.QueryExecution

object KafkaWriter extends Logging {
  def write(queryExecution: QueryExecution,
            consumerProperties: ju.Map[String, Object],
            producerProperties: ju.Map[String, Object],
            producerPartitions: Int,
            topic: String): Seq[KafkaWriteStatus] = {
    val schema = queryExecution.analyzed.output

    val baseRdd = queryExecution.toRdd

    // ensure we have one spark partition per kafka partition so resource management
    // is simple, eg. want more throughput increase the number of kakfa partitions
    val scaledRdd = baseRdd.coalesce(
      producerPartitions, producerPartitions > baseRdd.getNumPartitions)

    val writeTasks = scaledRdd.mapPartitions { iter =>
      val writeTask = new KafkaWriteTask(
        consumerProperties,
        producerProperties,
        schema,
        topic)

      var originalThrowable: Throwable = null
      var writeStatus: KafkaWriteStatus = null

      try {
        writeTask.execute(iter)
      } catch {
        case t: Throwable =>
          originalThrowable = t
          throw originalThrowable
      } finally {
        try {
          writeStatus = writeTask.close()
        } catch {
          case t: Throwable if originalThrowable != null && originalThrowable != t =>
            originalThrowable.addSuppressed(t)
            logWarning(s"Suppressing exception in finally: ${t.getMessage}", t)
            throw originalThrowable
        }
      }

      Iterator(writeStatus)
    }

    writeTasks.collect()
  }
}
