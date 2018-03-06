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

import akka.actor.{ActorContext, CoordinatedShutdown}
import akka.pattern.pipe

trait JobGuardianShutdownHook {
  def shutdown(context: ActorContext): Unit
}

object JobGuardianShutdownHook extends JobGuardianShutdownHook {
  override def shutdown(context: ActorContext): Unit = {
    import context.dispatcher
    val f = CoordinatedShutdown(context.system).run()
    f.pipeTo(context.self)
  }
}
