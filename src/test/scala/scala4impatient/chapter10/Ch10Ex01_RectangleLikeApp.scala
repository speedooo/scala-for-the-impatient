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

import java.awt.geom.Ellipse2D

import org.scalatest.{ FlatSpec, Matchers }

trait Ch10Ex01_RectangleLike {
  def getX: Double
  def getY: Double
  def getWidth: Double
  def getHeight: Double
  def setFrame(x: Double, y: Double, width: Double, height: Double): Unit

  def translate(dx: Double, dy: Double): Unit = {
    setFrame(getX + dx, getY + dy, getWidth, getHeight)
  }

  def grow(h: Double, v: Double): Unit = {
    setFrame(getX - h, getY - v, getWidth + 2 * h, getHeight + 2 * v)
  }
}

class Ch10Ex01_RectangleLikeSpec extends FlatSpec with Matchers {
  "rectangle like trait" should "be mixed into ellipse" in {
    val egg = new Ellipse2D.Double(5, 10, 20, 30) with Ch10Ex01_RectangleLike
    egg.translate(10, -10)
    egg.grow(10, 20)
  }
}
