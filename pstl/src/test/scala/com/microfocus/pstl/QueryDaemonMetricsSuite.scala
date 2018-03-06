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

import io.prometheus.client.CollectorRegistry
import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class QueryDaemonMetricsSuite extends FunSuite with GeneratorDrivenPropertyChecks with Matchers {

  import QueryDaemonMetrics._

  val registry = CollectorRegistry.defaultRegistry
  val expectedLabels = Array("job_id", "query_id")

  withMetrics("query daemon metrics batch counter") { data =>
    registry.getSampleValue(BatchCounterKey, expectedLabels, data.labels) shouldBe 0
    data.metrics.batchCounter.inc()
    registry.getSampleValue(BatchCounterKey, expectedLabels, data.labels) shouldBe 1
    data.metrics.batchCounter.inc(5)
    registry.getSampleValue(BatchCounterKey, expectedLabels, data.labels) shouldBe 6
  }

  withMetrics("query daemon metrics batch gauge") { data =>
    registry.getSampleValue(BatchGaugeKey, expectedLabels, data.labels) shouldBe 0
    data.metrics.batchGauge.inc()
    registry.getSampleValue(BatchGaugeKey, expectedLabels, data.labels) shouldBe 1
    data.metrics.batchGauge.set(0)
    registry.getSampleValue(BatchGaugeKey, expectedLabels, data.labels) shouldBe 0
    data.metrics.batchGauge.inc(5)
    registry.getSampleValue(BatchGaugeKey, expectedLabels, data.labels) shouldBe 5
  }

  def withMetrics[T](testName: String)(f: (MetricsContainer) => T): Unit = {
    ignore(testName) {
      forAll() { (jobId: String, queryId: String) =>
        val metrics = new QueryDaemonMetrics(jobId, queryId)
        val container = MetricsContainer(jobId, queryId, metrics)
        f(container)
      }
    }

  }

  case class MetricsContainer(jobId: String, queryId: String, metrics: QueryDaemonMetrics) {
    def labels: Array[String] = labels()
    def labels(addtl: String*): Array[String] = Array(jobId, queryId) ++ addtl
  }
}
