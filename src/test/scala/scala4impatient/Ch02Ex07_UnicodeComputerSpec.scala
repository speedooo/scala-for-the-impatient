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

import scala4impatient.Ch02Ex07_UnicodeComputer.unicodeProductWithoutLoop
import org.scalatest.{ FlatSpec, Matchers }

object Ch02Ex07_UnicodeComputer {
  def unicodeProductWithoutLoop(s: String): Long = {
    var product: Long = 1
    s.foreach(product *= _)
    product
  }
}

class Ch02Ex07_UnicodeComputerSpec extends FlatSpec with Matchers {
  "unicode product without loop of 'Hello'" should "be 9415087488L" in {
    unicodeProductWithoutLoop("Hello") should be(9415087488L)
  }
}
