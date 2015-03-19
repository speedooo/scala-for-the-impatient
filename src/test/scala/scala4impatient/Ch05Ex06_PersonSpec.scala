package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

object Ch05Ex06_Person {
  def apply(age: Int): Ch05Ex06_Person = {
    new Ch05Ex06_Person(age)
  }
}

class Ch05Ex06_Person {
  private var _age: Int = 0

  def this(age: Int) {
    this()
    if (age < 0) _age = 0 else _age = age
  }

  def age: Int = _age
}

class Ch05Ex06_PersonSpec extends FlatSpec with Matchers {
  "a person built with 42 yo" should "be 42 yo" in {
    Ch05Ex06_Person(42).age should be(42)
  }

  "a person built with a negative age" should "be 0 yo" in {
    Ch05Ex06_Person(-42).age should be(0)
  }
}
