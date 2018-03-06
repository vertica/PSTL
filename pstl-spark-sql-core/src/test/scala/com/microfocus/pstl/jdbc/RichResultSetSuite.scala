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

class RichResultSetSuite extends FunSuite
  with BeforeAndAfterAll
  with Matchers {

  private var connection: Connection = _

  override def beforeAll(): Unit = {
    connection = DriverManager.getConnection("jdbc:h2:mem:test")
  }

  override def afterAll(): Unit = {
    CloseableUtils.close(connection)
  }

  test("foreach") {
    val stmt = connection.prepareStatement("SELECT 1 x")

    var i = 0L
    var sum = 0L

    val rs = stmt.executeQuery()

    rs.isBeforeFirst shouldBe true
    rs.isAfterLast shouldBe false

    rs.foreach { row =>
      row.isBeforeFirst shouldBe false
      row.isAfterLast shouldBe false
      i += 1
      sum += rs.getLong("x")
    }

    rs.isClosed shouldBe true

    i shouldBe 1L
    sum shouldBe 1L
  }

  test("foreach closes result set on user error") {
    val stmt = connection.prepareStatement("SELECT 1 x")
    val rs = stmt.executeQuery()

    intercept[RuntimeException](rs.foreach(_ => throw new RuntimeException()))

    rs.isClosed shouldBe true
  }

  test("map") {
    val stmt = connection.prepareStatement("SELECT 1 x")

    val data = stmt.executeQuery().map { rs =>
      rs.getLong("x")
    }

    data shouldBe Seq(1L)
  }

  test("map closes result set on user error") {
    val stmt = connection.prepareStatement("SELECT 1 x")
    val rs = stmt.executeQuery()

    intercept[RuntimeException](rs.map(_ => throw new RuntimeException()))

    rs.isClosed shouldBe true
  }
}
