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

import java.util.concurrent.{ExecutorService, TimeUnit}

import scala.concurrent.ExecutionContextExecutorService
import scala.concurrent.duration.TimeUnit

import org.apache.spark.internal.Logging

object ExecutorServiceUtils extends Logging {
  def shutdown(context: ExecutionContextExecutorService): Unit = {
    shutdown(context, 100L, TimeUnit.MILLISECONDS)
  }

  def shutdown(context: ExecutionContextExecutorService, timeout: Long, unit: TimeUnit): Unit = {
    context.shutdown()

    try {
      if(!context.awaitTermination(timeout, unit)) {
        context.shutdownNow()
        if(!context.awaitTermination(timeout, unit)) {
          log.warn(s"unable to terminate executor service $context $timeout $unit")
        }
      }
    }
    catch {
      case e: InterruptedException =>
        log.debug(s"unable to terminate executor service $context $timeout $unit", e)
        context.shutdownNow()
        Thread.currentThread().interrupt()
    }
  }

  def shutdown(executor: ExecutorService): Unit = {
    shutdown(executor, 100L, TimeUnit.MILLISECONDS)
  }

  def shutdown(executor: ExecutorService, timeout: Long, unit: TimeUnit): Unit = {
    executor.shutdown()

    try {
      if(!executor.awaitTermination(timeout, unit)) {
        executor.shutdownNow()
        if(!executor.awaitTermination(timeout, unit)) {
          log.warn(s"unable to terminate executor service $executor $timeout $unit")
        }
      }
    }
    catch {
      case e: InterruptedException =>
        log.debug(s"unable to terminate executor service $executor $timeout $unit", e)
        executor.shutdownNow()
        Thread.currentThread().interrupt()
    }
  }
}
