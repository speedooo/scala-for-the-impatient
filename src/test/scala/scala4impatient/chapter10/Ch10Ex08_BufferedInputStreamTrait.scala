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

class Ch10Ex08_BufferedInputStreamTrait {
  this: FileInputStream =>
  val delegate: BufferedInputStream = new BufferedInputStream(this)

  def available(): Int = delegate.available()

  def read(): Int = delegate.read()
  def read(b: Array[Byte]): Int = delegate.read(b)
  def read(b: Array[Byte], off: Int, len: Int): Int = delegate.read(b, off, len)
  def skip(n: Long): Long = delegate.skip(n)
  def reset(): Unit = delegate.reset()

  def mark(readlimit: Int): Unit = delegate.mark(readlimit)
  def markSupported(): Boolean = delegate.markSupported()

  def close(): Unit = delegate.close()
}
