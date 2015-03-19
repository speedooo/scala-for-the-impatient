package scala4impatient

class Ch05Ex08_CarTheEasyWay(val manufacturer: String, val modelName: String, val modelYear: Int = -1, var licencePlate: String = "") {
  // NOP
}

class Ch05Ex08_CarTheHardWay() {
  private var _manufacturer: String = ""
  private var _modelName: String = ""
  private var _modelYear: Int = -1
  private var _licencePlate: String = ""

  def this(manufacturer: String, modelName: String) {
    this()
    _manufacturer = manufacturer
    _modelName = modelName
  }

  def this(manufacturer: String, modelName: String, modelYear: Int) {
    this(manufacturer, modelName)
    _modelYear = modelYear
  }

  def this(manufacturer: String, modelName: String, licencePlate: String) {
    this(manufacturer, modelName)
    _licencePlate = licencePlate
  }

  def this(manufacturer: String, modelName: String, modelYear: Int, licencePlate: String) {
    this(manufacturer, modelName, modelYear)
    _licencePlate = licencePlate
  }

  def manufacturer: String = _manufacturer
  def modelName: String = _modelName
  def modelYear: Int = _modelYear
  def licencePlate: String = _licencePlate

  def modelYear_=(modelYear: Int) { _modelYear = modelYear }
  def licencePlate_=(licencePlate: String) { _licencePlate = licencePlate }
}
