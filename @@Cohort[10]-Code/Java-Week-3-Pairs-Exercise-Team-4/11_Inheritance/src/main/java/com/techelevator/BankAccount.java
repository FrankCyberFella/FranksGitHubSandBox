package com.techelevator;

import java.math.BigDecimal;

public class BankAccount {
	
	private String accountNumber;
	private BigDecimal balance;
	
	public BankAccount() {
		balance = new BigDecimal("0.00");
		accountNumber = "unknown";
	}
	
	public BankAccount(String acctNum, BigDecimal bal) {
		accountNumber = acctNum;
		balance = bal;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	private void setBalance(BigDecimal balance) {
		this.balance = balance;
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
		
		System.out.println(accountNumber + " new balance is: " + this.balance.toString() +  "\n" + destinationAccount + " new balance is: " + destinationAccount.getBalance());
	}

}
