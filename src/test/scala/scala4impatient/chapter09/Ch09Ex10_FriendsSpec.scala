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

package scala4impatient.chapter09

import java.io._

import org.scalatest.{ Matchers, FlatSpec }

import scala.collection.mutable.ArrayBuffer

object Ch09Ex10_Person {
  def apply(name: String): Ch09Ex10_Person = {
    new Ch09Ex10_Person(name)
  }
}

@SerialVersionUID(42L) class Ch09Ex10_Person(val name: String, val friends: ArrayBuffer[Ch09Ex10_Person] = new ArrayBuffer[Ch09Ex10_Person]()) extends Serializable {
  def canEqual(other: Any): Boolean = other.isInstanceOf[Ch09Ex10_Person]

  override def equals(other: Any): Boolean = other match {
    case that: Ch09Ex10_Person => (that canEqual this) && name == that.name && friends == that.friends
    case _                     => false
  }

  override def hashCode(): Int = {
    val state = Seq(name, friends)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class Ch09Ex10_FriendsSpec extends FlatSpec with Matchers {
  "person and friends" should "be serializable" in {
    // create persons
    val expectedBen: Ch09Ex10_Person = Ch09Ex10_Person("ben")
    val expectedJack: Ch09Ex10_Person = Ch09Ex10_Person("Jack")
    val expectedJimi: Ch09Ex10_Person = Ch09Ex10_Person("Jimi")
    val expectedAnouk: Ch09Ex10_Person = Ch09Ex10_Person("anouk")

    // make them buddies
    expectedBen.friends += expectedJack
    expectedBen.friends += expectedJimi
    expectedBen.friends += expectedAnouk
    expectedJack.friends += expectedJimi
    expectedJack.friends += expectedAnouk
    expectedJimi.friends += expectedAnouk

    // serialize leader
    val tempFileBen: File = File.createTempFile("scala4impatient", "Ch09Ex10")
    val out: ObjectOutputStream = new ObjectOutputStream(new FileOutputStream(tempFileBen))
    out.writeObject(expectedBen)
    out.close()

    // deserialize leader
    val in: ObjectInputStream = new ObjectInputStream(new FileInputStream(tempFileBen))
    val actualBen: Ch09Ex10_Person = in.readObject().asInstanceOf[Ch09Ex10_Person]

    // check relationships
    actualBen should be(expectedBen)
    actualBen.friends(0) should be(expectedJack)
    actualBen.friends(1) should be(expectedJimi)
    actualBen.friends(2) should be(expectedAnouk)
  }
}
