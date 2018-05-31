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

import java.util.concurrent.TimeUnit

import scala.concurrent.duration._
import org.scalacheck.{Arbitrary, Gen}
import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

import scala.util.Try

class ExponentialBackoffSuite extends FunSuite with GeneratorDrivenPropertyChecks with Matchers {
  lazy val posFiniteDuration: Gen[FiniteDuration] = {
    Gen.chooseNum(0L, Long.MaxValue).map(Duration.fromNanos)
  }

  lazy val negFiniteDuration: Gen[FiniteDuration] = {
    Gen.chooseNum(Long.MinValue + 1, -1L).map(Duration.fromNanos)
  }

  implicit val d: Arbitrary[FiniteDuration] = Arbitrary(posFiniteDuration)

  test("exponential backoff") {
    forAll(Gen.posNum[Int], posFiniteDuration, posFiniteDuration) {
      case (i, min, max) if min < max =>
        val b = ExponentialBackoff(i, min, max)

        val expected = Try(min * Math.pow(2, i)).getOrElse(max)
        b should (be(expected) or be(max))

      case (i, min, max) =>
        intercept[IllegalArgumentException](ExponentialBackoff(i, min, max))
    }
  }

  test("exponential backoff restartCount < 0 throws") {
    forAll(Gen.negNum[Int]) { (restartCount: Int) =>
      intercept[IllegalArgumentException] {
        ExponentialBackoff(restartCount, 1.second, 1.minute)
      }
    }
  }

  test("exponential backoff minBackoff < 0 seconds throws") {
    forAll(negFiniteDuration) { (minBackoff: FiniteDuration) =>
      whenever(minBackoff < Duration.Zero) {
        intercept[IllegalArgumentException] {
          ExponentialBackoff(0, minBackoff, 1.minute)
        }
      }
    }
  }

  test("exponential backoff maxBackoff < 0 seconds throws") {
    forAll(negFiniteDuration) { (maxBackoff: FiniteDuration) =>
      intercept[IllegalArgumentException] {
        ExponentialBackoff(0, 1.second, maxBackoff)
      }
    }
  }

  test("exponential backoff randomFactor < 0 throws") {
    forAll(Gen.negNum[Double]) { (randomFactor: Double) =>
      intercept[IllegalArgumentException](
        ExponentialBackoff(0, 1.second, 1.minute, randomFactor))
    }
  }

  test("exponential backoff minBackoff < maxBackoff throws") {
    forAll(negFiniteDuration, negFiniteDuration) { (minBackoff: FiniteDuration, maxBackoff: FiniteDuration) =>
      intercept[IllegalArgumentException] {
        ExponentialBackoff(0, minBackoff, maxBackoff)
      }
    }
  }

  ignore("exponential backoff random factor") {
    forAll(Gen.posNum[Int], posFiniteDuration, posFiniteDuration, Gen.posNum[Double]) {
      case (i, min, max, rnd) if min < max =>
        val b = ExponentialBackoff(i, min, max, rnd)

        val floor = Try(min * Math.pow(2, i)).getOrElse(max)
        val ceiling = Try(floor * (1 + rnd)).getOrElse(max)
        b should (be >= floor and be <= ceiling)

      case (i, min, max, rnd) =>
        intercept[IllegalArgumentException](ExponentialBackoff(i, min, max, rnd))
    }
  }

  test("exponential backoff random factor is random") {
    val min = FiniteDuration(1, TimeUnit.SECONDS)
    val max = FiniteDuration(1, TimeUnit.MINUTES)

    forAll(Gen.posNum[Double]) { (r: Double) =>
      val b1 = ExponentialBackoff(0, min, max, r)
      val b2 = ExponentialBackoff(0, min, max, r)
      b1 should not equal b2
    }
  }
}
