package com.techelevator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class BankAccount {

	private static AtomicLong idSequence = new AtomicLong(1);
	private Long id;
	private String name;
	private String accountNumber;
	private String accountType;
	private DollarAmount balance;
	private List<Transaction> transactionHistory;
	
	public BankAccount(String name, String accountNumber, String accountType) {
		this.id = idSequence.getAndIncrement();
		this.name = name;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		balance = new DollarAmount(0);
		transactionHistory = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public DollarAmount getBalance() {
		return balance;
	}

	public List<Transaction> getTransactionHistory() {
		return Collections.unmodifiableList(transactionHistory);
	}
	
	public void deposit(DollarAmount depositAmount) {
		balance = balance.plus(depositAmount);
	}

	public void withdraw(DollarAmount withdrawalAmount) {
		balance = balance.minus(withdrawalAmount);
	}
	
	public void addTransaction(Transaction transaction) {
		transactionHistory.add(transaction);
	}
}
