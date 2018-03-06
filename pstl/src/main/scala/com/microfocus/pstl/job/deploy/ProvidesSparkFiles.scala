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

import java.nio.file.Path

trait ProvidesSparkFiles {
  protected def sparkFilesPath: Path

  private lazy val _sparkFiles: Seq[String] = {
    val dir = sparkFilesPath.toFile
    val maybeFiles = dir.listFiles(SparkFileFileFilter)

    Option(maybeFiles)
      .map { files =>
        deployLog.info(s"spark files detected (${files.length}): $dir")
        tf2s(files)
      }
      .getOrElse {
        deployLog.warn(s"spark files detected (0): $dir")
        Seq.empty
      }
  }

  def sparkFiles: Seq[String] = _sparkFiles
}
