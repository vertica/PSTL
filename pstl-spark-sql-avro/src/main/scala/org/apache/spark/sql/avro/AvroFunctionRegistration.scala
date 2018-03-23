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

package org.apache.spark.sql.avro

import org.apache.spark.sql.catalyst.analysis.{FunctionRegistration, FunctionRegistryPrivateMethods}
import org.apache.spark.sql.catalyst.analysis.FunctionRegistry.FunctionBuilder
import org.apache.spark.sql.catalyst.expressions.{ExpressionInfo, FromAvroExpr, ToAvroExpr}

class AvroFunctionRegistration extends FunctionRegistration {
  import FunctionRegistryPrivateMethods._

  override def functions(): Seq[(String, (ExpressionInfo, FunctionBuilder))] = Seq(
    expression[FromAvroExpr]("from_avro"),
    expression[ToAvroExpr]("to_avro")
  )
}
