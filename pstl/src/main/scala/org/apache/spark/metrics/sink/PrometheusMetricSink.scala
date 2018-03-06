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

package org.apache.spark.metrics.sink

import java.util.Properties

import com.codahale.metrics.MetricRegistry
import com.microfocus.pstl.metrics.DynamicHttpServer
import io.prometheus.client.CollectorRegistry
import io.prometheus.client.dropwizard.DropwizardExports
import org.apache.spark.SecurityManager
import org.apache.spark.internal.Logging

private[spark] object PrometheusMetricSink {
  val HttpHost = "httpHost"
  val HttpPort = "httpPort"

  val HttpHostDefault = "localhost"
  val HttpPortDefault = 13337
}

private[spark] class PrometheusMetricSink(val property: Properties,
                                          val registry: MetricRegistry,
                                          securityMgr: SecurityManager) extends Sink with Logging {

  import PrometheusMetricSink._

  val httpHost: String = Option(property.getProperty(HttpHost))
    .getOrElse(HttpHostDefault)

  val httpPort: Int = Option(property.getProperty(HttpPort))
    .map(_.toInt)
    .getOrElse(HttpPortDefault)

  CollectorRegistry.defaultRegistry
    .register(new DropwizardExports(registry))

  var httpServer: DynamicHttpServer = _

  override def start(): Unit = {
    httpServer = new DynamicHttpServer(httpHost, httpPort)
    log.info(s"http server started: ${httpServer.address}")
  }

  override def stop(): Unit = {
    if(httpServer != null) {
      try {
        httpServer.stop()
        log.info(s"http server stopped: ${httpServer.address}")
      }
      catch {
        case e: Throwable =>
          log.warn(s"http server closed abrubtly: ${httpServer.address}", e)
      }
    }
  }

  override def report(): Unit = ()
}
