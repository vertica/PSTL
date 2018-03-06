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

package org.apache.spark.sql.pstl.streaming

import org.apache.spark.{SparkConf, SparkFunSuite}
import org.apache.spark.sql.catalog.Table
import org.apache.spark.sql.catalyst.TableIdentifier
import org.apache.spark.sql.catalyst.catalog.{CatalogStorageFormat, CatalogTable, CatalogTableType}
import org.apache.spark.sql.catalyst.parser.pstl.SparkSqlParser
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.execution.datasources.CreateTable
import org.apache.spark.sql.test.SharedSQLContext
import org.apache.spark.sql.execution.datasources.CreateStreamFromCommand
import org.apache.spark.sql.types._
import org.apache.spark.sql.{AnalysisException, Row, SparkSession}
import org.apache.spark.sql.catalyst.parser.ParserInterface

class CreateStreamTestSuite extends SparkFunSuite with SharedSQLContext {

  override protected def sparkConf: SparkConf = {
    super.sparkConf
      .set("spark.sql.extensions", "com.microfocus.pstl.spark.SparkSqlExtensions")
  }

  ignore("CreateStream") {

    val sqlStr = "CREATE STREAM tableIdentifier ('('id: Int', 'name: String')')? " +
                 "sourceProvider (OPTIONS tablePropertyList)? "

    val logicalPlan : LogicalPlan = spark.sessionState.sqlParser.parsePlan(sqlStr)

               val table = new Table(tableType = "TableIdentifer",
              name = "table", database = "SQL",
              description = " userSpecifiedSchema: Option[StructType]", isTemporary = false)

            val schema = new StructType()
              .add("id", IntegerType, false)
              .add("name", StringType, false)

      assert(logicalPlan.resolve(sqlStr) == schema, "test case passed")
  }

//  test ("SaveStream") {
//
//  val sqlString = "SAVE STREAM tableIdentifier sinkProvider" +
//                  "(IDENTIFIED BY sinkProvider)? (TRIGGER 30)?" +
//                  "(OUTPUT MODE outputMode)?" +
//                  "(PARTITIONED ON identifierList)?" +
//                  "(OPTIONS tablePropertyList)?"
//
//  val logicalPlan : LogicalPlan = spark.sessionState.sqlParser.parsePlan(sqlString)
//
//            val SaveSchema = new StructType()
//               .add("id", IntegerType, false)
//               .add("name", StringType, false)
//
//  assert(logicalPlan.resolve(sqlString) == SaveSchema, "test case passed")
// }

}
