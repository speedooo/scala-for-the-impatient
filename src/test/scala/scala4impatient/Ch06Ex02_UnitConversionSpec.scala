package scala4impatient

import org.scalatest.{ Matchers, FlatSpec }

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
