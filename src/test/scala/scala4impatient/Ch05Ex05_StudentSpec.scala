package scala4impatient

import org.scalatest.{ Matchers, FlatSpec }

import scala.beans.BeanProperty

object Ch05Ex05_Student {
  def apply(id: Long, name: String): Ch05Ex05_Student = {
    new Ch05Ex05_Student(id, name)
  }
}

class Ch05Ex05_Student(@BeanProperty var id: Long = 0, @BeanProperty var name: String = "") {
  // NOP
}

class Ch05Ex05_StudentSpec extends FlatSpec with Matchers {
  "generated bean property accessors" should "be callable" in {
    val ben: Ch05Ex05_Student = Ch05Ex05_Student(42, "Ben Harper")
    ben.getId should be(42)
    ben.getName should be("Ben Harper")
  }
}
