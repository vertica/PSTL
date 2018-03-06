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

import io.prometheus.client.Gauge

object JobDaemonMetrics {
  private val UpGauge = Gauge.build()
    .name("pstl_job_up")
    .help("indicates whether a job is up or down")
    .labelNames("job_id")
    .register()
}

class JobDaemonMetrics(jobId: String) {
  import JobDaemonMetrics._

  val upGauge: Gauge.Child = UpGauge.labels(jobId)
  upGauge.set(0d)
}
