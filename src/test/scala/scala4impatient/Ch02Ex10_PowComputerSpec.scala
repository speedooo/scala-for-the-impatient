package scala4impatient

import scala4impatient.Ch02Ex10_PowComputer._
import org.scalatest.{ FlatSpec, Matchers }

object Ch02Ex10_PowComputer {
  def pow(x: Double, n: Int): Double = {
    if (n > 0 && n % 2 == 0) pow(x, n / 2) * pow(x, n / 2)
    else if (n > 0) x * pow(x, n - 1)
    else if (n == 0) 1
    else 1 / pow(x, -n)
  }
}

class Ch02Ex10_PowComputerSpec extends FlatSpec with Matchers {
  "weird computation of 2^0" should "be 1" in {
    pow(2, 0) should be(1)
  }

  "weird computation of 2^2" should "be 4" in {
    pow(2, 2) should be(4)
  }

  "weird computation of 2^3" should "be 8" in {
    pow(2, 3) should be(8)
  }

  "weird computation of 2^-2" should "be .25" in {
    pow(2, -2) should be(.25)
  }
}
