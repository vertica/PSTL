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

import java.nio.file.{Files, Paths}

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import akka.actor.{ActorSystem, CoordinatedShutdown}
import com.microfocus.pstl.spark.SparkExtension
import com.typesafe.config.ConfigFactory
import org.apache.spark.SparkFiles

object Driver {
  def main(args: Array[String]): Unit = {
    val options = new DriverOptions(args)
    val system = ActorSystem("pstl", ConfigFactory.load("pstl"))

    try {
      val sparkExtension = SparkExtension(system)

      val jobDefinition = loadJobDefinition()

      sparkExtension.withSession { spark =>
        val jobSession = JobSession.builder()
          .jobId(options.jobId)
          .jobDefinition(jobDefinition)
          .jobGuardian(JobExtension(system).jobGuardian)
          .sparkSession(spark)
          .build()

        jobSession.start()

        CoordinatedShutdown(system).addJvmShutdownHook(jobSession.stop())
      }
    }
    catch {
      case e: Throwable =>
        e.printStackTrace()
        CoordinatedShutdown(system).run()
    }

    Await.ready(system.whenTerminated, Duration.Inf)
  }

  private def loadJobDefinition(): JobDefinition = {
    if(Files.exists(Paths.get("job.sql"))) {
      val bytes = Files.readAllBytes(Paths.get("job.sql"))
      val sql = new String(bytes)
      new JobDefinition(sql)
    }
    else {
      val path = SparkFiles.get("job.sql")
      val bytes = Files.readAllBytes(Paths.get(path))
      val sql = new String(bytes)
      new JobDefinition(sql)
    }
  }
}
