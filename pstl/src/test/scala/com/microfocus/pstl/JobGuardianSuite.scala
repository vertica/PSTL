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

import java.util.concurrent.atomic.AtomicBoolean

import scala.concurrent.duration._
import akka.actor.{ActorContext, ActorRef, ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit, TestKitBase, TestProbe}
import com.microfocus.pstl.JobGuardian.JobMessage
import org.scalatest._

class JobGuardianSuite extends FunSuite
  with Matchers
  with BeforeAndAfterAll
  with TestKitBase
  with ImplicitSender {

  override implicit lazy val system: ActorSystem = ActorSystem("pstl")

  override def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system)
    super.afterAll()
  }

  test("job guardian routes to job daemon") {
    val probe = TestProbe()

    val props = Props(new JobGuardian(
      new TestJobDaemonFactory(probe.ref),
      new TestJobDaemonRepository(None)
    ))

    val guardian = system.actorOf(props)

    guardian ! JobMessage(new JobId("foo"), "hello")
    probe.expectMsg("hello")
  }

  test("job guardian shuts down if children leave gracefully") {
    val foo = TestProbe("foo")
    val bar = TestProbe("bar")

    val factory = new ManyJobDaemons(Map(
      new JobId("foo") -> foo.ref,
      new JobId("bar") -> bar.ref
    ))

    val props = Props(new JobGuardian(factory, factory))
    val guardian = system.actorOf(props)

    val monitor = TestProbe()
    monitor.watch(guardian)

    guardian ! JobMessage(new JobId("foo"), "activity")
    guardian ! JobMessage(new JobId("bar"), "activity")

    system.stop(foo.ref)
    system.stop(bar.ref)

    monitor.expectTerminated(guardian, 1.second)
  }

  class ManyJobDaemons(refs: Map[JobId, ActorRef]) extends JobDaemonFactory with JobDaemonRepository {
    override def findJobDaemon(jobId: JobId,
                               context: ActorContext): Option[ActorRef] = {
      refs.get(jobId)
    }

    override def createJobDaemon(jobId: JobId,
                                 context: ActorContext): ActorRef = {
      refs(jobId)
    }
  }


  class TestJobDaemonRepository(ref: Option[ActorRef]) extends JobDaemonRepository {
    override def findJobDaemon(jobId: JobId, context: ActorContext): Option[ActorRef] = ref
  }

  class TestJobDaemonFactory(ref: ActorRef) extends JobDaemonFactory {
    override def createJobDaemon(jobId: JobId, context: ActorContext): ActorRef = ref
  }

  object ShutdownHook extends JobGuardianShutdownHook {
    private val _isShutdown = new AtomicBoolean(false)
    def isShutdown: Boolean = _isShutdown.get()
    override def shutdown(context: ActorContext): Unit = _isShutdown.compareAndSet(false, true)
  }
}
