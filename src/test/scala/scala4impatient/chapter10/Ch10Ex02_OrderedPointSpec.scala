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

import java.awt.Point

import org.scalatest.{ FlatSpec, Matchers }

class Ch10Ex02_OrderedPoint(x: Int, y: Int) extends Point(x, y) with scala.math.Ordered[Point] {
  override def compare(that: Point): Int = {
    if (getX == that.getX) {
      (getY - that.getY).toInt
    } else {
      (getX - that.getX).toInt
    }
  }
}

class Ch10Ex02_OrderedPointSpec extends FlatSpec with Matchers {
  "(0, 0)" should "be equals to (0, 0)" in {
    new Ch10Ex02_OrderedPoint(0, 0) == new Ch10Ex02_OrderedPoint(0, 0) should be(right = true)
  }

  "(1, 0)" should "be greater than (0, 0)" in {
    new Ch10Ex02_OrderedPoint(1, 0) > new Ch10Ex02_OrderedPoint(0, 0) should be(right = true)
  }

  "(0, 1)" should "be greater than (0, 0)" in {
    new Ch10Ex02_OrderedPoint(0, 1) > new Ch10Ex02_OrderedPoint(0, 0) should be(right = true)
  }
}
