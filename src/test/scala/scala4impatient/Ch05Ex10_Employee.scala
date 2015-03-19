package scala4impatient

class Ch05Ex10_Employee {
  private var _name: String = "John Q. Public"
  var salary: Double = .0

  def this(name: String) {
    this()
    _name = name
  }

  def name: String = _name
}
