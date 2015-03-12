package com.github.cbismuth.scala4impatient

import com.github.cbismuth.scala4impatient.Ch02Ex07_UnicodeComputer.unicodeProductWithoutLoop
import org.scalatest.{ FlatSpec, Matchers }

class Ch02Ex07_UnicodeComputerSpec extends FlatSpec with Matchers {
  "unicode product without loop of 'Hello'" should "be 9415087488L" in {
    unicodeProductWithoutLoop("Hello") should be(9415087488L)
  }
}
