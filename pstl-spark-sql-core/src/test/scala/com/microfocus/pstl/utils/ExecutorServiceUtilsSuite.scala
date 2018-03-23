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

import java.util.concurrent.{Executors, TimeUnit}

import org.scalatest._

class ExecutorServiceUtilsSuite extends FunSuite with Matchers {
  test("executor service utils usage") {
    val executor = Executors.newSingleThreadExecutor()
    executor.submit(new Runnable {
      override def run(): Unit = {
        Thread.sleep(500L)
      }
    })

    ExecutorServiceUtils.shutdown(executor, 500L, TimeUnit.MILLISECONDS)

    executor.isShutdown shouldBe true
    executor.isTerminated shouldBe true
  }

  test("executor service utils interrupt") {
    val executor = Executors.newSingleThreadExecutor()
    executor.submit(new Runnable {
      override def run(): Unit = {
        try {
          Thread.sleep(500L)
        }
        catch {
          case _: InterruptedException =>
            Thread.sleep(500L)
        }
      }
    })

    ExecutorServiceUtils.shutdown(executor, 500L, TimeUnit.MILLISECONDS)

    executor.isShutdown shouldBe true
    executor.isTerminated shouldBe true
  }

  test("executor service utils shutdown thread interrupt") {
    val executor = Executors.newSingleThreadExecutor()
    executor.submit(new Runnable {
      override def run(): Unit = {
        try {
          Thread.sleep(500L)
        }
        catch {
          case _: InterruptedException =>
            Thread.sleep(500L)
        }
      }
    })

    val shutdownThread = new Thread() {
      override def run(): Unit = {
        ExecutorServiceUtils.shutdown(executor, 500L, TimeUnit.MILLISECONDS)
        Thread.currentThread().isInterrupted shouldBe true
      }
    }

    shutdownThread.start()
    shutdownThread.interrupt()
    shutdownThread.join()

    executor.isShutdown shouldBe true
    executor.isTerminated shouldBe false
  }
}
