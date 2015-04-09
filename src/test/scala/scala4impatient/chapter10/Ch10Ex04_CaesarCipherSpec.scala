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

import org.scalatest.{ FlatSpec, Matchers }

trait Ch10Ex04_Cipher {
  val key: Int = 3

  def encrypt(s: String): String
  def decrypt(s: String): String
}

class Ch10Ex04_CaesarCipher extends Ch10Ex04_Cipher {
  def encrypt(s: String): String = s map (c => caesar(c, key))
  def decrypt(s: String): String = s map (c => caesar(c, 26 - key))

  private def caesar(c: Char, k: Int): Char = c match {
    case `c` if c.isLower => ('a' + ((c - 'a' + k) % 26)).toChar
    case `c` if c.isUpper => ('A' + ((c - 'A' + k) % 26)).toChar
    case _                => c
  }
}

class Ch10Ex04_CaesarCipherSpec extends FlatSpec with Matchers {
  "encrypted log message" should "be decrypted (with default key)" in {
    val cipher: Ch10Ex04_CaesarCipher = new Ch10Ex04_CaesarCipher()
    cipher.decrypt(cipher.encrypt("test")) should be("test")
  }

  "encrypted log message" should "be decrypted (with overridden key)" in {
    val cipher: Ch10Ex04_CaesarCipher = new {
      override val key: Int = -3
    } with Ch10Ex04_CaesarCipher
    cipher.decrypt(cipher.encrypt("test")) should be("test")
  }
}
