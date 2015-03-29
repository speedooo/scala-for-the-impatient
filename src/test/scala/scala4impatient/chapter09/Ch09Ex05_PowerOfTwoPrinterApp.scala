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

import scala.collection.immutable.IndexedSeq

object Ch09Ex05_PowerOfTwoPrinterApp extends App {
  val tuples: IndexedSeq[(Double, Int, Double, Int)] = for {
    i <- 0 to 20
    p = math.pow(2, i)
    s = math.sqrt(i)
  } yield (p, p.toString.length, s, s.toString.length)

  val pmaxlen: Int = tuples.reduceLeft((x, y) => if (x._2 > y._2) x else y)._2 + 1
  val smaxlen: Int = tuples.reduceLeft((x, y) => if (x._4 > y._4) x else y)._4 + 1

  tuples.foreach {
    case (p, plen, s, slen) => println(" " * (pmaxlen - plen) + p + " " * (smaxlen - slen) + s)
  }
}
