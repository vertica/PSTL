/*
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

package com.microfocus.pstl.spark

import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.`type`.TypeFactory
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.util.Converter
import org.apache.log4j.Logger
import org.apache.spark.SparkContext
import org.apache.spark.scheduler._
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.execution.{QueryExecution, SQLExecution, SparkPlanInfo}
import org.apache.spark.sql.execution.metric._
import org.apache.spark.sql.execution.streaming.StreamExecution
import org.apache.spark.sql.execution.ui.{SparkListenerDriverAccumUpdates, SparkListenerSQLExecutionEnd, SparkListenerSQLExecutionStart, SparkPlanGraph}
import java.util.ArrayList

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class PstlSparkListener extends SparkListener {

  private val activeStages = mutable.Map[Long, Int]()
  private val expectedStages = mutable.Map[Long, Seq[Int]]()
  private val jobMetadata = mutable.Map[Long, JobQuery]()
  private val sqlPlanMetrics = mutable.Map[Long, Map[Long, SqlPlanMetric]]()
  private val accumupdates = mutable.Map[Long, Seq[(Long, Long)]]()
  private val stageExecutions = mutable.Map[Int, Long]()
  private val jobExecutions = mutable.Map[Int, Long]()
  private var stageId = ""

  override def onJobStart(event: SparkListenerJobStart): Unit = {
    val executionIdString = event.properties.getProperty(SQLExecution.EXECUTION_ID_KEY)
    if (executionIdString != null) {
      val executionIdJob = executionIdString.toLong
      val jobId = event.properties.getProperty("__pstl_jobId")
      val queryId = event.properties.getProperty("__pstl_sinkId")
      synchronized {
        jobExecutions.put(event.jobId, executionIdJob)
        expectedStages.put(executionIdJob, event.stageIds)
        jobMetadata.put(executionIdJob, JobQuery(jobId, queryId))
      }
      PublishMetrics(executionIdJob)
    }
  }

  override def onStageSubmitted(event: SparkListenerStageSubmitted): Unit = {
    val executionIdString = event.properties.getProperty(SQLExecution.EXECUTION_ID_KEY)
    if (executionIdString != null) {
      val executionIdStage = executionIdString.toLong
      stageId = event.stageInfo.stageId.toString
      synchronized {
        val valid = expectedStages.get(executionIdStage)
        val result = valid.getOrElse(ArrayBuffer(0))
        if (result.contains(event.stageInfo.stageId)) {
          stageExecutions.put(event.stageInfo.stageId, executionIdStage)
          activeStages.put(executionIdStage, event.stageInfo.stageId)
        }
      }
      PublishMetrics(executionIdStage)
    }
  }

  override def onStageCompleted(event: SparkListenerStageCompleted): Unit = {
    val executionId = stageExecutions(event.stageInfo.stageId)
    stageId = event.stageInfo.stageId.toString
    synchronized {
      val valid = expectedStages.get(executionId)
      val result = valid.getOrElse(Seq(0))
      if (result.contains(event.stageInfo.stageId)) {
        activeStages.remove(executionId)
        stageExecutions.remove(event.stageInfo.stageId)
      }
    }
    PublishMetrics(executionId)
  }

  override def onJobEnd(event: SparkListenerJobEnd): Unit = {
    val executionId = jobExecutions(event.jobId)
    synchronized {
      expectedStages.remove(executionId)
      jobExecutions.remove(event.jobId)
    }
    PublishMetrics(executionId)
  }

  override def onOtherEvent(event: SparkListenerEvent): Unit = event match {
    case event: SparkListenerSQLExecutionStart => onExecutionStart(event)
    case event: SparkListenerSQLExecutionEnd => onExecutionEnd(event)
    case event: SparkListenerDriverAccumUpdates => onAccumUpdates(event)
    case _ => // ignore
  }

  private def onExecutionStart(event: SparkListenerSQLExecutionStart): Unit = {
    val physicalPlanGraph = SparkPlanGraph(event.sparkPlanInfo)
    val metrics = physicalPlanGraph.allNodes.flatMap { node =>
      node.metrics.map { metric =>
        metric.accumulatorId -> SqlPlanMetric(metric.name, metric.accumulatorId, metric.metricType, node.name)
      }
    }.toMap
    synchronized {
      sqlPlanMetrics.put(event.executionId, metrics)
    }
    PublishMetrics(event.executionId)
  }

  private def onExecutionEnd(event: SparkListenerSQLExecutionEnd): Unit = {
    val executionId = event.executionId
    PublishMetrics(executionId)
    synchronized {
      sqlPlanMetrics.remove(event.executionId)
      jobMetadata.remove(executionId)
      accumupdates.remove(executionId)
    }
  }

  private def onAccumUpdates(event: SparkListenerDriverAccumUpdates): Unit = {
    val executionId = event.executionId
    accumupdates.put(executionId, event.accumUpdates)
    PublishMetrics(executionId)
  }

  private def PublishMetrics(executionId: Long): Unit = {
    if (sqlPlanMetrics.nonEmpty && accumupdates.nonEmpty && jobMetadata.nonEmpty) {
      sqlPlanMetrics.get(executionId).foreach {
        metrics =>
          accumupdates.get(executionId).foreach { value =>
            value.foreach {
              case (accumulatorId, value) =>
                val metric = metrics(accumulatorId)
                val jobQuery = jobMetadata(executionId)
                new SparkStreamingMetrics(
                  jobQuery.queryId, jobQuery.jobId, stageId, metric.nodeName.trim, metric.metricName.trim).gauge.set(value)
            }
          }
      }
    }
  }

  case class JobQuery(jobId: String, queryId: String)
  case class SqlPlanMetric(metricName: String, accumulatorId: Long, metricType: String, nodeName: String)

}
