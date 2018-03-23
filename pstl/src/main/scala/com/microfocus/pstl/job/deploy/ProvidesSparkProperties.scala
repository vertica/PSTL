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

import java.nio.file.{Files, Path}

import scala.collection.JavaConverters._

import com.microfocus.pstl.utils.Utils

trait ProvidesSparkProperties {
  protected def sparkPropertiesPath: Path

  private lazy val _sparkProperties: Map[String, String] = {
    if(Files.exists(sparkPropertiesPath)) {
      deployLog.info(s"detected spark properties $sparkPropertiesPath")
      Utils.loadProperties(sparkPropertiesPath).asScala.toMap
    }
    else {
      deployLog.warn(s"skipping spark properties $sparkPropertiesPath")
      Map.empty
    }
  }

  def sparkProperties: Map[String, String] = _sparkProperties
}
