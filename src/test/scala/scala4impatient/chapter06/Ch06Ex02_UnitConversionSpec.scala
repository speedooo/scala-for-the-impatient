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

import org.scalatest.{ FlatSpec, Matchers }

trait Ch06Ex02_UnitConversion {
  def convert(value: Double): Double
}

object Ch06Ex02_InchesToCentimeters extends Ch06Ex02_UnitConversion {
  override def convert(value: Double): Double = value * 2.54
}

object Ch06Ex02_GallonsToLiters extends Ch06Ex02_UnitConversion {
  override def convert(value: Double): Double = value * 3.78541178
}

object Ch06Ex02_MilesToKilometers extends Ch06Ex02_UnitConversion {
  override def convert(value: Double): Double = value * 1.609344
}

class Ch06Ex02_UnitConversionSpec extends FlatSpec with Matchers {
  "1 inch" should "be converted to 2.54 centimeters" in {
    Ch06Ex02_InchesToCentimeters.convert(1) should be(2.54)
  }

  "1 gallon" should "be converted to 3.78541178 liters" in {
    Ch06Ex02_GallonsToLiters.convert(1) should be(3.78541178)
  }

  "1 mile" should "be converted to 1.609344 kilometers" in {
    Ch06Ex02_MilesToKilometers.convert(1) should be(1.609344)
  }
}
