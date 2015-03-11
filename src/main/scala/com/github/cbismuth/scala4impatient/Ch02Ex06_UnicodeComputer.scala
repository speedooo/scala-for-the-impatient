package com.github.cbismuth.scala4impatient

object Ch02Ex06_UnicodeComputer {
  def unicodeProduct(s: String): Long = {
    var sum: Long = 1
    for (c <- s) {
      sum *= c.toInt
    }
    sum
  }
}
