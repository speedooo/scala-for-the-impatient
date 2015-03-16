package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

import scala.collection.immutable.IndexedSeq
import scala.collection.mutable.ArrayBuffer
import scala4impatient.Ch03Ex08_TransformArrayComputer._

object Ch03Ex08_TransformArrayComputer {
  def transform(a: Array[Int]): Array[Int] = {
    if (a.length > 0) {
      val b: ArrayBuffer[Int] = ArrayBuffer(a.clone(): _*)
      val range: IndexedSeq[Int] = for (i <- 0 until b.length if b(i) < 0) yield i
      for (k <- range.reverse.dropRight(1) if k < b.length) {
        b.remove(k)
      }
      b.toArray
    } else a
  }
}

class Ch03Ex08_TransformArrayComputerSpec extends FlatSpec with Matchers {
  "remove duplicate elements of Array()" should "be Array()" in {
    val actual: Array[Int] = transform(Array())
    val expected: Array[Int] = Array()
    actual should be(expected)
  }

  "remove duplicate elements of Array(1)" should "be Array(1)" in {
    val actual: Array[Int] = transform(Array(1))
    val expected: Array[Int] = Array(1)
    actual should be(expected)
  }

  "remove duplicate elements of Array(1, 2, 3, 4, 5)" should "be Array(1, 2, 3, 4, 5)" in {
    val actual: Array[Int] = transform(Array(1, 2, 3, 4, 5))
    val expected: Array[Int] = Array(1, 2, 3, 4, 5)
    actual should be(expected)
  }

  "remove duplicate elements of Array(1, -4, 1, -2, 3, -2)" should "be Array(1, -4, 1, 3)" in {
    // Array(1, -4, 1, -2, 3, -2)
    // Array(1, 3, 5)
    // Array(5, 3, 1)
    // Array(5, 3)
    // Array(1, -4, 1, -2, 3)
    // Array(1, -4, 1, 3)
    val actual: Array[Int] = transform(Array(1, -4, 1, -2, 3, -2))
    val expected: Array[Int] = Array(1, -4, 1, 3)
    actual should be(expected)
  }
}
