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

import scala4impatient.Ch02Ex05_CountdownComputer._
import org.scalatest.{ FlatSpec, Matchers }

object Ch02Ex05_CountdownComputer {
  def countdown(n: Int): Int = {
    var sum: Int = 0
    for (i <- if (n > 0) (0 to n).reverse else n to 0) sum += i
    sum
  }
}

class Ch02Ex05_CountdownComputerSpec extends FlatSpec with Matchers {
  "count down of 10" should "be 55" in {
    countdown(10) should be(55)
  }

  "count down of 0" should "be 0" in {
    countdown(0) should be(0)
  }

  "count down of -10" should "be -55" in {
    countdown(-10) should be(-55)
  }
}
