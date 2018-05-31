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

import org.scalacheck.Arbitrary._
import org.scalacheck.Gen
import org.scalacheck.Prop._

import org.scalatest._
import prop._

class JobIdSuite extends PropSpec with PropertyChecks with Matchers {
  property("job_id accepts valid names") {
    val nameGen = for {
      prefix <- Gen.alphaChar
      suffix <- Gen.alphaStr
    } yield prefix + suffix

    forAll(nameGen.suchThat(x => x.length >= 3 && x.length <= 128)) { name =>
      new JobId(name)
      true
    }

    new JobId(nameGen.sample.get)
  }

  property("job_id rejects invalid names") {
    val nameGen = for {
      name <- arbitrary[String].suchThat { s: String =>
        s match {
          case JobId.nameRegex(_) => false
          case _ => true
        }
      }
    } yield name

    forAll(nameGen) { name =>
      an[IllegalArgumentException] should be thrownBy {
        new JobId(name)
      }
    }
  }
}
