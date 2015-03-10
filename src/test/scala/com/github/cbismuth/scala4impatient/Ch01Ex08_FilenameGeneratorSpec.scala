package com.github.cbismuth.scala4impatient

import com.github.cbismuth.scala4impatient.Ch01Ex08_FilenameGenerator._
import org.scalatest.{ FlatSpec, Matchers }

class Ch01Ex08_FilenameGeneratorSpec extends FlatSpec with Matchers {
  "a valid filename" should "be generated using base 36" in {
    (generateFilename matches """[0-9a-zA-Z]+""") should be(right = true)
  }
}
