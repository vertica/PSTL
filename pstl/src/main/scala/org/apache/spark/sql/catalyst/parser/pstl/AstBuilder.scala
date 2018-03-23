/*
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

import java.util.Locale
import java.util.concurrent.TimeUnit

import org.antlr.v4.runtime.tree.{ParseTree, RuleNode, TerminalNode}
import org.apache.spark.sql.catalyst.TableIdentifier
import org.apache.spark.sql.catalyst.parser._
import org.apache.spark.sql.catalyst.parser.pstl.PstlSqlBaseParser._
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.execution.datasources.{CreateStreamFromCommand, SaveStreamToCommand, ShowStreamsCommand, StopStreamCommand}
import org.apache.spark.sql.streaming.Trigger
import org.apache.spark.sql.types._

import scala.collection.JavaConverters._

class AstBuilder extends PstlSqlBaseBaseVisitor[AnyRef] {
  import ParserUtils._

  protected def typedVisit[T](ctx: ParseTree): T = {
    ctx.accept(this).asInstanceOf[T]
  }

  override def visitChildren(node: RuleNode): AnyRef = {
    if(node.getChildCount == 1) {
      node.getChild(0).accept(this)
    }
    else {
      null
    }
  }

  override def visitSingleStatement(ctx: SingleStatementContext): LogicalPlan = withOrigin(ctx) {
    visit(ctx.statement()).asInstanceOf[LogicalPlan]
  }

  override def visitCreateStreamFrom(ctx: CreateStreamFromContext): LogicalPlan = withOrigin(ctx) {
    CreateStreamFromCommand(
      tableIdent = visitTableIdentifier(ctx.tableIdentifier),
      userSpecifiedSchema = Option(ctx.colTypeList()).map(createSchema),
      provider = ctx.sourceProvider().qualifiedName().getText,
      options = Option(ctx.tablePropertyList).map(visitPropertyKeyValues).getOrElse(Map.empty))
  }

  override def visitSaveStreamTo(ctx: SaveStreamToContext): LogicalPlan = withOrigin(ctx) {
    SaveStreamToCommand(
      tableIdent = visitTableIdentifier(ctx.tableIdentifier),
      provider = ctx.sinkProvider().qualifiedName().getText,
      outputMode = Option(ctx.outputMode())
        .map(_.getText.toLowerCase(Locale.ROOT))
        .getOrElse("append"),
      trigger = Option(ctx.trigger()).map(visitTrigger).getOrElse(Trigger.ProcessingTime(0L)),
      partitionBy = Option(ctx.identifierList).map(visitIdentifierList).getOrElse(Seq.empty),
      queryName = Option(ctx.qualifiedName())
        .map(_.getText)
        .getOrElse(visitTableIdentifier(ctx.tableIdentifier()).table),
      options = Option(ctx.tablePropertyList).map(visitPropertyKeyValues).getOrElse(Map.empty))
  }

  override def visitStopStream(ctx: StopStreamContext): LogicalPlan = withOrigin(ctx) {
    StopStreamCommand(ctx.qualifiedName().getText)
  }

  override def visitShowStreams(ctx: ShowStreamsContext): LogicalPlan = withOrigin(ctx) {
    ShowStreamsCommand()
  }

  override def visitTrigger(ctx: TriggerContext): Trigger = withOrigin(ctx) {
    visit(ctx.triggerField()).asInstanceOf[Trigger]
  }

  override def visitTriggerOnce(ctx: TriggerOnceContext): Trigger = withOrigin(ctx) {
    Trigger.Once()
  }

  override def visitTriggerProcessingTime(ctx: TriggerProcessingTimeContext): Trigger =
    withOrigin(ctx) {
      val timeUnit = ctx.triggerUnit().getText.toUpperCase() match {
        case "MILLISECOND" | "MILLISECONDS" =>
          TimeUnit.MILLISECONDS

        case "SECOND" | "SECONDS" =>
          TimeUnit.SECONDS

        case "MINUTE" | "MINUTES" =>
          TimeUnit.MINUTES

        case "HOUR" | "HOURS" =>
          TimeUnit.HOURS

        case _ =>
          operationNotAllowed(
            s"unknown time unit: ${ctx.triggerUnit().getText}", ctx)
      }

      Trigger.ProcessingTime(ctx.triggerValue().getText.toLong, timeUnit)
    }

  override def visitIdentifierList(ctx: IdentifierListContext): Seq[String] = withOrigin(ctx) {
    visitIdentifierSeq(ctx.identifierSeq)
  }

  override def visitIdentifierSeq(ctx: IdentifierSeqContext): Seq[String] = withOrigin(ctx) {
    ctx.identifier.asScala.map(_.getText)
  }

  override def visitTableIdentifier(ctx: TableIdentifierContext): TableIdentifier =
    withOrigin(ctx) {
      TableIdentifier(ctx.table.getText, Option(ctx.db).map(_.getText))
    }

  override def visitColTypeList(ctx: ColTypeListContext): Seq[StructField] = withOrigin(ctx) {
    ctx.colType().asScala.map(visitColType)
  }

  override def visitColType(ctx: ColTypeContext): StructField = withOrigin(ctx) {
    import ctx._

    val builder = new MetadataBuilder

    // add comment to metadata
    if(STRING != null) {
      builder.putString("comment", string(STRING))
    }

    // add hive type string to metadata
    val rawDataType = typedVisit[DataType](ctx.dataType)
    val cleanedDataType = HiveStringType.replaceCharType(rawDataType)

    if(rawDataType != cleanedDataType) {
      builder.putString(HIVE_TYPE_STRING, rawDataType.catalogString)
    }

    StructField(
      name = identifier.getText,
      dataType = cleanedDataType,
      nullable = true,
      metadata = builder.build())
  }

  override def visitSingleDataType(ctx: SingleDataTypeContext): DataType = withOrigin(ctx) {
    visitSparkDataType(ctx.dataType())
  }

  private def visitSparkDataType(ctx: DataTypeContext): DataType = withOrigin(ctx) {
    HiveStringType.replaceCharType(typedVisit(ctx))
  }

  /**
   * Resolve/create a primitive type.
   */
  override def visitPrimitiveDataType(ctx: PrimitiveDataTypeContext): DataType = withOrigin(ctx) {
    val dataType = ctx.identifier.getText.toLowerCase(Locale.ROOT)
    (dataType, ctx.INTEGER_VALUE().asScala.toList) match {
      case ("boolean", Nil) => BooleanType
      case ("tinyint" | "byte", Nil) => ByteType
      case ("smallint" | "short", Nil) => ShortType
      case ("int" | "integer", Nil) => IntegerType
      case ("bigint" | "long", Nil) => LongType
      case ("float", Nil) => FloatType
      case ("double", Nil) => DoubleType
      case ("date", Nil) => DateType
      case ("timestamp", Nil) => TimestampType
      case ("string", Nil) => StringType
      case ("char", length :: Nil) => CharType(length.getText.toInt)
      case ("varchar", length :: Nil) => VarcharType(length.getText.toInt)
      case ("binary", Nil) => BinaryType
      case ("decimal", Nil) => DecimalType.USER_DEFAULT
      case ("decimal", precision :: Nil) => DecimalType(precision.getText.toInt, 0)
      case ("decimal", precision :: scale :: Nil) =>
        DecimalType(precision.getText.toInt, scale.getText.toInt)
      case (dt, params) =>
        val dtStr = if (params.nonEmpty) s"$dt(${params.mkString(",")})" else dt
        throw new ParseException(s"DataType $dtStr is not supported.", ctx)
    }
  }

  /**
   * Create a complex DataType. Arrays, Maps and Structures are supported.
   */
  override def visitComplexDataType(ctx: ComplexDataTypeContext): DataType = withOrigin(ctx) {
    ctx.complex.getType match {
      case SqlBaseParser.ARRAY =>
        ArrayType(typedVisit(ctx.dataType(0)))
      case SqlBaseParser.MAP =>
        MapType(typedVisit(ctx.dataType(0)), typedVisit(ctx.dataType(1)))
      case SqlBaseParser.STRUCT =>
        StructType(Option(ctx.complexColTypeList).toSeq.flatMap(visitComplexColTypeList))
    }
  }

  /**
   * Create a [[StructType]] from a number of column definitions.
   */
  override def visitComplexColTypeList(ctx: ComplexColTypeListContext): Seq[StructField] = withOrigin(ctx) {
    ctx.complexColType().asScala.map(visitComplexColType)
  }

  /**
   * Create a [[StructField]] from a column definition.
   */
  override def visitComplexColType(ctx: ComplexColTypeContext): StructField = withOrigin(ctx) {
    import ctx._
    val structField = StructField(identifier.getText, typedVisit(dataType), nullable = true)
    if (STRING == null) structField else structField.withComment(string(STRING))
  }

  override def visitTablePropertyList(ctx: TablePropertyListContext): Map[String, String] =
    withOrigin(ctx) {
      val properties = ctx.tableProperty.asScala.map { property =>
        val key = visitTablePropertyKey(property.key)
        val value = visitTablePropertyValue(property.value)

        key -> value
      }

      checkDuplicateKeys(properties, ctx)

      properties.toMap
    }

  override def visitTablePropertyKey(key: TablePropertyKeyContext): String = withOrigin(key) {
    if(key.STRING != null) {
      string(key.STRING)
    }
    else {
      key.getText
    }
  }

  override def visitTablePropertyValue(value: TablePropertyValueContext): String =
    withOrigin(value) {
      if(value == null) {
        null
      }
      else if(value.STRING != null) {
        string(value.STRING)
      }
      else if(value.booleanValue != null) {
        value.getText.toLowerCase(Locale.ROOT)
      }
      else {
        value.getText
      }
    }

  protected def createSchema(ctx: ColTypeListContext): StructType = withOrigin(ctx) {
    StructType(Option(ctx).toSeq.flatMap(visitColTypeList))
  }

  private def visitPropertyKeyValues(ctx: TablePropertyListContext): Map[String, String] =
    withOrigin(ctx) {
      val props = visitTablePropertyList(ctx)
      val badKeys = props.collect { case(key, null) => key }

      if(badKeys.nonEmpty) {
        operationNotAllowed(
          s"Values must be specified for key(s): ${badKeys.mkString("[", ",", "]")}", ctx)
      }

      props
    }

  private def string(node: TerminalNode): String = {
    unescapeSqlString(node.getText)
  }

  private def unescapeSqlString(b: String): String = {
    var enclosure: Character = null
    val sb = new StringBuilder(b.length())

    def appendEscapedChar(n: Char) {
      n match {
        case '0' => sb.append('\u0000')
        case '\'' => sb.append('\'')
        case '"' => sb.append('\"')
        case 'b' => sb.append('\b')
        case 'n' => sb.append('\n')
        case 'r' => sb.append('\r')
        case 't' => sb.append('\t')
        case 'Z' => sb.append('\u001A')
        case '\\' => sb.append('\\')
        // The following 2 lines are exactly what MySQL does TODO: why do we do this?
        case '%' => sb.append("\\%")
        case '_' => sb.append("\\_")
        case _ => sb.append(n)
      }
    }

    var i = 0
    val strLength = b.length
    while (i < strLength) {
      val currentChar = b.charAt(i)
      if (enclosure == null) {
        if (currentChar == '\'' || currentChar == '\"') {
          enclosure = currentChar
        }
      } else if (enclosure == currentChar) {
        enclosure = null
      } else if (currentChar == '\\') {

        if ((i + 6 < strLength) && b.charAt(i + 1) == 'u') {
          // \u0000 style character literals.

          val base = i + 2
          val code = (0 until 4).foldLeft(0) { (mid, j) =>
            val digit = Character.digit(b.charAt(j + base), 16)
            (mid << 4) + digit
          }
          sb.append(code.asInstanceOf[Char])
          i += 5
        } else if (i + 4 < strLength) {
          // \000 style character literals.

          val i1 = b.charAt(i + 1)
          val i2 = b.charAt(i + 2)
          val i3 = b.charAt(i + 3)

          if ((i1 >= '0' && i1 <= '1') && (i2 >= '0' && i2 <= '7') && (i3 >= '0' && i3 <= '7')) {
            val tmp = ((i3 - '0') + ((i2 - '0') << 3) + ((i1 - '0') << 6)).asInstanceOf[Char]
            sb.append(tmp)
            i += 3
          } else {
            appendEscapedChar(i1)
            i += 1
          }
        } else if (i + 2 < strLength) {
          // escaped character literals.
          val n = b.charAt(i + 1)
          appendEscapedChar(n)
          i += 1
        }
      } else {
        // non-escaped character literals.
        sb.append(currentChar)
      }
      i += 1
    }
    sb.toString()
  }
}
