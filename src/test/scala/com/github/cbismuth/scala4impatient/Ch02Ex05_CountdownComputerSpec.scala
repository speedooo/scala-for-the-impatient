package com.github.cbismuth.scala4impatient

import com.github.cbismuth.scala4impatient.Ch02Ex05_CountdownComputer._
import org.scalatest.{ FlatSpec, Matchers }

class Ch02Ex05_CountdownComputerSpec extends FlatSpec with Matchers {
  "count down of 10" should "be 55" in {
    countdown(10) should be(55)
  }

  "count down of 0" should "be 0" in {
    countdown(0) should be(0)
  }

  "count down of -10" should "be -55" in {
    countdown(-10) should be(-55)
  }
}
