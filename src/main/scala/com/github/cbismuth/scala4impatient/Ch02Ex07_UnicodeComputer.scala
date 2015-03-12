package com.github.cbismuth.scala4impatient

object Ch02Ex07_UnicodeComputer {
  def unicodeProductWithoutLoop(s: String): Long = {
    var product: Long = 1
    s.foreach(product *= _)
    product
  }
}
