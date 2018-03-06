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

package org.apache.spark.sql.execution.datasources

import java.util.Locale

import org.apache.spark.sql.catalyst.TableIdentifier
import org.apache.spark.sql.catalyst.catalog.CatalogUtils
import org.apache.spark.sql.execution.SQLExecution
import org.apache.spark.sql.execution.command.{DDLUtils, RunnableCommand}
import org.apache.spark.sql.streaming.Trigger
import org.apache.spark.sql.{AnalysisException, Row, SparkSession}

case class SaveStreamToCommand(tableIdent: TableIdentifier,
                               provider: String,
                               outputMode: String,
                               trigger: Trigger,
                               partitionBy: Seq[String],
                               queryName: String,
                               options: Map[String, String]) extends RunnableCommand {
  if(tableIdent.database.isDefined) {
    throw new AnalysisException(
      s"Temporary view $tableIdent should not have specified a database")
  }

  override def argString: String = {
    s"[tableIdent:$tableIdent " +
    s"provider:$provider " +
    CatalogUtils.maskCredentials(options) +
    "]"
  }

  override def run(spark: SparkSession): Seq[Row] = {
    val normalizedProvider = provider.toLowerCase(Locale.ROOT)

    if(normalizedProvider == DDLUtils.HIVE_PROVIDER) {
      throw new AnalysisException(
        "Hive data source can only be used with tables, you can not " +
        "write files of Hive data source directly.")
    }

    // super hack, need to understand internals more to determine
    // the most appropriate thing to do with regards to
    // the executionId of this command vs the StreamExecution
    // we are spawning upon command invocation

    SQLExecution.withExecutionId(spark.sparkContext, null) {
      // PSTL-63 (support fair scheduler)
      // initially went a little crazy with this implementation
      // backing off for a simple solution which just sets the appropriate
      // local property on the spark context if it is found in the sink's
      // configured options. not super flexible but too rare of a pattern
      // to fully abstract out in JobExecutor and SinkExecutor.
      options.get("spark.scheduler.pool").foreach { pool =>
        spark.sparkContext.setLocalProperty("spark.scheduler.pool", pool)
      }

      spark.table(tableIdent)
        .writeStream
        .format(normalizedProvider)
        .options(options)
        .outputMode(outputMode)
        .trigger(trigger)
        .partitionBy(partitionBy: _*)
        .queryName(queryName)
        .start()
    }

    Seq.empty[Row]
  }

  def checkpointLocation: Option[String] = options.get("checkpointLocation")
}
