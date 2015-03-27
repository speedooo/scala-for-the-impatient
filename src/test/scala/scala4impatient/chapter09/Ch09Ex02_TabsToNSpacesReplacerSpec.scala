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

import java.io.{ FileWriter, BufferedWriter, File }

import org.scalatest.{ Matchers, FlatSpec }

import scala.io.Source
import scala4impatient.chapter09.Ch09Ex02_TabsToNSpacesReplacer._

object Ch09Ex02_TabsToNSpacesReplacer {
  def replaceTabsWithNSpaces(inputFilename: String, outputFilename: String, encoding: String, nbSpaces: Int): Unit = {
    val replacement: String = " " * nbSpaces
    val original: String = Source.fromFile(inputFilename).mkString
    val replaced: String = original.replaceAll("""\t""", replacement)

    val outputFile: File = new File(outputFilename)
    val bw: BufferedWriter = new BufferedWriter(new FileWriter(outputFile))
    bw.write(replaced)
    bw.close()
  }
}

class Ch09Ex02_TabsToNSpacesReplacerSpec extends FlatSpec with Matchers {
  "tabs" should "be replaced with N spaces" in {
    // default encoding
    val encoding: String = "UTF-8"

    // create input file
    val withTabsFile: File = File.createTempFile("scala4impatient", "Ch09Ex02")
    val withTabsFilename: String = withTabsFile.getAbsolutePath

    // add tabs and spaces
    val bw: BufferedWriter = new BufferedWriter(new FileWriter(withTabsFile))
    bw.write("\t\t   \t\t   ") // 4 tabs + 2 x 3 spaces
    bw.close()

    // create output file
    val withSpacesFile: File = File.createTempFile("scala4impatient", "Ch09Ex02")
    val withSpacesFilename: String = withSpacesFile.getAbsolutePath

    // replace tabs with 2 spaces each
    replaceTabsWithNSpaces(withTabsFilename, withSpacesFilename, encoding, 2)

    // get first line of output file
    val lines: Array[String] = Source.fromFile(withSpacesFilename, encoding).getLines().toArray
    val firstLineWithSpaces: String = lines(0)

    // check if tabs have been well replaced with spaces
    firstLineWithSpaces should be("              ") // 4 x 2 spaces + 2 x 3 spaces
  }
}
