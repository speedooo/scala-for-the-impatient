package com.github.cbismuth.scala4impatient

import com.github.cbismuth.scala4impatient.Ch03Ex02_ArraySwapComputer._
import org.scalatest.{ FlatSpec, Matchers }

class Ch03Ex02_ArraySwapComputerSpec extends FlatSpec with Matchers {
  "swapping elements of Array(1, 2, 3, 4, 5)" should "be Array(2, 1, 4, 3, 5)" in {
    val actual: Array[Int] = swap(Array(1, 2, 3, 4, 5))
    val expected: Array[Int] = Array(2, 1, 4, 3, 5)
    actual.deep == expected.deep should be(right = true)
  }
}
