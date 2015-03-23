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

import org.scalatest.{ Matchers, FlatSpec }

import scala.beans.BeanProperty

object Ch05Ex05_Student {
  def apply(id: Long, name: String): Ch05Ex05_Student = {
    new Ch05Ex05_Student(id, name)
  }
}

class Ch05Ex05_Student(@BeanProperty var id: Long = 0, @BeanProperty var name: String = "") {
  // NOP
}

class Ch05Ex05_StudentSpec extends FlatSpec with Matchers {
  "generated bean property accessors" should "be callable" in {
    val ben: Ch05Ex05_Student = Ch05Ex05_Student(42, "Ben Harper")
    ben.getId should be(42)
    ben.getName should be("Ben Harper")
  }
}
