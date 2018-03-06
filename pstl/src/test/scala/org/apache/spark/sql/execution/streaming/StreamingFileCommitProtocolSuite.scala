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

import java.io.File
import java.util
import java.util.UUID

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.permission.FsPermission
import org.apache.hadoop.fs.{CreateFlag, FileContext, Path}
import org.apache.hadoop.mapreduce._
import org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
import org.apache.spark.SparkContext
import org.apache.spark.sql.streaming.StreamTest
import org.scalatest._

object StreamingFileCommitProtocolSuite {
  def nextQueryId(): String = UUID.randomUUID().toString
}

class StreamingFileCommitProtocolSuite extends StreamTest with Matchers {

  import StreamingFileCommitProtocolSuite._

  test("streaming file commit protocol requires batch id") {
    val e1 = intercept[IllegalArgumentException](new StreamingFileCommitProtocol("foo", ""))
    e1.getMessage should include("must be a valid structured streaming batchId")

    val e2 = intercept[IllegalArgumentException](new StreamingFileCommitProtocol("-1", ""))
    e2.getMessage should include("must be a valid structured streaming batchId")

    val e3 = intercept[IllegalArgumentException](new StreamingFileCommitProtocol("0.0", ""))
    e3.getMessage should include("must be a valid structured streaming batchId")

    try {
      val q1 = nextQueryId()
      setFakeQueryId(q1)
      new StreamingFileCommitProtocol("0", "")
    }
    finally {
      clearFakeQueryId()
    }
  }

  test("streaming file commit protocol requires streaming query id") {
    withTempDir { outputDir =>
      val e = intercept[IllegalStateException](
        new StreamingFileCommitProtocol("0", outputDir.getCanonicalPath))

      e.getMessage should include("can only be used with structured streaming queries")

      val queryId = nextQueryId()
      setFakeQueryId(queryId)
      new StreamingFileCommitProtocol("0", outputDir.getCanonicalPath)
    }
  }

  test("streaming file commit protocol requires setupTask before abortTask and commitTask") {
    withProtocol(0L) { context =>
      withTaskAttempt() { taskContext =>
        val e1 = intercept[IllegalStateException](context.protocol.abortTask(taskContext))
        e1.getMessage should include("setupTask must be invoked before abortTask")

        val e2 = intercept[IllegalStateException](context.protocol.commitTask(taskContext))
        e2.getMessage should include("setupTask must be invoked before commitTask")

        context.protocol.setupTask(taskContext)
        context.protocol.abortTask(taskContext)
        context.protocol.commitTask(taskContext)
      }
    }
  }

  test("streaming file commit protocol creates necessary directory structure") {
    withProtocol(0L) { context =>
      withTaskAttempt() { taskContext =>
        val dirName = nextQueryId()
        context.protocol.setupTask(taskContext)
        val filename = context.protocol.newTaskTempFile(taskContext, Option(dirName), "")

        val rootDir = new File(context.outputDir, dirName)
        rootDir.exists() shouldBe true
      }
    }
  }

  test("streaming file commit protocol replaces existing temporary files") {
    withProtocol(0L) { protocolContext =>
      withTaskAttempt() { taskContext =>
        val filename = StreamingFileCommitProtocol.generateFileName(
          protocolContext.queryId, 0L, 0L, "")

        val fs = FileContext.getFileContext(taskContext.getConfiguration)

        val filepath = new Path(
          protocolContext.tmpOutputDir.getCanonicalPath, filename)

        fs.mkdir(
          new Path(protocolContext.tmpOutputDir.getCanonicalPath), FsPermission.getDirDefault, true)

        fs.util.exists(filepath) shouldBe false
        val out = fs.create(filepath, util.EnumSet.of(CreateFlag.CREATE))
        out.close()
        fs.util.exists(filepath) shouldBe true

        protocolContext.protocol.setupTask(taskContext)
        protocolContext.protocol.newTaskTempFile(taskContext, None, "")

        fs.util.exists(filepath) shouldBe false
      }
    }
  }

  test("streaming file commit protocol replaces existing finalized files") {
    withProtocol(0L) { protocolContext =>
      withTaskAttempt() { taskContext =>
        val fs = FileContext.getFileContext(taskContext.getConfiguration)
        fs.mkdir(new Path(protocolContext.tmpOutputDir.getCanonicalPath), FsPermission.getDirDefault, true)

        val f1 = new Path(protocolContext.outputDir.getCanonicalPath,
          StreamingFileCommitProtocol.generateFileName(protocolContext.queryId, 0L, 0L, ""))

        val out1 = fs.create(f1, util.EnumSet.of(CreateFlag.CREATE))
        out1.writeUTF("foo")
        out1.close()

        protocolContext.protocol.setupTask(taskContext)

        val src = protocolContext.protocol.newTaskTempFile(taskContext, None, "")
        val srcPath = new Path(src)

        val srcOut = fs.create(srcPath, util.EnumSet.of(CreateFlag.CREATE))
        srcOut.writeUTF("bar")
        srcOut.close()

        protocolContext.protocol.commitTask(taskContext)

        val in = fs.open(f1)
        val contents = in.readUTF()
        in.close()

        contents should be("bar")
      }
    }
  }

