package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

object Ch01Ex02_SquareRootComputer {
  def of(number: Double) = math.sqrt(number)
}

class Ch01Ex02_SquareRootComputerSpec extends FlatSpec with Matchers {
  "Square root of 9" should "return 3" in {
    Ch01Ex02_SquareRootComputer of 9 should be(3)
  }
}
