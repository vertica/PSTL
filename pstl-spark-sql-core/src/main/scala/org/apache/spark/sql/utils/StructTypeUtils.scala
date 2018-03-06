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

package org.apache.spark.sql.utils

import org.apache.spark.sql.AnalysisException
import org.apache.spark.sql.types.StructType

object StructTypeUtils {
  def assertDistinctColumnNames(schema: StructType): Unit = {
    val columns = schema.groupBy(_.name)
    val duplicates = columns.filter(_._2.length > 1)

    if(duplicates.nonEmpty) {
      throw new AnalysisException(
        s"The provided schema contains duplicate column names. " +
        "Please make necessary modifications to ensure the schema " +
        s"contains distinct column names: ${schema.treeString}")
    }
  }
}
