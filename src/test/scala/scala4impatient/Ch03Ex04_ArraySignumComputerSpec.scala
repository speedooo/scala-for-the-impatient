package scala4impatient

import scala.collection.mutable.ArrayBuffer
import scala4impatient.Ch03Ex04_ArraySignumComputer._
import org.scalatest.{ FlatSpec, Matchers }

object Ch03Ex04_ArraySignumComputer {
  def signumSwap(a: Array[Int]): Array[Int] = {
    var positives: ArrayBuffer[Int] = ArrayBuffer[Int]()
    var negatives: ArrayBuffer[Int] = ArrayBuffer[Int]()
    for (e <- a) {
      if (e > 0) positives += e
      else negatives += e
    }
    (positives ++= negatives).toArray
  }

  def signumSwapWithYield(a: Array[Int]): Array[Int] = {
    Array.concat(
      for (e <- a if e > 0) yield e,
      for (e <- a if e <= 0) yield e
    )
  }
}

class Ch03Ex04_ArraySignumComputerSpec extends FlatSpec with Matchers {
  "signum swapping elements of Array()" should "be Array()" in {
    val actual: Array[Int] = signumSwap(Array())
    val expected: Array[Int] = Array()
    actual.deep == expected.deep should be(right = true)
  }

  "signum swapping elements of Array(1)" should "be Array(1)" in {
    val actual: Array[Int] = signumSwap(Array(1))
    val expected: Array[Int] = Array(1)
    actual.deep == expected.deep should be(right = true)
  }

  "signum swapping elements of Array(1, -4, 3, -2)" should "be Array(1, 3, -4, -2)" in {
    val actual: Array[Int] = signumSwap(Array(1, -4, 3, -2))
    val expected: Array[Int] = Array(1, 3, -4, -2)
    actual.deep == expected.deep should be(right = true)
  }

  "signum swapping elements of Array(1, -4, 3, -2, 0)" should "be Array(1, 3, -4, -2, 0)" in {
    val actual: Array[Int] = signumSwap(Array(1, -4, 3, -2, 0))
    val expected: Array[Int] = Array(1, 3, -4, -2, 0)
    actual.deep == expected.deep should be(right = true)
  }

  "signum swapping with yield elements of Array()" should "be Array()" in {
    val actual: Array[Int] = signumSwapWithYield(Array())
    val expected: Array[Int] = Array()
    actual.deep == expected.deep should be(right = true)
  }

  "signum swapping with yield elements of Array(1)" should "be Array(1)" in {
    val actual: Array[Int] = signumSwapWithYield(Array(1))
    val expected: Array[Int] = Array(1)
    actual.deep == expected.deep should be(right = true)
  }

  "signum swapping with yield elements of Array(1, -4, 3, -2)" should "be Array(1, 3, -4, -2)" in {
    val actual: Array[Int] = signumSwapWithYield(Array(1, -4, 3, -2))
    val expected: Array[Int] = Array(1, 3, -4, -2)
    actual.deep == expected.deep should be(right = true)
  }

  "signum swapping with yield elements of Array(1, -4, 3, -2, 0)" should "be Array(1, 3, -4, -2, 0)" in {
    val actual: Array[Int] = signumSwapWithYield(Array(1, -4, 3, -2, 0))
    val expected: Array[Int] = Array(1, 3, -4, -2, 0)
    actual.deep == expected.deep should be(right = true)
  }
}
