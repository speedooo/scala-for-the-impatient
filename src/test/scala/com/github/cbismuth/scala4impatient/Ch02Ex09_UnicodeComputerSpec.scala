package com.github.cbismuth.scala4impatient

import com.github.cbismuth.scala4impatient.Ch02Ex09_UnicodeComputer.product
import org.scalatest.{ FlatSpec, Matchers }

object Ch02Ex09_UnicodeComputer {
  def product(s: String): Long = {
    if (s.length == 0) 0
    else if (s.length == 1) s(0).toInt
    else s.take(1)(0).toInt * product(s.drop(1))
  }
}

class Ch02Ex09_UnicodeComputerSpec extends FlatSpec with Matchers {
  "unicode product with recursion of 'Hello'" should "be 9415087488L" in {
    product("Hello") should be(9415087488L)
  }
}
