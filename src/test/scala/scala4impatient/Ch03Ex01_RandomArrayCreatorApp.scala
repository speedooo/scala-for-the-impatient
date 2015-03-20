package scala4impatient

import scala.util.Random

object Ch03Ex01_RandomArrayCreatorApp extends App {
  printArray(createRandomArrayWithoutYield(10))
  printArray(createRandomArrayWithYield(10))

  def createRandomArrayWithoutYield(n: Int): Array[Int] = {
    val a: Array[Int] = new Array[Int](n)
    var i: Int = 0
    while (i < a.length) {
      a(i) = Random.nextInt(n)
      i += 1
    }
    a
  }

  def createRandomArrayWithYield(n: Int): Array[Int] = {
    (for (i <- 0 until n) yield Random.nextInt(n)).toArray
  }

  def printArray(a: Array[Int]): Unit = {
    a foreach (println(_))
  }
}
