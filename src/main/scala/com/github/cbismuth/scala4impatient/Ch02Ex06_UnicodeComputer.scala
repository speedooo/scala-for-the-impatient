package com.github.cbismuth.scala4impatient

object Ch02Ex06_UnicodeComputer {
  def unicodeProduct(s: String): Long = {
    var product: Long = 1
    for (c <- s) {
      product *= c.toInt
    }
    product
  }
}
