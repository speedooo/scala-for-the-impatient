package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

import scala.util.Random
import scala4impatient.Ch04Ex01_MapWithYield._

object Ch04Ex01_MapWithYield {
  // just a tiny reminder
  def random(): Map[String, Double] = {
    ((for (i <- 0 until 100) yield Random.nextString(i)) map (e => e -> Random.nextDouble())).toMap
  }

  def discount(): Map[String, Double] = {
    val wishlist: Map[String, Double] = Map(
      "TC Electronic Ditto" -> 98.0,
      "TC Electronic PolyTune 2 Mini" -> 79.0
    )
    for ((k, v) <- wishlist) yield k -> truncateAt(0.9 * v, 2)
  }

  def truncateAt(n: Double, p: Int): Double = {
    val s: Double = math.pow(10, p)
    math.floor(n * s) / s
  }
}

class Ch04Ex01_MapWithYieldSpec extends FlatSpec with Matchers {
  "wishlist with discount" should "be as below" in {
    val actual: Map[String, Double] = discount()
    val expected: Map[String, Double] = Map(
      "TC Electronic Ditto" -> 88.20,
      "TC Electronic PolyTune 2 Mini" -> 71.10
    )
    actual should be(expected)
  }
}
