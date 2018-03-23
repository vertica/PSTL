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

import org.scalatest._

class BuildInfoSuite extends FunSuite with Matchers {
  test("usage") {
    BuildInfo.groupId shouldBe "com.microfocus.pstl"
    BuildInfo.artifactId shouldBe "pstl_2.11"
    BuildInfo.version shouldBe "1.0.0-SNAPSHOT"
    BuildInfo.scalaVersion shouldBe "2.11.8"
    BuildInfo.scalaBinaryVersion shouldBe "2.11"
  }
}
