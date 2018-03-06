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

package org.apache.spark.sql.avro

import java.io.ByteArrayOutputStream

import org.apache.avro.generic.GenericData.Record
import org.apache.avro.generic.GenericDatumWriter
import org.apache.avro.io.EncoderFactory
import org.apache.avro.specific.{SpecificData, SpecificDatumWriter, SpecificRecord}
import org.scalatest.Suite

trait AvroHelper {
  this: Suite =>

  def serialize(datum: Record): Array[Byte] = {
    val baos = new ByteArrayOutputStream()
    val encoder = EncoderFactory.get().binaryEncoder(baos, null)
    val writer = new GenericDatumWriter[Record](datum.getSchema)
    writer.write(datum, encoder)
    encoder.flush()
    baos.toByteArray
  }

  def serialize(record: SpecificRecord): Array[Byte] = {
    val baos = new ByteArrayOutputStream()
    val encoder = EncoderFactory.get().binaryEncoder(baos, null)
    val writer = new SpecificDatumWriter[SpecificRecord](record.getSchema)
    writer.write(record, encoder)
    encoder.flush()
    baos.toByteArray
  }
}
