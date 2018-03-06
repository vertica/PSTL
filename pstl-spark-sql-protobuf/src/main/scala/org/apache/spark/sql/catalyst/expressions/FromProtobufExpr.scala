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

import com.google.protobuf.DynamicMessage
import org.apache.spark.sql.catalyst.CatalystTypeConverters
import org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback
import org.apache.spark.sql.protobuf.ProtobufSchemaConverter
import org.apache.spark.sql.types.{AbstractDataType, BinaryType, DataType}

@ExpressionDescription(
  usage = "_FUNC_(class, bytes) - Returns proto bytes deserialized based on class " +
    "mapped to relevant Apache Spark DataTypes(s), class loading is expected to be handled upstream"
)
case class FromProtobufExpr(clazz: String, child: Expression)
  extends UnaryExpression with ExpectsInputTypes with CodegenFallback {

  def this(child: Expression, clazz: Expression) = {
    this(
      clazz = ProtobufExprUtils.validateClassLiteral(clazz),
      child = child)
  }

  @transient private lazy val descriptor = ProtobufSchemaConverter.descriptorFor(clazz)

  override def nullSafeEval(input: Any): Any = {
    try {
      val msg = DynamicMessage.parseFrom(descriptor, input.asInstanceOf[Array[Byte]])
      val row = ProtobufSchemaConverter.messageAsRow(msg)

      // this is kind of silly
      // 1) convert proto Message to spark Row
      // 2) convert spark Row to spark InternalRow
      // ... if only our converter were aware of InternalRow to begin with

      CatalystTypeConverters.convertToCatalyst(row)
    }
    catch {
      case _: Throwable => null
    }
  }

  override def nullable: Boolean = true
  override def dataType: DataType = ProtobufSchemaConverter.structFor(clazz)
  override def inputTypes: Seq[AbstractDataType] = BinaryType :: Nil
  override def prettyName: String = "from_protobuf"
}
