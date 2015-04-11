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

package scala4impatient.chapter10

import java.io.{ BufferedInputStream, FileInputStream }

import org.scalatest.{ FlatSpec, Matchers }

trait Ch10Ex08_BufferedInputStreamTrait {
  this: FileInputStream =>

  val delegate: BufferedInputStream = new BufferedInputStream(this)

  override def read(b: Array[Byte]): Int = delegate.read(b)
}

class Ch10Ex08_BufferedInputStreamTraitSpec extends FlatSpec with Matchers {
  "file" should "be read with buffer" in {
    val buffered: Ch10Ex08_BufferedInputStreamTrait = new FileInputStream("src/test/resources/lorem-ipsum.txt") with Ch10Ex08_BufferedInputStreamTrait

    val bytes: Array[Byte] = new Array[Byte](1024)
    buffered.read(bytes)

    new String(bytes).startsWith("Lorem ipsum dolor sit amet") should be(right = true)
  }
}
