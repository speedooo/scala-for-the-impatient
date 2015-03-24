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

package scala4impatient.chapter06

object Ch06Ex08_CubeCorners extends Enumeration {
  type Ch06Ex08_CubeCorners = Value
  val _1 = Value(0xff00)
  val _2 = Value(_1.id >> 1)
  val _3 = Value(_1.id >> 2)
  val _4 = Value(_1.id >> 3)
  val _5 = Value(_1.id >> 4)
  val _6 = Value(_1.id >> 6)
  val _7 = Value(_1.id >> 7)
  val _8 = Value(_1.id >> 8)
}
