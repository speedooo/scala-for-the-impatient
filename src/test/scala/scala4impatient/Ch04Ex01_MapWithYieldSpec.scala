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

import scala.util.Random
import scala4impatient.Ch04Ex01_MapWithYield._

object Ch04Ex01_MapWithYield {
  // just a tiny reminder
  def random(): Map[String, Double] = {
    ((for (i <- 0 until 100) yield Random.nextString(i)) map (e => e -> Random.nextDouble())).toMap
  }

  def discount(): Map[String, Double] = {
    val wishlist: Map[String, Double] = Map(
      "TC Electronic Ditto" -> 98.0,
      "TC Electronic PolyTune 2 Mini" -> 79.0
    )
    for ((k, v) <- wishlist) yield k -> truncateAt(0.9 * v, 2)
  }

  def truncateAt(n: Double, p: Int): Double = {
    val s: Double = math.pow(10, p)
    math.floor(n * s) / s
  }
}

class Ch04Ex01_MapWithYieldSpec extends FlatSpec with Matchers {
  "wishlist with discount" should "be as below" in {
    val actual: Map[String, Double] = discount()
    val expected: Map[String, Double] = Map(
      "TC Electronic Ditto" -> 88.20,
      "TC Electronic PolyTune 2 Mini" -> 71.10
    )
    actual should be(expected)
  }
}
