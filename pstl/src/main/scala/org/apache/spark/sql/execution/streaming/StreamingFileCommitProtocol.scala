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

import org.apache.hadoop.fs._
import org.apache.hadoop.fs.permission.FsPermission
import org.apache.hadoop.mapreduce.{JobContext, TaskAttemptContext}
import org.apache.spark.SparkContext
import org.apache.spark.internal.Logging
import org.apache.spark.internal.io.FileCommitProtocol
import org.apache.spark.internal.io.FileCommitProtocol.TaskCommitMessage

import scala.collection.mutable.ArrayBuffer
import scala.util.Try

object StreamingFileCommitProtocol {
  private val TMP_DIR = "_spark_tmp"

  case class ManagedFile(src: String, dst: String)

  def generateFileName(queryId: String,
                       batchId: Long,
                       partitionId: Long,
                       fileExtension: String): String = {
    f"$queryId-$batchId%05d-part-$partitionId%05d$fileExtension"
  }

  def resolveTempDirectory(dir: File): File = {
    new File(dir, TMP_DIR)
  }
}

/**
 * Offers an alternative to [[ManifestFileCommitProtocol]] for use cases where external systems
 * are interested in reading output from a [[FileStreamSink]] but may not necessarily understand
 * how to query the underlying manifest for filtering dirty writes, etc. Unlike the manifest based
 * approach, [[StreamingFileCommitProtocol]] is lower latency as we allow executors to deal with
 * commits without driver coordination (eventually consistent in the face of failures and retries).
 * This assumes deterministic input during failures, etc. Essentially a failure could mean some
 * tasks succeeded and that data is available to readers even though the entire batch did not
 * complete successfully. This should be a clue that deterministic input is required when using
 * [[StreamingFileCommitProtocol]] otherwise your mileage may vary.
 * @param jobId the batchId of this structured streaming micro batch
 * @param path the base path to output files to
 */
class StreamingFileCommitProtocol(jobId: String, path: String)
  extends FileCommitProtocol with Serializable with Logging {

  import StreamingFileCommitProtocol._

  private val batchId: Long = Try(jobId.toLong).toOption.filter(_ >= 0).getOrElse {
    throw new IllegalArgumentException(
      s"jobId must be a valid structured streaming batchId, but received '$jobId'")
  }

  // todo: spark-2.3.0+, not supported in spark-2.2.0
  private val queryId = SparkContext.getActive.flatMap { sc =>
    Option(sc.getLocalProperty(StreamExecution.QUERY_ID_KEY))
  }.getOrElse {
    throw new IllegalStateException(
      s"$this can only be used with structured streaming queries, " +
        s"expected to find local property '${StreamExecution.QUERY_ID_KEY}'")
  }

//  private val queryId = throw new IllegalStateException(
  //  s"$this can only be used with structured streaming queries in spark-2.3.0-SNAPSHOT+")

  @transient private var managedFiles: ArrayBuffer[ManagedFile] = _

  override def setupJob(jobContext: JobContext): Unit = ()
  override def commitJob(jobContext: JobContext, taskCommits: Seq[TaskCommitMessage]): Unit = ()
  override def abortJob(jobContext: JobContext): Unit = ()

  override def setupTask(taskContext: TaskAttemptContext): Unit = {
    managedFiles = new ArrayBuffer[ManagedFile]()
  }

  override def commitTask(taskContext: TaskAttemptContext): TaskCommitMessage = {
    if(managedFiles == null) {
      throw new IllegalStateException(s"$this setupTask must be invoked before commitTask")
    }
    else if(managedFiles.nonEmpty) {
      val fs = FileContext.getFileContext(taskContext.getConfiguration)

      try {
        managedFiles.foreach {
          case ManagedFile(src, dst) =>
            fs.rename(new Path(src), new Path(dst), Options.Rename.OVERWRITE)
        }
      }
      catch {
        case e: Throwable =>
          val files = managedFiles.map(f => s"${f.src} => ${f.dst}").mkString(", ")
          log.error(s"failed to commit temporary files batchId=[$batchId] files=[$files]", e)
          throw e
      }

      new TaskCommitMessage(Seq.empty[ManagedFile])
    }
    else {
      new TaskCommitMessage(Seq.empty[ManagedFile])
    }
  }

  override def abortTask(taskContext: TaskAttemptContext): Unit = {
    if(managedFiles == null) {
      throw new IllegalStateException(s"$this setupTask must be invoked before abortTask")
    }
    else if(managedFiles.nonEmpty) {
      val fs = FileContext.getFileContext(taskContext.getConfiguration)

      try {
        managedFiles.foreach {
          case ManagedFile(src, _) =>
            if(!fs.delete(new Path(src), false)) {
              log.warn(s"failed to delete temporary file batchId=[$batchId] file=[$src]")
            }
        }
      }
      catch {
        case e: Throwable =>
          val files = managedFiles.map(_.src).mkString(", ")
          log.error(s"failed to delete temporary files batchId=[$batchId] files=[$files]", e)
          throw e
      }
    }
  }

  override def newTaskTempFile(taskContext: TaskAttemptContext,
                               dir: Option[String],
                               ext: String): String = {
    val tmpDir = dir.map(d => new Path(path, new Path(d, TMP_DIR)))
      .getOrElse(new Path(path, TMP_DIR))

    val fs = FileContext.getFileContext(taskContext.getConfiguration)

    if(!fs.util.exists(tmpDir)) {
      fs.mkdir(tmpDir, FsPermission.getDirDefault, true)
    }

    val part = taskContext.getTaskAttemptID.getTaskID.getId
    val filename = f"$queryId-$batchId%05d-part-$part%05d$ext"

    val src = new Path(tmpDir, filename)
    val srcString = src.toString

    if(fs.util.exists(src)) {
      if(!fs.delete(src, false)) {
        throw new IllegalStateException(
          s"failed to delete temporary file which already exists $src")
      }
    }

    val dst = dir.map(d => new Path(path, new Path(d, filename)))
      .getOrElse(new Path(path, filename))
    val dstString = dst.toString

    managedFiles += ManagedFile(srcString, dstString)
    srcString
  }

  /**
   * @throws UnsupportedOperationException not implemented
   */
  override def newTaskTempFileAbsPath(taskContext: TaskAttemptContext,
                                      absoluteDir: String,
                                      ext: String): String = {
    throw new UnsupportedOperationException(
      s"$this does not support adding files with an absolute path")
  }

  private[streaming] def addManagedFile(src: String, dst: String): Unit = {
    managedFiles += ManagedFile(src, dst)
  }

  private[streaming] def clearManagedFiles(): Unit = {
    managedFiles.clear()
  }
}
