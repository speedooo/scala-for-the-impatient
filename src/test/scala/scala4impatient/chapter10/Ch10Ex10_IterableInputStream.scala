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

import java.io.{FileInputStream, InputStream}

import org.scalatest.{FlatSpec, Matchers}

// @BasileDuPlessis - delegation pattern credits

class Ch10Ex10_IterableInputStream(val delegate: InputStream) extends InputStream with Iterable[Byte] {
  override def iterator: Iterator[Byte] = new Iterator[Byte] {
    override def hasNext: Boolean = delegate.available() > 0

    // no delegation
    override def next(): Byte = read().toByte
  }

  override def read(): Int = delegate.read()
}

class Ch10Ex10_IterableInputStreamSpec extends FlatSpec with Matchers {
  "input stream" should "be iterable" in {
    val filename: String = "src/test/resources/lorem-ipsum.txt"

    val i: Iterator[Byte] = new Ch10Ex10_IterableInputStream(new FileInputStream(filename)).iterator

    i.hasNext should be(right = true)
    i.next().toChar should be('L')
    i.hasNext should be(right = true)
  }
}
