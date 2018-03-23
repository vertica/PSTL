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

import java.io.File
import java.nio.file.{Files, Path}

import com.microfocus.pstl.JobId

case class DeployDirectory(basePath: Path)
  extends ProvidesEnvironmentProperties
    with ProvidesSparkFiles
    with ProvidesSparkJars
    with ProvidesSparkProperties {

  def this(baseDir: File) = {
    this(baseDir.toPath)
  }

  def this(baseDir: String) = {
    this(new File(baseDir).toPath)
  }

  override protected def environmentPropertiesPath: Path = {
    basePath.resolve("environment.properties")
  }

  override protected def sparkFilesPath: Path = {
    basePath.resolve("spark_files")
  }

  override protected def sparkJarsPath: Path = {
    basePath.resolve("spark_jars")
  }

  override protected def sparkPropertiesPath: Path = {
    basePath.resolve("spark.properties")
  }

  def jobId: JobId = {
    new JobId(basePath.toFile.getName)
  }

  override def sparkFiles: Seq[String] = {
    super.sparkFiles ++ internalSparkFiles
  }

  private def internalSparkFiles: Seq[String] = {
    val path = basePath.resolve("job.sql")
    val pathString = path.normalize().toString

    if(Files.exists(path)) {
      deployLog.info(s"job detected $pathString")
      Seq(pathString)
    }
    else {
      throw new DeployException(s"no job detected $pathString")
    }
  }
}
