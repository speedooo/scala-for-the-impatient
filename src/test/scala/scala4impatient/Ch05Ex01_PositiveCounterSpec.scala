package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

object Ch05Ex01_PositiveCounter {
  def apply(init: Int) = {
    new Ch05Ex01_PositiveCounter(init)
  }
}

class Ch05Ex01_PositiveCounter() {
  private var count: Int = 0

  def this(init: Int) {
    this()
    count = init
  }

  def value: Int = count

  def increment(): Ch05Ex01_PositiveCounter = {
    if (count < Int.MaxValue) count += 1
    this
  }
}

class Ch05Ex01_PositiveCounterSpec extends FlatSpec with Matchers {
  "positive counter" should "not overflow" in {
    Ch05Ex01_PositiveCounter(Int.MaxValue).increment().value should be(Int.MaxValue)
  }
}
