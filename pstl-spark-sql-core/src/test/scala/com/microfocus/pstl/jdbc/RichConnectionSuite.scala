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

package com.microfocus.pstl.jdbc

import java.sql.{Connection, DriverManager}

import com.microfocus.pstl.utils.CloseableUtils
import org.scalatest._

class RichConnectionSuite extends FunSuite
  with BeforeAndAfterAll
  with Matchers {

  private var connection: Connection = _

  override def beforeAll(): Unit = {
    connection = DriverManager.getConnection("jdbc:h2:mem:test")
  }

  override def afterAll(): Unit = {
    CloseableUtils.close(connection)
  }

  test("execute") {
    connection.execute("DROP TABLE IF EXISTS foo") shouldBe false
    connection.execute("SELECT 1 x") shouldBe true
  }

  test("execute prepared statement") {
    connection.execute("SELECT 1 x WHERE 1 = ?", _.setLong(1, 1)) shouldBe true
    connection.execute("SELECT 1 x WHERE 1 = ?", _.setLong(1, 2)) shouldBe true
  }

  test("query") {
    val rs = connection.query("SELECT 1 x") { rs =>
      rs.next() shouldBe true
      rs.getLong("x") shouldBe 1L
      rs.next() shouldBe false
    }
  }

  test("query prepared statement") {
    connection.query("SELECT 1 x WHERE 1 = ?", _.setLong(1, 1)) { rs =>
      rs.next() shouldBe true
      rs.getLong("x") shouldBe 1L
      rs.next() shouldBe false
    }
  }
}
