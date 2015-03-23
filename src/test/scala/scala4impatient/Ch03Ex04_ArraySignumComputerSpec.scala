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

import scala.collection.mutable.ArrayBuffer
import scala4impatient.Ch03Ex04_ArraySignumComputer._
import org.scalatest.{ FlatSpec, Matchers }

object Ch03Ex04_ArraySignumComputer {
  def signumSwap(a: Array[Int]): Array[Int] = {
    var positives: ArrayBuffer[Int] = ArrayBuffer()
    var negatives: ArrayBuffer[Int] = ArrayBuffer()
    for (e <- a) {
      if (e > 0) positives += e
      else negatives += e
    }
    (positives ++= negatives).toArray
  }

  def signumSwapWithYield(a: Array[Int]): Array[Int] = {
    Array.concat(
      for (e <- a if e > 0) yield e,
      for (e <- a if e <= 0) yield e
    )
  }
}

class Ch03Ex04_ArraySignumComputerSpec extends FlatSpec with Matchers {
  "signum swapping elements of Array()" should "be Array()" in {
    val actual: Array[Int] = signumSwap(Array())
    val expected: Array[Int] = Array()
    actual.deep == expected.deep should be(right = true)
  }

  "signum swapping elements of Array(1)" should "be Array(1)" in {
    val actual: Array[Int] = signumSwap(Array(1))
    val expected: Array[Int] = Array(1)
    actual.deep == expected.deep should be(right = true)
  }

  "signum swapping elements of Array(1, -4, 3, -2)" should "be Array(1, 3, -4, -2)" in {
    val actual: Array[Int] = signumSwap(Array(1, -4, 3, -2))
    val expected: Array[Int] = Array(1, 3, -4, -2)
    actual.deep == expected.deep should be(right = true)
  }

  "signum swapping elements of Array(1, -4, 3, -2, 0)" should "be Array(1, 3, -4, -2, 0)" in {
    val actual: Array[Int] = signumSwap(Array(1, -4, 3, -2, 0))
    val expected: Array[Int] = Array(1, 3, -4, -2, 0)
    actual.deep == expected.deep should be(right = true)
  }

  "signum swapping with yield elements of Array()" should "be Array()" in {
    val actual: Array[Int] = signumSwapWithYield(Array())
    val expected: Array[Int] = Array()
    actual.deep == expected.deep should be(right = true)
  }

  "signum swapping with yield elements of Array(1)" should "be Array(1)" in {
    val actual: Array[Int] = signumSwapWithYield(Array(1))
    val expected: Array[Int] = Array(1)
    actual.deep == expected.deep should be(right = true)
  }

  "signum swapping with yield elements of Array(1, -4, 3, -2)" should "be Array(1, 3, -4, -2)" in {
    val actual: Array[Int] = signumSwapWithYield(Array(1, -4, 3, -2))
    val expected: Array[Int] = Array(1, 3, -4, -2)
    actual.deep == expected.deep should be(right = true)
  }

  "signum swapping with yield elements of Array(1, -4, 3, -2, 0)" should "be Array(1, 3, -4, -2, 0)" in {
    val actual: Array[Int] = signumSwapWithYield(Array(1, -4, 3, -2, 0))
    val expected: Array[Int] = Array(1, 3, -4, -2, 0)
    actual.deep == expected.deep should be(right = true)
  }
}
