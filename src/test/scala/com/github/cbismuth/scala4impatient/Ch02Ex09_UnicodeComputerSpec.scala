package com.github.cbismuth.scala4impatient

import com.github.cbismuth.scala4impatient.Ch02Ex09_UnicodeComputer.product
import org.scalatest.{ FlatSpec, Matchers }

class Ch02Ex09_UnicodeComputerSpec extends FlatSpec with Matchers {
  "unicode product with recursion of 'Hello'" should "be 9415087488L" in {
    product("Hello") should be(9415087488L)
  }
}