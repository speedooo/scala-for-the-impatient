package com.github.cbismuth.scala4impatient

object Ch03Ex03_ArraySwapWithYieldComputer {
  def bubbleSwapWithYield(a: Array[Int]): Array[Int] = (for (i <- 0 until a.length) yield {
    if (i % 2 == 0 && i + 1 < a.length) a(i + 1)
    else if (i % 2 != 0 && i - 1 > -1) a(i - 1)
    else a(i)
  }).toArray
}
