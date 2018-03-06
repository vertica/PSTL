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

import akka.actor.SupervisorStrategy.{Escalate, Resume}
import akka.actor.{Actor, ActorLogging, ActorRef, OneForOneStrategy, Props, Stash, SupervisorStrategy, Terminated, Timers}

import org.apache.spark.sql.AnalysisException
import org.apache.spark.sql.catalyst.parser.ParseException
import org.apache.spark.sql.streaming.StreamingQueryListener._

object JobDaemon {
  case class JobSessionStarted(session: JobSession)
}

class JobDaemon extends Actor
  with Stash
  with Timers
  with ActorJobSettings
  with ActorLogging {

  import JobDaemon._

  private var session: JobSession = _
  private var metrics: JobDaemonMetrics = _

  override def supervisorStrategy: SupervisorStrategy = OneForOneStrategy() {
    case _: AnalysisException | _: ParseException => Escalate
    case _: Throwable => Resume
  }

  override def postStop(): Unit = {
    clearMetrics()
  }

  override def receive: Receive = starting

  private def starting: Receive = {
    case JobSessionStarted(session) =>
      this.session = session

      this.metrics = new JobDaemonMetrics(session.jobId)
      this.metrics.upGauge.set(1d)

      unstashAll()
      context become started

    case _ => stash()
  }

  private def started: Receive = {
    case e: QueryStartedEvent     => msgQueryDaemon(e.id, e)
    case e: QueryProgressEvent    => msgQueryDaemon(e.progress.id, e)
    case e: QueryTerminatedEvent  => msgQueryDaemon(e.id, e)
    case Terminated(_)            => maybeShutdownGracefully()
  }

  private def msgQueryDaemon(queryId: String, msg: Any): Unit = {
    val queryDaemon = getOrCreateQueryDaemon(queryId)
    queryDaemon ! msg
  }

  private def getOrCreateQueryDaemon(queryId: String): ActorRef = {
    context.child(queryId).getOrElse {
      val queryDaemon = context.actorOf(Props(new QueryDaemon(session)), queryId)
      context.watch(queryDaemon)
    }
  }

  private def maybeShutdownGracefully(): Unit = {
    if(context.children.isEmpty) {
      context.stop(self)
    }
  }

  private def clearMetrics(): Unit = Option(metrics).foreach { m =>
    m.upGauge.set(0d)
  }
}
