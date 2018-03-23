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

import java.net.InetSocketAddress

import io.prometheus.client.CollectorRegistry
import io.prometheus.client.exporter.HTTPServer

class DynamicHttpServer(addr: InetSocketAddress,
                        registry: CollectorRegistry) extends HTTPServer(addr, registry) {

  // lift address in case port=0 for dynamic assignment
  // so port can be routed according to discovery policies
  def address: InetSocketAddress = {
    server.getAddress
  }

  def this(port: Int) = {
    this(new InetSocketAddress(port), CollectorRegistry.defaultRegistry)
  }

  def this(host: String, port: Int) = {
    this(new InetSocketAddress(host, port), CollectorRegistry.defaultRegistry)
  }
}
