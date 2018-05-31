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

package com.microfocus.pstl.spark

import java.util.ServiceLoader

import scala.collection.JavaConverters._

import akka.actor.{ExtendedActorSystem, Extension, ExtensionId, ExtensionIdProvider}

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.analysis.FunctionRegistration
import org.apache.spark.sql.catalyst.FunctionIdentifier

object SparkExtension extends ExtensionId[SparkExtension] with ExtensionIdProvider {
  override def createExtension(system: ExtendedActorSystem): SparkExtension = {
    new SparkExtension(system)
  }

  override def lookup(): ExtensionId[_ <: Extension] = SparkExtension
}

class SparkExtension(system: ExtendedActorSystem) extends Extension {
  private val spark: SparkSession = {
    SparkSession.builder().getOrCreate()
  }

  /**
   * Provides access to files hosted on spark's file server, namely those files which were added
   * to the --files arg on spark-submit, etc. We leverage the file manager to get at job
   * definitions uploaded to shared storage during the spark-submit stage.
   */
  lazy val fileManager: SparkFileManager = new SparkFileManager(spark)

  def withSession[T](f: SparkSession => T): T = {
    val child = spark.newSession()

    functionRegistrations.foreach { registration =>
      val functions = registration.functions()

      functions.foreach { function =>
        child.sessionState.functionRegistry.registerFunction(
          FunctionIdentifier(function._1),
          function._2._1,
          function._2._2
        )
      }
    }

    f(child)
  }

  def functionRegistrations: Seq[FunctionRegistration] = {
    val serviceLoader = ServiceLoader.load(classOf[FunctionRegistration])
    serviceLoader.iterator().asScala.toSeq
  }
}
