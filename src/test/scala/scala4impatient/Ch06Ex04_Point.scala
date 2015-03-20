package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

object Ch06Ex04_Point {
  def apply(x: Int, y: Int): Ch06Ex04_Point = {
    new Ch06Ex04_Point(x, y)
  }
}

class Ch06Ex04_Point(var x: Int, var y: Int) {
  // NOP
}

class Ch06Ex04_PointSpec extends FlatSpec with Matchers {
  "" should "" in {
    val point: Ch06Ex04_Point = Ch06Ex04_Point(3, 4)
    point.x should be(3)
    point.y should be(4)
  }
}
