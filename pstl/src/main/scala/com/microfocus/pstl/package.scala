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

package com.microfocus

import java.time.{Duration => JDuration}
import java.util.UUID
import java.util.concurrent.TimeUnit

import scala.concurrent.duration.{Duration, FiniteDuration}
import scala.language.implicitConversions

package object pstl {
  implicit def jobId2String(jobId: JobId): String = jobId.toString

  implicit def jd2sd(duration: JDuration): Duration = {
    Duration(duration.toNanos, TimeUnit.NANOSECONDS)
  }

  implicit def jd2sfd(duration: JDuration): FiniteDuration = {
    FiniteDuration(duration.toNanos, TimeUnit.NANOSECONDS)
  }

  implicit class OptionOps[T](option: Option[T]) {
    def either[U](some: T => U, none: => U): U = option match {
      case Some(v) => some(v)
      case None => none
    }
  }

  implicit def uuid2string(uuid: UUID): String = uuid.toString
}
