/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package scala4impatient

object Ch07Ex07_HashMapConverter {
  import java.util.{ HashMap => JavaHashMap }
  import scala.collection.JavaConversions.mapAsScalaMap
  import scala.collection.mutable.{ HashMap => ScalaHashMap }

  def toJavaHashMap(from: ScalaHashMap[String, String]): JavaHashMap[String, String] = {
    val to: JavaHashMap[String, String] = new JavaHashMap[String, String]()
    for ((k, v) <- from) to += (k -> v)
    to
  }

  def toScalaHashMap(from: JavaHashMap[String, String]): ScalaHashMap[String, String] = {
    val to: ScalaHashMap[String, String] = new ScalaHashMap[String, String]()
    for ((k, v) <- from) to += (k -> v)
    to
  }
}
