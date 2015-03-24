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

package scala4impatient.chapter08

import org.scalatest.{ FlatSpec, Matchers }

class Ch08Ex05_Point(val x: Double, val y: Double) {
  // NOP
}

class Ch08Ex05_LabeledPoint(val label: String, x: Double, y: Double)
    extends Ch08Ex05_Point(x, y) {
  // NOP
}

class Ch08Ex05_LabeledPointSpec extends FlatSpec with Matchers {
  "Black Thursday" should "be a labeled point" in {
    val point: Ch08Ex05_LabeledPoint = new Ch08Ex05_LabeledPoint("Black Thursday", 1929, 230.07)
    point.x should be(1929)
    point.y should be(230.07)
    point.label should be("Black Thursday")
  }
}
