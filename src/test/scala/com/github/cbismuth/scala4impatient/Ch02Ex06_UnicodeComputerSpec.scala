package com.github.cbismuth.scala4impatient

import com.github.cbismuth.scala4impatient.Ch02Ex06_UnicodeComputer.unicodeProduct
import org.scalatest.{ FlatSpec, Matchers }

class Ch02Ex06_UnicodeComputerSpec extends FlatSpec with Matchers {
  "unicode product of 'Hello'" should "be 9415087488L" in {
    unicodeProduct("Hello") should be(9415087488L)
  }
}
