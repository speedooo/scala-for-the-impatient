package scala4impatient

import scala4impatient.Ch03Ex03_ArraySwapWithYieldComputer._
import org.scalatest.{ FlatSpec, Matchers }

object Ch03Ex03_ArraySwapWithYieldComputer {
  def bubbleSwapWithYield(a: Array[Int]): Array[Int] = (for (i <- 0 until a.length) yield {
    if (i % 2 == 0 && i + 1 < a.length) a(i + 1)
    else if (i % 2 != 0 && i - 1 > -1) a(i - 1)
    else a(i)
  }).toArray
}

class Ch03Ex03_ArraySwapWithYieldComputerSpec extends FlatSpec with Matchers {
  "swapping with yield elements of Array()" should "be Array()" in {
    val actual: Array[Int] = bubbleSwapWithYield(Array())
    val expected: Array[Int] = Array()
    actual.deep == expected.deep should be(right = true)
  }

  "swapping with yield elements of Array(1)" should "be Array(1)" in {
    val actual: Array[Int] = bubbleSwapWithYield(Array(1))
    val expected: Array[Int] = Array(1)
    actual.deep == expected.deep should be(right = true)
  }

  "swapping with yield elements of Array(1, 2, 3, 4)" should "be Array(2, 1, 4, 3)" in {
    val actual: Array[Int] = bubbleSwapWithYield(Array(1, 2, 3, 4))
    val expected: Array[Int] = Array(2, 1, 4, 3)
    actual.deep == expected.deep should be(right = true)
  }

  "swapping with yield elements of Array(1, 2, 3, 4, 5)" should "be Array(2, 1, 4, 3, 5)" in {
    val actual: Array[Int] = bubbleSwapWithYield(Array(1, 2, 3, 4, 5))
    val expected: Array[Int] = Array(2, 1, 4, 3, 5)
    actual.deep == expected.deep should be(right = true)
  }
}
