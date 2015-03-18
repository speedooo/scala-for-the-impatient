package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

import scala4impatient.Ch04Ex08_MinMax._

object Ch04Ex08_MinMax {
  def minmax(values: Array[Int]): (Int, Int) = {
    (values.min, values.max)
  }
}

class Ch04Ex08_MinMaxSpec extends FlatSpec with Matchers {
  "minmax(Array())" should "throw an UnsupportedOperationException" in {
    an[java.lang.UnsupportedOperationException] shouldBe thrownBy(minmax(Array()))
  }

  "minmax(Array(32, 423, -312, 34))" should "be (-312, 423)" in {
    val t: (Int, Int) = minmax(Array(32, 423, -312, 34))
    t should be((-312, 423))
  }
}
