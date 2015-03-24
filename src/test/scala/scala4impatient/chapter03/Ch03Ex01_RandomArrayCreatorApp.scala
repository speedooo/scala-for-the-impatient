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

package scala4impatient.chapter03

import scala.util.Random

object Ch03Ex01_RandomArrayCreatorApp extends App {
  printArray(createRandomArrayWithoutYield(10))
  printArray(createRandomArrayWithYield(10))

  def createRandomArrayWithoutYield(n: Int): Array[Int] = {
    val a: Array[Int] = new Array[Int](n)
    var i: Int = 0
    while (i < a.length) {
      a(i) = Random.nextInt(n)
      i += 1
    }
    a
  }

  def createRandomArrayWithYield(n: Int): Array[Int] = {
    (for (i <- 0 until n) yield Random.nextInt(n)).toArray
  }

  def printArray(a: Array[Int]): Unit = {
    a foreach (println(_))
  }
}
