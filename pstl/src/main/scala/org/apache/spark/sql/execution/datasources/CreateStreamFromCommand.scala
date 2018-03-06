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
import org.apache.spark.sql.execution.command.{DDLUtils, RunnableCommand}
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{AnalysisException, Row, SparkSession}

case class CreateStreamFromCommand(tableIdent: TableIdentifier,
                                   userSpecifiedSchema: Option[StructType],
                                   provider: String,
                                   options: Map[String, String]) extends RunnableCommand {
  if(tableIdent.database.isDefined) {
    throw new AnalysisException(
      s"Temporary view $tableIdent should not have specified a database")
  }

  override def argString: String = {
    s"[tableIdent:$tableIdent " +
    userSpecifiedSchema.map(_ + " ").getOrElse("") +
    s"provider:$provider " +
    CatalogUtils.maskCredentials(options) +
    s"]"
  }

  override def run(spark: SparkSession): Seq[Row] = {
    val normalizedProvider = provider.toLowerCase(Locale.ROOT)

    if(normalizedProvider == DDLUtils.HIVE_PROVIDER) {
      throw new AnalysisException(
        "Hive data source can only be used with tables, " +
        "you can't use it with CREATE STREAM FROM")
    }

    val reader = spark.readStream
      .format(normalizedProvider)
      .options(options)

    userSpecifiedSchema.foreach(reader.schema)

    val df = reader.load()

    spark.sessionState.catalog.createTempView(
      name = tableIdent.table,
      tableDefinition = df.logicalPlan,
      overrideIfExists = false)

    Seq.empty[Row]
  }
}
