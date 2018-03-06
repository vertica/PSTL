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

import io.prometheus.client.{Counter, Histogram}

object VerticaMetrics {
  private val ProducerHistogram: Histogram = Histogram.build()
    .name("pstl_vertica_kafka_producer")
    .help("tracks time spent producing data to kafka within the vertica sink")
    .labelNames("job_id", "sink_id", "vertica_url", "vertica_table")
    .register()

  private val CopyDurationHistogram: Histogram = Histogram.build()
    .name("pstl_vertica_copy_duration")
    .help("tracks time spent executing copy commands within the vertica sink")
    .labelNames("job_id", "sink_id", "vertica_url", "vertica_table", "stage_id")
    .register()

  private val CopyIncrementalCounter: Counter = Counter.build()
    .name("pstl_vertica_copy_total")
    .help("number of incremental copy commands triggered per microbatch")
    .labelNames("job_id", "sink_id", "vertica_url", "vertica_table")
    .register()

  private val RowsLoadedCouter: Counter = Counter.build()
    .name("pstl_vertica_copy_rows_total")
    .help("number of rows loaded per copy")
    .labelNames("job_id", "sink_id", "vertica_url", "vertica_table")
    .register()
}

case class VerticaMetrics(options: VerticaSinkOptions) {
  import VerticaMetrics._

  val copyIncrementalCounter: Counter.Child =
    CopyIncrementalCounter.labels(options.jobId, options.sinkId, options.jdbcUrl, options.table)

  val rowsLoadedCounter: Counter.Child =
    RowsLoadedCouter.labels(options.jobId, options.sinkId, options.jdbcUrl, options.table)

  val producerHistogram: Histogram.Child =
    ProducerHistogram.labels(options.jobId, options.sinkId, options.jdbcUrl, options.table)

  def copyDurationHistogram(stageId: String): Histogram.Child = CopyDurationHistogram
    .labels(options.jobId, options.sinkId, options.jdbcUrl, options.table, stageId)
}
