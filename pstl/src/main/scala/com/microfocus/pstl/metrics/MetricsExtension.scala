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

package com.microfocus.pstl.metrics

import akka.Done
import akka.actor.{CoordinatedShutdown, ExtendedActorSystem, Extension, ExtensionId, ExtensionIdProvider}
import io.prometheus.client.hotspot.DefaultExports

import scala.concurrent.Future

object MetricsExtension extends ExtensionId[MetricsExtension] with ExtensionIdProvider {
  override def createExtension(system: ExtendedActorSystem): MetricsExtension = {
    new MetricsExtension(system)
  }

  override def lookup(): ExtensionId[_ <: Extension] = {
    MetricsExtension
  }
}

class MetricsExtension(system: ExtendedActorSystem) extends Extension {
  val settings = MetricsSettings(system)

  import CoordinatedShutdown._
  import settings._
  import system.dispatcher

  DefaultExports.initialize()

  private val httpServer = new DynamicHttpServer(HttpHost, HttpPort)
  system.log.info("Metric Http Server Started {}", httpServer.address.toString)

  /**
   * Register a shutdown task to ensure the embedded http server
   * shuts down with this JVM in a sane fashion
   */
  CoordinatedShutdown(system).addTask(PhaseServiceStop, "PstlMetrics") { () => shutdown() }

  private def shutdown(): Future[Done] = Future {
    httpServer.stop()
    Done
  }
}
