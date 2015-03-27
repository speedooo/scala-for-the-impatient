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

package scala4impatient.chapter09.util

import java.io.{ BufferedWriter, File, FileWriter }

import scala.io.Source

object UnsafeStringOps {
  def string2file(string: String, filename: String, encoding: String = "UTF-8"): Unit = {
    val outputFile: File = new File(filename)
    val bw: BufferedWriter = new BufferedWriter(new FileWriter(outputFile))
    bw.write(string)
    bw.close()
  }

  def file2string(filename: String, encoding: String = "UTF-8"): String = {
    Source.fromFile(filename, encoding).mkString
  }
}
