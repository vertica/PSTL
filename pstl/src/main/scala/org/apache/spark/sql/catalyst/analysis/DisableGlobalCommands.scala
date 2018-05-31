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
import org.apache.spark.sql.execution.command.{CreateFunctionCommand, CreateViewCommand, LocalTempView}
import org.apache.spark.sql.execution.datasources.CreateTempViewUsing

case class DisableGlobalCommands(spark: SparkSession) extends (LogicalPlan => Unit) {
  override def apply(plan: LogicalPlan): Unit = plan match {
    case x: CreateViewCommand if x.viewType != LocalTempView =>
      throw new AnalysisException(
        "global temporary views are disabled", plan = Option(plan))

    case x: CreateTempViewUsing if x.global =>
      throw new AnalysisException(
        "global temporary views are disabled", plan = Option(plan))

    case x: CreateFunctionCommand if !x.isTemp =>
      throw new AnalysisException(
        "global function registrations are disabled", plan = Option(plan))

    // todo: is there a functional construct on LogicalPlan that just lets use PartialFunction?
    case _ => // ignore (prevent match error)
  }
}
