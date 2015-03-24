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

package scala4impatient.chapter05

import org.scalatest.{ FlatSpec, Matchers }

object Ch05Ex03_Time {
  def apply(hrs: Int, min: Int): Ch05Ex03_Time = {
    new Ch05Ex03_Time(hrs, min)
  }
}

class Ch05Ex03_Time() {
  private var _hrs: Int = 0
  private var _min: Int = 0

  def this(hrs: Int, min: Int) {
    this()
    if (hrs < 0 || hrs > 23 || min < 0 || min > 59) throw new IllegalArgumentException
    _hrs = hrs
    _min = min
  }

  def hrs: Int = _hrs

  def min: Int = _min

  def isBefore(other: Ch05Ex03_Time): Boolean = {
    if (_hrs != other.hrs) _hrs < other.hrs
    else _min < other.min
  }
}

class Ch05Ex03_TimeSpec extends FlatSpec with Matchers {
  "12:30" should "be before 12:45" in {
    Ch05Ex03_Time(12, 30).isBefore(Ch05Ex03_Time(12, 45)) should be(right = true)
  }
}
