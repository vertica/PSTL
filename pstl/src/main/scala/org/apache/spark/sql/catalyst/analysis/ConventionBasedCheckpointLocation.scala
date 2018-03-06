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

package org.apache.spark.sql.catalyst.analysis

import org.apache.spark.sql.{AnalysisException, SparkSession}
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.catalyst.rules.Rule
import org.apache.spark.sql.execution.datasources.SaveStreamToCommand
import org.apache.spark.sql.internal.SQLConf

case class ConventionBasedCheckpointLocation(spark: SparkSession) extends Rule[LogicalPlan] {

  import SQLConf._

  override def apply(plan: LogicalPlan): LogicalPlan = plan transform {
    case x: SaveStreamToCommand if x.checkpointLocation.isEmpty =>
      val baseDir = spark.conf.get(CHECKPOINT_LOCATION)

      if(baseDir.isEmpty) {
        val key = CHECKPOINT_LOCATION.key
        throw new AnalysisException(
          s"Please configure '$key' to a desirable base directory so we can " +
          "store WAL(s) for your jobs and their streaming queries.", plan = Option(plan))
      }

      if(!x.options.contains("__pstl_job_id")) {
        throw new AnalysisException(
          s"BugOrBroken: Expected __pstl_job_id to be configured within your streaming " +
          "query options. Although you could set this explicitly it is an indication of " +
          "a larger bug with this build/version or similar.", plan = Option(plan))
      }

      val jobId = x.options("__pstl_job_id")
      val checkpointLocation = s"${baseDir.get}/$jobId/${x.queryName}"

      x.copy(options = x.options +
        ("checkpointLocation" -> checkpointLocation))
  }
}
