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

import akka.actor.ActorRef

import org.apache.spark.sql.streaming.StreamingQueryListener
import org.apache.spark.sql.streaming.StreamingQueryListener._

import com.microfocus.pstl.JobGuardian._

class JobStreamingQueryListener(jobId: JobId, jobDaemon: ActorRef) extends StreamingQueryListener {
  override def onQueryStarted(e: QueryStartedEvent): Unit = notify(e)
  override def onQueryProgress(e: QueryProgressEvent): Unit = notify(e)
  override def onQueryTerminated(e: QueryTerminatedEvent): Unit = notify(e)

  private def notify(msg: AnyRef): Unit = {
    jobDaemon ! JobMessage(jobId, msg)
  }
}
