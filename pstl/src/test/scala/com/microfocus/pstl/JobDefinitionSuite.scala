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

import org.apache.spark.SparkFunSuite
import org.apache.spark.sql.catalyst.parser.ParseException
import org.apache.spark.sql.catalyst.parser.pstl.SparkSqlParser
import org.apache.spark.sql.test.SharedSQLContext
import org.scalatest._

class JobDefinitionSuite extends SparkFunSuite with SharedSQLContext with Matchers {

  lazy val parser = new SparkSqlParser(spark)

  test("job definition - empty") {
    new JobDefinition() === JobDefinition.empty
  }

  test("job definition - sanitizes") {
    new JobDefinition("\n\n;;;\n\n\n\n\n;;;;") === JobDefinition.empty
  }

  test("job definition - fluent") {
    val j1 = JobDefinition.empty
    val j2 = j1.add("SELECT 1 x")
    val j3 = j2.add("SELECT 2 y")

    new JobDefinition("SELECT 1 x; SELECT 2 y;") === j3
  }

  test("job definition - terminal semicolon not interesting") {
    val j1 = new JobDefinition("SELECT 1 x; SELECT 2 y")
    val j2 = new JobDefinition("SELECT 1 x; SELECT 2 y;")
    j1 === j2
  }

  test("job definition - tostring") {
    val sql =
      """
        |CREATE STREAM foo(a int)
        |FROM CSV
        |OPTIONS('path'='/tmp/foo');
        |
        |CREATE TEMPORARY VIEW bar AS
        |SELECT a FROM foo;
        |
        |SAVE STREAM bar
        |TO PARQUET
        |OPTIONS('path'='/tmp/bar');
      """.stripMargin

    val j1 = new JobDefinition(sql)

    j1.toString === sql
  }

  test("job definition - tostring with separator") {
    val sql =
      """
        |CREATE STREAM foo(a int)
        |FROM CSV
        |OPTIONS('path'='/tmp/foo');
        |CREATE TEMPORARY VIEW bar AS
        |SELECT a FROM foo;
        |SAVE STREAM bar
        |TO PARQUET
        |OPTIONS('path'='/tmp/bar');
      """.stripMargin

    val j1 = new JobDefinition(sql)

    j1.toString(";\n")
  }

  test("job definition - throws parse exception parsing garbage") {
    intercept[ParseException] {
      new JobDefinition("SELECT 1 x SELECT 2 y").parse(sqlContext.sparkSession)
    }
  }

  test("supports comment blocks") {
    val d1 = new JobDefinition()
      .add("--CREATE STREAM foo FROM KAFKA OPTIONS();")

    d1.isEmpty shouldBe true
    d1.toString shouldBe empty

    val d2 = new JobDefinition(
      """
        |CREATE STREAM foo FROM KAFKA OPTIONS();
        |--SAVE STREAM foo TO CONSOLE;
      """.stripMargin)

    d2.isEmpty shouldBe false
    d2.toString shouldBe "CREATE STREAM foo FROM KAFKA OPTIONS()"
  }
}
