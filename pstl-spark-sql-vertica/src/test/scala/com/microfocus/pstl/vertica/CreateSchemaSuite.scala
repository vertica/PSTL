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

import com.microfocus.pstl.jdbc._
import org.scalacheck.Gen
import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class CreateSchemaSuite extends FunSuite
  with GeneratorDrivenPropertyChecks
  with Matchers
  with ProvidesVerticaConnection
  with ConnectionFromEnvironmentVariables
  with VerticaMigrationSuite {

  private val schemaGen = (for {
    prefix <- Gen.alphaChar
    suffix <- Gen.alphaStr
  } yield prefix + suffix).suchThat(_.trim.length > 0)

  ignore("create schema") {
    forAll(schemaGen) { (schema: String) =>
      testUp(CreateSchema(schema)) { migration =>
        val schemas = connection.getMetaData.getSchemas(null, migration.schema)
          .map(_.getString("TABLE_SCHEM"))

        schemas.headOption should not be empty
        schemas.length shouldBe 1
        schemas.head shouldBe migration.schema
      }
    }
  }

  ignore("drop schema") {
    forAll(schemaGen) { (schema: String) =>
      testDown(CreateSchema(schema)) { migration =>
        val schemas = connection.getMetaData.getSchemas(null, migration.schema)
          .map(_.getString("TABLE_SCHEM"))

        schemas.length shouldBe 0
        schemas.headOption shouldBe empty
      }
    }
  }
}
