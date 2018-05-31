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
import org.apache.spark.sql.streaming.OutputMode
import org.scalacheck.{Arbitrary, Gen}
import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

// todo: validate columns
// todo: validate partition by
// todo: validate cascade

class CreateTableSuite extends FunSuite
  with GeneratorDrivenPropertyChecks
  with Matchers
  with ProvidesVerticaConnection
  with ConnectionFromEnvironmentVariables
  with VerticaMigrationSuite {

  private val createTableGen = for {
    schema <- Generators.schemaName
    table <- Generators.tableName
  } yield CreateTable(schema, table, "a int" :: Nil)

  implicit private val arbitraryCreateTable = Arbitrary(createTableGen)

  ignore("create table") {
    forAll() { (migration: CreateTable) =>
      testUp(migration) { _ =>
        val tables = connection.getMetaData
          .getTables(null, migration.schema, migration.table, null)
          .map(_.getString("TABLE_NAME"))

        tables should not be empty
        tables.length shouldBe 1
        tables.head shouldBe migration.table
      }
    }
  }

  ignore("drop table") {
    forAll(Generators.tableName) { (table: String) =>
      testUp(CreateTable("public", table, "a int" :: Nil)) { migration =>
        val tables = connection.getMetaData
          .getTables(null, migration.schema, migration.table, null)
          .map(_.getString("TABLE_NAME"))

        tables.length shouldBe 0
        tables.headOption shouldBe empty
      }
    }
  }
}
