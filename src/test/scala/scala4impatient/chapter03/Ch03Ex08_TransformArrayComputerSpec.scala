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

import scala.collection.mutable
import scala4impatient.chapter03.Ch03Ex08_TransformArrayComputer._

object Ch03Ex08_TransformArrayComputer {
  def transform(a: Array[Int]): Array[Int] = {
    val b: mutable.Buffer[Int] = a.toBuffer
    (for (i <- 0 until b.length if b(i) < 0) yield i)
      .reverse
      .dropRight(1)
      .foreach(b.remove)
    b.toArray
  }
}

class Ch03Ex08_TransformArrayComputerSpec extends FlatSpec with Matchers {
  "transformation of Array()" should "be Array()" in {
    val actual: Array[Int] = transform(Array())
    val expected: Array[Int] = Array()
    actual should be(expected)
  }

  "transformation of Array(1)" should "be Array(1)" in {
    val actual: Array[Int] = transform(Array(1))
    val expected: Array[Int] = Array(1)
    actual should be(expected)
  }

  "transformation of Array(1, 2, 3, 4, 5)" should "be Array(1, 2, 3, 4, 5)" in {
    val actual: Array[Int] = transform(Array(1, 2, 3, 4, 5))
    val expected: Array[Int] = Array(1, 2, 3, 4, 5)
    actual should be(expected)
  }

  "transformation of Array(1, -4, 1, -2, 3, -2)" should "be Array(1, -4, 1, 3)" in {
    // initial      - Array(1, -4, 1, -2, 3, -2)
    // yield        - Array(1, 3, 5)
    // reverse      - Array(5, 3, 1)
    // drop right   - Array(5, 3)
    // a(5) removed - Array(1, -4, 1, -2, 3)
    // a(3) removed - Array(1, -4, 1, 3)
    val actual: Array[Int] = transform(Array(1, -4, 1, -2, 3, -2))
    val expected: Array[Int] = Array(1, -4, 1, 3)
    actual should be(expected)
  }
}
