package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {
	
	private static BigDecimal interestRate = new BigDecimal("0.02");
	
	
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

	public SavingsAccount() {
		super();
	}
	
	public SavingsAccount(String acctNum, BigDecimal bal) {
		super(acctNum, bal);
	}

	

	
	@Override
	
	public String toString() {
		String acctInfo = "Acct#: " + getAccountNumber() + "\n";
		acctInfo += "Balance: " + getBalance();
		return acctInfo;
	}
	
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		
		BigDecimal currentBal = new BigDecimal("0.00");
		if (super.getBalance().doubleValue() < amountToWithdraw.doubleValue()) {
			return super.getBalance();
		}
		
		
		if (super.getBalance().doubleValue() < 150.00) {
			currentBal = amountToWithdraw.add(new BigDecimal("2.00"));
			currentBal = super.withdraw(currentBal);
			return currentBal;
		}
			
		return super.withdraw(amountToWithdraw);		
	}
	
	
	public BigDecimal addInterest() {
		BigDecimal currentBal = super.getBalance();
	//	BigDecimal withdraw = new BigDecimal("0.00");

		currentBal = this.interestRate.multiply(currentBal);
		currentBal = super.deposit(currentBal);
		//System.out.println(currentBal);
		
		
		
		return currentBal;
		
		
	}
}
