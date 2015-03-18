package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

import scala.collection._
import scala.io.Source
import scala4impatient.Ch04Ex05_WordCountWithTreeMap._

import scala.collection.JavaConversions.mapAsScalaMap

object Ch04Ex05_WordCountWithTreeMap {
  def wcWithGetOrElse(): Map[String, Int] = {
    var wc: mutable.Map[String, Int] = new java.util.TreeMap[String, Int]()
    Source.fromFile("src/test/scala/scala4impatient/Ch04Ex02_WordCount.txt", "UTF-8")
      .mkString
      .toLowerCase
      .split("\\W+")
      .foreach(e => wc = wc + (e -> (wc.getOrElse(e, 0) + 1)))
    wc
  }

}

class Ch04Ex05_WordCountWithTreeMapSpec extends FlatSpec with Matchers {
  "word count with tree map" should "be as below" in {
    val count: Map[String, Int] = wcWithGetOrElse()
    count("fermentum") should be(41)
    count("tincidunt") should be(102)
    count("donec") should be(67)
  }
}
