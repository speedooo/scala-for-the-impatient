package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

object Ch06Ex03_Origin extends java.awt.Point {
  // NOP
}

class Ch06Ex03_OriginSpec extends FlatSpec with Matchers {
  "origin move" should "not be allowed as it's a singleton (shared resource)" in {
    Ch06Ex03_Origin.getX should be(0)
    Ch06Ex03_Origin.getY should be(0)

    Ch06Ex03_Origin.move(1, 2)

    Ch06Ex03_Origin.getX should be(1)
    Ch06Ex03_Origin.getY should be(2)
  }
}
