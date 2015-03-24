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

import scala.Double.NaN
import scala4impatient.chapter03.Ch03Ex05_ArrayAverageComputer._

object Ch03Ex05_ArrayAverageComputer {
  def avg(a: Array[Int]): Double = {
    a.sum.toDouble / a.length
  }
}

class Ch03Ex05_ArrayAverageComputerSpec extends FlatSpec with Matchers {
  "signum swapping elements of Array()" should "be NaN" in {
    NaN.equals(avg(Array())) should be(right = true)
  }

  "signum swapping elements of Array(1)" should "be 1" in {
    val actual: Double = avg(Array(1))
    val expected: Double = 1
    actual should be(expected)
  }

  "signum swapping elements of Array(1, -4, 3, -2)" should "be -.5" in {
    val actual: Double = avg(Array(1, -4, 3, -2))
    val expected: Double = -.5
    actual should be(expected)
  }

  "signum swapping elements of Array(1, -4, 3, -2, 0)" should "be -.4" in {
    val actual: Double = avg(Array(1, -4, 3, -2, 0))
    val expected: Double = -.4
    actual should be(expected)
  }
}
