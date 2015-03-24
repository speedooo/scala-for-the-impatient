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

import org.scalatest.{ FlatSpec, Matchers }

import scala4impatient.chapter03.Ch03Ex02_ArraySwapComputer._

object Ch03Ex02_ArraySwapComputer {
  def bubbleSwap(a: Array[Int]): Array[Int] = {
    for (i <- 0 to (if (a.length % 2 == 0) a.length - 2 else a.length - 3, 2)) {
      val tmp: Int = a(i)
      a(i) = a(i + 1)
      a(i + 1) = tmp
    }
    a
  }

  def functionalSwap(a: Array[Int]): Array[Int] = {
    a.grouped(2).flatMap {
      case Array(x, y) => Array(y, x)
      case Array(x)    => Array(x)
    }.toArray
  }
}

class Ch03Ex02_ArraySwapComputerSpec extends FlatSpec with Matchers {
  "bubble swapping elements of Array()" should "be Array()" in {
    val actual: Array[Int] = bubbleSwap(Array())
    val expected: Array[Int] = Array()
    actual.deep == expected.deep should be(right = true)
  }

  "bubble swapping elements of Array(1)" should "be Array(1)" in {
    val actual: Array[Int] = bubbleSwap(Array(1))
    val expected: Array[Int] = Array(1)
    actual.deep == expected.deep should be(right = true)
  }

  "bubble swapping elements of Array(1, 2, 3, 4)" should "be Array(2, 1, 4, 3)" in {
    val actual: Array[Int] = bubbleSwap(Array(1, 2, 3, 4))
    val expected: Array[Int] = Array(2, 1, 4, 3)
    actual.deep == expected.deep should be(right = true)
  }

  "bubble swapping elements of Array(1, 2, 3, 4, 5)" should "be Array(2, 1, 4, 3, 5)" in {
    val actual: Array[Int] = bubbleSwap(Array(1, 2, 3, 4, 5))
    val expected: Array[Int] = Array(2, 1, 4, 3, 5)
    actual.deep == expected.deep should be(right = true)
  }

  "functional swapping elements of Array(1, 2, 3, 4, 5)" should "be Array(2, 1, 4, 3, 5)" in {
    val actual: Array[Int] = functionalSwap(Array(1, 2, 3, 4, 5))
    val expected: Array[Int] = Array(2, 1, 4, 3, 5)
    actual.deep == expected.deep should be(right = true)
  }
}
