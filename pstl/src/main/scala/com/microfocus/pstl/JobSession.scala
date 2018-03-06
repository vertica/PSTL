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

import akka.actor.ActorRef

import org.apache.spark.internal.Logging
import org.apache.spark.sql.{DatasetPrivateMethods, SparkSession}
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.execution.datasources.{CreateStreamFromCommand, SaveStreamToCommand}

import com.microfocus.pstl.JobGuardian.JobMessage

object JobSession {
  def builder(): Builder = {
    new Builder()
  }

  class Builder {
    private var jobId: JobId = _
    private var jobDefinition: JobDefinition = _
    private var jobGuardian: ActorRef = _
    private var sparkSession: SparkSession = _

    def jobId(jobId: JobId): Builder = {
      this.jobId = jobId
      this
    }

    def jobDefinition(jobDefinition: JobDefinition): Builder = {
      this.jobDefinition = jobDefinition
      this
    }

    def jobGuardian(jobGuardian: ActorRef): Builder = {
      this.jobGuardian = jobGuardian
      this
    }

    def sparkSession(sparkSession: SparkSession): Builder = {
      this.sparkSession = sparkSession
      this
    }

    def build(): JobSession = {
      new JobSession(
        jobId,
        jobDefinition,
        jobGuardian,
        sparkSession
      )
    }
  }
}

class JobSession private(val jobId: JobId,
                         jobDefinition: JobDefinition,
                         jobGuardian: ActorRef,
                         spark: SparkSession) extends Logging {

  import JobDaemon._

  private val logicalPlans = initializeLogicalPlans(jobDefinition)
  private val planDependencies = extractPlanDependencies(logicalPlans)
  private val planQueries = extractPlanQueries(logicalPlans)
  private val streamingQueryListener = new JobStreamingQueryListener(jobId, jobGuardian)

  def start(): Unit = {
    spark.streams.addListener(streamingQueryListener)

    // todo: cbowden set these correctly (move to constants)
//    sparkSession.sparkContext.setLocalProperty("__pstl_jobId", jobId.toString)
//    sparkSession.sparkContext.setLocalProperty("__pstl_sinkId", plan.queryName)

    (planDependencies ++ planQueries.values).foreach(executePlan)

    jobGuardian ! JobMessage(jobId, JobSessionStarted(this))
  }

  def restart(queryId: String): Unit = {
    val plan = findPlanByQueryId(queryId)

    // todo: cbowden set these correctly (move to constants)
//      sparkSession.sparkContext.setLocalProperty("__pstl_jobId", jobId.toString)
//      sparkSession.sparkContext.setLocalProperty("__pstl_sinkId", plan.queryName)

    executePlan(plan)
  }

  def stop(): Unit = {
    stopAllStreamingQueries()
    spark.streams.removeListener(streamingQueryListener)
  }

  def queryOptions(queryId: String): QueryOptions = {
    val plan = findPlanByQueryId(queryId)
    new QueryOptions(plan.options)
  }

  private[pstl] def initializeLogicalPlans(definition: JobDefinition): Seq[LogicalPlan] = {
    val parser = spark.sessionState.sqlParser
    val logicalPlans = definition.map(parser.parsePlan)

    if (!logicalPlans.exists(_.isInstanceOf[CreateStreamFromCommand])) {
      throw new InvalidJobDefinitionException("No streaming sources detected", definition)
    }
    else if (!logicalPlans.exists(_.isInstanceOf[SaveStreamToCommand])) {
      throw new InvalidJobDefinitionException("No streaming sinks detected", definition)
    }

    logicalPlans.map(_.transform(injectJobMetadata))
  }

  private[pstl] def injectJobMetadata: PartialFunction[LogicalPlan, LogicalPlan] = {
    case streamingQuery: SaveStreamToCommand =>
      val additionalOptions = Map(
        "__pstl_job_id" -> jobId.toString,
        "__pstl_sink_id" -> streamingQuery.queryName
      )

      streamingQuery.copy(options = streamingQuery.options ++ additionalOptions)
  }

  private[pstl] def executePlan(plan: LogicalPlan): Unit = {
    DatasetPrivateMethods.ofRows(spark, plan)
  }

  private[pstl] def extractPlanDependencies(plans: Seq[LogicalPlan]): Seq[LogicalPlan] = {
    plans.filterNot(predicateStreamingQuery)
  }

  private[pstl] def extractPlanQueries(plans: Seq[LogicalPlan])
    : Map[String, SaveStreamToCommand] = {
    plans.filter(predicateStreamingQuery)
      .map(_.asInstanceOf[SaveStreamToCommand])
      .map(query => query.queryName -> query)
      .toMap
  }

  private[pstl] def predicateStreamingQuery: PartialFunction[LogicalPlan, Boolean] = {
    case _: SaveStreamToCommand => true
    case _ => false
  }

  private def findPlanByQueryId(queryId: String): SaveStreamToCommand = {
    planQueries.getOrElse(queryId,
      throw new QueryNotFoundException(
        s"Query '$queryId' was not provided in job definition '$jobId'"))
  }

  private def stopAllStreamingQueries(): Unit = {
    spark.streams.active.foreach { streamingQuery =>
      try {
        streamingQuery.stop()
      }
      catch {
        case cause: Throwable =>
          log.debug(s"streaming query did not stop quietly", cause)
      }
    }
  }
}

