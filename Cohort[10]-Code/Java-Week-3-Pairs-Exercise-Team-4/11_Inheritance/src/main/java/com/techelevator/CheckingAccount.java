package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {

	public CheckingAccount() {
		super();
	}
	
	public CheckingAccount(String acctNum, BigDecimal bal) {
		super(acctNum, bal);
	}
	
	@Override
	
	public String toString() {
		String acctInfo = "Acct#: " + this.getAccountNumber() + "\n";
		acctInfo += "Balance: " + this.getBalance();
		return acctInfo;
	}
	
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		
		BigDecimal currentBalance = this.getBalance();

		
	if (currentBalance.subtract(amountToWithdraw).doubleValue() < -90) { // does penalty count for this -100
			System.out.println(currentBalance);
			return currentBalance;
		}
		if (currentBalance.subtract(amountToWithdraw).doubleValue() < 0) {
			currentBalance = super.withdraw(amountToWithdraw.add(new BigDecimal("10.00")));
			return currentBalance;
		} 
		currentBalance = super.withdraw(amountToWithdraw);
		return currentBalance;
	} 
	
}
