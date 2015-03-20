package scala4impatient

object Ch06Ex08_CubeCorners extends Enumeration {
  type Ch06Ex08_CubeCorners = Value
  val _1 = Value(0xff00)
  val _2 = Value(_1.id >> 1)
  val _3 = Value(_1.id >> 2)
  val _4 = Value(_1.id >> 3)
  val _5 = Value(_1.id >> 4)
  val _6 = Value(_1.id >> 6)
  val _7 = Value(_1.id >> 7)
  val _8 = Value(_1.id >> 8)
}
