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

package com.microfocus.pstl.spark

import io.prometheus.client.{Counter, Gauge}
import org.apache.spark.scheduler.{SparkListenerJobEnd, SparkListenerJobStart}
//import org.apache.spark.sql.execution.streaming.vertica.VerticaSinkOptions

import io.prometheus.client.{Counter, Histogram}

object SparkStreamingMetrics {
  private val AccumulatorMetricGauge = Gauge.build()
    .name("spark_sql_accumulator_current")
    .help("current value of a specific sql accumulator")
    .labelNames("job_id", "query_id", "stage_id", "node_name", "metric_name")
    .register()
}

class SparkStreamingMetrics(jobId: String, queryId: String, stageId: String, nodeName: String, metricName: String) {
  import SparkStreamingMetrics._
  val gauge: Gauge.Child = AccumulatorMetricGauge.labels(jobId, queryId, stageId, nodeName, metricName)
}
