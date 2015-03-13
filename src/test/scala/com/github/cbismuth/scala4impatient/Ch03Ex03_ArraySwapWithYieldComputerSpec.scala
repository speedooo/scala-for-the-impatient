package com.github.cbismuth.scala4impatient

import com.github.cbismuth.scala4impatient.Ch03Ex03_ArraySwapWithYieldComputer._
import org.scalatest.{ FlatSpec, Matchers }

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
    actual.foreach(println)
    actual.deep == expected.deep should be(right = true)
  }

  "swapping with yield elements of Array(1, 2, 3, 4, 5)" should "be Array(2, 1, 4, 3, 5)" in {
    val actual: Array[Int] = bubbleSwapWithYield(Array(1, 2, 3, 4, 5))
    val expected: Array[Int] = Array(2, 1, 4, 3, 5)
    actual.foreach(println)
    actual.deep == expected.deep should be(right = true)
  }
}
