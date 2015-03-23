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

import scala4impatient.Ch02Ex01_SignumComputer._
import org.scalatest.{ FlatSpec, Matchers }

object Ch02Ex01_SignumComputer {
  def signum(number: Double): Int = if (number > 0) 1 else if (number < 0) -1 else 0
}

class Ch02Ex01_SignumComputerSpec extends FlatSpec with Matchers {
  "signum of -42" should "be -1" in {
    signum(-42) should be(-1)
  }

  "signum of 42" should "be 1" in {
    signum(42) should be(1)
  }

  "signum of 0" should "be 0" in {
    signum(0) should be(0)
  }
}
