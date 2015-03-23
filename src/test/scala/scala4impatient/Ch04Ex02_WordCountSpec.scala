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

import scala.collection._
import scala4impatient.Ch04Ex02_WordCount._
import scala.io.Source

object Ch04Ex02_WordCount {
  def wc(): Map[String, Int] = {
    val wc: mutable.Map[String, Int] = mutable.Map[String, Int]() withDefault (_ => 0)
    Source.fromFile("src/test/scala/scala4impatient/Ch04Ex02_WordCount.txt", "UTF-8")
      .mkString
      .toLowerCase
      .split("\\W+")
      .foreach(wc(_) += 1)
    wc
  }
}

class Ch04Ex02_WordCountSpec extends FlatSpec with Matchers {
  "word count" should "be as below" in {
    val count: Map[String, Int] = wc()
    count("fermentum") should be(41)
    count("tincidunt") should be(102)
    count("donec") should be(67)
  }
}
