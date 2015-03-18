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
    val expected: Array[String] = Array(
      "image/jpeg",
      "image/png",
      "image/x-png",
      "image/gif",
      "PNG",
      "JFIF"
    )
    quickSort(actual)
    quickSort(expected)
    actual.deep == expected.deep should be(right = true)
  }
}
