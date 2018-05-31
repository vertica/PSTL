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

import akka.actor.{Actor, ActorLogging, CoordinatedShutdown, OneForOneStrategy, SupervisorStrategy, Terminated}
import akka.actor.SupervisorStrategy.{Resume, Stop}

import org.apache.spark.sql.AnalysisException
import org.apache.spark.sql.catalyst.parser.ParseException

object JobGuardian {
  case class JobMessage(jobId: JobId, msg: AnyRef)
}

class JobGuardian(daemonFactory: JobDaemonFactory,
                  daemonRepository: JobDaemonRepository) extends Actor with ActorLogging {

  import JobGuardian._

  override def supervisorStrategy: SupervisorStrategy = OneForOneStrategy() {
    case _: AnalysisException | _: ParseException => // paranoid
      CoordinatedShutdown(context.system).run()
      Stop

    case _: Throwable => Resume
  }

  override def receive: Receive = {
    case JobMessage(jobId, msg) =>
      val jobDaemon = context.watch(
        daemonRepository.findJobDaemon(jobId, context)
          .getOrElse(daemonFactory.createJobDaemon(jobId, context)))

      jobDaemon forward msg

    case Terminated(_) =>
      maybeShutdownCleanly()
  }

  private def maybeShutdownCleanly(): Unit = {
    if(context.children.isEmpty) {
      context.stop(self)
    }
  }
}
