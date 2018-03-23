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

package com.microfocus.pstl.utils

import java.util.concurrent.ThreadLocalRandom

import scala.concurrent.duration.{Duration, FiniteDuration}

object ExponentialBackoff {
  def apply(restartCount: Int,
            minBackoff: FiniteDuration,
            maxBackoff: FiniteDuration): FiniteDuration = {
    apply(restartCount, minBackoff, maxBackoff, 0d)
  }

  def apply(restartCount: Int,
            minBackoff: FiniteDuration,
            maxBackoff: FiniteDuration,
            randomFactor: Double): FiniteDuration = {
    require(!(restartCount < 0), s"restartCount < 0: $restartCount")
    require(!(minBackoff < Duration.Zero), s"minBackoff < 0: $minBackoff")
    require(!(maxBackoff < Duration.Zero), s"maxBackoff < 0: $maxBackoff")
    require(minBackoff < maxBackoff, s"minBackoff < maxBackoff: $minBackoff, $maxBackoff")
    require(!(randomFactor < 0d), s"randomFactor < 0: $randomFactor")

    val rnd = 1.0 + ThreadLocalRandom.current().nextDouble() * randomFactor

    // Duration overflow protection (> 100 years)
    if (restartCount >= 30) {
      maxBackoff
    }
    else {
      // if restart count is very large and min/max are very large, exponential backoff
      // can quickly exceed FiniteDuration container size and we get an IllegalArgument
      // so we need to have a safe floor (here) or restrict users from using large min/max

      try {
        maxBackoff.min(minBackoff * math.pow(2, restartCount)) * rnd match {
          case f: FiniteDuration => f
          case _ => maxBackoff
        }
      }
      catch {
        case _: IllegalArgumentException =>
          maxBackoff
      }
    }
  }
}
