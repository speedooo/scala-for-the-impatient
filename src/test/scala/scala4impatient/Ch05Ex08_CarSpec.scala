package scala4impatient

import org.scalatest.{ FlatSpec, Matchers }

class Ch05Ex08_CarWithoutPrivateFields(
    // fields
    val manufacturer: String,
    val modelName: String,
    val modelYear: Int = -1,
    var licensePlate: String = "") {
}

class Ch05Ex08_CarWithPrivateFields() {
  private var _manufacturer: String = ""
  private var _modelName: String = ""
  private var _modelYear: Int = -1
  private var _licensePlate: String = ""

  def this(manufacturer: String, modelName: String) {
    this()
    _manufacturer = manufacturer
    _modelName = modelName
  }

  def this(manufacturer: String, modelName: String, modelYear: Int) {
    this(manufacturer, modelName)
    _modelYear = modelYear
  }

  def this(manufacturer: String, modelName: String, licensePlate: String) {
    this(manufacturer, modelName)
    _licensePlate = licensePlate
  }

  def this(manufacturer: String, modelName: String, modelYear: Int, licensePlate: String) {
    this(manufacturer, modelName, modelYear)
    _licensePlate = licensePlate
  }

  def manufacturer: String = _manufacturer

  def modelName: String = _modelName

  def modelYear: Int = _modelYear

  def licensePlate: String = _licensePlate

  def modelYear_=(modelYear: Int): Unit = {
    _modelYear = modelYear
  }

  def licensePlate_=(licensePlate: String): Unit = {
    _licensePlate = licensePlate
  }
}

class Ch05Ex08_CarSpec extends FlatSpec with Matchers {
  "cars" should "be built with optional arguments" in {
    val manufacturer: String = "Ford"
    val modelName: String = "Mustang Shelby GT500"
    val modelYear: Int = 1965
    val licensePlate: String = "123456789"

    var car1: Ch05Ex08_CarWithoutPrivateFields = null

    car1 = new Ch05Ex08_CarWithoutPrivateFields(manufacturer, modelName)
    car1.manufacturer should be(manufacturer)
    car1.modelName should be(modelName)
    car1.modelYear should be(-1)
    car1.licensePlate should be("")

    car1 = new Ch05Ex08_CarWithoutPrivateFields(manufacturer, modelName, modelYear)
    car1.manufacturer should be(manufacturer)
    car1.modelName should be(modelName)
    car1.modelYear should be(modelYear)
    car1.licensePlate should be("")

    car1 = new Ch05Ex08_CarWithoutPrivateFields(manufacturer, modelName, licensePlate = licensePlate)
    car1.manufacturer should be(manufacturer)
    car1.modelName should be(modelName)
    car1.modelYear should be(-1)
    car1.licensePlate should be(licensePlate)

    car1 = new Ch05Ex08_CarWithoutPrivateFields(manufacturer, modelName, modelYear, licensePlate)
    car1.manufacturer should be(manufacturer)
    car1.modelName should be(modelName)
    car1.modelYear should be(modelYear)
    car1.licensePlate should be(licensePlate)

    car1.licensePlate_=("987654321")
    car1.licensePlate should be("987654321")

    car1.licensePlate = "9876543210"
    car1.licensePlate should be("9876543210")

    var car2: Ch05Ex08_CarWithPrivateFields = null

    car2 = new Ch05Ex08_CarWithPrivateFields(manufacturer, modelName)
    car2.manufacturer should be(manufacturer)
    car2.modelName should be(modelName)
    car2.modelYear should be(-1)
    car2.licensePlate should be("")

    car2 = new Ch05Ex08_CarWithPrivateFields(manufacturer, modelName, modelYear)
    car2.manufacturer should be(manufacturer)
    car2.modelName should be(modelName)
    car2.modelYear should be(modelYear)
    car2.licensePlate should be("")

    car2 = new Ch05Ex08_CarWithPrivateFields(manufacturer, modelName, licensePlate = licensePlate)
    car2.manufacturer should be(manufacturer)
    car2.modelName should be(modelName)
    car2.modelYear should be(-1)
    car2.licensePlate should be(licensePlate)

    car2 = new Ch05Ex08_CarWithPrivateFields(manufacturer, modelName, modelYear, licensePlate)
    car2.manufacturer should be(manufacturer)
    car2.modelName should be(modelName)
    car2.modelYear should be(modelYear)
    car2.licensePlate should be(licensePlate)

    car2.licensePlate_=("987654321")
    car2.licensePlate should be("987654321")

    car2.licensePlate = "9876543210"
    car2.licensePlate should be("9876543210")
  }
}
