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

package scala4impatient.chapter03

import java.awt.datatransfer.DataFlavor.imageFlavor
import java.awt.datatransfer.SystemFlavorMap
import java.awt.datatransfer.SystemFlavorMap.getDefaultFlavorMap

import org.scalatest.{ FlatSpec, Matchers }

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable
import scala4impatient.chapter03.Ch03Ex10_Flavor._

object Ch03Ex10_Flavor {
  def nativesForFlavor(): mutable.Buffer[String] = {
    getDefaultFlavorMap
      .asInstanceOf[SystemFlavorMap]
      .getNativesForFlavor(imageFlavor)
  }
}

class Ch03Ex10_FlavorSpec extends FlatSpec with Matchers {
  "native image flavor identifiers" should "contain PNG" in {
    nativesForFlavor().contains("PNG") should be(right = true)
  }
}
