package com.techelevator;

import java.math.BigDecimal;

public class BankAccount {
	
	private String accountNumber;
	private BigDecimal balance;
	
	
	
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	private void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BankAccount() {
		balance = new BigDecimal("0.00");
		accountNumber = "unknown";
		}
	
	public BankAccount(String acctNum, BigDecimal bal) {
		accountNumber = acctNum;
		balance = bal;
		
	}
	public BigDecimal deposit(BigDecimal amountToDeposit) {
		 balance = balance.add(amountToDeposit);
		 this.setBalance(balance);
		 return balance;
		
	}
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		balance = balance.subtract(amountToWithdraw);
		this.setBalance(balance);
		return balance;
	}
	public void transfer(BankAccount destinationAccount, BigDecimal transferAmount) {
		this.balance = this.balance.subtract(transferAmount);
		destinationAccount.balance = destinationAccount.balance.add(transferAmount);
		
		
	}

}
