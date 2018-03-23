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

object JobId {
  private[pstl] val nameRegex = """^[a-zA-Z][a-zA-Z0-9_]{2,127}$""".r
}

class JobId(name: String) {
  import JobId._

  private val _name: String = if(nameRegex.pattern.matcher(name).matches()) {
    name
  }
  else {
    throw new IllegalArgumentException(
      s"Provided name is not valid '$name', please choose a name which satisfies '$nameRegex'")
  }

  override def toString: String = _name

  override def hashCode(): Int = {
    var result = 31
    result = result * 37 + _name.hashCode
    result
  }

  override def equals(obj: Any): Boolean = obj match {
    case x: JobId => _name == x._name
    case _ => false
  }
}
