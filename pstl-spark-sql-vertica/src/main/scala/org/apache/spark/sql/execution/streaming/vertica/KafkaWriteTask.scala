/*
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

package org.apache.spark.sql.execution.streaming.vertica

import java.{util => ju}
import java.io.ByteArrayOutputStream

import org.apache.avro.SchemaBuilder
import org.apache.avro.generic.GenericData.Record
import org.apache.avro.generic.GenericDatumWriter
import org.apache.avro.io.EncoderFactory
import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}
import org.apache.spark.sql.Row
import org.apache.spark.sql.avro.AvroSchemaConverter
import org.apache.spark.sql.catalyst.{CatalystTypeConverters, InternalRow}
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.kafka010.CachedKafkaProducer
import org.apache.spark.sql.types.StructType

class KafkaWriteTask(consumerProperties: ju.Map[String, Object],
                     producerProperties: ju.Map[String, Object],
                     inputSchema: Seq[Attribute],
                     topic: String) {
  @volatile private var failedWrite: Exception = _

  private var producer: KafkaProducer[Array[Byte], Array[Byte]] = _
  private var messagesProduced: Long = 0L

  private val sparkSchema = StructType.fromAttributes(inputSchema)

  private val catalystConverter = CatalystTypeConverters.createToScalaConverter(sparkSchema)

  private val avroSchema = AvroSchemaConverter.convertStructToAvro(
    sparkSchema, SchemaBuilder.record("record"), "pstl")

  private val avroConverter = AvroSchemaConverter.createConverterToAvro(
    sparkSchema, "record", "pstl")

  private val avroBaos = new ByteArrayOutputStream()
  private val avroEncoder = EncoderFactory.get().binaryEncoder(avroBaos, null)
  private val avroWriter = new GenericDatumWriter[Record](avroSchema)

  def execute(iterator: Iterator[InternalRow]): Unit = {
    producer = CachedKafkaProducer.getOrCreate(producerProperties)

    while(iterator.hasNext && failedWrite == null) {
      val internalRow = iterator.next()
      val convertedRow = catalystConverter(internalRow).asInstanceOf[Row]
      val avroRecord = avroConverter(convertedRow).asInstanceOf[Record]

      avroBaos.reset()
      avroWriter.write(avroRecord, avroEncoder)
      avroEncoder.flush()
      val avroBytes = avroBaos.toByteArray

      val record = new ProducerRecord[Array[Byte], Array[Byte]](topic, avroBytes)

      val callback = new Callback {
        override def onCompletion(metadata: RecordMetadata, exception: Exception): Unit = {
          if(failedWrite == null && exception != null) {
            failedWrite = exception
          }
        }
      }

      producer.send(record, callback)
      messagesProduced += 1L
    }
  }

  def close(): KafkaWriteStatus = {
    checkForErrors()

    if(producer != null) {
      producer.flush()
      checkForErrors()
      producer = null

      KafkaWriteStatus(
        topic = topic,
        messagesProduced = messagesProduced)
    }
    else {
      throw new IllegalStateException(
        "kafka producer was null, unable to finalize: topic=$topic")
    }
  }

  private def checkForErrors(): Unit = {
    if(failedWrite != null) {
      throw failedWrite
    }
  }
}
