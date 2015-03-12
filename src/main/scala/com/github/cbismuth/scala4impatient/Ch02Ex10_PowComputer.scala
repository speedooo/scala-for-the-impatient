package com.github.cbismuth.scala4impatient

object Ch02Ex10_PowComputer {
  def pow(x: Double, n: Int): Double = {
    if (n > 0 && n % 2 == 0) pow(x, n / 2) * pow(x, n / 2)
    else if (n > 0) x * pow(x, n - 1)
    else if (n == 0) 1
    else 1 / pow(x, -n)
  }
}
