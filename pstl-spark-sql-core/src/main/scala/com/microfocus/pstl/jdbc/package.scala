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

import java.sql.{Connection, PreparedStatement, ResultSet}

import scala.collection.generic.CanBuildFrom

import com.microfocus.pstl.utils.CloseableUtils

package object jdbc {
  implicit class RichConnection(connection: Connection) {
    def execute(sql: String): Boolean = {
      execute(sql, _ => ())
    }

    def execute(sql: String, config: PreparedStatement => Unit): Boolean = {
      withPreparedStatement(sql) { stmt =>
        config(stmt)
        stmt.execute()
      }
    }

    def query[T](sql: String,
                 preExecute: PreparedStatement => Unit = _ => (),
                 preDispose: PreparedStatement => Unit = _ => ())(handler: ResultSet => T): T = {
      withPreparedStatement(sql) { stmt =>
        preExecute(stmt)
        val rs = stmt.executeQuery()
        val r = handler(rs)
        preDispose(stmt)
        r
      }
    }

    private def withPreparedStatement[T](sql: String)(f: PreparedStatement => T): T = {
      val statement = connection.prepareStatement(sql)

      try {
        f(statement)
      }
      finally {
        CloseableUtils.close(statement)
      }
    }
  }

  implicit class RichResultSet(resultSet: ResultSet) {
    def foreach(f: ResultSet => Unit): Unit = {
      try {
        while(resultSet.next()) {
          f(resultSet)
        }
      }
      finally {
        CloseableUtils.close(resultSet)
      }
    }

    def map[T](f: ResultSet => T)(implicit bf: CanBuildFrom[Seq[T], T, Seq[T]]): Seq[T] = {
      val builder = bf()

      try {
        while(resultSet.next()) {
          builder += f(resultSet)
        }
      }
      finally {
        CloseableUtils.close(resultSet)
      }

      builder.result()
    }
  }
}
