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

import joptsimple.OptionException
import org.scalatest._

class DriverOptionsSuite extends FunSuite with Matchers {
  val validArgs = Array("--job-id", "foo")
  val noArgs = Array.empty[String]
  val invalidArgs = Array("--garbage", "t", "foo")

  test("driver options") {
    val options = new DriverOptions(validArgs)
    options.jobId shouldBe new JobId("foo")
  }

  ignore("driver options no args") {
    intercept[OptionException] {
      new DriverOptions(noArgs)
    }
  }

  test("driver options invalid args") {
    intercept[OptionException] {
      new DriverOptions(invalidArgs)
    }
  }
}
