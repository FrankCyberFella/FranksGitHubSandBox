package com.techelevator.model;

import java.time.LocalDate;

public class Transaction {

	private LocalDate transactionDate;
	private String description;
	private DollarAmount amount;

	public Transaction(LocalDate transactionDate, String description, DollarAmount amount) {
		this.transactionDate = transactionDate;
		this.description = description;
		this.amount = amount;
	}
	
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public String getDescription() {
		return description;
	}
	public DollarAmount getAmount() {
		return amount;
	}
}
