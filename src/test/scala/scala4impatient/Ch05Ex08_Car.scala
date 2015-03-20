package scala4impatient

class Ch05Ex08_CarTheEasyWay(val manufacturer: String, val modelName: String, val modelYear: Int = -1, var licensePlate: String = "") {
  // NOP
}

class Ch05Ex08_CarTheHardWay() {
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

  def modelYear_=(modelYear: Int): Unit = { _modelYear = modelYear }
  def licensePlate_=(licensePlate: String): Unit = { _licensePlate = licensePlate }
}
