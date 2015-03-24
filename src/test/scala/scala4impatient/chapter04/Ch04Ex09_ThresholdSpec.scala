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

package scala4impatient.chapter04

import org.scalatest.{ FlatSpec, Matchers }

import scala4impatient.chapter04.Ch04Ex09_Threshold._

object Ch04Ex09_Threshold {
  def lteqgt(values: Array[Int], threshold: Int): (Int, Int, Int) = {
    val lt: Int = values count {
      _ < threshold
    }
    val eq: Int = values count {
      _ == threshold
    }
    val gt: Int = values count {
      _ > threshold
    }
    (lt, eq, gt)
  }
}

class Ch04Ex09_ThresholdSpec extends FlatSpec with Matchers {
  "minmax(Array(), 42)" should "be (0, 0, 0)" in {
    val t: (Int, Int, Int) = lteqgt(Array(), 42)
    t should be((0, 0, 0))
  }

  "minmax(Array(32, 423, -312, 34), 42)" should "be (3, 0, 1)" in {
    val t: (Int, Int, Int) = lteqgt(Array(32, 423, -312, 34), 42)
    t should be((3, 0, 1))
  }
}
