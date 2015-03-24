/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package scala4impatient.chapter08

import org.scalatest.{ Matchers, FlatSpec }

object Ch08Ex01_BankAccount {
  def apply(initialBalance: Double): Ch08Ex01_BankAccount = {
    new Ch08Ex01_BankAccount(initialBalance)
  }
}

class Ch08Ex01_BankAccount(initialBalance: Double) {
  private var _balance: Double = initialBalance

  def balance: Double = _balance

  // see chapter 08 exercise 02
  protected def balance_=(balance: Double): Unit = {
    _balance = balance
  }

  def deposit(amount: Double): Double = {
    _balance += amount
    _balance
  }

  def withdraw(amount: Double): Double = {
    _balance -= amount
    _balance
  }
}

class Ch08Ex01_BankAccountSpec extends FlatSpec with Matchers {
  "bank account" should "be well balanced" in {
    val account: Ch08Ex01_BankAccount = Ch08Ex01_BankAccount(50d)
    account.deposit(50d)
    account.withdraw(50d)
    account.balance should be(50d)
  }
}

object Ch08Ex01_CheckingAccount {
  def apply(initialBalance: Double): Ch08Ex01_CheckingAccount = {
    new Ch08Ex01_CheckingAccount(initialBalance)
  }
}

class Ch08Ex01_CheckingAccount(initialBalance: Double) extends Ch08Ex01_BankAccount(initialBalance) {
  private var _fees: Double = .0

  override def deposit(amount: Double): Double = {
    super.deposit(amount - 1)
    _fees += 1
    balance
  }

  override def withdraw(amount: Double): Double = {
    super.withdraw(amount + 1)
    _fees += 1
    balance
  }
}

class Ch08Ex01_CheckingAccountSpec extends FlatSpec with Matchers {
  "bank account" should "not be well balanced" in {
    val account: Ch08Ex01_BankAccount = Ch08Ex01_CheckingAccount(50d)
    account.deposit(50d)
    account.withdraw(50d)
    account.balance should be(48d)
  }
}
