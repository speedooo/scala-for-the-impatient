package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

import scala.Double.NaN
import scala4impatient.Ch03Ex05_ArrayAverageComputer._

object Ch03Ex05_ArrayAverageComputer {
  def avg(a: Array[Int]): Double = {
    a.sum.toDouble / a.length
  }
}

class Ch03Ex05_ArrayAverageComputerSpec extends FlatSpec with Matchers {
  "signum swapping elements of Array()" should "be Array()" in {
    NaN.equals(avg(Array())) should be(right = true)
  }

  "signum swapping elements of Array(1)" should "be Array(1)" in {
    val actual: Double = avg(Array(1))
    val expected: Double = 1
    actual should be(expected)
  }

  "signum swapping elements of Array(1, -4, 3, -2)" should "be Array(1, 3, -4, -2)" in {
    val actual: Double = avg(Array(1, -4, 3, -2))
    val expected: Double = -.5
    actual should be(expected)
  }

  "signum swapping elements of Array(1, -4, 3, -2, 0)" should "be Array(1, 3, -4, -2, 0)" in {
    val actual: Double = avg(Array(1, -4, 3, -2, 0))
    val expected: Double = -.4
    actual should be(expected)
  }
}
