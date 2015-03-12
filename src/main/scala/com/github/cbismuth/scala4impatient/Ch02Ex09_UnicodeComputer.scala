package com.github.cbismuth.scala4impatient

object Ch02Ex09_UnicodeComputer {
  def product(s: String): Long = {
    if (s.length == 0) 0
    else if (s.length == 1) s(0).toInt
    else s.take(1)(0).toInt * product(s.drop(1))
  }
}
