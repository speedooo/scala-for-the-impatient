package com.github.cbismuth.scala4impatient

import java.lang.Math.abs

import scala.util.Random

object Ch01Ex08_FilenameGenerator {
  def generateFilename: String = BigInt(abs(Random.nextLong())).toString(36)
}
