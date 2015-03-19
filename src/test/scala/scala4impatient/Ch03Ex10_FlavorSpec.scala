package scala4impatient

import java.awt.datatransfer.DataFlavor.imageFlavor
import java.awt.datatransfer.SystemFlavorMap
import java.awt.datatransfer.SystemFlavorMap.getDefaultFlavorMap

import org.scalatest.{ FlatSpec, Matchers }

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable
import scala.util.Sorting.quickSort
import scala4impatient.Ch03Ex10_Flavor._

object Ch03Ex10_Flavor {
  def nativesForFlavor(): mutable.Buffer[String] = {
    getDefaultFlavorMap
      .asInstanceOf[SystemFlavorMap]
      .getNativesForFlavor(imageFlavor)
  }
}

class Ch03Ex10_FlavorSpec extends FlatSpec with Matchers {
  "native image flavor identifiers" should "be listed below" in {
    val actual: Array[String] = nativesForFlavor().toArray
    var expected: Array[String] = Array()
    if (System.getProperty("os.name").contains("Linux")) {
      expected = Array(
        "image/jpeg",
        "image/png",
        "image/x-png",
        "image/gif",
        "PNG",
        "JFIF"
      )
    } else if (System.getProperty("os.name").contains("Mac")) {
      expected = Array(
        "PNG",
        "JFIF",
        "TIFF"
      )
    }
    quickSort(actual)
    quickSort(expected)
    println(System.getProperty("os.name"))
    actual.foreach(println)
    actual.deep == expected.deep should be(right = true)
  }
}
