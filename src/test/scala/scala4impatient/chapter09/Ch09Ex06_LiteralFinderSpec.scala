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

import org.scalatest.{ FlatSpec, Matchers }

import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala4impatient.chapter09.Ch09Ex06_LiteralFinder._

object Ch09Ex06_LiteralFinder {
  /**
   * Credits: @hempalex
   * @param filename the name of the file to read
   * @return an array of literals
   */
  def findLiterals(filename: String): Array[String] = {
    val literals: ArrayBuffer[String] = ArrayBuffer[String]()

    Source
      .fromFile(filename, "UTF-8")
      .getLines()
      .foreach(
        """"([^"\\]*([\\]+"[^"\\]*)*)"""".r.findFirstIn(_) match {
          case Some(s: String) => literals += s
          case None            => // NOP
        })

    literals.toArray
  }
}

class Ch09Ex06_LiteralFinderSpec extends FlatSpec with Matchers {
  "literals" should "be found" in {
    val actual: Array[String] = findLiterals("src/test/resources/literals.txt")
    val expected: Array[String] = Array(""""test2"""", """"test\" 5"""", """"test \\" 8"""")
    actual.deep == expected.deep should be(right = true)
  }
}
