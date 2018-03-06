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

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit, TestKitBase, TestProbe}
import com.microfocus.pstl.JobGuardian.JobMessage
import org.apache.spark.sql.execution.streaming.MemoryStream
import org.apache.spark.sql.streaming.{StreamTest, Trigger}
import org.apache.spark.sql.streaming.StreamingQueryListener.{QueryProgressEvent, QueryStartedEvent, QueryTerminatedEvent}
import org.scalatest._
import org.scalatest.time._
import org.scalatest.time.SpanSugar._

class QueryListenerSuite extends StreamTest
  with TestKitBase
  with ImplicitSender
  with BeforeAndAfterAll {

  import testImplicits._

  override val streamingTimeout: Span = 1.seconds
  override implicit lazy val system: ActorSystem = ActorSystem("pstl")

  override def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system)
    super.afterAll()
  }

  test("StreamingQueryListener sends JobMessage") {
    val probe = TestProbe()

    val jobId = new JobId("foo")
    val queryId = "bar"

    val listener = new JobStreamingQueryListener(jobId, probe.ref)
    sqlContext.streams.addListener(listener)

    val stream = MemoryStream[String]

    val query = stream.toDF()
      .writeStream
      .format("console")
      .queryName(queryId)
      .trigger(Trigger.Once())
      .start()

    try {
      stream.addData("1")
      failAfter(streamingTimeout) {
        query.processAllAvailable()
      }

      probe.expectMsgPF() {
        case JobMessage(`jobId`, e: QueryStartedEvent)
          if e.name == queryId => true
      }

      probe.expectMsgPF() {
        case JobMessage(`jobId`, e: QueryProgressEvent)
          if e.progress.batchId == 0 => true
      }

      probe.expectMsgPF() {
        case JobMessage(`jobId`, e: QueryTerminatedEvent)
          if e.exception.isEmpty => true
      }

      stream.addData("2")
      failAfter(streamingTimeout) {
        query.processAllAvailable()
      }

      probe.expectNoMsg()
    }
    finally {
      query.stop()
      sqlContext.streams.removeListener(listener)
    }
  }

  test("QueryListener is multi-tenant") {

  }
}
