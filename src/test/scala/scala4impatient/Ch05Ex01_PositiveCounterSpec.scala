package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

object Ch05Ex01_PositiveCounter {
  def apply(count: Int): Ch05Ex01_PositiveCounter = {
    new Ch05Ex01_PositiveCounter(count)
  }
}

class Ch05Ex01_PositiveCounter() {
  private var _count: Int = 0

  def this(count: Int) {
    this()
    _count = count
  }

  def count: Int = _count

  def increment(): Ch05Ex01_PositiveCounter = {
    if (_count < Int.MaxValue) _count += 1
    this
  }
}

class Ch05Ex01_PositiveCounterSpec extends FlatSpec with Matchers {
  "positive counter" should "not overflow" in {
    Ch05Ex01_PositiveCounter(Int.MaxValue).increment().count should be(Int.MaxValue)
  }
}
