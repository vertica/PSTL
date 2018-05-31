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

import scala.collection.JavaConverters._

import com.microfocus.pstl.avro.{People, Person}

import org.apache.spark.SparkFunSuite
import org.apache.spark.sql.avro.AvroHelper
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.util.GenericArrayData
import org.apache.spark.sql.types._

class ToAvroExprSpec extends SparkFunSuite with ExpressionEvalHelper with AvroHelper {
  test("to_avro struct") {
    val schema = new StructType()
      .add("name", StringType, false)
      .add("age", IntegerType, false)

    val struct = Literal.create(create_row("john doe", 42), schema)

    val person = Person.newBuilder()
      .setName("john doe")
      .setAge(42)
      .build()

    checkEvaluation(ToAvroExpr(struct), serialize(person))
  }

  // todo: converter has issues with arrays currently
  ignore("to_avro array") {
    val innerSchema = new StructType()
      .add("name", StringType, false)
      .add("age", IntegerType, false)

    val input = new GenericArrayData(
      Array(InternalRow("john doe", 42), InternalRow("bob bobson", 99)))

    val people = People.newBuilder()
      .setPeople(Seq(
        Person.newBuilder().setName("john doe").setAge(42).build(),
        Person.newBuilder().setName("bob bobson").setAge(99).build()).asJava)
      .build()

    checkEvaluation(ToAvroExpr(Literal.create(input, ArrayType(innerSchema))), serialize(people))
  }

  test("to_json null input column") {
    val schema = new StructType()
      .add("col0", IntegerType)

    val struct = Literal.create(null, schema)

    checkEvaluation(ToAvroExpr(struct), null)
  }
}
