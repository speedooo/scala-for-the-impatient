package com.github.cbismuth.scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

class Ch01Ex02_SquareRootComputerSpec extends FlatSpec with Matchers {
  "Square root of 9" should "return 3" in {
    Ch01Ex02_SquareRootComputer of 9 should be(3)
  }
}
