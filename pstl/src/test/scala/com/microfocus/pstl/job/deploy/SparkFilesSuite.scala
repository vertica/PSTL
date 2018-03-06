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

import java.io._

import org.apache.spark.{SparkConf, SparkContext, SparkFiles, SparkFunSuite}
import java.nio.file.{Files, Path, Paths}

import org.apache.spark.sql.test.SharedSQLContext
import org.scalatest.Matchers

class SparkFilesSuite extends SparkFunSuite with SharedSQLContext with Matchers  {
  test ("files")
  {
    withTempDir { dir =>
      val file = new File(dir, "text.txt")
      file.getParentFile.mkdirs()
      file.createNewFile()
      val providerSparkFiles = new ProvidesSparkFiles {
      override protected def sparkFilesPath: Path = dir.toPath
      }
      val files = providerSparkFiles.sparkFiles
      println(providerSparkFiles.sparkFiles)
      assert(files == Seq(file.getCanonicalPath))
    }
  }

}
