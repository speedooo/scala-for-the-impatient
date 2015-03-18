package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

import scala4impatient.Ch04Ex09_Threshold._

object Ch04Ex09_Threshold {
  def lteqgt(values: Array[Int], threshold: Int): (Int, Int, Int) = {
    val lt: Int = values count { _ < threshold }
    val eq: Int = values count { _ == threshold }
    val gt: Int = values count { _ > threshold }
    (lt, eq, gt)
  }
}

class Ch04Ex09_ThresholdSpec extends FlatSpec with Matchers {
  "minmax(Array(), 42)" should "be (0, 0, 0)" in {
    val t: (Int, Int, Int) = lteqgt(Array(), 42)
    t should be((0, 0, 0))
  }

  "minmax(Array(32, 423, -312, 34), 42)" should "be (3, 0, 1)" in {
    val t: (Int, Int, Int) = lteqgt(Array(32, 423, -312, 34), 42)
    t should be((3, 0, 1))
  }
}
