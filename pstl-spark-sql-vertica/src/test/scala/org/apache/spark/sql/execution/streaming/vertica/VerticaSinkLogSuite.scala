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

package org.apache.spark.sql.execution.streaming.vertica

import org.apache.spark.sql.internal.SQLConf
import org.scalatest._

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class VerticaSinkLogSuite extends FunSuite
  with Matchers
  with VerticaDatabaseKit
  with VerticaEnvironmentVariables {
val  parameters = Map(
  "url"-> verticaJdbcUrl,
  "vertica.jdbc.user"-> verticaUsername,
  "vertics.jdbc.password"-> verticaPassword,
  "commitLogCompactInterval"-> "1",
  "copyOptions"-> "NO COMMIT",
  "eofTimeout" -> "2",
  "table"-> "target table",
  "transactionTable"->"vertica_sink_batch"
)
  private lazy val options = new VerticaSinkOptions(parameters, new SQLConf)
  private lazy val metrics = VerticaMetrics(options)

  ignore("add") {

    connection.setAutoCommit(false)
    val log = new VerticaSinkLog(connection, options, metrics)

//    log.add(121, Seq(SinkVerticaStatus("topic", 3, 111L, 222L)))
    val added = log.add(122, Seq(SinkVerticaStatus("topic2", 4, 333L, 444L)))
    added shouldBe true

    val stmt = connection.prepareStatement("SELECT batch_id, kafka_topic,kafka_partition,kafka_offset_from,kafka_offset_until FROM vertica_sink_batch WHERE batch_id = 1")
    val rs = stmt.executeQuery()
    var batchId = Long.MinValue
//    val response = mutable.ArrayBuffer(Seq(SinkVerticaStatus("topic", 3, 111L, 222L)))
    val response = mutable.Seq(SinkVerticaStatus("topic2",4, 333L, 444L))

     print(response)

    while (rs.next()) {
      batchId = rs.getLong("batch_id")
      response :+ SinkVerticaStatus(
        rs.getString("kafka_topic"),
        rs.getInt("kafka_partition"),
        rs.getLong("kafka_offset_from"),
        rs.getLong("kafka_offset_until"))
    }

    assert(Seq(SinkVerticaStatus("topic2",4, 333L, 444L)) == response)
//    assert(response.contains(ArrayBuffer("topic",3, 111L, 222L)))
   // assert(Seq(SinkVerticaStatus("topic",3, 111L, 222L)) == response)
  }

  ignore("get") {
    val log = new VerticaSinkLog(connection, options, metrics)

    val response = log.get(122)
    print(response)

    assert(response.contains(ArrayBuffer(SinkVerticaStatus("topic2", 4, 333L, 444L))))

  }

  ignore("getlatest") {
    connection.setAutoCommit(false)
    val log = new VerticaSinkLog(connection,options, metrics)

    log.add(121, Seq(SinkVerticaStatus("topic", 1, 111L, 222L)))
    log.add(122, Seq(SinkVerticaStatus("topic2", 2, 333L, 444L)))
//    log.add(133, Seq(SinkVerticaStatus("topic3", 3, 555L, 666L)))

    val response = log.getLatest()
    print(response)

//    assert(response.contains((133, Seq(SinkVerticaStatus("topic3", 3, 555L, 666L)))))
        assert(response.contains((122, Seq(SinkVerticaStatus("topic2", 2, 333L, 444L)))))
  }

  ignore("purge") {

   val log = new VerticaSinkLog(connection, options, metrics)
    log.purge(122)

    val stmt = connection.prepareStatement("SELECT COUNT(*) FROM vertica_sink_batch where batch_id <= 122")
    val rs = stmt.executeQuery()
    var count = Long.MinValue
    while (rs.next()) {
      count = rs.getInt(1)
    }
    assert( 0 == count)

  }

  ignore("getStartId") {
    val log = new VerticaSinkLog(connection, options, metrics)

    intercept[UnsupportedOperationException] {
      log.get(Some(1L), Some(2L))
    }
  }

  ignore("clear test table") {
    val stmt = connection.prepareStatement("truncate table vertica_sink_batch")
    val rs = stmt.execute()
    assert( 0 == 0)
  }
}
