package com.techelevator;
import java.math.BigDecimal;
public class BankAccount {
	//data members---------------------------
	private String accountNumber = "unknown";
	private BigDecimal balance = new BigDecimal("0.00");
	//ctor----------------------------------
	public BankAccount() {
		
	}
	public BankAccount(String acctNum, BigDecimal bal) {
		balance=balance.add(bal);
		accountNumber = acctNum;
	}
	//getters and setters--------------------
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
	
	//methods--------------------------------
	public BigDecimal deposit(BigDecimal amountToDeposit) {
		balance=balance.add(amountToDeposit); 
		//System.out.println("depositing "+amountToDeposit);
		//System.out.println("new balance" + balance);
		return balance;
	}
	public BigDecimal withdraw (BigDecimal amountToWithdraw) {
		balance=balance.subtract(amountToWithdraw);
		return balance;
	}
	public void transfer(BankAccount destinationAccount, BigDecimal transferAmount) {
		destinationAccount.deposit(transferAmount);
		this.withdraw(transferAmount);
	}
}
