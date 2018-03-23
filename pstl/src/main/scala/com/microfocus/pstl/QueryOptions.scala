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

import java.util.concurrent.TimeUnit

import scala.concurrent.duration.{Duration, FiniteDuration}
import scala.util.Try

import org.apache.spark.sql.catalyst.util.CaseInsensitiveMap

object QueryOptions {
  lazy val RetryMinBackoff = "__pstl_retry_min_backoff"
  lazy val RetryMaxBackoff = "__pstl_retry_max_backoff"
  lazy val RetryRandomFactor = "__pstl_retry_random_factor"
}

class QueryOptions(options: CaseInsensitiveMap[String]) {

  import QueryOptions._

  def this() = this(CaseInsensitiveMap(Map.empty[String, String]))
  def this(options: Map[String, String]) = this(CaseInsensitiveMap(options))
  def this(key: String, value: String) = this(CaseInsensitiveMap(Map(key -> value)))

  def retryMinBackoff: Option[FiniteDuration] = {
    getFiniteDuration(RetryMinBackoff)
  }

  def retryMaxBackoff: Option[FiniteDuration] = {
    getFiniteDuration(RetryMaxBackoff)
      .filter(max => retryMinBackoff.isEmpty || retryMinBackoff.exists(_ < max))
  }

  def retryRandomFactor: Option[Double] = {
    options.get(RetryRandomFactor).flatMap { value =>
      Try(value.toDouble).toOption
        .filter(x => x > 0.0 && x <= 1.0)
    }
  }

  private def getFiniteDuration(key: String): Option[FiniteDuration] = {
    options.get(key).flatMap { value =>
      Try(Duration(value)).toOption
        .filter(_.isFinite())
        .map(_.asInstanceOf[FiniteDuration])
        .filter(_ > FiniteDuration(0, TimeUnit.NANOSECONDS))
    }
  }
}
