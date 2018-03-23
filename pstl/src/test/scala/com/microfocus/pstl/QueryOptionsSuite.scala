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

import scala.concurrent.duration._
import org.scalacheck.{Arbitrary, Gen}
import org.scalatest._
import org.scalatest.prop._

class QueryOptionsSuite extends FunSuite with GeneratorDrivenPropertyChecks with Matchers {

  import QueryOptions._

  lazy val posFiniteDuration: Gen[FiniteDuration] = {
    Gen.chooseNum(1L, Long.MaxValue).map(Duration.fromNanos)
  }

  lazy val validFiniteDurations: Gen[FiniteDuration] = {
    for {
      d <- finiteDuration if d > Duration.Zero
    } yield d
  }

  lazy val duration: Gen[Duration] = {
    Gen.frequency(
      1 -> Gen.const(Duration.Inf),
      1 -> Gen.const(Duration.MinusInf),
      1 -> Gen.const(Duration.Undefined),
      1 -> Gen.const(Duration.Zero),
      6 -> finiteDuration
    )
  }

  lazy val finiteDuration: Gen[FiniteDuration] = {
    Gen.chooseNum(Long.MinValue + 1, Long.MaxValue)
      .map(Duration.fromNanos)
  }

  implicit val arbDuration: Arbitrary[Duration] = Arbitrary(duration)
  implicit val arbFiniteDuration: Arbitrary[FiniteDuration] = Arbitrary(finiteDuration)

  test("query options") {
    val options = new QueryOptions()
    options.retryMinBackoff shouldBe empty
    options.retryMaxBackoff shouldBe empty
    options.retryRandomFactor shouldBe empty
  }

  test(s"query options $RetryMinBackoff") {
    forAll { (d: Duration) =>
      val options = new QueryOptions(RetryMinBackoff, d.toString)

      if(d.isFinite() && d > Duration.Zero) options.retryMinBackoff shouldBe Option(d)
      else options.retryMinBackoff shouldBe empty
    }
  }

  test(s"query options $RetryMaxBackoff") {
    forAll { (d: Duration) =>
      val options = new QueryOptions(RetryMaxBackoff, d.toString)

      if(d.isFinite && d > Duration.Zero) options.retryMaxBackoff shouldBe Option(d)
      else options.retryMaxBackoff shouldBe empty
    }
  }

  test(s"query options $RetryMinBackoff < $RetryMaxBackoff") {
    forAll(posFiniteDuration, posFiniteDuration) { (min: FiniteDuration, max: FiniteDuration) =>
      val options = new QueryOptions(Map(
        RetryMinBackoff -> min.toString,
        RetryMaxBackoff -> max.toString
      ))

      if(min < max) {
        options.retryMinBackoff shouldBe Option(min)
        options.retryMaxBackoff shouldBe Option(max)
      }
      else {
        options.retryMinBackoff shouldBe Option(min)
        options.retryMaxBackoff shouldBe empty
      }
    }
  }

  test(s"query options $RetryRandomFactor") {
    forAll(Gen.choose(0d, 1d)) { (d: Double) =>
      val options = new QueryOptions(RetryRandomFactor, d.toString)
      options.retryRandomFactor shouldBe Option(d)
    }

    forAll(Gen.choose(Double.MinValue, 0)) { (d: Double) =>
      val options = new QueryOptions(RetryRandomFactor, d.toString)
      options.retryRandomFactor shouldBe empty
    }

    forAll(Gen.choose(1, Double.MaxValue)) { (d: Double) =>
      val options = new QueryOptions(RetryRandomFactor, d.toString)
      options.retryRandomFactor shouldBe empty
    }
  }
}
