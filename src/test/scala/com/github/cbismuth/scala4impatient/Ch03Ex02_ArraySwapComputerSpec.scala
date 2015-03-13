package com.github.cbismuth.scala4impatient

import com.github.cbismuth.scala4impatient.Ch03Ex02_ArraySwapComputer._
import org.scalatest.{ FlatSpec, Matchers }

object Ch03Ex02_ArraySwapComputer {
  def bubbleSwap(a: Array[Int]): Array[Int] = {
    for (i <- 0 to (if (a.length % 2 == 0) a.length - 2 else a.length - 3, 2)) {
      val tmp: Int = a(i)
      a(i) = a(i + 1)
      a(i + 1) = tmp
    }
    a
  }

  def functionalSwap(a: Array[Int]): Array[Int] = {
    a.grouped(2).flatMap {
      case Array(x, y) => Array(y, x)
      case Array(x)    => Array(x)
    }.toArray
  }
}

class Ch03Ex02_ArraySwapComputerSpec extends FlatSpec with Matchers {
  "bubble swapping elements of Array()" should "be Array()" in {
    val actual: Array[Int] = bubbleSwap(Array())
    val expected: Array[Int] = Array()
    actual.deep == expected.deep should be(right = true)
  }

  "bubble swapping elements of Array(1)" should "be Array(1)" in {
    val actual: Array[Int] = bubbleSwap(Array(1))
    val expected: Array[Int] = Array(1)
    actual.deep == expected.deep should be(right = true)
  }

  "bubble swapping elements of Array(1, 2, 3, 4)" should "be Array(2, 1, 4, 3)" in {
    val actual: Array[Int] = bubbleSwap(Array(1, 2, 3, 4))
    val expected: Array[Int] = Array(2, 1, 4, 3)
    actual.deep == expected.deep should be(right = true)
  }

  "bubble swapping elements of Array(1, 2, 3, 4, 5)" should "be Array(2, 1, 4, 3, 5)" in {
    val actual: Array[Int] = bubbleSwap(Array(1, 2, 3, 4, 5))
    val expected: Array[Int] = Array(2, 1, 4, 3, 5)
    actual.deep == expected.deep should be(right = true)
  }

  "functional swapping elements of Array(1, 2, 3, 4, 5)" should "be Array(2, 1, 4, 3, 5)" in {
    val actual: Array[Int] = functionalSwap(Array(1, 2, 3, 4, 5))
    val expected: Array[Int] = Array(2, 1, 4, 3, 5)
    actual.deep == expected.deep should be(right = true)
  }
}
