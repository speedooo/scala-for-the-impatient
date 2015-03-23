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

import scala4impatient.Ch04Ex08_MinMax._

object Ch04Ex08_MinMax {
  def minmax(values: Array[Int]): (Int, Int) = {
    (values.min, values.max)
  }
}

class Ch04Ex08_MinMaxSpec extends FlatSpec with Matchers {
  "minmax(Array())" should "throw an UnsupportedOperationException" in {
    an[java.lang.UnsupportedOperationException] shouldBe thrownBy(minmax(Array()))
  }

  "minmax(Array(32, 423, -312, 34))" should "be (-312, 423)" in {
    val t: (Int, Int) = minmax(Array(32, 423, -312, 34))
    t should be((-312, 423))
  }
}
