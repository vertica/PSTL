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

import org.scalacheck.{Arbitrary, Gen}
import org.scalacheck.Gen.{ choose, listOf,nonEmptyListOf, listOfN, oneOf }

import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class CreateSaveStreamTestSuite extends SparkFunSuite
  with SharedSQLContext
  with GeneratorDrivenPropertyChecks
  with Matchers {

  lazy val parser = new SparkSqlParser(spark)

  // todo: test quoted name vs `name`, it should work, but it is failing (bug at the moment?)
  // todo: cut radar, cb will take

  val nameGen: Gen[String] = Gen.alphaStr.filter(_.trim.nonEmpty)

  test("scalacheck for parse schema correctly"){
    forAll(nameGen) { (field: String)=>
      val logicalPlan = parser.parsePlan(s"CREATE STREAM foo($field string) FROM CSV ")
        .asInstanceOf[CreateStreamFromCommand]

      val schema = new StructType()
        .add(field, StringType)

      logicalPlan.userSpecifiedSchema.get shouldBe schema
    }
  }

  test("create stream from parses schema correctly") {
    val logicalPlan = parser.parsePlan("CREATE STREAM foo(id string) FROM CSV ")
      .asInstanceOf[CreateStreamFromCommand]

    val schema = new StructType()
      .add("id", StringType)

    assert(logicalPlan.userSpecifiedSchema.nonEmpty, "test case passed")
    assert(logicalPlan.userSpecifiedSchema.get == schema, "test case passed")
  }

  ignore("create stream from parses schema with reserved keywords") {
    val logicalPlan = parser.parsePlan("CREATE STREAM foo (name string) FROM CSV")
      .asInstanceOf[CreateStreamFromCommand]

    val schema = new StructType()
      .add("name", StringType)

    assert(logicalPlan.userSpecifiedSchema.nonEmpty, "test case passed")
    assert(logicalPlan.userSpecifiedSchema.get == schema, "test case passed")
  }

  test("scalacheck table identifier") {
    forAll(nameGen, nameGen) { (tableName: String, identifier: String) =>
      val logicalPlan = parser.parsePlan(s"SAVE STREAM $tableName TO CSV IDENTIFIED BY $identifier")
        .asInstanceOf[SaveStreamToCommand]

      logicalPlan.tableIdent.identifier shouldBe tableName
      logicalPlan.queryName shouldBe identifier
    }
  }

  test("save stream query name defaults to table identifier") { //SAVE STREAM foo should result in tableIdentifier being equal to foo
    val logicalPlan = parser.parsePlan("SAVE STREAM foo TO CSV IDENTIFIED BY foo")
      .asInstanceOf[SaveStreamToCommand]

    assert(logicalPlan.tableIdent.identifier === "foo")
  }

  ignore("scalacheck for provider being something") {
    forAll(nameGen) { (provider: String) =>
      val logicalPlan = parser.parsePlan(s"SAVE STREAM foo TO $provider IDENTIFIED BY foo ").asInstanceOf[SaveStreamToCommand]
      logicalPlan.provider shouldBe provider
    }
  }

  test ("save stream to something defaults to provider") { //SAVE STREAM foo TO something should result in the provider being equal to something.
    val logicalPlan = parser.parsePlan("SAVE STREAM foo TO CSV IDENTIFIED BY foo ")
      .asInstanceOf[SaveStreamToCommand]

    assert(logicalPlan.provider.contentEquals("CSV"))
  }

  test("scalacheck for outputmode results in one of 3 modes") {
    val output = Gen.oneOf("complete","update","append").filter(_.trim.nonEmpty)

    forAll(output) { outputMode :String  =>
      val logicalPlan = parser.parsePlan(s"SAVE STREAM foo TO CSV IDENTIFIED BY foo TRIGGER ONCE OUTPUT MODE $outputMode")
        .asInstanceOf[SaveStreamToCommand]

      logicalPlan.outputMode shouldBe outputMode
    }
  }

  test("save stream with no outputmode defaults to append") { //SAVE STREAM (no output mode specified) should result in output mode defaulting to append
    val logicalPlan = parser.parsePlan("SAVE STREAM foo TO CSV IDENTIFIED BY foo ")
      .asInstanceOf[SaveStreamToCommand]

    assert(logicalPlan.outputMode.equalsIgnoreCase("append"))
  }

  test("save stream with output mode results in one of 3 modes") { // SAVE STREAM OUTPUT MODE [ APPEND | COMPLETE | UPDATE ] should result in output mode being append, complete or update
    val logicalPlan = parser.parsePlan("SAVE STREAM foo TO CSV IDENTIFIED BY foo TRIGGER ONCE OUTPUT MODE COMPLETE ")
      .asInstanceOf[SaveStreamToCommand]

    assert(logicalPlan.outputMode.equalsIgnoreCase("append")  || logicalPlan.outputMode.equalsIgnoreCase("COMPLETE") || logicalPlan.outputMode.equalsIgnoreCase("UPDATE"))
  }

  test("save stream with no trigger results in 0 milliseconds processing time") { //SAVE STREAM ... (no trigger specified) should result in trigger being ProcessingTime(0 milliseconds)
    val logicalPlan = parser.parsePlan("SAVE STREAM foo TO CSV IDENTIFIED BY foo ")
      .asInstanceOf[SaveStreamToCommand]

    assert(logicalPlan.trigger ==  Trigger.ProcessingTime(0))
  }

  test("scalacheck with 5 min trigger results in 5 min processing time"){
    val gen = Gen.chooseNum(1,10)
    forAll(gen) { (trigger: Int) =>
      val logicalPlan = parser.parsePlan(s"SAVE STREAM foo TO CSV IDENTIFIED BY foo TRIGGER $trigger MINUTES ").asInstanceOf[SaveStreamToCommand]
      logicalPlan.trigger shouldBe Trigger.ProcessingTime(trigger, TimeUnit.MINUTES)
    }
  }

  test("save stream with  5 minute trigger results in 5 minute processing time") { //SAVE STREAM ... TRIGGER 5 MINUTES should result in trigger being ProcessingTime(5 minutes)
    val logicalPlan = parser.parsePlan("SAVE STREAM foo TO CSV IDENTIFIED BY foo TRIGGER 5 MINUTES ")
      .asInstanceOf[SaveStreamToCommand]

    assert(logicalPlan.trigger == Trigger.ProcessingTime(5,TimeUnit.MINUTES))
  }

  test("scalacheck for partition by seq") {
    forAll(nameGen, nameGen){  (x: String, y: String) =>
      val logicalPlan = parser.parsePlan(s"SAVE STREAM foo TO CSV IDENTIFIED BY foo TRIGGER ONCE OUTPUT MODE COMPLETE PARTITIONED ON ($x,$y)")
        .asInstanceOf[SaveStreamToCommand]

      logicalPlan.partitionBy shouldBe Seq(x,y)
    }
  }

  test("save stream partition by seq results in seq") { //SAVE STREAM PARTITION BY Seq(colA, colB) should result in partitionBy being Seq(colA,colB)
    val logicalPlan = parser.parsePlan("SAVE STREAM foo TO CSV IDENTIFIED BY foo TRIGGER ONCE OUTPUT MODE COMPLETE PARTITIONED ON (id,age)")
      .asInstanceOf[SaveStreamToCommand]

    assert(logicalPlan.partitionBy === Seq("id","age"))
  }

  test("scalacheck for queryname being foo") {
    forAll(nameGen){ (tableName: String) =>
      val logicalPlan = parser.parsePlan(s"SAVE STREAM $tableName TO CSV ")
        .asInstanceOf[SaveStreamToCommand]

      logicalPlan.queryName shouldBe tableName
    }
  }

  test("save stream foo defaults to queryname foo") { // SAVE STREAM foo should result in the queryName being foo
    val logicalPlan = parser.parsePlan("SAVE STREAM foo TO CSV IDENTIFIED BY foo ")
      .asInstanceOf[SaveStreamToCommand]

    assert(logicalPlan.queryName.equals("foo"))
  }

  test("scalacheck queryname uses identified by") {
    forAll(nameGen) { (identifier: String) =>
      val logicalPlan = parser.parsePlan(s"SAVE STREAM foo TO CSV IDENTIFIED BY $identifier")
        .asInstanceOf[SaveStreamToCommand]

      logicalPlan.queryName shouldBe identifier
    }
  }

  test("save stream query name uses identified by") { // SAVE STREAM IDENTIFIED BY bar should result in the queryName being bar, not foo
    val logicalPlan = parser.parsePlan("SAVE STREAM foo TO CSV IDENTIFIED BY bar")
      .asInstanceOf[SaveStreamToCommand]

    assert(logicalPlan.queryName.equals("bar"))
  }

  test("scalacheck for parse options") {
    forAll(nameGen, nameGen) { (key: String, value: String) =>
      val logicalPlan = parser.parsePlan(s"SAVE STREAM foo TO CSV OPTIONS ('$key'='$value')")
        .asInstanceOf[SaveStreamToCommand]

      logicalPlan.options.get(key) shouldBe Some (value)
    }
  }

  test("save stream parses options") { //SAVE STREAM OPTIONS('key'='value') should result in options containing (key -> value)
    val logicalPlan = parser.parsePlan("SAVE STREAM foo TO CSV OPTIONS('path'='tmp/csv-data')")
      .asInstanceOf[SaveStreamToCommand]

    assert(logicalPlan.options.get("path") === Some("tmp/csv-data"))
  }

  //new test case
  test("create stream from parses schema") {
    val logicalPlan = parser.parsePlan("CREATE STREAM foo(id string) FROM CSV OPTIONS('path'='/Users/medhabanda/Music')")
      .asInstanceOf[CreateStreamFromCommand]

    val seqRow = CreateStreamFromCommand(logicalPlan.tableIdent,logicalPlan.userSpecifiedSchema,logicalPlan.provider,logicalPlan.options)
    println(seqRow)
  }

  test("save stream from parses schema") {
    val logicalPlan = parser.parsePlan("SAVE STREAM foo TO CSV IDENTIFIED BY foo TRIGGER ONCE OUTPUT MODE COMPLETE PARTITIONED ON (id) OPTIONS('path'='/Users/medhabanda/Music')")
      .asInstanceOf[SaveStreamToCommand]

    val seqRow = SaveStreamToCommand(
      logicalPlan.tableIdent,
      logicalPlan.provider,
      logicalPlan.outputMode,
      logicalPlan.trigger,
      logicalPlan.partitionBy,
      logicalPlan.queryName,
      logicalPlan.options)

    println(seqRow)

  }
}
