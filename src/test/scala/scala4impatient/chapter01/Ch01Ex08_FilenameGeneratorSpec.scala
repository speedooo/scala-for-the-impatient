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

package scala4impatient.chapter01

import java.lang.Math._

import org.scalatest.{ FlatSpec, Matchers }

import scala.util.Random
import scala4impatient.chapter01.Ch01Ex08_FilenameGenerator._

object Ch01Ex08_FilenameGenerator {
  def generateFilename: String = BigInt(abs(Random.nextLong())).toString(36)
}

class Ch01Ex08_FilenameGeneratorSpec extends FlatSpec with Matchers {
  "a valid filename" should "be generated using base 36" in {
    (generateFilename matches """[0-9a-zA-Z]+""") should be(right = true)
  }
}
