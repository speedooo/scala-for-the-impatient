package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

import scala.collection._
import scala.collection.mutable.ArrayBuffer
import scala4impatient.Ch04Ex03_WordCountWithImmutableMap._
import scala.io.Source

object Ch04Ex03_WordCountWithImmutableMap {
  def wcWithZip(): Map[String, Int] = {
    val all: Array[String] = Source.fromFile("src/test/scala/scala4impatient/Ch04Ex02_WordCount.txt", "UTF-8")
      .mkString
      .toLowerCase
      .split("\\W+")
    val words: ArrayBuffer[String] = ArrayBuffer[String]()
    val count: ArrayBuffer[Int] = ArrayBuffer[Int]()
    var i: Int = 0
    for (e <- all) {
      if (!words.contains(e)) {
        words.insert(i, e)
        count.insert(i, 1)
        i += 1
      } else {
        count(words.indexOf(e)) += 1
      }
    }
    words.zip(count).toMap
  }

  def wcWithGetOrElse(): Map[String, Int] = {
    var wc: immutable.Map[String, Int] = immutable.Map[String, Int]()
    Source.fromFile("src/test/scala/scala4impatient/Ch04Ex02_WordCount.txt", "UTF-8")
      .mkString
      .toLowerCase
      .split("\\W+")
      .foreach(e => wc = wc + (e -> (wc.getOrElse(e, 0) + 1)))
    wc
  }
}

class Ch04Ex03_WordCountWithImmutableMapSpec extends FlatSpec with Matchers {
  "word count with zip" should "be as below" in {
    val count: Map[String, Int] = wcWithZip()
    count("fermentum") should be(41)
    count("tincidunt") should be(102)
    count("donec") should be(67)
  }

  "word count with get or else" should "be as below" in {
    val count: Map[String, Int] = wcWithGetOrElse()
    count("fermentum") should be(41)
    count("tincidunt") should be(102)
    count("donec") should be(67)
  }
}
