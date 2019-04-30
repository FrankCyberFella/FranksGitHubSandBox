package com.techelevator;

import java.math.BigDecimal;

public class BankAccount {

	private String accountNumber = "unknown";
	private BigDecimal balance = new BigDecimal("0.0");
	
	public BankAccount() {
		
	}

	public BankAccount(String accountNumber, BigDecimal balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String toString() {
		return "Acct. number " + accountNumber + " balance: " + balance;
	}

	public BigDecimal deposit(BigDecimal amountToDeposit) {
		this.balance = balance.add(amountToDeposit);
		return balance;
	}

	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		this.balance = balance.subtract(amountToWithdraw);
		return balance;
	}

	public BigDecimal transfer(BankAccount destinationAccount, BigDecimal transferAmount) {
		this.withdraw(transferAmount);
		destinationAccount.deposit(transferAmount);
		return balance;
	}

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

}