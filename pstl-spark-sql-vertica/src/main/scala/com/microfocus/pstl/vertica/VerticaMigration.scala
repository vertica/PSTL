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

package com.microfocus.pstl.vertica

import java.nio.charset.Charset
import java.util
import java.util.Locale

import scala.collection.JavaConverters._
import com.google.common.io.Resources
import com.hubspot.jinjava.Jinjava
import com.microfocus.pstl.jdbc._
import com.microfocus.pstl.utils.ProductUtils
import org.apache.commons.lang3.StringUtils


trait VerticaMigration {
  this: Product =>

  def down(context: VerticaMigrationContext): Boolean = {
    val sql = renderTemplate(
      downTemplateResource, downTemplateParameters, context.templateEngine)

    context.connection.execute(sql)
    true
  }

  def up(context: VerticaMigrationContext): Boolean = {
    val sql = renderTemplate(
      upTemplateResource, upTemplateParameters, context.templateEngine)

    context.connection.execute(sql)
    true
  }

  protected def downTemplateParameters: util.Map[String, Object] = productParameters()
  protected def downTemplateResource: String = templateForClassName("down.sql")

  protected def upTemplateParameters: util.Map[String, Object] = productParameters()
  protected def upTemplateResource: String = templateForClassName("up.sql")

  protected def renderTemplate(resourceFile: String,
                               parameters: util.Map[String, Object],
                               templateEngine: Jinjava): String = {
    val resource = Resources.getResource(resourceFile)
    val template = Resources.toString(resource, Charset.forName("UTF-8"))
    templateEngine.render(template, parameters)
  }

  private def productParameters(): util.Map[String, Object] = {
    ProductUtils.getParameters(this)
      .mapValues(jinjaValue)
      .asJava
  }

  private def jinjaValue(v: Any): Object = v match {
    case None => null
    case seq: Seq[_] => seq.asJava
    case _ => v.asInstanceOf[AnyRef]
  }

  private def templateForClassName(suffix: String): String = {
    val className = getClass.getSimpleName
    val segments = StringUtils.splitByCharacterTypeCamelCase(className)
      .map(_.toLowerCase(Locale.ROOT))
    (segments :+ suffix).mkString("_")
  }
}
