package scala4impatient

import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection._

object Ch04Ex07_SystemPropertiesPrinterApp extends App {
  val props: Map[String, String] = System.getProperties
  var max: Int = 0
  // reduce style
  max = props
    .keys
    .reduceLeft((x, y) => if (x.length > y.length) x else y)
    .length
  // map style
  max = props
    .keys
    .map(_.length)
    .max
  props
    .toMap
    .transform((k, v) => Tuple3(k, v, max - k.length))
    .values
    .toList
    .foreach(t => println("%s%s | %s".format(t._1, " " * t._3, t._2)))
}
