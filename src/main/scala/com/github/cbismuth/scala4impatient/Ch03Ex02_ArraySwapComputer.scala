package com.github.cbismuth.scala4impatient

object Ch03Ex02_ArraySwapComputer {
  def swap(a: Array[Int]): Array[Int] = {
    a.grouped(2).flatMap {
      case Array(x, y) => Array(y, x)
      case Array(x)    => Array(x)
    }.toArray
  }
}
