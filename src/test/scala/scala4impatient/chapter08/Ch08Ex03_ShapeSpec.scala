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

class Ch08Ex03_Point(val x: Double, val y: Double) {
  // NOP
}

abstract class Ch08Ex03_ShapeSpec {
  def perimeter: Double
}

class Ch08Ex03_Square(val origin: Ch08Ex03_Point, val sideLength: Double) extends Ch08Ex03_ShapeSpec {
  override def perimeter: Double = 4 * sideLength
}

class Ch08Ex03_Circle(val center: Ch08Ex03_Point, val radius: Double) extends Ch08Ex03_ShapeSpec {
  override def perimeter: Double = 2 * math.Pi * radius
}
