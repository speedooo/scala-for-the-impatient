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

import java.util.Calendar._

import org.scalatest.{ FlatSpec, Matchers }

import scala.collection._
import scala4impatient.chapter04.Ch04Ex06_WeekdaysInLinkedHashMap._

object Ch04Ex06_WeekdaysInLinkedHashMap {
  def weekdays(): Map[String, Int] = {
    mutable.LinkedHashMap[String, Int](
      "MONDAY" -> MONDAY,
      "TUESDAY" -> TUESDAY,
      "WEDNESDAY" -> WEDNESDAY,
      "THURSDAY" -> THURSDAY,
      "FRIDAY" -> FRIDAY,
      "SATURDAY" -> SATURDAY,
      "SUNDAY" -> SUNDAY
    )
  }
}

class Ch04Ex06_WeekdaysInLinkedHashMapSpec extends FlatSpec with Matchers {
  "insertion order with a linked hash map" should "be preserved" in {
    val i: scala.Iterator[String] = weekdays().keysIterator
    i.next() should be("MONDAY")
    i.next() should be("TUESDAY")
    i.next() should be("WEDNESDAY")
    i.next() should be("THURSDAY")
    i.next() should be("FRIDAY")
    i.next() should be("SATURDAY")
    i.next() should be("SUNDAY")
  }
}
