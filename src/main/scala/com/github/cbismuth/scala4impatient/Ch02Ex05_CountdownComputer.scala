package com.github.cbismuth.scala4impatient

object Ch02Ex05_CountdownComputer extends App {
  def countdown(n: Int) = {
    var sum: Int = 0
    for (i <- if (n > 0) (0 to n).reverse else n to 0) sum += i
    sum
  }
}
