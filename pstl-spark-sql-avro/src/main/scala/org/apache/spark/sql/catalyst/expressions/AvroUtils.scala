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

object AvroUtils {
  def validateSchemaLiteral(expr: Expression): String = expr match {
    case Literal(s, StringType) => s.toString
    case e => throw new AnalysisException(s"Expected a string literal instead of $e")
  }

  def verifySchema(schema: StructType): Unit = {
    def verifyType(name: String, dataType: DataType): Unit = dataType match {
      case NullType | BooleanType | ByteType | ShortType | IntegerType | LongType | FloatType |
        DoubleType | StringType | TimestampType | DateType | BinaryType | _: DecimalType =>
        // we accept these

      case s: StructType =>
        s.foreach(field => verifyType(field.name, field.dataType))

      case a: ArrayType =>
        verifyType(name, a.elementType)

      case _ =>
        throw new UnsupportedOperationException(
          s"Unable to convert column $name of type ${dataType.simpleString} to avro")
    }

    schema.foreach(field => verifyType(field.name, field.dataType))
  }
}
