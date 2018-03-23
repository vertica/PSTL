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

import java.io.File

import org.apache.spark.SparkFunSuite
import org.apache.spark.sql.execution.datasources.{CreateStreamFromCommand, SaveStreamToCommand, ShowStreamsCommand, StopStreamCommand}
import org.apache.spark.sql.streaming.StreamTest
import org.apache.spark.sql.test.SharedSQLContext
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.scalacheck.Gen

import org.apache.hadoop.fs.{FileStatus, Path, RawLocalFileSystem}
import org.scalatest.Matchers
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class ShowStreamTestSuite extends SparkFunSuite
  with SharedSQLContext
  with GeneratorDrivenPropertyChecks
  with Matchers  {
  lazy val parser = SparkSqlParser(sqlContext.sparkSession, sqlContext.sparkSession.sessionState.sqlParser)

  test("scalacheck for show streams") {

    val logicalPlan = parser.parsePlan("SHOW STREAMS").asInstanceOf[ShowStreamsCommand]

    assert(logicalPlan.isInstanceOf[ShowStreamsCommand])

    logicalPlan.output.foreach(println)

  }

  test("scalacheck for show streams list") {

    withTempDir { dir =>

      val logicalPlanCreate = parser.parsePlan("CREATE STREAM foo(id String) FROM CSV OPTIONS('path'="+"'"+s"${dir.toString}"+"'"+")").asInstanceOf[CreateStreamFromCommand]

      logicalPlanCreate.run(sqlContext.sparkSession)

      /** Testing for save stream */

      sqlContext.sparkSession.conf.set("spark.sql.streaming.checkpointLocation", dir.toString)
      val logicalPlanSave = parser.parsePlan("SAVE STREAM foo TO CSV IDENTIFIED BY foo TRIGGER ONCE OUTPUT MODE APPEND PARTITIONED ON (id) OPTIONS('path'="+"'"+s"${dir.toString}"+"'"+")").asInstanceOf[SaveStreamToCommand]

      logicalPlanSave.run(sqlContext.sparkSession)

      /** testing for show team */
      val logicalPlan = parser.parsePlan("SHOW STREAMS").asInstanceOf[ShowStreamsCommand]
      val seqRow = logicalPlan.run(sqlContext.sparkSession)
      assert(1 == seqRow.size) /** Asserts 1 as we saved only ONE STREAM */

      seqRow.foreach(x => assert(x.get(0).toString.equals("foo")))

      /** Testing to Stop Stream */

      val logicalPlanStop = parser.parsePlan("STOP STREAM foo").asInstanceOf[StopStreamCommand]
      logicalPlanStop.run(sqlContext.sparkSession)

    }
  }
}
