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

import org.scalatest.{ FlatSpec, Matchers }

package object random {
  var seed: Int = 0
  var a: Int = 1664525
  var b: Int = 1013904223
  var n: Int = 32

  def nextInt(): Int = {
    seed = ((seed * a + b) % math.pow(2, 32)).toInt
    seed
  }

  def nextDouble(): Double = 1 / nextInt()

  def setSeed(value: Int): Unit = {
    seed = value
  }
}

class Ch07Ex03_Random extends FlatSpec with Matchers {
  "random integer with 0 as seed" should "be 1013904223" in {
    import random._
    nextInt() should be(1013904223)
  }

  "random double with 0 as seed" should "be 0" in {
    import random._
    nextDouble() should be(.0)
  }

  "random integer with 42 as seed" should "be 1083814273" in {
    import random._
    setSeed(42)
    nextInt() should be(1083814273)
  }

  "random double with 42 as seed" should "be 0" in {
    import random._
    setSeed(42)
    nextDouble() should be(.0)
  }
}
