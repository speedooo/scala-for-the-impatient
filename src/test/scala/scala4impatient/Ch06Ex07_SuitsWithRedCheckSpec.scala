package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

object Ch06Ex07_Suits extends Enumeration {
  type Ch06Ex07_Suits = Value
  val HEART = Value("♥")
  val DIAMOND = Value("♦")
  val CLOVER = Value("♣")
  val SPADE = Value("♠")

  def isRed(suits: Ch06Ex07_Suits): Boolean = HEART == suits || DIAMOND == suits
}

class Ch06Ex07_SuitsSpec extends FlatSpec with Matchers {
  "heart and diamond only" should "be red" in {
    Ch06Ex07_Suits.isRed(Ch06Ex07_Suits.HEART) should be(right = true)
    Ch06Ex07_Suits.isRed(Ch06Ex07_Suits.DIAMOND) should be(right = true)
    Ch06Ex07_Suits.isRed(Ch06Ex07_Suits.CLOVER) should be(right = false)
    Ch06Ex07_Suits.isRed(Ch06Ex07_Suits.SPADE) should be(right = false)
  }
}
