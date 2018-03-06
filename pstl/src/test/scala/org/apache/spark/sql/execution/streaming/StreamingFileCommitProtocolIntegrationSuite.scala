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

package org.apache.spark.sql.execution.streaming

import java.io.{File, PrintWriter}
import java.nio.file.{Files, Paths}

import org.apache.spark.sql.Dataset
import org.apache.spark.sql.streaming.{StreamTest, StreamingQuery}
import org.apache.spark.sql.internal.SQLConf
import org.scalatest._
import org.scalatest.concurrent.Eventually

// todo: c000 is arbitrary extension, this is fragile
class StreamingFileCommitProtocolIntegrationSuite extends StreamTest with Matchers with Eventually {

  import SQLConf._
  import testImplicits._

  test("streaming file commit protocol") {
    val input = MemoryStream[String]

    withFileSink(input.toDS().repartition(2)) { context =>
      input.addData("1", "2", "3")
      context.query.processAllAvailable()

      new File(s"${context.outputDir}/${context.query.id}-00000-part-00000-c000.csv").exists() shouldBe true
      new File(s"${context.outputDir}/${context.query.id}-00000-part-00001-c000.csv").exists() shouldBe true

      input.addData("4", "5", "6")
      context.query.processAllAvailable()

      new File(s"${context.outputDir}/${context.query.id}-00001-part-00000-c000.csv").exists() shouldBe true
      new File(s"${context.outputDir}/${context.query.id}-00001-part-00001-c000.csv").exists() shouldBe true
    }
  }

  test("streaming file commit protocol attempts to cleanup when aborting") {
    val input = MemoryStream[String]

    withFileSink(input.toDS().repartition(2)) { context =>
      input.addData("1", "2", "3")

      val processThread = new Thread() {
        override def run(): Unit = {
          context.query.processAllAvailable()
        }
      }

      processThread.start()
      Thread.sleep(5L)
      context.query.stop()

      eventually {
        new File(s"${context.outputDir}/${context.query.id}-00000-part-00000-c000.csv").exists() shouldBe false
        new File(s"${context.outputDir}/${context.query.id}-00000-part-00001-c000.csv").exists() shouldBe false
      }
    }
  }

  test("streaming file commit protocol overwrites existing (job, batch, partition, format) output") {
    val input = MemoryStream[String]

    withFileSink(input.toDS().repartition(2)) { context =>
      val writer1 = new PrintWriter(new File(context.outputDir, s"${context.query.id}-00000-part-00000-c000.csv"))
      writer1.print("foo")
      writer1.close()

      val initial1 = new String(Files.readAllBytes(Paths.get(s"${context.outputDir}/${context.query.id}-00000-part-00000-c000.csv")), "UTF-8")
      initial1 shouldBe "foo"

      val writer2 = new PrintWriter(new File(context.outputDir, s"${context.query.id}-00000-part-00001-c000.csv"))
      writer2.print("foo")
      writer2.close()

      val initial2 = new String(Files.readAllBytes(Paths.get(s"${context.outputDir}/${context.query.id}-00000-part-00001-c000.csv")), "UTF-8")
      initial2 shouldBe "foo"

      input.addData("1", "2", "3")
      context.query.processAllAvailable()

      val output1 = new String(Files.readAllBytes(Paths.get(s"${context.outputDir}/${context.query.id}-00000-part-00000-c000.csv")), "UTF-8")
      output1 should not be "foo"

      val output2 = new String(Files.readAllBytes(Paths.get(s"${context.outputDir}/${context.query.id}-00000-part-00001-c000.csv")), "UTF-8")
      output2 should not be "foo"
    }
  }

  private def withFileSink[T](df: Dataset[T])(f: TestFileSinkContext => Unit): Unit = {
    withSQLConf(
      STREAMING_FILE_COMMIT_PROTOCOL_CLASS.key -> classOf[StreamingFileCommitProtocol].getName) {
      withTempDir { checkpointDir =>
        withTempDir { outputDir =>
          val query = df.writeStream
            .format("csv")
            .option("checkpointLocation", checkpointDir.getCanonicalPath)
            .start(outputDir.getCanonicalPath)

          try {
            f(TestFileSinkContext(checkpointDir, outputDir, query))
          }
          finally {
            if(query.isActive) {
              query.stop()
            }
          }
        }
      }
    }
  }

  case class TestFileSinkContext(checkpointDir: File,
                                 outputDir: File,
                                 query: StreamingQuery)
}
