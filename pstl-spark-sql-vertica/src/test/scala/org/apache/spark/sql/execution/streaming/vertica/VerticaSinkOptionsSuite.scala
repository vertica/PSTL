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

import java.util.Properties

import org.scalatest._

class VerticaSinkOptionsSuite extends FunSuite with Matchers {

  def verticaUsername: String = "dbadmin"
  def verticaPassword: String = "password"
  def verticaJdbcUrl: String = "jdbc:vertica://localhost:5433/default"

  test("Without URL") {
lazy val parameters = Map(
//      "url"-> verticaJdbcUrl,
      "vertica.jdbc.username"-> verticaUsername )
    val params = new VerticaSinkOptions(parameters)
    assert(params.jdbcUrl != null)
    assert(params.jdbcUrl.length != 0)
    assert(params.jdbcUrl == "jdbc:vertica://localhost:5433/default")
  }

  test("With URL") {
   lazy val  parameters = Map("url"-> verticaJdbcUrl)
    val params = new VerticaSinkOptions(parameters)
    assert(params.jdbcUrl == verticaJdbcUrl)

  }

  test("Without Topic") {
   lazy val  parameters = Map("queryName"->"ABC"
//     , "topic"->"12"
    )
    val caught = intercept[IllegalArgumentException]
    {
       lazy val params = new VerticaSinkOptions( parameters)
       val topicval = params.topic
    }
    assert(caught.getMessage == "Vertica sink requires option 'topic' to specify the target topic")
  }

  test("With Topic") {
  lazy val  parameters = Map("topic"->"12")
  val params = new VerticaSinkOptions(parameters)
  assert(params.topic == "12")
  }

  test("Without TransactionTable") {
    lazy val  parameters = Map(
//      "transactionTable"->"vertica_sink_batch",
      "queryName"->"ABC"
    )
    lazy val params = new VerticaSinkOptions(parameters)
    assert(params.commitLogTable != null)
    assert(params.commitLogTable.length != 0)
  }

  test("With TransactionTable") {
    lazy val  parameters = Map("transactionTable"->"vertica_sink_batch")
    val params = new VerticaSinkOptions(parameters)
    assert(params.commitLogTable == "vertica_sink_batch")
  }

  test("Without Table") {
    lazy val  parameters = Map(
      "eofTimeout" -> "2"
//    ,"table"-> "target table",
    )
    val caught = intercept[IllegalArgumentException]
      {
        lazy val params = new VerticaSinkOptions(parameters)
        val tableval = params.table
      }
    println(caught.getMessage)
    assert(caught.getMessage == "Vertica sink requires option 'table' to specify the target table")
  }

  test("With Table") {
    lazy val parameters = Map("table" -> "target table")
    val params = new VerticaSinkOptions(parameters)
    assert(params.table == "target table")
  }

  test("Without SinkID") {
    lazy val  parameters = Map(
      "transactionTable"->"vertica_sink_batch"
//      ,"queryName"->"ABC"
    )
    val params = new VerticaSinkOptions(parameters)
    assert(params.sinkId == "<unknown>")
  }

  test("With SinkID") {
    lazy val  parameters = Map("queryName"->"ABC")
    val params = new VerticaSinkOptions(parameters)
    assert(params.sinkId == "ABC")
  }

  test("Without JobID") {
    lazy val  parameters = Map(
      "queryName"->"ABC"
//     , "__pstl_job_id"->"1"
    )
    val params = new VerticaSinkOptions(parameters)
      assert(params.jobId == "<unknown>")
  }

  test("With JobID") {
    lazy val  parameters = Map( "__pstl_job_id"->"1")
    val params = new VerticaSinkOptions(parameters)
    assert(params.jobId =="1")
  }

  test("Without EOF") {
    lazy val  parameters = Map(
      "copyOptions"-> "NO COMMIT"
//      ,"eofTimeout" -> "2"
    )
    val params = new VerticaSinkOptions(parameters)
    assert(params.copyEofTimeoutMs != null)
//    assert(params.copyEofTimeoutMs.length != 0)
    assert(params.copyEofTimeoutMs == "30 seconds")
  }

  test("With EOF") {
    lazy val  parameters = Map("eofTimeout" -> "2")
    val params = new VerticaSinkOptions(parameters)
     assert(params.copyEofTimeoutMs == "2")
  }

  test("Without IncrementalCopyDuration") {
    lazy val  parameters = Map("__pstl_job_id"->"1"
//      ,"incrementalCopyDuration"->"5"
    )
    val params = new VerticaSinkOptions(parameters)
    assert(params.copyDurationMs != null)
//    assert(params.copyDurationMs.length != 0)
//assert(params.incrementalCopyDuration == "1000 milliseconds")
  }

  test("With IncrementalCopyDuration") {
   lazy val  parameters = Map("incrementalCopyDuration"->"5")
    val params = new VerticaSinkOptions(parameters)
    assert(params.copyDurationMs == "5")
  }

  test("Without CommitCompactInterval") {
    lazy val  parameters = Map(
      "vertica.jdbc.user"-> verticaUsername
     // ,"commitLogCompactInterval"-> "1",
    )
    val params = new VerticaSinkOptions(parameters)
    assert(params.commitLogCompactionInterval == 65536)
  }

  test("With CommitCompactInterval") {
    lazy val  parameters = Map("commitLogCompactInterval"-> "abc")
    val caught = intercept[IllegalArgumentException]
      {
        val params = new VerticaSinkOptions(parameters)
        val commitval = params.commitLogCompactionInterval
      }
    println(caught.getMessage)
    assert(caught.getMessage ==  s"Invalid value 'abc' for option 'commitLogCompactInterval', must be a valid number > 0")
  }

  test("Without CopyOptions") {
    lazy val  parameters = Map("copyOptions"-> "YES COMMIT")
    val caught = intercept[IllegalArgumentException]
      {
        val params = new VerticaSinkOptions(parameters)
        val copyval = params.copyOptions
      }
    println(caught.getMessage)
    assert(caught.getMessage ==  "Vertica sink requires option 'copyOptions' to contain 'NO COMMIT' since COPY commands " +
                                 "auto-commit by default without the NO COMMIT option, and depending on your 'copyOptions' " +
                                 "determining placement of NO COMMIT is a tad tricky.")
  }

  test("With CopyOptions") {
    lazy val  parameters = Map("copyOptions"-> "NO COMMIT")
    val params = new VerticaSinkOptions(parameters)
    assert(params.copyOptions == "NO COMMIT")
  }
  test("With ProducerParallelismFactor") {
    val  parameters = Map("producerParallelismFactor"-> "1")
    val params = new VerticaSinkOptions(parameters)

    assert(params.producerParallelism == 1)
  }

  test("Without ProducerParallelismFactor") {
    lazy val  parameters = Map("producerParallelismFactor"-> "abc")
    val caught = intercept[IllegalArgumentException] {
      val params = new VerticaSinkOptions(parameters)
      val factorval = params.producerParallelism
    }
println(caught.getMessage)
    assert(caught.getMessage == s"Invalid value 'abc' for option 'producerParallelismFactor', must be a positive integer")
  }

  test("JdbcProperties") {
    lazy val  parameters = Map(
      "vertica.jdbc.username"-> verticaUsername,
      "vertica.jdbc.password"-> verticaPassword
    )
  val params = new VerticaSinkOptions(parameters)
    var props = new Properties
    props = params.jdbcProperties
    assert(params.jdbcProperties.getProperty("username") == verticaUsername)
    assert(params.jdbcProperties.getProperty("password") == verticaPassword)
  }

}
