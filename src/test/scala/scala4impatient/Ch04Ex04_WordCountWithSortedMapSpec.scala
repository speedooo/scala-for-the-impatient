package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

import scala.collection._
import scala.io.Source
import scala4impatient.Ch04Ex04_WordCountWithSortedMap._

object Ch04Ex04_WordCountWithSortedMap {
  def wc(): Map[String, Int] = {
    var wc: immutable.Map[String, Int] = immutable.SortedMap[String, Int]()
    Source.fromFile("src/test/scala/scala4impatient/Ch04Ex02_WordCount.txt", "UTF-8")
      .mkString
      .toLowerCase
      .split("\\W+")
      .foreach(e => wc = wc + (e -> (wc.getOrElse(e, 0) + 1)))
    wc
  }
}

class Ch04Ex04_WordCountWithSortedMapSpec extends FlatSpec with Matchers {
  "word count with sorted map" should "be as below" in {
    val count: Map[String, Int] = wc()
    count("fermentum") should be(41)
    count("tincidunt") should be(102)
    count("donec") should be(67)
  }
}
