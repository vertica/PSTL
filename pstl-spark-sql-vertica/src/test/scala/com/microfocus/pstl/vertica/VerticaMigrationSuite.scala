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

import java.sql.Connection

import com.hubspot.jinjava.Jinjava
import org.scalacheck.Arbitrary
import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

trait VerticaMigrationSuite extends BeforeAndAfterAll with GeneratorDrivenPropertyChecks {
  this: FunSuite =>

  def connection: Connection

  private var _migrationContext: VerticaMigrationContext = _
  def migrationContext: VerticaMigrationContext = _migrationContext
  protected def templateEngine: Jinjava = new Jinjava()

  override def beforeAll(): Unit = {
    super.beforeAll()
    _migrationContext = VerticaMigrationContext(connection, templateEngine)
  }

  override def afterAll(): Unit = {
    super.afterAll()
  }

  protected def testUp[T <: VerticaMigration](migration: T)(f: T => Unit): Unit = {
    migration.up(migrationContext)
    f(migration)
    migration.down(migrationContext)
  }

  protected def testDown[T <: VerticaMigration](migration: T)(f: T => Unit): Unit = {
    migration.up(migrationContext)
    migration.down(migrationContext)
    f(migration)
  }
}
