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

package scala4impatient.chapter02

import org.scalatest.{ FlatSpec, Matchers }

import scala4impatient.chapter02.Ch02Ex10_PowComputer._

object Ch02Ex10_PowComputer {
  def pow(x: Double, n: Int): Double = {
    if (n > 0 && n % 2 == 0) pow(x, n / 2) * pow(x, n / 2)
    else if (n > 0) x * pow(x, n - 1)
    else if (n == 0) 1
    else 1 / pow(x, -n)
  }
}

class Ch02Ex10_PowComputerSpec extends FlatSpec with Matchers {
  "weird computation of 2^0" should "be 1" in {
    pow(2, 0) should be(1)
  }

  "weird computation of 2^2" should "be 4" in {
    pow(2, 2) should be(4)
  }

  "weird computation of 2^3" should "be 8" in {
    pow(2, 3) should be(8)
  }

  "weird computation of 2^-2" should "be .25" in {
    pow(2, -2) should be(.25)
  }
}
