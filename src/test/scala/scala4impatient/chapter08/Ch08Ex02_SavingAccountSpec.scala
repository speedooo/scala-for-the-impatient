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

import org.scalatest.{ FlatSpec, Matchers }

object Ch08Ex02_SavingAccount {
  def apply(initialBalance: Double): Ch08Ex02_SavingAccount = {
    new Ch08Ex02_SavingAccount(initialBalance)
  }
}

class Ch08Ex02_SavingAccount(initialBalance: Double) extends Ch08Ex01_CheckingAccount(initialBalance) {
  private var transactionCount: Int = 0

  def earnMonthlyInterest(): Unit = {
    balance += 42d
    transactionCount = 0
  }

  override def deposit(amount: Double): Double = {
    if (transactionCount < 3) balance += amount
    else super.deposit(amount)
    transactionCount += 1
    balance
  }

  override def withdraw(amount: Double): Double = {
    if (transactionCount < 3) balance -= amount
    else super.withdraw(amount)
    transactionCount += 1
    balance
  }
}

class Ch08Ex02_SavingAccountSpec extends FlatSpec with Matchers {
  "saving account" should "help to save money" in {
    val account: Ch08Ex02_SavingAccount = Ch08Ex02_SavingAccount(50d)

    account.deposit(50d)
    account.balance should be(100d)

    account.withdraw(50d)
    account.balance should be(50d)

    account.withdraw(50d)
    account.balance should be(0d)

    account.deposit(50d)
    account.balance should be(49d)

    account.withdraw(50d)
    account.balance should be(-2d)

    account.earnMonthlyInterest()
    account.balance should be(40d)

    account.deposit(60d)
    account.balance should be(100d)

    account.withdraw(50d)
    account.balance should be(50d)
  }
}
