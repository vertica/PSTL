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

package org.apache.spark.sql.catalyst.parser.pstl

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.parser.ParserInterface
import org.apache.spark.sql.internal.{SQLConf, VariableSubstitution}

case class SparkSqlParser(spark: SparkSession,
                          delegate: ParserInterface) extends AbstractSqlParser {
  val astBuilder: AstBuilder = new AstBuilder

  def this(spark: SparkSession) = this(spark, spark.sessionState.sqlParser)

  // this is a silly hack
  // session state is being built so sql conf is not directly accessibly from the session
  // at this point in time, so we have to construct a proper conf inline even though it's
  // available in the call stack (SparkSessionExtensions does not make it available to
  // push down into extensions / customizations unfortunately).
  private lazy val conf: SQLConf = {
    val conf = new SQLConf
    mergeSparkConf(conf, spark.sparkContext.conf)
    conf
  }

  private def mergeSparkConf(sqlConf: SQLConf, sparkConf: SparkConf): Unit = {
    sparkConf.getAll.foreach {
      case (k, v) =>
        sqlConf.setConfString(k, v)
    }
  }

  private val substitutor = new VariableSubstitution(conf)

  override protected def parse[T](command: String)(toResult: (PstlSqlBaseParser) => T): T = {
    super.parse(substitutor.substitute(command))(toResult)
  }
}
