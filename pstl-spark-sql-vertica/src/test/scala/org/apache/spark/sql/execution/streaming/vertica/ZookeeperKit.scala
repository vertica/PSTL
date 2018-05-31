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

package org.apache.spark.sql.execution.streaming.vertica

import kafka.utils.ZkUtils
import org.scalatest._

trait ZookeeperKit extends BeforeAndAfterAll {

  this: Suite =>

  def zookeeperConnect(): String

  private var _zkUtils: ZkUtils = _
  def zkUtils: ZkUtils = _zkUtils

  override def beforeAll(): Unit = {
    super.beforeAll()
    _zkUtils = ZkUtils(zookeeperConnect(), 10000, 30000, isZkSecurityEnabled = false)
  }

  override def afterAll(): Unit = {
    try {
      _zkUtils.close()
    }
    catch {
      case _: Throwable => // ignore
    }

    super.afterAll()
  }
}
