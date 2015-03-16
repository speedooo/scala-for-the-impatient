package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

import scala.collection.mutable.ArrayBuffer
import scala4impatient.Ch03Ex07_ArrayDuplicatesRemovalComputer._

object Ch03Ex07_ArrayDuplicatesRemovalComputer {
  def removeDuplicates(a: Array[Int]): Array[Int] = {
    var filtered: ArrayBuffer[Int] = ArrayBuffer()
    for (e <- a if !filtered.contains(e)) filtered += e
    filtered.toArray
  }

  def removeDuplicatesWithDistinct(a: Array[Int]): Array[Int] = a.distinct
}

class Ch03Ex07_ArrayDuplicatesRemovalComputerSpec extends FlatSpec with Matchers {
  "remove duplicate elements of Array()" should "be Array()" in {
    val actual: Array[Int] = removeDuplicates(Array())
    val expected: Array[Int] = Array()
    actual should be(expected)
  }

  "remove duplicate elements of Array(1)" should "be Array(1)" in {
    val actual: Array[Int] = removeDuplicates(Array(1))
    val expected: Array[Int] = Array(1)
    actual should be(expected)
  }

  "remove duplicate elements of Array(1, -4, 1, -2, 3, -2)" should "be Array(1, -4, -2, 3)" in {
    val actual: Array[Int] = removeDuplicates(Array(1, -4, 1, -2, 3, -2))
    val expected: Array[Int] = Array(1, -4, -2, 3)
    actual should be(expected)
  }

  "remove duplicate elements with distinct of Array()" should "be Array()" in {
    val actual: Array[Int] = removeDuplicatesWithDistinct(Array())
    val expected: Array[Int] = Array()
    actual should be(expected)
  }

  "remove duplicate elements with distinct of Array(1)" should "be Array(1)" in {
    val actual: Array[Int] = removeDuplicatesWithDistinct(Array(1))
    val expected: Array[Int] = Array(1)
    actual should be(expected)
  }

  "remove duplicate elements with distinct of Array(1, -4, 1, -2, 3, -2)" should "be Array(1, -4, -2, 3)" in {
    val actual: Array[Int] = removeDuplicatesWithDistinct(Array(1, -4, 1, -2, 3, -2))
    val expected: Array[Int] = Array(1, -4, -2, 3)
    actual should be(expected)
  }
}
