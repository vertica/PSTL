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

import org.apache.spark.sql.{AnalysisException, SparkSession, SparkSessionExtensions}
import org.apache.spark.sql.catalyst.parser.pstl.SparkSqlParser
import org.apache.spark.sql.execution.datasources.SaveStreamToCommand
import org.apache.spark.sql.internal.SQLConf
import org.apache.spark.SparkFunSuite
import org.scalatest._

class SparkSqlExtensionsSuite extends SparkFunSuite with Matchers {

  import SQLConf._

  testWithSession("extensions provide custom spark sql parser") { spark =>
    spark.sessionState.sqlParser shouldBe a[SparkSqlParser]
  }

  testWithSession("extensions provide convention based checkpoint location") { spark =>
    spark.conf.set(CHECKPOINT_LOCATION.key, "/tmp")
    spark.conf.get(CHECKPOINT_LOCATION.key) shouldBe "/tmp"

    val plan = spark.sessionState.sqlParser.parsePlan(
      "SAVE STREAM foo TO MEMORY OPTIONS('__pstl_job_id'='jobId')")

    val analyzedPlan = spark.sessionState.analyzer.execute(plan)
    analyzedPlan shouldBe a[SaveStreamToCommand]

    val command = analyzedPlan.asInstanceOf[SaveStreamToCommand]
    command.options.get("checkpointLocation") should not be empty
    command.options.get("checkpointLocation") shouldBe Option("/tmp/jobId/foo")
  }

  testWithSession(
    "extensions provide convention based checkpoint location user can override explicitly") {
    spark =>

      spark.conf.unset(CHECKPOINT_LOCATION.key)

      val plan = spark.sessionState.sqlParser.parsePlan(
        "SAVE STREAM foo TO MEMORY OPTIONS('checkpointLocation'='/tmp/custom')")

      val analyzedPlan = spark.sessionState.analyzer.execute(plan)
      analyzedPlan shouldBe a[SaveStreamToCommand]

      val command = analyzedPlan.asInstanceOf[SaveStreamToCommand]
      command.options.get("checkpointLocation") should not be empty
      command.options.get("checkpointLocation") shouldBe Option("/tmp/custom")
  }

  testWithSession("extensions revoke global create view") { spark =>
    val e = intercept[AnalysisException](spark.sql(
      "CREATE GLOBAL TEMPORARY VIEW foo AS SELECT 1 x"))
    e.getMessage() should startWith("global temporary views are disabled")
  }

  testWithSession("extensions revoke global create view using") { spark =>
    val e = intercept[AnalysisException](spark.sql(
      "CREATE GLOBAL TEMPORARY VIEW foo USING CSV"))
    e.getMessage() should startWith("global temporary views are disabled")
  }

  testWithSession("extensions revoke non-temporary functions") { spark =>
    val e = intercept[AnalysisException](spark.sql("CREATE FUNCTION foo AS 'com.acme.udfs.Foo'"))
    e.getMessage() should startWith("global function registrations are disabled")
  }

  private def testWithSession(testName: String,
                              builder: SparkSessionExtensions => Unit = new SparkSqlExtensions)
                             (f: SparkSession => Unit): Unit = {
    test(testName) {
      withSession(builder) { spark =>
        f(spark)
      }
    }
  }

  private def withSession(builder: SparkSessionExtensions => Unit)(f: SparkSession => Unit): Unit = {
    val spark = SparkSession.builder()
      .master("local[1]")
      .withExtensions(builder)
      .getOrCreate()

    try {
      f(spark)
    }
    finally {
      spark.stop()
      SparkSession.clearActiveSession()
      SparkSession.clearDefaultSession()
    }
  }
}
