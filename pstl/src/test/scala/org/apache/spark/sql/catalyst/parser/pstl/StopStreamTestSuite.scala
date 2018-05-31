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

package org.apache.spark.sql.catalyst.parser.pstl
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream, IntStream}
import org.apache.spark.sql.catalyst.parser.{ParseErrorListener, ParserInterface, PostProcessor}
import org.apache.spark.sql.execution.datasources.{CreateStreamFromCommand, SaveStreamToCommand}
import org.apache.spark.sql.test.SharedSQLContext
import org.apache.spark.sql.types._
import org.apache.spark.{SparkConf, SparkFunSuite}
import org.apache.spark.sql.streaming.{OutputMode, Trigger}
import java.util.concurrent.TimeUnit

import org.apache.spark.sql.AnalysisException
import org.apache.spark.sql.execution.datasources.{ShowStreamsCommand, StopStreamCommand}
import org.scalacheck.{Arbitrary, Gen}
import org.scalacheck.Gen.{choose, listOf, listOfN, nonEmptyListOf, oneOf}
import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class StopStreamTestSuite extends SparkFunSuite
                          with SharedSQLContext
                          with GeneratorDrivenPropertyChecks
                          with Matchers {
  lazy val parser = SparkSqlParser(sqlContext.sparkSession, sqlContext.sparkSession.sessionState.sqlParser)

  test("scalacheck for qualified name") {

    val gen = Gen.alphaStr.suchThat(_.length > 0)

    forAll(gen) { (qualifiedname: String) =>

      val logicalPlan = parser.parsePlan(s"STOP STREAM $qualifiedname").asInstanceOf[StopStreamCommand]

      logicalPlan.streamName shouldBe qualifiedname

    }
  }

  test("scalacheck for stopping the stream") {

    withTempDir { dir =>

      val logicalPlanCreate = parser.parsePlan(s"CREATE STREAM foo(id String) FROM CSV OPTIONS('path'=" + "'" + s"${dir.toString}" + "'" + ")").asInstanceOf[CreateStreamFromCommand]

      logicalPlanCreate.run(sqlContext.sparkSession)

      /** Testing for save stream */

      sqlContext.sparkSession.conf.set("spark.sql.streaming.checkpointLocation", dir.toString)
      val logicalPlanSave = parser.parsePlan(s"SAVE STREAM foo TO CSV IDENTIFIED BY foo TRIGGER ONCE OUTPUT MODE APPEND PARTITIONED ON (id) OPTIONS('path'=" + "'" + s"${dir.toString}" + "'" + ")").asInstanceOf[SaveStreamToCommand]

      logicalPlanSave.run(sqlContext.sparkSession)

      val logicalPlanStop = parser.parsePlan("STOP STREAM foo").asInstanceOf[StopStreamCommand]
      val seqRow = logicalPlanStop.run(sqlContext.sparkSession)
      seqRow.foreach(x => assert(x.get(0).toString.equals("some")))
      val logicalPlanshow = parser.parsePlan("SHOW STREAMS").asInstanceOf[ShowStreamsCommand]
      logicalPlanshow.run(sqlContext.sparkSession)
      assert(0 == seqRow.size, "Stream is successfully Stopped ") /** Asserts 0 as the only stream started is STOPPED here */

    }

  }
    test("scalacheck for analysis exception") {

      val logicalPlan = parser.parsePlan(s"STOP STREAM foo").asInstanceOf[StopStreamCommand]

      intercept[AnalysisException] {
        logicalPlan.run(sqlContext.sparkSession)
      }
    }
  }
