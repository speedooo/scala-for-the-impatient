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

import java.io.FileInputStream
import java.util.Date

import org.scalatest.{ Matchers, FlatSpec }

trait Ch10Ex09_LoggerTrait {
  def log(msg: String): Unit
}

trait Ch10Ex09_ConsoleLoggerTrait extends Ch10Ex09_LoggerTrait {
  override def log(msg: String): Unit = println(msg)
}

trait Ch10Ex09_TimestampLoggerTrait extends Ch10Ex09_LoggerTrait {
  abstract override def log(msg: String): Unit = super.log(s"${new Date()} $msg")
}

trait Ch10Ex09_ShortLoggerTrait extends Ch10Ex09_LoggerTrait {
  val maxLength: Int = 15

  abstract override def log(msg: String): Unit = super.log(s"${msg.substring(0, maxLength)}")
}

class Ch10Ex09_BufferedInputStreamWithLoggerTrait extends FlatSpec with Matchers {
  "file" should "be read with logged buffer" in {
    val filename: String = "src/test/resources/lorem-ipsum.txt"

    // format: OFF
    val buffered: Ch10Ex08_BufferedInputStreamTrait = new FileInputStream(filename)
      with Ch10Ex08_BufferedInputStreamTrait
      with Ch10Ex09_ConsoleLoggerTrait
      with Ch10Ex09_TimestampLoggerTrait
      with Ch10Ex09_ShortLoggerTrait {
        override def read(b: Array[Byte]): Int = {
          val size: Int = super.read(b)
          super.log(s"${b.length} bytes read!")
          size
        }
      }
    // format: ON

    val bytes: Array[Byte] = new Array[Byte](1024)
    buffered.read(bytes)

    val expectation: Boolean = new Predef.String(bytes)
      .toLowerCase
      .startsWith("lorem ipsum dolor sit amet")

    expectation should be(right = true)
  }
}
