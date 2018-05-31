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

import org.apache.spark.sql.{AnalysisException, SQLContext}
import org.apache.spark.sql.execution.streaming.Sink
import org.apache.spark.sql.sources.{DataSourceRegister, StreamSinkProvider}
import org.apache.spark.sql.streaming.OutputMode

class VerticaSinkProvider extends StreamSinkProvider with DataSourceRegister {
  override def shortName(): String = "vertica"

  override def createSink(sqlContext: SQLContext,
                          parameters: Map[String, String],
                          partitionColumns: Seq[String],
                          outputMode: OutputMode): Sink = {
    if(outputMode != OutputMode.Append()) {
      throw new AnalysisException(
        s"Data source $className does not support $outputMode output mode")
    }

    if(partitionColumns.nonEmpty) {
      throw new AnalysisException(
        s"Data source $className does not support partition columns")
    }

    val options = new VerticaSinkOptions(parameters, sqlContext.conf)

    new VerticaSink(options)
  }

  private def className: String = classOf[VerticaSink].getName
}
