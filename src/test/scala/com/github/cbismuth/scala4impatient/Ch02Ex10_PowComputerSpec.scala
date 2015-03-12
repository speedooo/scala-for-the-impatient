package com.github.cbismuth.scala4impatient

import com.github.cbismuth.scala4impatient.Ch02Ex10_PowComputer._
import org.scalatest.{ FlatSpec, Matchers }

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
