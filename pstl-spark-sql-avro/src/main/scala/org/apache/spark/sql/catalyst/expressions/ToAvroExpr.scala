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

import java.io.ByteArrayOutputStream

import org.apache.avro.SchemaBuilder
import org.apache.avro.generic.GenericData.Record
import org.apache.avro.generic.{GenericData, GenericDatumWriter}
import org.apache.avro.io.EncoderFactory
import org.apache.spark.sql.AnalysisException
import org.apache.spark.sql.avro.AvroSchemaConverter
import org.apache.spark.sql.catalyst.analysis.TypeCheckResult
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback
import org.apache.spark.sql.catalyst.util.ArrayData
import org.apache.spark.sql.types._

@ExpressionDescription(
  usage = "_FUNC_(expr) - returns avro bytes with a given struct value",
  extended = """
    Examples:
      > SELECT _FUNC_(named_struct('a', 1, 'b', 2));
      // todo: output
      > SELECT _FUNC_(array(named_struct('a', 1, 'b', 2)));
      // todo: output
  """)
case class ToAvroExpr(child: Expression) extends UnaryExpression
  with ExpectsInputTypes
  with NullIntolerant
  with CodegenFallback {

  @transient private lazy val sqlSchema = child.dataType match {
    case s: StructType => s
    case ArrayType(s: StructType, _) => s
    case _ => throw new AnalysisException(
      s"Input type '${child.dataType.simpleString}' must be a struct, or an array of structs")
  }

  @transient private lazy val avroSchema = AvroSchemaConverter.convertStructToAvro(
    sqlSchema, SchemaBuilder.record("record"), "pstl")

  @transient private lazy val baos = new ByteArrayOutputStream()
  @transient private lazy val encoder = EncoderFactory.get().binaryEncoder(baos, null)

  @transient private lazy val recordWriter = {
    new GenericDatumWriter[GenericData.Record](avroSchema)
  }

  @transient private lazy val arrayWriter = {
    new GenericDatumWriter[GenericData.Array[GenericData.Record]](avroSchema)
  }

  @transient private lazy val avroConverter = {
    AvroSchemaConverter.convertInternalRowToAvroRecord(sqlSchema, "record", "pstl")
  }

  override def nullSafeEval(input: Any): Any = child.dataType match {
    case _: StructType =>
      val avroRecord = avroConverter(input.asInstanceOf[InternalRow])
        .asInstanceOf[Record]

      baos.reset()
      recordWriter.write(avroRecord, encoder)
      encoder.flush()
      baos.toByteArray

    case ArrayType(_: StructType, _) =>
      val avroArray = avroConverter(input.asInstanceOf[ArrayData])
        .asInstanceOf[GenericData.Array[Record]]

      baos.reset()
      arrayWriter.write(avroArray, encoder)
      encoder.flush()
      baos.toByteArray
  }

  override def checkInputDataTypes(): TypeCheckResult = child.dataType match {
    case _: StructType | ArrayType(_: StructType, _) =>
      try {
        AvroUtils.verifySchema(sqlSchema)
        TypeCheckResult.TypeCheckSuccess
      }
      catch {
        case e: UnsupportedOperationException =>
          TypeCheckResult.TypeCheckFailure(e.getMessage)
      }

    case _ => TypeCheckResult.TypeCheckFailure(
      s"Input type ${child.dataType.simpleString} must be a struct, or array of structs")
  }

  override def nullable: Boolean = true
  override def dataType: DataType = BinaryType
  override def inputTypes: Seq[AbstractDataType] = TypeCollection(ArrayType, StructType) :: Nil
  override def prettyName: String = "to_avro"
}
