package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

object Ch05Ex07_PersonWithName {
  def apply(name: String): Ch05Ex07_PersonWithName = {
    new Ch05Ex07_PersonWithName(name)
  }
}

class Ch05Ex07_PersonWithName(name: String) {
  val firstName: String = name.split("\\s+")(0)
  val lastName: String = name.split("\\s+")(1)
}

class Ch05Ex07_PersonWithNameSpec extends FlatSpec with Matchers {
  "'Ben Harper'" should "be named Ben Harper" in {
    val person: Ch05Ex07_PersonWithName = Ch05Ex07_PersonWithName("Ben Harper")
    person.firstName should be("Ben")
    person.lastName should be("Harper")
  }
}
