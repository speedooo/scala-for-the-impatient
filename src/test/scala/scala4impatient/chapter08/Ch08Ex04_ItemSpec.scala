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

import scala.collection._

abstract class Ch08Ex04_Item extends Ordered[Ch08Ex04_Item] {
  def price: Double

  def description: String

  override def compare(that: Ch08Ex04_Item): Int = description.compareTo(that.description)
}

object Ch08Ex04_SimpleItem {
  def apply(price: Double, description: String): Ch08Ex04_SimpleItem = {
    new Ch08Ex04_SimpleItem(price, description)
  }
}

class Ch08Ex04_SimpleItem(val price: Double, val description: String) extends Ch08Ex04_Item {
  // NOP
}

object Ch08Ex04_Bundle {
  def apply(): Ch08Ex04_Bundle = {
    new Ch08Ex04_Bundle()
  }
}

class Ch08Ex04_Bundle() extends Ch08Ex04_Item {
  private var items: SortedMap[String, Ch08Ex04_Item] = SortedMap[String, Ch08Ex04_Item]()

  override def price: Double = items.mapValues(_.price).values.sum

  override def description: String = items.keys.mkString(", ")

  def addItem(item: Ch08Ex04_Item): Unit = {
    items += item.description -> item
  }
}

class Ch08Ex04_ItemSpec extends FlatSpec with Matchers {
  "a bundle" should "sum prices and join descriptions" in {
    val bundle: Ch08Ex04_Bundle = Ch08Ex04_Bundle()
    bundle.addItem(Ch08Ex04_SimpleItem(39d, "book 1"))
    bundle.addItem(Ch08Ex04_SimpleItem(19d, "book 2"))

    bundle.price should be(39d + 19d)
    bundle.description should be("book 1, book 2")
  }
}
