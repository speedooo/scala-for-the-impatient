package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

class Ch01Ex09_StringOpsSpec extends FlatSpec with Matchers {
  "first character of a string" should "be extracted with the head function" in {
    "xyz".head should be('x')
  }

  "last character of a string" should "be extracted with the last function" in {
    "xyz".last should be('z')
  }
}
