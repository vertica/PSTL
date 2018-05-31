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

import java.time.Duration

import akka.actor.ActorSystem
import com.typesafe.config.Config

object JobSettings {
  def apply(system: ActorSystem): JobSettings = {
    JobSettings(system.settings.config)
  }
}

case class JobSettings(config: Config) {
  private val cc = config.getConfig("pstl.job")
  val RetryMinBackoff: Duration = cc.getDuration("retry-min-backoff")
  val RetryMaxBackoff: Duration = cc.getDuration("retry-max-backoff")
  val RetryRandomFactor: Double = cc.getDouble("retry-random-factor")
}
