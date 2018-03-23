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

import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.execution.command.RunnableCommand
import org.apache.spark.sql.types._
import org.apache.spark.sql.{Row, SparkSession}

case class ShowStreamsCommand() extends RunnableCommand {
  override val output: Seq[Attribute] = {
    val schema = StructType(StructField("stream", StringType, nullable = false) :: Nil)
    schema.toAttributes
  }

  override def run(spark: SparkSession): Seq[Row] = {
    val queries = spark.streams.active
    val queryNames = queries.map(_.name)
    queryNames.sorted.map(Row(_))
  }
}
