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

package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

object Ch06Ex03_Origin extends java.awt.Point {
  // NOP
}

class Ch06Ex03_OriginSpec extends FlatSpec with Matchers {
  "origin move" should "not be allowed as it's a singleton (shared resource)" in {
    Ch06Ex03_Origin.getX should be(0)
    Ch06Ex03_Origin.getY should be(0)

    Ch06Ex03_Origin.move(1, 2)

    Ch06Ex03_Origin.getX should be(1)
    Ch06Ex03_Origin.getY should be(2)
  }
}
