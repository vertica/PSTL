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

import org.antlr.v4.runtime.atn.PredictionMode
import org.antlr.v4.runtime.misc.ParseCancellationException
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream, IntStream}
import org.apache.spark.internal.Logging
import org.apache.spark.sql.AnalysisException
import org.apache.spark.sql.catalyst.expressions.Expression
import org.apache.spark.sql.catalyst.parser._
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.catalyst.trees.Origin
import org.apache.spark.sql.catalyst.{FunctionIdentifier, TableIdentifier}
import org.apache.spark.sql.types.{DataType, StructType}

abstract class AbstractSqlParser extends ParserInterface with Logging {
  override def parsePlan(sqlText: String): LogicalPlan = {
    try {
      delegate.parsePlan(sqlText)
    }
    catch {
      case _: ParseException =>
        parse(sqlText) { parser =>
          astBuilder.visitSingleStatement(parser.singleStatement())
        }
    }
  }

  // ==========================================================================
  // delegate most of the workload back down to spark
  // we only modify very specific parts of the sql dialect
  // if we don't have to touch it push it down
  // ==========================================================================

  override def parseExpression(sqlText: String): Expression = {
    delegate.parseExpression(sqlText)
  }

  override def parseTableIdentifier(sqlText: String): TableIdentifier = {
    delegate.parseTableIdentifier(sqlText)
  }

  override def parseFunctionIdentifier(sqlText: String): FunctionIdentifier = {
    delegate.parseFunctionIdentifier(sqlText)
  }

  override def parseTableSchema(sqlText: String): StructType = {
    delegate.parseTableSchema(sqlText)
  }

  override def parseDataType(sqlText: String): DataType = {
    delegate.parseDataType(sqlText)
  }

  // ==========================================================================
  // implementer must provide us an
  // * AstBuilder
  // * ParserInterface
  // ==========================================================================

  protected def astBuilder: AstBuilder
  protected def delegate: ParserInterface

  // ==========================================================================
  // ANTLR infrastructure setup so we can parse
  // nothing particularly interesting other than case insensitive parsing
  // we reuse a lot of spark code here
  // ==========================================================================

  protected def parse[T](command: String)(toResult: PstlSqlBaseParser => T): T = {
    val lexer = new PstlSqlBaseLexer(new ANTLRNoCaseStringStream(command))
    lexer.removeErrorListeners()
    lexer.addErrorListener(ParseErrorListener)

    val tokenStream = new CommonTokenStream(lexer)
    val parser = new PstlSqlBaseParser(tokenStream)
    parser.addParseListener(PostProcessor)
    parser.removeErrorListeners()
    parser.addErrorListener(ParseErrorListener)

    try {
      try {
        parser.getInterpreter.setPredictionMode(PredictionMode.SLL)
        toResult(parser)
      }
      catch {
        case e: ParseCancellationException =>
          tokenStream.reset()
          parser.reset()

          parser.getInterpreter.setPredictionMode(PredictionMode.LL)
          toResult(parser)
      }
    }
    catch {
      case e: ParseException if e.command.isDefined =>
        throw e

      case e: ParseException =>
        throw e.withCommand(command)

      case e: AnalysisException =>
        throw new ParseException(
          Option(command),
          e.message,
          Origin(e.line, e.startPosition),
          Origin(e.line, e.startPosition))
    }
  }
}

// spark keeps this private so we need to replicate it
private[parser] class ANTLRNoCaseStringStream(input: String) extends ANTLRInputStream(input) {
  override def LA(i: Int): Int = {
    val la = super.LA(i)
    if(la == 0 || la == IntStream.EOF) la
    else Character.toUpperCase(la)
  }
}
