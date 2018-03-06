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

import org.apache.avro.{Schema, SchemaParseException}
import org.apache.avro.generic.GenericData.Record
import org.apache.avro.generic.GenericDatumReader
import org.apache.avro.io.DecoderFactory
import org.apache.spark.internal.Logging
import org.apache.spark.sql.AnalysisException
import org.apache.spark.sql.avro.AvroSchemaConverter
import org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback
import org.apache.spark.sql.types.{AbstractDataType, BinaryType, DataType}

@ExpressionDescription(
  usage = "_FUNC_(expr, 'schema') - returns sql row(s) for given avro bytes and avro schema",
  extended = """
    Examples:
      > SELECT _FUNC_(bytesCol, '{...}');
      // todo: output
  """)
case class FromAvroExpr(schema: String, child: Expression) extends UnaryExpression
  with ExpectsInputTypes
  with NullIntolerant
  with CodegenFallback
  with Logging {

  def this(child: Expression, schema: Expression) = {
    this(
      schema = AvroUtils.validateSchemaLiteral(schema),
      child = child)
  }

  @transient private lazy val avroSchema = {
    try {
      new Schema.Parser().parse(schema)
    }
    catch {
      case e: NullPointerException =>
        throw new AnalysisException(
          s"'$prettyName' provided avro schema is null or empty", cause = Option(e))

      case e: SchemaParseException =>
        throw new AnalysisException(
          s"'$prettyName' unable to parse avro schema '$schema'", cause = Option(e))
    }
  }

  @transient private lazy val reader = new GenericDatumReader[Record](avroSchema)

  @transient private lazy val converter = {
    AvroSchemaConverter.convertAvroRecordToInternalRow(avroSchema, dataType)
  }

  override def nullSafeEval(input: Any): Any = {
    try {
      val decoder = DecoderFactory.get().binaryDecoder(input.asInstanceOf[Array[Byte]], null)
      val avroRecord = reader.read(null, decoder)
      val row = converter(avroRecord)
      row
    }
    catch {
      case cause: Throwable =>
        log.debug(s"failed to deserialize $input", cause)
    }
  }

  override def nullable: Boolean = true
  override def inputTypes: Seq[AbstractDataType] = BinaryType :: Nil
  override def dataType: DataType = AvroSchemaConverter.toSqlType(avroSchema).dataType
  override def prettyName: String = "from_avro"
}
