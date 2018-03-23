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

import java.sql.Timestamp

import com.vertica.jdbc.kv.VHash
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback
import org.apache.spark.sql.types._
import org.apache.spark.unsafe.types.UTF8String

object VerticaHashExpr {
  def apply(child: Expression): VerticaHashExpr = {
    VerticaHashExpr(Seq(child))
  }
}

case class VerticaHashExpr(children: Seq[Expression])
  extends Expression with CodegenFallback {

  @transient private lazy val vhash = new VHash()
  @transient private lazy val converters = children.map(child =>
    (child, createConverter(child.dataType)))

  override def eval(input: InternalRow): Any = {
    vhash.reset()

    converters.foreach {
      case (child, converter) =>
        converter(child.eval(input))
    }

    vhash.getHash
  }

  override def nullable: Boolean = false
  override def dataType: DataType = LongType
  override def prettyName: String = "vertica_hash"

  private def createConverter(dataType: DataType): (Any) => Unit = {
    dataType match {
      case BinaryType => {
        case null => vhash.addNull()
        case bytes: Array[Byte] => vhash.addBytes(bytes)
      }

      case ByteType => {
        case null => vhash.addNull()
        case byte: Byte => vhash.addLong(byte.toLong)
      }

      case ShortType => {
        case null => vhash.addNull()
        case short: Short => vhash.addLong(short.toLong)
      }

      case IntegerType => {
        case null => vhash.addNull()
        case int: Integer => vhash.addLong(int.toLong)
      }

      case LongType => {
        case null => vhash.addNull()
        case long: Long => vhash.addLong(long)
      }

      case FloatType => {
        case null => vhash.addDoubleNull()
        case float: Float => vhash.addDouble(float.toDouble)
      }

      case DoubleType => {
        case null => vhash.addDoubleNull()
        case double: Double => vhash.addDouble(double)
      }

      case StringType => {
        case null => vhash.addString(null)
        case str: String => vhash.addString(str)
        case utf: UTF8String => vhash.addString(utf.toString)
      }

      case BooleanType => {
        case null => vhash.addBooleanNull()
        case bool: Boolean => vhash.addBoolean(bool)
      }

      case TimestampType => {
        case null => vhash.addNull()
        case ts: Timestamp => vhash.addTimestamp(ts.getTime)
        case long: Long => vhash.addTimestamp(long)
      }

      case NullType =>
        _ => vhash.addNull()
    }
  }
}
