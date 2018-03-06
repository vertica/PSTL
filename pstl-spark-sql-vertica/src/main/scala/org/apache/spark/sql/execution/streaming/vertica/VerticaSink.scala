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
import java.sql.DriverManager
import java.util.Collections
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.Executors

import com.microfocus.pstl.utils.{CloseableUtils, ExecutorServiceUtils, TryUtils}

import scala.collection.JavaConverters._
import scala.concurrent._
import scala.concurrent.duration.Duration
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.TopicPartition
import org.apache.spark.internal.Logging
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.execution.streaming.Sink
import org.apache.spark.sql.execution.streaming.vertica.VerticaCopyManager.{CopyContext, IncrementalLoadState}
import org.apache.spark.util.{ThreadUtils, UninterruptibleThread}

class VerticaSink(options: VerticaSinkOptions) extends Sink
  with Serializable with Logging with Closeable {

  private val metrics = VerticaMetrics(options)

  private val kafkaConsumer = {
    val consumer = new KafkaConsumer[Array[Byte], Array[Byte]](options.driverConsumerProperties)

    try {
      consumer.subscribe(Collections.singletonList(options.topic))
      consumer
    }
    catch {
      case cause: Throwable =>
        CloseableUtils.close(consumer)
        throw cause
    }
  }

  private val kafkaExecutionContext = {
    ExecutionContext.fromExecutorService(Executors.newSingleThreadExecutor())
  }

  private val verticaConnection = {
    val conn = DriverManager.getConnection(options.jdbcUrl, options.jdbcProperties)
    conn.setAutoCommit(false)
    conn
  }

  private val verticaCopyManager = new VerticaCopyManager(verticaConnection, options)

  private val verticaExecutionContext = {
    ExecutionContext.fromExecutorService(Executors.newSingleThreadExecutor())
  }

  private val verticaLog = new VerticaSinkLog(verticaConnection, options, metrics)

  private val copyThreadSignal = new AtomicBoolean(false)

  override def addBatch(batchId: Long, data: DataFrame): Unit = {
    try {
      verticaConnection.setAutoCommit(false)
      doAddBatch(batchId, data)
      verticaConnection.commit()
    }
    catch {
      case cause: Throwable =>
        CloseableUtils.close(this)
        throw cause
    }
  }

  private def doAddBatch(batchId: Long, data: DataFrame): Unit = {
    if(batchId <= verticaLog.getLatest().map(_._1).getOrElse(-1L)) {
      logInfo(s"Skipping already committed batch $batchId")
    }

    else {
      if(!copyThreadSignal.compareAndSet(false, true)) {
        throw new IllegalStateException(
          "BugOrBroken copy thread signal in invalid state")
      }

      verticaLog.offerSchema(data.schema)

      val initialOffsets = kafkaFetchLatestOffsets()

      val copyFuture = Future {
        val copyTimer = metrics.copyDurationHistogram("loadData").startTimer()

        try {
          var context = CopyContext(initialOffsets, data.schema, IncrementalLoadState(initialOffsets, Map.empty))

          while(copyThreadSignal.get()) {
            val loaded = verticaCopyManager.incrementalCopy(context)

            metrics.copyIncrementalCounter.inc()

            loaded.rows.foreach {
              case (partition, row) =>
                val previousRows = context.state.rows.get(partition)
                  .map(_.msgCount)
                  .getOrElse(0L)

                metrics.rowsLoadedCounter.inc(row.msgCount - previousRows)
            }

            val newOffsets = initialOffsets.map {
              case (partition, _) =>
                (partition, loaded.findNextStartingOffset(partition))
            }

            context = CopyContext(newOffsets, context.schema, loaded)
          }

          context.state
        }
        finally {
          copyTimer.close()
        }
      }(verticaExecutionContext)

      val kafkaTimer = metrics.producerHistogram.startTimer()

      val kafkaWriteStatus = try {
        KafkaWriter.write(
          queryExecution = data.queryExecution,
          consumerProperties = options.executorConsumerProperties,
          producerProperties = options.executorProducerProperties,
          producerPartitions = initialOffsets.size * options.producerParallelism,
          topic = options.topic)
      }
      finally {
        kafkaTimer.observeDuration()
      }

      if(!copyThreadSignal.compareAndSet(true, false)) {
        throw new IllegalStateException(
          s"copy signal compare and set failed batchId=$batchId")
      }

      val copyCompletion = Await.result(copyFuture, Duration.Inf)

      val finalOffsets = initialOffsets.map {
        case (partition, _) =>
          (partition, copyCompletion.findNextStartingOffset(partition))
      }

      val copyTimer = metrics.copyDurationHistogram("loadData").startTimer()

      val finalCompletion = try {
        val loaded = verticaCopyManager.finalizeCopy(
          CopyContext(finalOffsets, data.schema, copyCompletion))

        metrics.copyIncrementalCounter.inc()

        loaded.rows.foreach {
          case (partition, row) =>
            val previousRows = copyCompletion.rows.get(partition)
              .map(_.msgCount)
              .getOrElse(0L)

            metrics.rowsLoadedCounter.inc(row.msgCount - previousRows)
        }

        loaded
      }
      finally {
        copyTimer.close()
      }

      validateLoadedRecords(kafkaWriteStatus, finalCompletion)

      val metadata = finalCompletion.rows.map {
        case (_, row) =>
          SinkVerticaStatus(row.topic, row.partition, row.startOffset, row.endOffset)
      }.toSeq

      if(verticaLog.add(batchId, metadata)) {
        logInfo(s"committed batchId=$batchId metadata=$metadata")
      }
      else {
        throw new IllegalStateException(
          s"unable to commit batchId=$batchId metadata=$metadata")
      }
    }
  }

  /**
   * Although Structured Streaming does not properly dispatch Closeable#close, we take a dependency
   * hit on the interface in case it is added in the future. Provides orderly shutdown in the
   * following order:
   * - Terminates kafka consumer thread and closes kafka consumer connection
   * - Terminates vertica incremental copy thread
   * - Sends a close signal to vertica log, which holds statements open
   * - Closes vertica database connection
   */
  override def close(): Unit = {
    ExecutorServiceUtils.shutdown(kafkaExecutionContext)
    CloseableUtils.close(kafkaConsumer)

    ExecutorServiceUtils.shutdown(verticaExecutionContext)
    CloseableUtils.close(verticaLog)

    // paranoid rollback due to orphan transaction issues historically
    TryUtils.quietly(verticaConnection.rollback())
    CloseableUtils.close(verticaConnection)
  }

  private def validateLoadedRecords(producerContext: Seq[KafkaWriteStatus],
                                    consumerContext: IncrementalLoadState): Unit = {
    val produced = producerContext.map(_.messagesProduced).sum
    val consumed = consumerContext.rows.map(_._2.msgCount).sum

    if(produced != consumed) {
      throw new IllegalStateException(
        s"Expected to load $produced rows, but vertica only consumed $consumed rows")
    }
  }

  private def kafkaFetchLatestOffsets(): Map[TopicPartition, Long] = {
    runUninterruptibly(kafkaExecutionContext) {
      assert(Thread.currentThread().isInstanceOf[UninterruptibleThread])
      kafkaConsumer.poll(0)
      val partitions = kafkaConsumer.assignment()
      kafkaConsumer.seekToEnd(partitions)
      val offsets = partitions.asScala.map { partition =>
        (partition, kafkaConsumer.position(partition))
      }.toMap
      kafkaConsumer.pause(partitions)

      offsets
    }
  }

  private def runUninterruptibly[T](ctx: ExecutionContext)(body: => T): T = {
    if(!Thread.currentThread().isInstanceOf[UninterruptibleThread]) {
      val future = Future {
        body
      }(ctx)
      ThreadUtils.awaitResult(future, Duration.Inf)
    }
    else {
      body
    }
  }
}
