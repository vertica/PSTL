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

import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.execution.datasources.SaveStreamToCommand

class JobPlan(plans: Seq[LogicalPlan]) {
  val prerequisites: Seq[LogicalPlan] = plans.collect {
    case plan: LogicalPlan if !isStreamingQueryPlan(plan) =>
      plan
  }

  val streamingQueries: Seq[SaveStreamToCommand] = plans.collect {
    case plan: LogicalPlan if isStreamingQueryPlan(plan) =>
      plan.asInstanceOf[SaveStreamToCommand]
  }

  require(prerequisites.nonEmpty)
  require(streamingQueries.nonEmpty)

  def isEmpty: Boolean = plans.isEmpty

  def add(plan: LogicalPlan): JobPlan = {
    new JobPlan(plans :+ plan)
  }

  def foreach[T](f: LogicalPlan => T): Unit = {
    prerequisites.foreach(f)
    streamingQueries.foreach(f)
  }

  def transform(f: PartialFunction[LogicalPlan, LogicalPlan]): JobPlan = {
    val newPlans = plans.map { p =>
      if(f.isDefinedAt(p)) f(p) else p
    }

    new JobPlan(newPlans)
  }

  override def toString: String = toString("\n")
  def toString(sep: String): String = plans.mkString(sep)

//  override def hashCode(): Int = {
//    var result = 31
//    result = 37 * result + plans.hashCode()
//    result
//  }
//
//  override def equals(obj: Any): Boolean = obj match {
//    case x: JobPlan => plans.equals(x.plans)
//    case _ => false
//  }

  private def isStreamingQueryPlan(plan: LogicalPlan): Boolean = {
    plan.isInstanceOf[SaveStreamToCommand]
  }
}
