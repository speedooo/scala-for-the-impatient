package com.github.cbismuth.scala4impatient

object Ch02Ex01_SignumComputer {
  def signum(number: Double): Int = if (number > 0) 1 else if (number < 0) -1 else 0
}
