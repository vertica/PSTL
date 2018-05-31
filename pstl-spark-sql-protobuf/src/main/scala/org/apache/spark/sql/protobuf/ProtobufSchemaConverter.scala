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


package org.apache.spark.sql.protobuf

import java.lang.reflect.Method

import com.google.protobuf.{AbstractMessage, ByteString}
import com.google.protobuf.Descriptors.{Descriptor, EnumValueDescriptor, FieldDescriptor}
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType._
import org.apache.spark.sql.Row
import org.apache.spark.sql.types._

import scala.reflect.runtime.{universe => ru}
import ru._

object ProtobufSchemaConverter {
  private[this] val lock = new Object()

  def structFor(clazz: String): StructType = {
    structFor(clazz, Thread.currentThread().getContextClassLoader)
  }

  def structFor(clazz: String, loader: ClassLoader): StructType = {
    val clazzInstance = loader.loadClass(clazz).asInstanceOf[Class[AbstractMessage]]
    val mirror = ru.runtimeMirror(loader)

    structFor(clazzInstance, mirror)
  }

  def structFor[T <: AbstractMessage](clazz: Class[T], mirror: Mirror): StructType = {
    structFor(mirror.classSymbol(clazz).toType, mirror)
  }

  def structFor[T: TypeTag](mirror: Mirror): StructType = {
    structFor(localTypeOf[T](mirror), mirror)
  }

  def descriptorFor(clazz: String): Descriptor = {
    descriptorFor(clazz, Thread.currentThread().getContextClassLoader)
  }

  def descriptorFor(clazz: String, loader: ClassLoader): Descriptor = {
    val clazzInstance = loader.loadClass(clazz).asInstanceOf[Class[AbstractMessage]]
    val mirror = ru.runtimeMirror(loader)

    descriptorFor(clazzInstance, mirror)
  }

  def descriptorFor[T <: AbstractMessage](clazz: Class[T], mirror: Mirror): Descriptor = {
    descriptorFor(mirror.classSymbol(clazz).toType, mirror)
  }

  def descriptorFor[T: TypeTag](mirror: Mirror): Descriptor = {
    descriptorFor(localTypeOf[T](mirror), mirror)
  }

  def descriptorFor(tpe: `Type`, mirror: Mirror): Descriptor = {
    tpe match {
      case t if t <:< localTypeOf[AbstractMessage](mirror) =>
        val clazz = mirror.runtimeClass(t).asInstanceOf[Class[AbstractMessage]]

        clazz.getMethod("getDescriptor")
          .invoke(null)
          .asInstanceOf[Descriptor]

      case _ =>
        throw new RuntimeException("no clue how you got here")
    }
  }

  def parserMethodFor(className: String): Method = {
    val clazz = Class.forName(className).asInstanceOf[Class[AbstractMessage]]

    clazz.getMethod("parseFrom", classOf[Array[Byte]])
  }

  def structFor(tpe: `Type`, mirror: Mirror): StructType = {
    tpe match {
      case t if t <:< localTypeOf[AbstractMessage](mirror) =>
        val clazz = mirror.runtimeClass(t).asInstanceOf[Class[AbstractMessage]]
        val descriptor = clazz.getMethod("getDescriptor").invoke(null).asInstanceOf[Descriptor]

        val fds = descriptor.getFields

        var i = 0
        val data = new Array[StructField](fds.size())

        while(i < fds.size()) {
          data(i) = fieldDescriptorAsStructField(fds.get(i))

          i += 1
        }

        StructType(data)

      case _ =>
        throw new RuntimeException("no clue how you got here")
    }
  }

  private def localTypeOf[T: TypeTag](mirror: Mirror): `Type` = typeTag[T].in(mirror).tpe

  def fieldDescriptorAsStructField(fd: FieldDescriptor): StructField = {
    val dataType = fd.getJavaType match {
      case INT => IntegerType
      case LONG => LongType
      case FLOAT => FloatType
      case DOUBLE => DoubleType
      case BOOLEAN => BooleanType
      case STRING => StringType
      case BYTE_STRING => BinaryType
      case ENUM => StringType
      case MESSAGE =>
        val fds = fd.getMessageType.getFields

        var i = 0
        val structFields = new Array[StructField](fds.size())

        while(i < fds.size()) {
          structFields(i) = fieldDescriptorAsStructField(fds.get(i))

          i += 1
        }

        StructType(structFields)
    }


    val adjustedDataType = if(fd.isRepeated) {
      ArrayType(dataType, containsNull = false)
    }
    else {
      dataType
    }

    val nullable = !fd.isRequired && !fd.isRepeated

    StructField(fd.getName, adjustedDataType, nullable)
  }

  def messageAsRow(message: AbstractMessage): Row = {
    def fieldData(fd: FieldDescriptor, obj: AnyRef) = {
      fd.getJavaType match {
        case INT => obj.asInstanceOf[Int]
        case LONG => obj.asInstanceOf[Long]
        case FLOAT => obj.asInstanceOf[Float]
        case DOUBLE => obj.asInstanceOf[Double]
        case BOOLEAN => obj.asInstanceOf[Boolean]
        case STRING => obj.asInstanceOf[String]
        case BYTE_STRING => obj.asInstanceOf[ByteString].toStringUtf8
        case ENUM => obj.asInstanceOf[EnumValueDescriptor].getName
        case MESSAGE => messageAsRow(obj.asInstanceOf[AbstractMessage])
      }
    }

    val fds = message.getDescriptorForType.getFields
    val fields = message.getAllFields

    var i = 0
    val data = new Array[Any](fds.size())

    while(i < fds.size()) {
      val fd = fds.get(i)

      if(fields.containsKey(fd)) {
        val obj = fields.get(fd)

        if(fd.isRepeated) {
          val list = obj.asInstanceOf[java.util.List[Object]]

          var j = 0
          val jData = new Array[Any](list.size())

          while(j < list.size()) {
            val item = list.get(j)

            jData(j) = fieldData(fd, item)

            j += 1
          }

          data(i) = jData.toSeq
        }
        else {
          data(i) = fieldData(fd, obj)
        }
      }
      else if(fd.isRepeated) {
        data(i) = Seq()
      }
      else {
        data(i) = null
      }

      i += 1
    }

    Row(data: _*)
  }
}
