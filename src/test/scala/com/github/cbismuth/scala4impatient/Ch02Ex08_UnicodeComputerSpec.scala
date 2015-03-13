package com.github.cbismuth.scala4impatient

import com.github.cbismuth.scala4impatient.Ch02Ex07_UnicodeComputer._
import com.github.cbismuth.scala4impatient.Ch02Ex08_UnicodeComputer.product
import org.scalatest.{ FlatSpec, Matchers }

object Ch02Ex08_UnicodeComputer {
  def product(s: String): Long = unicodeProductWithoutLoop(s)
}

class Ch02Ex08_UnicodeComputerSpec extends FlatSpec with Matchers {
  "unicode product without loop of 'Hello'" should "be 9415087488L" in {
    product("Hello") should be(9415087488L)
  }
}
