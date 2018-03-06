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

package com.microfocus.pstl.job.deploy

import java.nio.file.{Path, Paths,Files,StandardCopyOption}

import org.apache.spark.SparkFunSuite
import org.apache.spark.sql.test.SharedSQLContext
import org.scalatest.Matchers
import java.io._


class SparkJarsSuite extends SparkFunSuite with Matchers with SharedSQLContext {
  test("jars") {
    withTempDir { dir =>
      val file = new File(dir, "text.jar")
      file.getParentFile.mkdirs()
      file.createNewFile()
      val providedsparkjars = new ProvidesSparkJars {
       override protected def sparkJarsPath: Path = dir.toPath
      }
      val jars = providedsparkjars.sparkJars
      println(providedsparkjars.sparkJars)
      assert(jars == Seq(file.getCanonicalPath))
    }
  }
}
