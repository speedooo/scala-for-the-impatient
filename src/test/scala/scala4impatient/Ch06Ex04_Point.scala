package scala4impatient

object Ch06Ex04_Point {
  def apply(x: Int, y: Int): Ch06Ex04_Point = {
    new Ch06Ex04_Point(x, y)
  }
}

class Ch06Ex04_Point(var x: Int, var y: Int) {
  // NOP
}
