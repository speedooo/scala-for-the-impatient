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

import org.scalatest.{ FlatSpec, Matchers }

import scala.collection._
import scala.io.Source
import scala4impatient.chapter04.Ch04Ex04_WordCountWithSortedMap._

object Ch04Ex04_WordCountWithSortedMap {
  def wc(): Map[String, Int] = {
    var wc: immutable.Map[String, Int] = immutable.SortedMap[String, Int]()
    Source.fromFile("src/test/resources/lorem-ipsum.txt", "UTF-8")
      .mkString
      .toLowerCase
      .split("\\W+")
      .foreach(e => wc = wc + (e -> (wc.getOrElse(e, 0) + 1)))
    wc
  }
}

class Ch04Ex04_WordCountWithSortedMapSpec extends FlatSpec with Matchers {
  "word count with sorted map" should "be as below" in {
    val count: Map[String, Int] = wc()
    count("fermentum") should be(41)
    count("tincidunt") should be(102)
    count("donec") should be(67)
  }
}
