package scala4impatient

object Ch05Ex02_BankAccount {
  def apply(): Ch05Ex02_BankAccount = {
    new Ch05Ex02_BankAccount()
  }

  def apply(amount: Double): Ch05Ex02_BankAccount = {
    new Ch05Ex02_BankAccount(amount)
  }
}

class Ch05Ex02_BankAccount() {
  private var _balance: Double = .0

  def this(amount: Double) {
    this()
    _balance = amount
  }

  def balance: Double = _balance

  def deposit(amount: Double): Unit = {
    _balance += amount
  }

  def withdraw(amount: Double): Unit = {
    _balance -= amount
  }
}
