package scala4impatient

import org.scalatest.{ Matchers, FlatSpec }

object Ch05Ex03_Time {
  def apply(hrs: Int, min: Int): Ch05Ex03_Time = {
    new Ch05Ex03_Time(hrs, min)
  }
}

class Ch05Ex03_Time() {
  private var _hrs: Int = 0
  private var _min: Int = 0

  def this(hrs: Int, min: Int) {
    this()
    if (hrs < 0 || hrs > 23 || min < 0 || min > 60) throw new IllegalArgumentException
    _hrs = hrs
    _min = min
  }

  def hrs: Int = _hrs
  def min: Int = _min

  def isBefore(other: Ch05Ex03_Time): Boolean = {
    if (_hrs != other.hrs) _hrs < other.hrs
    else _min < other.min
  }
}

class Ch05Ex03_TimeSpec extends FlatSpec with Matchers {
  "12:30" should "be before 12:45" in {
    Ch05Ex03_Time(12, 30).isBefore(Ch05Ex03_Time(12, 45)) should be(right = true)
  }
}
