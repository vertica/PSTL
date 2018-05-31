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

//package org.apache.spark.sql.catalyst.expressions
//
//import org.apache.spark.SparkFunSuite
//import org.apache.spark.sql.types._
//
//class VerticaHashExprSuite extends SparkFunSuite with ExpressionEvalHelper {
//  test("vertica_hash(string)") {
//    checkEvaluation(VerticaHashExpr(Literal(null, StringType)), 1782799874601786468L)
//    checkEvaluation(VerticaHashExpr(Literal("abc")), 1193732203864995963L)
//  }
//
//  test("vertica_hash(int)") {
//    checkEvaluation(VerticaHashExpr(Literal(null, IntegerType)), 2640072791146048207L)
//    checkEvaluation(VerticaHashExpr(Literal(123)), 4953476069966620714L)
//  }
//}
