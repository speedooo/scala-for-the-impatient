package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting.quickSort
import scala4impatient.Ch03Ex06_ArrayReverseSortComputer._

object Ch03Ex06_ArrayReverseSortComputer {
  def reverseSortArrayBuffer(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    ArrayBuffer(reverseSortArray(a.toArray): _*)
  }

  def reverseSortArray(a: Array[Int]): Array[Int] = {
    val clone: Array[Int] = a.clone()
    quickSort(clone)
    ArrayBuffer(clone: _*).reverse.toArray
  }
}

class Ch03Ex06_ArrayReverseSortComputerSpec extends FlatSpec with Matchers {
  "reverse sorting elements of Array()" should "be Array()" in {
    val actual: ArrayBuffer[Int] = reverseSortArrayBuffer(ArrayBuffer())
    val expected: ArrayBuffer[Int] = ArrayBuffer()
    actual should be(expected)
  }

  "reverse sorting elements of Array(1)" should "be Array(1)" in {
    val actual: ArrayBuffer[Int] = reverseSortArrayBuffer(ArrayBuffer(1))
    val expected: ArrayBuffer[Int] = ArrayBuffer(1)
    actual should be(expected)
  }

  "reverse sorting elements of Array(1, -4, 3, -2)" should "be Array(3, 1, -2, -4)" in {
    val actual: ArrayBuffer[Int] = reverseSortArrayBuffer(ArrayBuffer(1, -4, 3, -2))
    val expected: ArrayBuffer[Int] = ArrayBuffer(3, 1, -2, -4)
    actual should be(expected)
  }

  "reverse sorting elements of Array(1, -4, 3, -2, 0)" should "be Array(3, 1, 0, -2, -4)" in {
    val actual: ArrayBuffer[Int] = reverseSortArrayBuffer(ArrayBuffer(1, -4, 3, -2, 0))
    val expected: ArrayBuffer[Int] = ArrayBuffer(3, 1, 0, -2, -4)
    actual should be(expected)
  }
}
