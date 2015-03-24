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

object Ch05Ex01_PositiveCounter {
  def apply(count: Int): Ch05Ex01_PositiveCounter = {
    new Ch05Ex01_PositiveCounter(count)
  }
}

class Ch05Ex01_PositiveCounter() {
  private var _count: Int = 0

  def this(count: Int) {
    this()
    _count = count
  }

  def count: Int = _count

  def increment(): Ch05Ex01_PositiveCounter = {
    if (_count < Int.MaxValue) _count += 1
    this
  }
}

class Ch05Ex01_PositiveCounterSpec extends FlatSpec with Matchers {
  "positive counter" should "not overflow" in {
    Ch05Ex01_PositiveCounter(Int.MaxValue).increment().count should be(Int.MaxValue)
  }
}
