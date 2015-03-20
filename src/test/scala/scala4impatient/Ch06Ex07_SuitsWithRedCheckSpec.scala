package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

object Ch06Ex07_SuitsWithRedCheck extends Enumeration {
  type Ch06Ex07_SuitsWithRedCheck = Value
  val HEART = Value("♥")
  val DIAMOND = Value("♦")
  val CLOVER = Value("♣")
  val SPADE = Value("♠")

  def isRed(suits: Ch06Ex07_SuitsWithRedCheck): Boolean = HEART == suits || DIAMOND == suits
}

class Ch06Ex07_SuitsWithRedCheckSpec extends FlatSpec with Matchers {
  "heart and diamond only" should "be red" in {
    Ch06Ex07_SuitsWithRedCheck.isRed(Ch06Ex07_SuitsWithRedCheck.HEART) should be(right = true)
    Ch06Ex07_SuitsWithRedCheck.isRed(Ch06Ex07_SuitsWithRedCheck.DIAMOND) should be(right = true)
    Ch06Ex07_SuitsWithRedCheck.isRed(Ch06Ex07_SuitsWithRedCheck.CLOVER) should be(right = false)
    Ch06Ex07_SuitsWithRedCheck.isRed(Ch06Ex07_SuitsWithRedCheck.SPADE) should be(right = false)
  }
}
