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

import io.prometheus.client.{Counter, Gauge}

object QueryDaemonMetrics {
  val BatchCounterKey         = "pstl_query_batch_total"
  val BatchGaugeKey           = "pstl_query_batch_current"
  val ExecutionTimeCounterKey = "pstl_query_duration_seconds_total"
  val InputRowCounterKey      = "pstl_query_input_rows_total"
  val InputRowGaugeKey        = "pstl_query_input_rows_current"
  val ProcessedRowGaugeKey    = "pstl_query_processed_rows_current"
  val RestartCounterKey       = "pstl_query_restarts_total"
  val RestartTimerGaugeKey    = "pstl_query_restart_seconds"
  val UpGaugeKey              = "pstl_query_up"

  private val BatchCounter = Counter.build()
    .name(BatchCounterKey)
    .help("numbers of batches processed by query")
    .labelNames("job_id", "query_id")
    .register()

  private val BatchGauge = Gauge.build()
    .name(BatchGaugeKey)
    .help("most recent batch processed by query")
    .labelNames("job_id", "query_id")
    .register()

  private val ExecutionTimeCounter = Counter.build()
    .name(ExecutionTimeCounterKey)
    .help("amount of time a micro-batch took to execute")
    .labelNames("job_id", "query_id", "stage_id")
    .register()

  private val InputRowCounter = Counter.build()
    .name(InputRowCounterKey)
    .help("number of rows input to a query")
    .labelNames("job_id", "query_id")
    .register()

  private val InputRowGauge = Gauge.build()
    .name(InputRowGaugeKey)
    .help("number of rows input to most recent micro-batch (pre-aggregated by second)")
    .labelNames("job_id", "query_id")
    .register()

  private val ProcessedRowGauge = Gauge.build()
    .name(ProcessedRowGaugeKey)
    .help("number of rows processed in most recent micro-batch (pre-aggregated by second)")
    .labelNames("job_id", "query_id")
    .register()

  private val RestartCounter = Counter.build()
    .name(RestartCounterKey)
    .help("number of times a query has been restarted")
    .labelNames("job_id", "query_id")
    .register()

  private val RestartTimerGauge = Gauge.build()
    .name(RestartTimerGaugeKey)
    .help("number of seconds remaining before retrying this query")
    .labelNames("job_id", "query_id")
    .register()

  private val UpGauge = Gauge.build()
    .name(UpGaugeKey)
    .help("indicates whether a streaming query is up or down")
    .labelNames("job_id", "query_id")
    .register()
}

class QueryDaemonMetrics(jobId: String, queryId: String) {

  import QueryDaemonMetrics._

  val batchCounter: Counter.Child = BatchCounter.labels(jobId, queryId)
  val batchGauge: Gauge.Child = BatchGauge.labels(jobId, queryId)
  val inputRowCounter: Counter.Child = InputRowCounter.labels(jobId, queryId)
  val inputRowGauge: Gauge.Child = InputRowGauge.labels(jobId, queryId)
  val processedRowGauge: Gauge.Child = ProcessedRowGauge.labels(jobId, queryId)
  val restartCounter: Counter.Child = RestartCounter.labels(jobId, queryId)
  val restartTimerGauge: Gauge.Child = RestartTimerGauge.labels(jobId, queryId)
  val upGauge: Gauge.Child = UpGauge.labels(jobId, queryId)

  def executionTimeCounter(stageId: String): Counter.Child = {
    ExecutionTimeCounter.labels(jobId, queryId, stageId)
  }
}
