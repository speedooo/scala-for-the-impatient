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

import java.io.{ File, BufferedWriter, FileWriter }

import org.scalatest.{ FlatSpec, Matchers }

import scala.io.Source
import scala4impatient.chapter09.Ch09Ex01_TextFileReverse._

object Ch09Ex01_TextFileReverse {
  /**
   * Reverses input text file content into output text file.
   * Caution: resources are not safely closed.
   * @param inputFilename input filename
   * @param outputFilename output filename
   * @param encoding encoding (e.g. "UTF-8")
   */
  def reverseTextFile(inputFilename: String, outputFilename: String, encoding: String): Unit = {
    val outputFile: File = new File(outputFilename)
    val bw: BufferedWriter = new BufferedWriter(new FileWriter(outputFile))
    bw.write(
      Source.fromFile(inputFilename, encoding)
        .getLines()
        .toList
        .reverse
        .mkString(System.getProperty("line.separator"))
    )
    bw.close()
  }
}

class Ch09Ex01_TextFileReverseSpec extends FlatSpec with Matchers {
  "text file" should "be reversed" in {
    // can't deal with original text file as eol are stripped
    val inputFilename: String = "src/test/resources/lorem-ipsum.txt"
    val encoding: String = "UTF-8"

    val outputFilename1: String = File.createTempFile("scala4impatient", "Ch09Ex01").getAbsolutePath
    reverseTextFile(inputFilename, outputFilename1, encoding)
    val reversed1: String = Source.fromFile(outputFilename1, encoding).mkString

    val outputFilename2: String = File.createTempFile("scala4impatient", "Ch09Ex01").getAbsolutePath
    reverseTextFile(outputFilename1, outputFilename2, encoding)
    val reversed2: String = Source.fromFile(outputFilename2, encoding).mkString

    val outputFilename3: String = File.createTempFile("scala4impatient", "Ch09Ex01").getAbsolutePath
    reverseTextFile(outputFilename2, outputFilename3, encoding)
    val reversed3: String = Source.fromFile(outputFilename3, encoding).mkString

    reversed1 shouldNot be(reversed2)
    reversed1 should be(reversed3)
  }
}
