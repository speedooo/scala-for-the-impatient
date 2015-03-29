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

package scala4impatient.chapter09

import org.scalatest.{ FlatSpec, Matchers }

import scala4impatient.chapter09.Ch09Ex04_FloatingPointReader._
import scala4impatient.chapter09.util.UnsafeStringOps._

object Ch09Ex04_FloatingPointReader {
  def sum(filename: String): Float = {
    file2string(filename).split("""\s+""").map(_.toFloat).sum
  }

  def avg(filename: String): Float = {
    val values: Array[Float] = file2string(filename).split("""\s+""").map(_.toFloat)
    val (s, l) = values.foldLeft((0.0, 0))((t, f) => (t._1 + f, t._2 + 1))
    (s / l).toFloat
  }

  def min(filename: String): Float = {
    file2string(filename).split("""\s+""").map(_.toFloat).min
  }

  def max(filename: String): Float = {
    file2string(filename).split("""\s+""").map(_.toFloat).max
  }
}

class Ch09Ex04_FloatingPointReaderSpec extends FlatSpec with Matchers {
  "floating point values" should "be SUM" in {
    (sum("src/test/resources/floating-point-values.txt") - 56.38345).abs < 0.001 should be(right = true)
  }

  "floating point values" should "be AVG" in {
    (avg("src/test/resources/floating-point-values.txt") - 56.38345 / 5).abs < 0.001 should be(right = true)
  }

  "floating point values" should "be MIN" in {
    (min("src/test/resources/floating-point-values.txt") - 0.12345).abs < 0.001 should be(right = true)
  }

  "floating point values" should "be MAX" in {
    (max("src/test/resources/floating-point-values.txt") - 42).abs < 0.001 should be(right = true)
  }
}
