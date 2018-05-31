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



package org.apache.spark.sql.catalyst.expressions

import org.apache.spark.sql.AnalysisException
import org.apache.spark.sql.types._

import org.scalatest._

class AvroUtilSuite extends FunSuite {
  test("AvroUtil verifies string literal schema") {
    AvroUtils.validateSchemaLiteral(Literal.create("")) === ""
  }

  test("AvroUtil throws analysis exception without string literal") {
    intercept[AnalysisException](AvroUtils.validateSchemaLiteral(Literal.create(0)))
  }

  test("AvroUtil struct") {
    AvroUtils.verifySchema(new StructType().add("col0", IntegerType))
  }
}
