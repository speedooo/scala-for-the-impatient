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

import scala.io.Source
import scala4impatient.chapter09.Ch09Ex03_LongWordFinder._

object Ch09Ex03_LongWordFinder {
  def findLongWords(inputFilename: String, encoding: String = "UTF-8"): Int = {
    Source.fromFile(inputFilename)
      .mkString
      .split("[^a-zA-Z]+")
      .count(_.length > 11)
  }
}

class Ch09Ex03_LongWordFinderSpec extends FlatSpec with Matchers {
  "long words" should "should be found" in {
    // find [a-zA-Z]{12,} with a text editor
    findLongWords("src/test/resources/lorem-ipsum.txt") should be(126)
  }
}
