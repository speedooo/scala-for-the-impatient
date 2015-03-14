package scala4impatient

import scala4impatient.Ch02Ex07_UnicodeComputer._
import scala4impatient.Ch02Ex08_UnicodeComputer.product
import org.scalatest.{ FlatSpec, Matchers }

object Ch02Ex08_UnicodeComputer {
  def product(s: String): Long = unicodeProductWithoutLoop(s)
}

class Ch02Ex08_UnicodeComputerSpec extends FlatSpec with Matchers {
  "unicode product without loop of 'Hello'" should "be 9415087488L" in {
    product("Hello") should be(9415087488L)
  }
}
