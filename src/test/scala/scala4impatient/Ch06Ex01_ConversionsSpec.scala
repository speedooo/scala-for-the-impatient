package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

import scala4impatient.Ch06Ex01_Conversions._

object Ch06Ex01_Conversions {
  def inchesToCentimeters(inches: Double): Double = inches * 2.54
  def gallonsToLiters(gallons: Double): Double = gallons * 3.78541178
  def milesToKilometers(miles: Double): Double = miles * 1.609344
}

class Ch06Ex01_ConversionsSpec extends FlatSpec with Matchers {
  "1 inch" should "be converted to 2.54 centimeters" in {
    inchesToCentimeters(1) should be(2.54)
  }

  "1 gallon" should "be converted to 3.78541178 liters" in {
    gallonsToLiters(1) should be(3.78541178)
  }

  "1 mile" should "be converted to 1.609344 kilometers" in {
    milesToKilometers(1) should be(1.609344)
  }
}
