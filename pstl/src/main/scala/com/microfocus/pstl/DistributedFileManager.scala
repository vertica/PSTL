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

import java.nio.charset.Charset
import java.nio.file.{Files, Paths}

import org.apache.spark.SparkFiles
import org.apache.spark.sql.SparkSession

class DistributedFileManager(spark: SparkSession) {
  def readAllLines(file: String): String = {
    readAllLines(file, Charset.forName("UTF-8"))
  }

  def readAllLines(file: String, encoding: Charset): String = {
    val path = SparkFiles.get(file)
    val bytes = Files.readAllBytes(Paths.get(path))
    new String(bytes, encoding)
  }
}
