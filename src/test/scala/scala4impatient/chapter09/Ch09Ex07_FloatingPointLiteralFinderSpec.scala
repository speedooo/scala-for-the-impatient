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
import scala4impatient.chapter09.Ch09Ex07_FloatingPointLiteralFinder._
import scala4impatient.chapter09.util.UnsafeStringOps
import scala4impatient.chapter09.util.UnsafeStringOps._

object Ch09Ex07_FloatingPointLiteralFinder {
  /**
   * Credits: @hempalex
   * @param filename the name of the file to read
   * @return an array of floating-point literals
   */
  def findFloatingPointLiterals(filename: String): Array[String] = {
    file2string(filename)
      .split("""\s+""")
      .filter("^[0-9]+(\\.[0-9]+)?$".r.findFirstIn(_) match {
        case Some(s: String) => false
        case None            => true
      })
  }
}

class Ch09Ex07_FloatingPointLiteralFinderSpec extends FlatSpec with Matchers {
  "literals" should "be found" in {
    val actual: Array[String] = findFloatingPointLiterals("src/test/resources/Ch09Ex07_FloatingPointLiteralFinderSpec.txt")
    val expected: Array[String] = Array(
      "azerty1",
      "azerty2",
      "azerty3",
      "azerty4",
      "azerty5",
      """"azerty6"""",
      "3.",
      ".33"
    )
    actual.deep == expected.deep should be(right = true)
  }
}
