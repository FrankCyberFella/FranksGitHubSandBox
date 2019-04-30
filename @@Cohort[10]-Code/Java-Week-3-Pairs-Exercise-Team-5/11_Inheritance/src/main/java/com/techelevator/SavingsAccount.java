package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {

	private static BigDecimal interestRate = new BigDecimal(".02");

	public SavingsAccount(String accountNumber, BigDecimal balance) {
		super(accountNumber, balance);
	}

	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		if (amountToWithdraw.doubleValue() > super.getBalance().doubleValue()) {
			return super.getBalance();
		} else if (super.getBalance().doubleValue() < 150.00) {
			return super.withdraw(amountToWithdraw.add(new BigDecimal("2.00")));
		}
		return super.withdraw(amountToWithdraw);

	}

	public BigDecimal addInterest() {
		return super.deposit(super.getBalance().multiply(interestRate));
	}

	/**
	 * @return the interestRate
	 */
	public static BigDecimal getInterestRate() {
		return interestRate;
	}

	/**
	 * @param interestRate the interestRate to set
	 */
	private static void setInterestRate(BigDecimal interestRate) {
		SavingsAccount.interestRate = interestRate;
	}

}
