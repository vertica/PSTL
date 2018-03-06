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

import java.util.Properties

object BuildInfo {
  private lazy val properties = {
    val p = new Properties()
    val is = getClass.getClassLoader.getResourceAsStream("build-info.properties")

    try {
      p.load(is)
    }
    finally {
      is.close()
    }

    p
  }

  lazy val groupId: String = properties.getProperty("build.groupId")
  lazy val artifactId: String = properties.getProperty("build.artifactId")
  lazy val version: String = properties.getProperty("build.version")
  lazy val scalaVersion: String = properties.getProperty("build.scala.version")
  lazy val scalaBinaryVersion: String = properties.getProperty("build.scala.binary.version")
}
