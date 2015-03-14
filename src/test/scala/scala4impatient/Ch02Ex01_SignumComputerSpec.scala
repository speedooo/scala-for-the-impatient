package scala4impatient

import scala4impatient.Ch02Ex01_SignumComputer._
import org.scalatest.{ FlatSpec, Matchers }

object Ch02Ex01_SignumComputer {
  def signum(number: Double): Int = if (number > 0) 1 else if (number < 0) -1 else 0
}

class Ch02Ex01_SignumComputerSpec extends FlatSpec with Matchers {
  "signum of -42" should "be -1" in {
    signum(-42) should be(-1)
  }

  "signum of 42" should "be 1" in {
    signum(42) should be(1)
  }

  "signum of 0" should "be 0" in {
    signum(0) should be(0)
  }
}
