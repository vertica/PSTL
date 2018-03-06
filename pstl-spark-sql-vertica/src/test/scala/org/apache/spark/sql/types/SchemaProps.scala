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


package org.apache.spark.sql.types

import org.scalacheck.Gen
import org.scalacheck.Arbitrary

object SchemaProps {
  implicit def arbSchema: Arbitrary[StructType] = Arbitrary(structType(structFieldGen))

  def structType(gen: Gen[StructField], maxDiscarded: Int = 1000): Gen[StructType] = {
    var struct = new StructType()
    var discarded = 0

    Gen.sized { size =>
      if(struct.size == size) {
        struct
      }
      else {
        while(struct.size <= size && discarded < maxDiscarded) {
          gen.sample match {
            case Some(f) => struct = struct.add(f)
            case _ => discarded += 1
          }
        }

        struct
      }
    }.suchThat(schema => schema.nonEmpty && schema.size <= 1000)
  }

  lazy val structFieldGen: Gen[StructField] = {
    for {
      name <- Gen.alphaStr.suchThat(str => str.nonEmpty && str.length < 32)
      dataType <- dataTypeGen
      nullable <- Gen.oneOf(Seq(true, false))
    } yield StructField(name, dataType, nullable)
  }

  lazy val dataTypeGen: Gen[DataType] = Gen.frequency(
    1 -> BinaryType,
    1 -> BooleanType,
    1 -> ByteType,
    1 -> CalendarIntervalType,
//    1 -> CharType,
    1 -> DateType,
//    1 -> DecimalType,
    1 -> DoubleType,
    1 -> FloatType,
    1 -> IntegerType,
    1 -> LongType,
    1 -> NullType,
    1 -> ShortType,
    1 -> StringType,
    1 -> TimestampType
    //,
//    1 -> VarcharType
  )
}
