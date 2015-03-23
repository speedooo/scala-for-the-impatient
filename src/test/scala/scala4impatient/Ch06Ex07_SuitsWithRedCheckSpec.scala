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

object Ch06Ex07_SuitsWithRedCheck extends Enumeration {
  type Ch06Ex07_SuitsWithRedCheck = Value
  val HEART = Value("♥")
  val DIAMOND = Value("♦")
  val CLOVER = Value("♣")
  val SPADE = Value("♠")

  def isRed(suits: Ch06Ex07_SuitsWithRedCheck): Boolean = HEART == suits || DIAMOND == suits
}

class Ch06Ex07_SuitsWithRedCheckSpec extends FlatSpec with Matchers {
  "heart and diamond only" should "be red" in {
    Ch06Ex07_SuitsWithRedCheck.isRed(Ch06Ex07_SuitsWithRedCheck.HEART) should be(right = true)
    Ch06Ex07_SuitsWithRedCheck.isRed(Ch06Ex07_SuitsWithRedCheck.DIAMOND) should be(right = true)
    Ch06Ex07_SuitsWithRedCheck.isRed(Ch06Ex07_SuitsWithRedCheck.CLOVER) should be(right = false)
    Ch06Ex07_SuitsWithRedCheck.isRed(Ch06Ex07_SuitsWithRedCheck.SPADE) should be(right = false)
  }
}
