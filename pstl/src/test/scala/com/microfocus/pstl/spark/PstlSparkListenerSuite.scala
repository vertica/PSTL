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
	
package com.microfocus.pstl.spark

import akka.actor.ActorSystem
import akka.testkit.TestKitBase
import com.microfocus.pstl.metrics.MetricsExtension
import org.apache.spark
import org.apache.spark.executor.TaskMetrics
import org.apache.spark.sql.execution.ui.{SparkListenerDriverAccumUpdates, SparkListenerSQLExecutionEnd, SparkListenerSQLExecutionStart}
import org.apache.spark.{SparkContext, SparkFunSuite}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.test.SharedSQLContext
import org.scalatest.Matchers
import org.apache.spark.scheduler._
import org.apache.spark.sql.execution.SparkPlanInfo
import org.scalatest.FunSuite
import org.apache.spark.sql.execution.SparkPlanInfo
import org.apache.spark.sql.execution.metric.SQLMetricInfo
import org.apache.spark.storage.{RDDInfo, StorageLevel}
import org.scalatest.PrivateMethodTester.PrivateMethod
import scala.collection.mutable

class PstlSparkListenerSuite extends SparkFunSuite
  with Matchers
  with SharedSQLContext
  with TestKitBase {

  implicit lazy val system: ActorSystem = ActorSystem("pstl")
  MetricsExtension(system)

  test("spark listener test") {

    spark.sql("CREATE TEMPORARY VIEW foo(value string) USING CSV OPTIONS('path'='/Users/medhabanda/tmp/csv-input')")
    val listener = new PstlSparkListener()

    val sc = spark.sparkContext

    sc.addSparkListener(listener)

    sc.setLocalProperty("__pstl_jobId", "1")

    sc.setLocalProperty("__pstl_sinkId", "1")

    spark.sql("select * from foo ").show

    maybeWaitForPrometheus()
  }

  private def createStageInfo(stageId: Int, attemptId: Int): StageInfo = new StageInfo(
    stageId = stageId,
    attemptId = attemptId,
    name = "",
    numTasks = 0,
    rddInfos = Nil,
    parentIds = Nil,
    details = ""
  )

  test("executionStart") {
    val listener = new MockListener()
    val cmetricInfo = new SQLMetricInfo("Spark_accumulator_metric_child", 0L, "TestMetricChild")
    val cmetrics = Seq(cmetricInfo)
    val metricInfo = new SQLMetricInfo("Spark_accumulator_metric", 0L, "TestMetric")
    val metrics = Seq(metricInfo)
    val children = Seq(new SparkPlanInfo("Node2", "", null,  cmetrics))
    val sparkPlanInfo = new SparkPlanInfo("Node1", "", children,  metrics)
    val accumupdates = Seq(scala.Tuple2(0L, 0L))
    val taskMetrics = null
    val storage = new StorageLevel()
    val method = PrivateMethod[Unit]('RDDOperationScope)
    val rddOp = null
    val RddInfo = Seq(new RDDInfo(1, "RDD", 1, storage, Seq(1, 1), "callsite", rddOp))
    val stageInfo = Seq(createStageInfo(0, 0))
    val stageSub = new StageInfo(1, 1, "stage", 1, RddInfo, Seq(1), "details", taskMetrics)

    listener.onOtherEvent(SparkListenerSQLExecutionStart(0L, "", "", "", sparkPlanInfo, 0L))
    listener.onOtherEvent(SparkListenerDriverAccumUpdates(0L, accumupdates))
    listener.onOtherEvent(SparkListenerJobStart(0, 0L, stageInfo, null))
    listener.onOtherEvent(SparkListenerStageSubmitted(stageSub, null))
    listener.onOtherEvent(SparkListenerJobEnd(0, 0L, null))
    listener.onOtherEvent(SparkListenerSQLExecutionEnd(0L, 0L))
    maybeWaitForPrometheus()
  }

  class MockListener extends SparkListener {
    override def onOtherEvent(event: SparkListenerEvent): Unit = event match {
      case e: SparkListenerSQLExecutionStart => println("executionStarted")
      //                PublishMetrics()
      case e: SparkListenerDriverAccumUpdates => println("AccumUpdates")
        PublishMetrics()
      case e: SparkListenerJobStart => println("jobStarted")
        PublishMetrics()
      case e: SparkListenerStageSubmitted => println("stageSubmitted")
        PublishMetrics()
      case e: SparkListenerStageCompleted => println("stageCompleted")
        PublishMetrics()
      case e: SparkListenerJobEnd => println("jobEnded")
        PublishMetrics()
      case e: SparkListenerSQLExecutionEnd => println("executionEnded")
        PublishMetrics()
    }
  }

  private def PublishMetrics(): Unit = {
    new SparkStreamingMetrics(
      "123", "345", "456", "nodename", "metricname").gauge.set(1)
    new SparkStreamingMetrics(
      "111", "222", "333", "sampleNODE", "sampleMETRIC").gauge.set(2)
    new SparkStreamingMetrics(
      "888", "999", "000", "newark", "maiden").gauge.set(3)
    new SparkStreamingMetrics(
      "444", "555", "666", "california", "SFO").gauge.set(4)
  }

  private val waitForPrometheus: Boolean = true
  private val waitForPrometheusPeriod: Long = 30000L

  private def maybeWaitForPrometheus(): Unit = {
    if (waitForPrometheus) {
      Thread.sleep(waitForPrometheusPeriod)
    }
  }
}
