package com.github.cbismuth.scala4impatient

import com.github.cbismuth.scala4impatient.Ch02Ex01_SignumComputer._
import org.scalatest.{ FlatSpec, Matchers }

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
