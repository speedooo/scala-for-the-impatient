package scala4impatient

import java.util.Calendar._

import org.scalatest.{ FlatSpec, Matchers }

import scala.collection._
import scala4impatient.Ch04Ex06_WeekdaysInLinkedHashMap._

object Ch04Ex06_WeekdaysInLinkedHashMap {
  def weekdays(): Map[String, Int] = {
    mutable.LinkedHashMap[String, Int](
      "MONDAY" -> MONDAY,
      "TUESDAY" -> TUESDAY,
      "WEDNESDAY" -> WEDNESDAY,
      "THURSDAY" -> THURSDAY,
      "FRIDAY" -> FRIDAY,
      "SATURDAY" -> SATURDAY,
      "SUNDAY" -> SUNDAY
    )
  }

}

class Ch04Ex06_WeekdaysInLinkedHashMapSpec extends FlatSpec with Matchers {
  "insertion order with a linked hash map" should "be preserved" in {
    val i: scala.Iterator[String] = weekdays().keysIterator
    i.next() should be("MONDAY")
    i.next() should be("TUESDAY")
    i.next() should be("WEDNESDAY")
    i.next() should be("THURSDAY")
    i.next() should be("FRIDAY")
    i.next() should be("SATURDAY")
    i.next() should be("SUNDAY")
  }
}
