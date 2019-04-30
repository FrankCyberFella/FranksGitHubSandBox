package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {

	public CheckingAccount(String accountNumber, BigDecimal balance) {
		super(accountNumber, balance);
		//this.accountNumber = accountNumber;
		 //this.balance = balance;

	}

	//public CheckingAccount() {
		// TODO Auto-generated constructor stub
	//}

	public BigDecimal withdraw(BigDecimal amountToWithdraw) {

		if ((super.getBalance().doubleValue() - amountToWithdraw.doubleValue()) < -100.00) {
			return super.getBalance();
		} else if (super.getBalance().doubleValue() - amountToWithdraw.doubleValue() < 0) {
			return super.withdraw(amountToWithdraw.add(new BigDecimal("10.00")));
		}
		return super.withdraw(amountToWithdraw);

	}

}
