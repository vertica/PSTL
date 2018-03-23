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

import com.microfocus.pstl.avro.Person
import org.apache.avro.SchemaBuilder
import org.apache.spark.SparkFunSuite
import org.apache.spark.sql.AnalysisException
import org.apache.spark.sql.avro.{AvroHelper, AvroSchemaConverter}
import org.apache.spark.sql.types._

class FromAvroExprSpec extends SparkFunSuite with ExpressionEvalHelper with AvroHelper {
  test("from_avro throws on invalid reader schema") {
    val schema = new StructType()
      .add("col0", IntegerType)

    val input = Literal.create(create_row(0), schema)

    intercept[AnalysisException](checkEvaluation(FromAvroExpr(null, input), null))
    intercept[AnalysisException](checkEvaluation(FromAvroExpr("", input), null))
    intercept[AnalysisException](checkEvaluation(FromAvroExpr("abc", input), null))
  }

  test("from_avro struct") {
    val schema = new StructType()
      .add("name", StringType, false)
      .add("age", IntegerType, false)

    val person = Person.newBuilder()
      .setName("john doe")
      .setAge(30)
      .build()

    checkEvaluation(
      FromAvroExpr(
        AvroSchemaConverter.convertStructToAvro(
          schema, SchemaBuilder.record("record"), "pstl").toString(),
        Literal(serialize(person))
      ),
      create_row("john doe", 30)
    )
  }
}
