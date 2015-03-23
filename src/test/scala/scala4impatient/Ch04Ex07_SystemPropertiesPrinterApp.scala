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

import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection._

object Ch04Ex07_SystemPropertiesPrinterApp extends App {
  val props: Map[String, String] = System.getProperties
  var max: Int = 0
  // reduce style
  max = props
    .keys
    .reduceLeft((x, y) => if (x.length > y.length) x else y)
    .length
  // map style
  max = props
    .keys
    .map(_.length)
    .max
  props
    .toMap
    .transform((k, v) => Tuple3(k, v, max - k.length))
    .values
    .toList
    .foreach(t => println(s"${t._1}${" " * t._3} | ${t._2}"))
}
