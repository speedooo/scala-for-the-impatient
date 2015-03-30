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

package scala4impatient.chapter08

import org.scalatest.{ FlatSpec, Matchers }

object Ch08Ex06_Point {
  def apply(x: Double, y: Double): Ch08Ex06_Point = {
    new Ch08Ex06_Point(x, y)
  }
}

class Ch08Ex06_Point(val x: Double, val y: Double) {
  def canEqual(other: Any): Boolean = other.isInstanceOf[Ch08Ex06_Point]

  override def equals(other: Any): Boolean = other match {
    case that: Ch08Ex06_Point =>
      (that canEqual this) && x == that.x && y == that.y
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(x, y)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

abstract class Ch08Ex06_Shape {
  def centerPoint: Ch08Ex06_Point
}

class Ch08Ex06_Rectangle(val origin: Ch08Ex06_Point, val width: Double, val height: Double) extends Ch08Ex06_Shape {
  override def centerPoint: Ch08Ex06_Point = Ch08Ex06_Point(origin.x + width / 2, origin.y + height / 2)
}

class Ch08Ex06_Circle(var center: Ch08Ex06_Point, val radius: Double) extends Ch08Ex06_Shape {
  override def centerPoint: Ch08Ex06_Point = center
}

class Ch08Ex06_ShapeSpec extends FlatSpec with Matchers {
  "rectangle((1, 2), 4.5, 6)" should "be centered at (3.25, 4)" in {
    new Ch08Ex06_Rectangle(Ch08Ex06_Point(1, 2), 4.5, 6).centerPoint should be(Ch08Ex06_Point(3.25, 5))
  }

  "circle((1, 2), 4.5)" should "be centered at (3.25, 4)" in {
    new Ch08Ex06_Circle(Ch08Ex06_Point(1, 2), 4.5).centerPoint should be(Ch08Ex06_Point(1, 2))
  }
}
