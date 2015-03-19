package scala4impatient

import org.scalatest.{ Matchers, FlatSpec }

object Ch05Ex04_TimeSinceMidnight {
  def apply(hrs: Int, min: Int): Ch05Ex04_TimeSinceMidnight = {
    new Ch05Ex04_TimeSinceMidnight(hrs, min)
  }
}

class Ch05Ex04_TimeSinceMidnight() {
  private var _minSinceMidnight: Int = 0

  def this(hrs: Int, min: Int) {
    this()
    if (hrs < 0 || hrs > 23 || min < 0 || min > 59) throw new IllegalArgumentException
    _minSinceMidnight = hrs * 60 + min
  }

  def hrs: Int = _minSinceMidnight / 60
  def min: Int = _minSinceMidnight % 60

  def isBefore(other: Ch05Ex04_TimeSinceMidnight): Boolean = {
    if (hrs != other.hrs) hrs < other.hrs
    else min < other.min
  }
}

class Ch05Ex04_TimeSinceMidnightSpec extends FlatSpec with Matchers {
  "13:45" should "be 13:45" in {
    val time: Ch05Ex04_TimeSinceMidnight = Ch05Ex04_TimeSinceMidnight(13, 45)
    time.hrs should be(13)
    time.min should be(45)
  }

  "12:30" should "be before 12:45" in {
    Ch05Ex04_TimeSinceMidnight(12, 30).isBefore(Ch05Ex04_TimeSinceMidnight(12, 45)) should be(right = true)
  }
}
