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

object Ch05Ex06_Person {
  def apply(age: Int): Ch05Ex06_Person = {
    new Ch05Ex06_Person(age)
  }
}

class Ch05Ex06_Person {
  private var _age: Int = 0

  def this(age: Int) {
    this()
    if (age < 0) _age = 0 else _age = age
  }

  def age: Int = _age
}

class Ch05Ex06_PersonSpec extends FlatSpec with Matchers {
  "a person built with 42 yo" should "be 42 yo" in {
    Ch05Ex06_Person(42).age should be(42)
  }

  "a person built with a negative age" should "be 0 yo" in {
    Ch05Ex06_Person(-42).age should be(0)
  }
}
