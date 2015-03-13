package com.github.cbismuth.scala4impatient

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
