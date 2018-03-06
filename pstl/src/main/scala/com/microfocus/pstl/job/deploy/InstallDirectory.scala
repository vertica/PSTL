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

import java.io.{File, FileNotFoundException}
import java.nio.file.{Files, Path}

import com.microfocus.pstl.BuildInfo

case class InstallDirectory(basePath: Path)
  extends ProvidesEnvironmentProperties
    with ProvidesSparkJars
    with ProvidesSparkFiles
    with ProvidesSparkProperties {

  def this(baseDir: File) = {
    this(baseDir.toPath)
  }

  def this(baseDir: String) = {
    this(new File(baseDir).toPath)
  }

  override protected def environmentPropertiesPath: Path = {
    basePath.resolve("conf/environment.properties")
  }

  override protected def sparkFilesPath: Path = {
    basePath.resolve("conf/spark_files")
  }

  override protected def sparkJarsPath: Path = {
    basePath.resolve("conf/spark_jars")
  }

  override protected def sparkPropertiesPath: Path = {
    basePath.resolve("conf/spark.properties")
  }

  def sparkAppResource: String = {
    import BuildInfo._

    val jarName = s"$artifactId-$version.jar"

    val path = basePath.resolve("lib").resolve(jarName)
    val pathString = path.normalize().toString

    if(Files.exists(path)) {
      pathString
    }
    else {
      throw new FileNotFoundException(pathString)
    }
  }

  override def sparkFiles: Seq[String] = {
    super.sparkFiles ++ internalSparkFiles
  }

  private def internalSparkFiles: Seq[String] = {
    val path = basePath.resolve("conf/pstl.conf")
    val pathString = path.normalize().toString

    if(Files.exists(path)) {
      deployLog.info(s"pstl.conf detected $pathString")
      Seq(pathString)
    }
    else {
      throw new DeployException(s"no pstl.conf detected $pathString")
    }
  }

  override def sparkJars: Seq[String] = {
    super.sparkJars ++ internalSparkJars
  }

  private def internalSparkJars: Seq[String] = {
    val path = basePath.resolve("lib")

    val dependencyManagement = configuredDependencyManagement

    if(dependencyManagement.nonEmpty) {
      deployLog.warn(
        s"skipping system jars from: $path, " +
        s"advanced dependency management detected: ${dependencyManagement.mkString(",")}")

      Seq.empty
    }
    else {
      deployLog.info(s"basic dependency management enabled, uploading system jars $path")

      val jars = path.toFile.listFiles(SparkJarFileFilter)

      Option(jars)
        .map(files => files.map(_.getCanonicalPath).toSeq)
        .getOrElse {
          deployLog.error(
            s"basic dependency management enabled, but unable to detect system jars $path")

          Seq.empty
        }
    }
  }

  private def configuredDependencyManagement: Seq[String] = {
    val props = sparkProperties
    val keys = Seq("spark.jars.packages", "spark.yarn.jars", "spark.yarn.archive")
    keys.filter(props.contains)
  }
}
