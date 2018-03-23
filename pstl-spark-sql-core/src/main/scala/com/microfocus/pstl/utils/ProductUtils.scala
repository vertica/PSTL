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

package com.microfocus.pstl.utils

import java.lang.reflect.Field

object ProductUtils {
  def getParameters(product: Product): Map[String, Any] = {
    def extractField(field: Field, value: Any): (String, Any) = {
      val v = value match {
        case l: List[_] => l
        case s: Seq[_] => s
        case p: Product if p.productArity > 0 => getParameters(p)
        case x => x
      }

      field.getName -> v
    }

    val values = product.productIterator
    val fields = product.getClass.getDeclaredFields

    fields.map { field =>
      val value = values.next()
      extractField(field, value)
    }.toMap
  }
}
