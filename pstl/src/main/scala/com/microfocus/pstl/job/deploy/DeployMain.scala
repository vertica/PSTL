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

import java.io.Closeable

import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.Source
import org.apache.spark.launcher.SparkLauncher
import com.microfocus.pstl.{BuildInfo, Constants}

object DeployMain {
  def main(args: Array[String]): Unit = {
    val options = new DeployOptions(args, sys.env)

    val deployDirectory = new DeployDirectory(options.deployDir)
    val installDirectory = new InstallDirectory(options.pstlHome)

    val launcher = setupEnvironmentVariables(
      systemEnvironment = installDirectory.environmentProperties,
      userEnvironment = deployDirectory.environmentProperties)

    setupSparkConfiguration(
      launcher,
      installDirectory.sparkProperties,
      deployDirectory.sparkProperties,
      installDirectory.environmentProperties,
      deployDirectory.environmentProperties)

    setupSparkFiles(
      launcher,
      installDirectory.sparkFiles,
      deployDirectory.sparkFiles)

    setupSparkJars(
      launcher,
      installDirectory.sparkJars,
      deployDirectory.sparkJars)

    if(!deployDirectory.sparkProperties.contains("spark.app.name")) {
      import BuildInfo._

      if(options.jobId.isEmpty) {
        val jobId = s"$groupId:$artifactId:$version:${deployDirectory.jobId}"

        deployLog.warn("job id not detected in spark.app.name in deploy spark.properties")
        deployLog.warn("job id not detected as command line argument")
        deployLog.info(s"job id generated using deploy directory name: $jobId")

        launcher.setAppName(jobId)
      }
      else {
        val jobId = s"$groupId:$artifactId:$version:${options.jobId.get}"

        deployLog.warn("job id not detected in spark.app.name in deploy spark.properties")
        deployLog.info(s"job id generated using command line argument: $jobId")

        launcher.setAppName(jobId)
      }
    }

    launcher.setMainClass("com.microfocus.pstl.Driver")
    launcher.setAppResource(installDirectory.sparkAppResource)
    launcher.setVerbose(options.verbose)
    launcher.setSparkHome(options.sparkHome.getCanonicalPath)
    launcher.addAppArgs("--job-id", options.jobId.getOrElse(deployDirectory.jobId.toString))

    val jobLauncher = new JobLauncher(launcher.launch())

    // todo: scalatyle should not give us shutdown hook warnings about hadoop, etc.
    // scalastyle:off
    Runtime.getRuntime.addShutdownHook(new Thread() {
      override def run(): Unit = {
        jobLauncher.close()
      }
    })
    // scalastyle:on

    // scalastyle:off
    Future(jobLauncher.stderrIterator.foreach(System.err.println))
    Future(jobLauncher.stdoutIterator.foreach(System.out.println))
    // scalastyle:on

    val exitCode = Await.result(jobLauncher.exitCode, Duration.Inf)

    System.exit(exitCode)
  }

  private def setupEnvironmentVariables(systemEnvironment: Map[String, String],
                                        userEnvironment: Map[String, String]): SparkLauncher = {
    val environment = mutable.Map[String, String]()

    systemEnvironment.foreach { case (key, value) =>
      environment.put(key, value)
    }

    userEnvironment.foreach { case (key, value) =>
      if(environment.contains(key)) {
        val oldValue = environment(key)
        deployLog.warn(s"system environment $key=$oldValue overriden by user $key=$value")
      }

      environment.put(key, value)
    }

    new SparkLauncher(environment.asJava)
  }

  private def setupSparkFiles(launcher: SparkLauncher,
                              systemFiles: Seq[String],
                              userFiles: Seq[String]): Unit = {
    systemFiles.foreach(launcher.addFile)
    userFiles.foreach(launcher.addFile)
  }

  private def setupSparkJars(launcher: SparkLauncher,
                             systemJars: Seq[String],
                             userJars: Seq[String]): Unit = {
    systemJars.foreach(launcher.addJar)
    userJars.foreach(launcher.addJar)
  }

  private def setupSparkConfiguration(launcher: SparkLauncher,
                                      systemConfiguration: Map[String, String],
                                      userConfiguration: Map[String, String],
                                      systemEnvironment: Map[String, String],
                                      userEnvironment: Map[String, String]): Unit = {
    val appendable = Map[String, String](
      "spark.driver.extraClassPath" -> Constants.PathSeparator,
      "spark.driver.extraJavaOptions" -> Constants.WhiteSpace,
      "spark.driver.extraLibraryPath" -> Constants.WhiteSpace,
      "spark.executor.extraClassPath" -> Constants.PathSeparator,
      "spark.executor.extraJavaOptions" -> Constants.WhiteSpace,
      "spark.executor.extraLibraryPath" -> Constants.WhiteSpace)

    val configuration = mutable.Map[String, String]()

    systemConfiguration.foreach { case (key, value) =>
      configuration.put(key, value)
    }

    userConfiguration.foreach { case (key, value) =>
      if(configuration.contains(key)) {
        if(appendable.contains(key)) {
          val oldValue = configuration(key)
          val separator = appendable(key)

          val newValue = s"$oldValue$separator$value"

          deployLog.warn(
            s"$key is defined in system configuration and user configuration, " +
            s"appending user configuration. system($oldValue), user($value), final($newValue)")

          configuration.put(key, newValue)
        }
        else {
          val oldValue = configuration(key)
          deployLog.warn(s"system configuration $key=$oldValue overriden by user $key=$value")

          configuration.put(key, value)
        }
      }
      else {
        configuration.put(key, value)
      }
    }

    configuration.foreach {
      case (key, value) =>
        launcher.setConf(key, value)
    }

    val isYarn = configuration.get("spark.master").exists(_.equalsIgnoreCase("yarn"))
    val isCluster = configuration.get("spark.submit.deployMode")
      .exists(_.equalsIgnoreCase("cluster"))

    if(isYarn && isCluster) {
      val environment = mutable.Map[String, String]()

      systemEnvironment.foreach(entry => environment.put(entry._1, entry._2))
      userEnvironment.foreach(entry => environment.put(entry._1, entry._2))

      environment.foreach {
        case (key, value) =>
          launcher.setConf(s"spark.yarn.appMasterEnv.$key", value)
      }
    }
  }

  class JobLauncher(process: Process)(implicit ec: ExecutionContext) extends Closeable {
    def exitCode: Future[Int] = Future {
      process.waitFor()
    }

    def stderrIterator: Iterator[String] = {
      Source.fromInputStream(process.getErrorStream).getLines()
    }

    def stdoutIterator: Iterator[String] = {
      Source.fromInputStream(process.getInputStream).getLines()
    }

    override def close(): Unit = {
      process.destroy()
    }
  }
}
