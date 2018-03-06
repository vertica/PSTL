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

package com.microfocus.pstl

import scala.collection.generic.CanBuildFrom

import org.apache.spark.sql.{AnalysisException, SparkSession}
import org.apache.spark.sql.catalyst.parser.{ParseException, ParserInterface}

object JobDefinition {
  def empty: JobDefinition = new JobDefinition()

  private def sanitize(sql: String): Seq[String] = {
    sql.split(Constants.SEMICOLON)
      .map(_.trim)
      .filterNot(_.isEmpty)
      .filterNot(isComment)
  }

  private def isComment(sql: String): Boolean = sql.startsWith("--")
}

class JobDefinition(statements: Seq[String]) {
  import JobDefinition._

  def this() = this(Seq.empty)
  def this(sql: String) = this(JobDefinition.sanitize(sql))

  private val sql = statements.flatMap(sanitize)

  def isEmpty: Boolean = statements.isEmpty

  def add(sql: String): JobDefinition = {
    new JobDefinition(this.sql ++ sanitize(sql))
  }

  @throws(classOf[AnalysisException])
  @throws(classOf[ParseException])
  def parse(spark: SparkSession): JobPlan = {
    parse(spark.sessionState.sqlParser)
  }

  def parse(sqlParser: ParserInterface): JobPlan = {
    val plans = statements.map(sqlParser.parsePlan)
    new JobPlan(plans)
  }

  def map[B, That](f: String => B)(implicit bf: CanBuildFrom[Seq[String], B, That]): That = {
    statements.map(f)(bf)
  }

  def foreach[T](f: String => T): Unit = {
    statements.foreach(f)
  }

  override def toString: String = toString(";\n\n")
  def toString(sep: String): String = sql.mkString(sep)

  override def hashCode(): Int = {
    var result = 31
    result = 37 * result + sql.hashCode()
    result
  }

  override def equals(obj: Any): Boolean = obj match {
    case x: JobDefinition => sql.equals(x.sql)
    case _ => false
  }
}
