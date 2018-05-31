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

import com.microfocus.pstl.BuildInfo
import com.microfocus.pstl.utils.CommandLineUtils
import joptsimple.OptionParser

class DeployOptions(args: Array[String], env: Map[String, String]) {
  private val parser = new OptionParser(false)

  private val deployOpt = parser.accepts("deploy", "job directory to deploy")
    .withRequiredArg()
    .ofType(classOf[File])

  private val jobIdOpt = parser.accepts("job-id", "human readable label to identify this job")
    .withOptionalArg()
    .ofType(classOf[String])

  private val pstlHomeOpt = parser.accepts("pstl-home", "path to pstl installation directory")
    .withOptionalArg()
    .ofType(classOf[File])

  private val sparkHomeOpt = parser.accepts("spark-home", "path to spark installation directory")
    .withOptionalArg()
    .ofType(classOf[File])

  private val helpOpt = parser.accepts("help", "show this message")
  private val verboseOpt = parser.accepts("verbose", "provide(s) verbose output")
  private val versionOpt = parser.accepts("version", "show version number and quit")

  if(args.isEmpty) {
    CommandLineUtils.printUsageAndDie(parser, "pstl --deploy /path/to/job")
  }

  private val options = parser.parse(args: _*)

  if(options.has(helpOpt)) {
    CommandLineUtils.printUsageAndDie(parser, "pstl --deploy /path/to/job")
  }
  else if(options.has(versionOpt)) {
    System.out.println(BuildInfo.version)
    System.exit(0)
  }

  val deployDir: File = {
    val f = options.valueOf(deployOpt)
    if(!f.exists()) {
      throw new DeployException(s"$deployOpt $f does not exist")
    }
    else if(!f.isDirectory) {
      throw new DeployException(s"$deployOpt $f is not a directory")
    }
    f
  }

  val jobId: Option[String] = {
    if(options.has(jobIdOpt)) {
      val s = options.valueOf(jobIdOpt)
      if(s.trim.isEmpty) {
        throw new DeployException(s"$jobIdOpt can not be empty")
      }
      Option(s)
    }
    else {
      None
    }
  }

  val pstlHome: File = {
    if(options.has(pstlHomeOpt)) {
      val f = options.valueOf(pstlHomeOpt)
      if(!f.exists()) {
        throw new DeployException(s"$pstlHomeOpt $f does not exist")
      }
      else if(!f.isDirectory) {
        throw new DeployException(s"$pstlHomeOpt $f is not a directory")
      }
      f
    }
    else if(env.contains("PSTL_HOME")) {
      val f = new File(env("PSTL_HOME"))
      if(!f.exists()) {
        throw new DeployException(s"PSTL_HOME $f does not exist")
      }
      else if(!f.isDirectory) {
        throw new DeployException(s"PSTL_HOME $f is not a directory")
      }
      f
    }
    else {
      throw new DeployException(
        s"Either $pstlHomeOpt must be specified as a command line argument, " +
        "or PSTL_HOME must be provided as an environment variable")
    }
  }

  val sparkHome: File = {
    if(options.has(sparkHomeOpt)) {
      val f = options.valueOf(sparkHomeOpt)
      if(!f.exists()) {
        throw new DeployException(s"$sparkHomeOpt $f does not exist")
      }
      else if(!f.isDirectory) {
        throw new DeployException(s"$sparkHomeOpt $f is not a directory")
      }
      f
    }
    else if(env.contains("SPARK_HOME")){
      val f = new File(env("SPARK_HOME"))
      if(!f.exists()) {
        throw new DeployException(s"SPARK_HOME $f does not exist")
      }
      else if(!f.isDirectory) {
        throw new DeployException(s"SPARK_HOME $f is not a directory")
      }
      f
    }
    else {
      throw new DeployException(
        s"Either $sparkHomeOpt must be specified as a command line argument, " +
        "or SPARK_HOME must be provided as an environment variable")
    }
  }

  val verbose: Boolean = options.has(verboseOpt)
}
