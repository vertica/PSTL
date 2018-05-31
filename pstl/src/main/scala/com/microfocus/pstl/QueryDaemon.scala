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

package com.microfocus.pstl

import java.util.UUID
import java.util.concurrent.TimeUnit

import scala.collection.JavaConverters._
import scala.concurrent.duration._
import akka.actor.{Actor, ActorLogging, Timers}
import org.apache.spark.sql.streaming.StreamingQueryListener._
import com.microfocus.pstl.utils.ExponentialBackoff

import scala.util.control.NonFatal

object QueryDaemon {
  case object Heartbeat
  case object HeartbeatKey

  case object RestartQuery
  case object RestartQueryKey
}

class QueryDaemon(session: JobSession) extends Actor
  with Timers
  with ActorJobSettings
  with ActorLogging {

  import QueryDaemon._

  private var batchId: Long = -1L
  private var queryId: UUID = _
  private var queryName: String = _
  private var queryOptions: QueryOptions = _
  private var queryMetrics: QueryDaemonMetrics = _
  private var queryRestarts: Int = 0

  private val heartbeatInterval: FiniteDuration = 100.milliseconds

  override def postStop(): Unit = {
    clearMetrics()
  }

  override def receive: Receive = {
    case e: QueryStartedEvent     => onQueryStarted(e)
    case e: QueryProgressEvent    => onQueryProgress(e)
    case e: QueryTerminatedEvent  => onQueryTerminated(e)
    case RestartQuery             => onRestartQuery()
    case Heartbeat                => onHeartbeat()
  }

  private def onQueryStarted(e: QueryStartedEvent): Unit = {
    this.queryId = e.id
    this.queryName = e.name
    this.queryOptions = session.queryOptions(e.name)

    this.queryMetrics = new QueryDaemonMetrics(session.jobId, e.name)
    this.queryMetrics.upGauge.set(1d)

    timers.startPeriodicTimer(
      HeartbeatKey, Heartbeat, heartbeatInterval)
  }

  private def onQueryProgress(e: QueryProgressEvent): Unit = {
    this.queryRestarts = 0

    // only increment batch id if we processed new data, progress events show up
    // when a streaming query is "idle", so incrementing blindly can indicate
    // we are processing batches when we arent (eg. batch id is same in multiple
    // progress events while no new data is available from source).
    if(e.progress.batchId > batchId) {
      this.batchId = e.progress.batchId
      this.queryMetrics.batchCounter.inc()
    }

    this.queryMetrics.batchGauge.set(e.progress.batchId)
    this.queryMetrics.inputRowCounter.inc(e.progress.numInputRows)
    this.queryMetrics.inputRowGauge.set(e.progress.inputRowsPerSecond)
    this.queryMetrics.processedRowGauge.set(e.progress.processedRowsPerSecond)

    e.progress.durationMs.asScala.foreach { case (stageId, durationMs) =>
      val durationSec = durationMs / 1000d
      this.queryMetrics.executionTimeCounter(stageId).inc(durationSec)
    }
  }

  private def onQueryTerminated(e: QueryTerminatedEvent): Unit = {
    this.queryMetrics.upGauge.set(0d)

    e.exception.either(
      some = scheduleRestart,
      none = shutdownGracefully())
  }

  private def scheduleRestart(exception: String): Unit = {
    val delay = ExponentialBackoff(
      restartCount = queryRestarts,
      minBackoff = queryOptions.retryMinBackoff.getOrElse(jobSettings.RetryMinBackoff),
      maxBackoff = queryOptions.retryMaxBackoff.getOrElse(jobSettings.RetryMaxBackoff),
      randomFactor = queryOptions.retryRandomFactor.getOrElse(jobSettings.RetryRandomFactor))

    timers.startSingleTimer(
      RestartQueryKey, RestartQuery, delay)

    this.queryMetrics.restartTimerGauge.set(delay.toUnit(TimeUnit.SECONDS))
  }

  private def shutdownGracefully(): Unit = {
    context.stop(self)
  }

  private def onRestartQuery(): Unit = {
    this.queryRestarts += 1
    this.queryMetrics.restartCounter.inc()

    try {
      // blocking op on spark which never triggers a QueryStartedEvent -> QueryTerminatedEvent
      // if it fails during initialization of underlying DAG and relevant resources.
      // todo: we need to make job session more explicit so we can deal with this via supervision
      // and custom exception types rather than needing specific error handling here.
      session.restart(queryName)
    }
    catch {
      case NonFatal(e) =>
        log.error(e, "query restart failed {}", this)
        scheduleRestart(e.getMessage)
    }
  }

  private def onHeartbeat(): Unit = {
    val retryTimer = queryMetrics.restartTimerGauge.get()
    val heartbeatSecondsElapsed = heartbeatInterval.toUnit(TimeUnit.SECONDS)
    queryMetrics.restartTimerGauge.set(Math.max(0d, retryTimer - heartbeatSecondsElapsed))
  }

  private def clearMetrics(): Unit = Option(queryMetrics).foreach { m =>
    m.upGauge.set(0d)
    m.restartTimerGauge.set(0d)
  }

  override def toString: String = {
    s"[batchId=$batchId, queryId=$queryId, queryName=$queryName]"
  }
}
