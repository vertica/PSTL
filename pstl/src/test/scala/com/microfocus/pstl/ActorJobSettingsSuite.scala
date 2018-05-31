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

import akka.actor.{Actor, ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKitBase}
import org.scalatest._

class ActorJobSettingsSuite extends FunSuite
  with Matchers
  with TestKitBase
  with ImplicitSender {

  override implicit lazy val system: ActorSystem = ActorSystem("pstl")

  test("actor job settings") {
    val settings = JobExtension(system).settings

    val a1 = system.actorOf(Props(new FakeActor))
    a1 ! settings
    expectMsg(settings)

    val a2 = system.actorOf(Props(new FakeActor))
    a2 ! settings
    expectMsg(settings)
  }

  class FakeActor extends Actor with ActorJobSettings {
    override def receive: Receive = {
      case _ => sender() ! jobSettings
    }
  }
}
