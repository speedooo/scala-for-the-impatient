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

object Ch05Ex07_PersonWithName {
  def apply(name: String): Ch05Ex07_PersonWithName = {
    new Ch05Ex07_PersonWithName(name)
  }
}

class Ch05Ex07_PersonWithName(name: String) {
  val firstName: String = name.split("\\s+")(0)
  val lastName: String = name.split("\\s+")(1)
}

class Ch05Ex07_PersonWithNameSpec extends FlatSpec with Matchers {
  "'Ben Harper'" should "be named Ben Harper" in {
    val person: Ch05Ex07_PersonWithName = Ch05Ex07_PersonWithName("Ben Harper")
    person.firstName should be("Ben")
    person.lastName should be("Harper")
  }
}
