package scala4impatient

import scala4impatient.Ch02Ex06_UnicodeComputer.unicodeProduct
import org.scalatest.{ FlatSpec, Matchers }

object Ch02Ex06_UnicodeComputer {
  def unicodeProduct(s: String): Long = {
    var product: Long = 1
    for (c <- s) {
      product *= c.toInt
    }
    product
  }
}

class Ch02Ex06_UnicodeComputerSpec extends FlatSpec with Matchers {
  "unicode product of 'Hello'" should "be 9415087488L" in {
    unicodeProduct("Hello") should be(9415087488L)
  }
}
