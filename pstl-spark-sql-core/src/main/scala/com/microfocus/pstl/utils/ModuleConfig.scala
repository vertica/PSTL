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

package com.microfocus.pstl.utils

import java.util

import scala.collection.JavaConverters._

import org.apache.spark.internal.Logging

case class ModuleConfig[T](module: String, config: Map[String, T]) extends Logging {
  def set(key: String, value: T): ModuleConfig[T] = {
    logInfo(s"$module: set '$key' to '$value', earlier value: '${config.getOrElse(key, "")}'")
    copy(config = config + (key -> value))
  }

  def setIfUnset(key: String, value: T): ModuleConfig[T] = {
    if(config.contains(key)) {
      logInfo(s"$module: set '$key' to '$value', no earlier value")
      copy(config = config + (key -> value))
    }
    else {
      this
    }
  }

  def asScala: Map[String, T] = config
  def asJava: util.Map[String, T] = new util.HashMap[String, T](config.asJava)
}
