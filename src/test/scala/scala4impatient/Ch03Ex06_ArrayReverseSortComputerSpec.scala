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

import org.scalatest.{ FlatSpec, Matchers }

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting.quickSort
import scala4impatient.Ch03Ex06_ArrayReverseSortComputer._

object Ch03Ex06_ArrayReverseSortComputer {
  def reverseSortArrayBuffer(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    ArrayBuffer(reverseSortArray(a.toArray): _*)
  }

  def reverseSortArray(a: Array[Int]): Array[Int] = {
    val clone: Array[Int] = a.clone()
    quickSort(clone)
    ArrayBuffer(clone: _*).reverse.toArray
  }
}

class Ch03Ex06_ArrayReverseSortComputerSpec extends FlatSpec with Matchers {
  "reverse sorting elements of Array()" should "be Array()" in {
    val actual: ArrayBuffer[Int] = reverseSortArrayBuffer(ArrayBuffer())
    val expected: ArrayBuffer[Int] = ArrayBuffer()
    actual should be(expected)
  }

  "reverse sorting elements of Array(1)" should "be Array(1)" in {
    val actual: ArrayBuffer[Int] = reverseSortArrayBuffer(ArrayBuffer(1))
    val expected: ArrayBuffer[Int] = ArrayBuffer(1)
    actual should be(expected)
  }

  "reverse sorting elements of Array(1, -4, 3, -2)" should "be Array(3, 1, -2, -4)" in {
    val actual: ArrayBuffer[Int] = reverseSortArrayBuffer(ArrayBuffer(1, -4, 3, -2))
    val expected: ArrayBuffer[Int] = ArrayBuffer(3, 1, -2, -4)
    actual should be(expected)
  }

  "reverse sorting elements of Array(1, -4, 3, -2, 0)" should "be Array(3, 1, 0, -2, -4)" in {
    val actual: ArrayBuffer[Int] = reverseSortArrayBuffer(ArrayBuffer(1, -4, 3, -2, 0))
    val expected: ArrayBuffer[Int] = ArrayBuffer(3, 1, 0, -2, -4)
    actual should be(expected)
  }
}
