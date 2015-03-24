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

import scala4impatient.chapter02.Ch02Ex09_UnicodeComputer._

object Ch02Ex09_UnicodeComputer {
  def product(s: String): Long = {
    if (s.length == 0) 0
    else if (s.length == 1) s(0).toInt
    else s.take(1)(0).toInt * product(s.drop(1))
  }
}

class Ch02Ex09_UnicodeComputerSpec extends FlatSpec with Matchers {
  "unicode product with recursion of 'Hello'" should "be 9415087488L" in {
    product("Hello") should be(9415087488L)
  }
}
