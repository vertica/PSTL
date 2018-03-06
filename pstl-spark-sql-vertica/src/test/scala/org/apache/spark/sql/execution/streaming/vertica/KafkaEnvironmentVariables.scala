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


package org.apache.spark.sql.execution.streaming.vertica

trait KafkaEnvironmentVariables {
  this: KafkaKit =>
  private def kafkaHost: String = sys.env.getOrElse("KAFKA_HOST", "17.147.76.224")
  private def kafkaPort: Int = sys.env.get("KAFKA_PORT").map(_.toInt).getOrElse(9092)
  override def kafkaBootstrapServers: String = s"$kafkaHost:$kafkaPort"
}