  test("streaming file commit protocol abort task when managed files empty") {
    withProtocol(0L) { protocolContext =>
      withTaskAttempt() { taskContext =>
        protocolContext.protocol.setupTask(taskContext)
        protocolContext.protocol.abortTask(taskContext)
      }
    }
  }

  test("streaming file commit protocol abort task when managed files exist") {
    withProtocol(0L) { protocolContext =>
      withTaskAttempt() { taskContext =>
        val fs = FileContext.getFileContext(taskContext.getConfiguration)
        fs.mkdir(new Path(protocolContext.tmpOutputDir.getCanonicalPath), FsPermission.getDirDefault, true)

        val src1 = new Path(protocolContext.tmpOutputDir.getCanonicalPath, "a")
        val src2 = new Path(protocolContext.tmpOutputDir.getCanonicalPath, "b")

        val out1 = fs.create(src1, util.EnumSet.of(CreateFlag.CREATE))
        out1.close()

        val out2 = fs.create(src2, util.EnumSet.of(CreateFlag.CREATE))
        out2.close()

        val dst1 = new Path(protocolContext.outputDir.getCanonicalPath, "a")
        val dst2 = new Path(protocolContext.outputDir.getCanonicalPath, "b")

        protocolContext.protocol.setupTask(taskContext)

        protocolContext.protocol.addManagedFile(src1.toString, dst1.toString)
        protocolContext.protocol.addManagedFile(src2.toString, dst2.toString)

        protocolContext.protocol.abortTask(taskContext)

        fs.util.exists(src1) shouldBe false
        fs.util.exists(src2) shouldBe false

        fs.util.exists(dst1) shouldBe false
        fs.util.exists(dst2) shouldBe false
      }
    }
  }

  test("streaming file commit protocol commit task when managed files empty") {
    withProtocol(0L) { protocolContext =>
      withTaskAttempt() { taskContext =>
        protocolContext.protocol.setupTask(taskContext)
        protocolContext.protocol.commitTask(taskContext)
      }
    }
  }

  test("streaming file commit protocol commit task when managed files exist") {
    withProtocol(0L) { protocolContext =>
      withTaskAttempt() { taskContext =>
        val fs = FileContext.getFileContext(taskContext.getConfiguration)
        fs.mkdir(new Path(protocolContext.tmpOutputDir.getCanonicalPath), FsPermission.getDirDefault, true)

        val src1 = new Path(protocolContext.tmpOutputDir.getCanonicalPath, "a")
        val src2 = new Path(protocolContext.tmpOutputDir.getCanonicalPath, "b")

        val out1 = fs.create(src1, util.EnumSet.of(CreateFlag.CREATE))
        out1.close()

        val out2 = fs.create(src2, util.EnumSet.of(CreateFlag.CREATE))
        out2.close()

        val dst1 = new Path(protocolContext.outputDir.getCanonicalPath, "a")
        val dst2 = new Path(protocolContext.outputDir.getCanonicalPath, "b")

        protocolContext.protocol.setupTask(taskContext)

        protocolContext.protocol.addManagedFile(src1.toString, dst1.toString)
        protocolContext.protocol.addManagedFile(src2.toString, dst2.toString)

        protocolContext.protocol.commitTask(taskContext)

        fs.util.exists(src1) shouldBe false
        fs.util.exists(src2) shouldBe false

        fs.util.exists(dst1) shouldBe true
        fs.util.exists(dst2) shouldBe true
      }
    }
  }

  test("streaming file commit protocol does not support new task temp file abs path") {
    withProtocol(0L) { context =>
      val e = intercept[UnsupportedOperationException] {
        withTaskAttempt() { taskContext =>
          context.protocol.newTaskTempFileAbsPath(taskContext, context.outputDir.getCanonicalPath, "")
        }
      }

      e.getMessage should endWith("does not support adding files with an absolute path")
    }
  }

  private def withProtocol(jobId: Long)(f: ProtocolContext => Unit): Unit = {
    withTempDir { outputDir =>
      val queryId = nextQueryId()
      setFakeQueryId(queryId)

      val protocol = new StreamingFileCommitProtocol(jobId.toString, outputDir.getCanonicalPath)

      val protocolContext = ProtocolContext(
        outputDir, protocol, queryId, StreamingFileCommitProtocol.resolveTempDirectory(outputDir))

      try {
        f(protocolContext)
      }
      finally {
        clearFakeQueryId()
      }
    }
  }

  private def withTaskAttempt(partitionId: Int = 0)(f: TaskAttemptContext => Unit): Unit = {
    val context = new TaskAttemptContextImpl(
      new Configuration(),
      new TaskAttemptID(
        new TaskID(new JobID("job", 0), TaskType.MAP, partitionId), 0))

    f(context)
  }

  private def setFakeQueryId(queryId: String): Unit = {
    // todo: StreamExecution.QUERY_ID_KEY
    SparkContext.getActive.foreach(_.setLocalProperty("sql.streaming.queryId", queryId))
  }

  private def clearFakeQueryId(): Unit = {
    // todo: StreamExecution.QUERY_ID_KEY
    SparkContext.getActive.foreach(_.setLocalProperty("sql.streaming.queryId", null))
  }

  case class ProtocolContext(outputDir: File,
                             protocol: StreamingFileCommitProtocol,
                             queryId: String,
                             tmpOutputDir: File)
}
