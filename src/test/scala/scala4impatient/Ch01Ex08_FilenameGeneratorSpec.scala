package scala4impatient

import java.lang.Math._

import scala4impatient.Ch01Ex08_FilenameGenerator._
import org.scalatest.{ FlatSpec, Matchers }

import scala.util.Random

object Ch01Ex08_FilenameGenerator {
  def generateFilename: String = BigInt(abs(Random.nextLong())).toString(36)
}

class Ch01Ex08_FilenameGeneratorSpec extends FlatSpec with Matchers {
  "a valid filename" should "be generated using base 36" in {
    (generateFilename matches """[0-9a-zA-Z]+""") should be(right = true)
  }
}
