package scala4impatient
import org.scalatest.{ FlatSpec, Matchers }

import scala.collection._
import scala4impatient.Ch04Ex02_WordCount._
import scala.io.Source

object Ch04Ex02_WordCount {
  def wc(): Map[String, Int] = {
    val wc: mutable.Map[String, Int] = mutable.Map[String, Int]() withDefault (_ => 0)
    Source.fromFile("src/test/scala/scala4impatient/Ch04Ex02_WordCount.txt", "UTF-8")
      .mkString
      .toLowerCase
      .split("\\W+")
      .foreach(wc(_) += 1)
    wc
  }
}

class Ch04Ex02_WordCountSpec extends FlatSpec with Matchers {
  "word count" should "be as below" in {
    val count: Map[String, Int] = wc()
    count("fermentum") should be(41)
    count("tincidunt") should be(102)
    count("donec") should be(67)
  }
}
