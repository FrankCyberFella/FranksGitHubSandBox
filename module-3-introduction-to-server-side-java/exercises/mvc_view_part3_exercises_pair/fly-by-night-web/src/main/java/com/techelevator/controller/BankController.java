package com.techelevator.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.BankAccount;
import com.techelevator.model.DollarAmount;
import com.techelevator.model.Transaction;

@Controller 
public class BankController {

	private static List<BankAccount> bankAccounts = getBankAccounts();
	
	@RequestMapping("/")
	public String displayHomePage() {
		return "homePage";
	}
	
	@RequestMapping("/accountList")
	public String displayAccountList(HttpServletRequest request) {
		request.setAttribute("accounts", bankAccounts);
		return "accountList";
	}
	
	@RequestMapping("/accountDetail")
	public String displayAccountDetail(HttpServletRequest request) {
		Long id = Long.valueOf(request.getParameter("accountId"));
		request.setAttribute("account", getAccountById(id));
		return "accountDetail";
	}
	
	private BankAccount getAccountById(Long id) {
		BankAccount result = null;
		for(BankAccount account : bankAccounts) {
			if(id.equals(account.getId())) {
				result = account;
			}
		}
		return result;
	}

	private static List<BankAccount> getBankAccounts() {
		ArrayList<BankAccount> accounts = new ArrayList<>();
		
		BankAccount account = new BankAccount("Interest Free Checking", "12345678", "Checking");
		account.deposit(new DollarAmount(430023));
		account.addTransaction(new Transaction(LocalDate.of(2016, 6, 10), "Starbucks", new DollarAmount(-623)));
		account.addTransaction(new Transaction(LocalDate.of(2016, 6, 12), "Microcenter", new DollarAmount(-1210)));
		account.addTransaction(new Transaction(LocalDate.of(2016, 6, 13), "Costco", new DollarAmount(-13203)));
		account.addTransaction(new Transaction(LocalDate.of(2016, 6, 15), "Ty Phun", new DollarAmount(-2523)));
		account.addTransaction(new Transaction(LocalDate.of(2016, 6, 15), "Payroll", new DollarAmount(125323)));
		accounts.add(account);
		
		account = new BankAccount("Save-A-Lot Savings", "98765432", "Savings");
		account.deposit(new DollarAmount(1213201));
		account.addTransaction(new Transaction(LocalDate.of(2016, 3, 10), "Transfer", new DollarAmount(-1623)));
		account.addTransaction(new Transaction(LocalDate.of(2016, 4, 12), "Deposit", new DollarAmount(1610)));
		account.addTransaction(new Transaction(LocalDate.of(2016, 5, 13), "Costco", new DollarAmount(-12203)));
		account.addTransaction(new Transaction(LocalDate.of(2016, 6, 15), "Transfer", new DollarAmount(122323)));
		accounts.add(account);
		
		account = new BankAccount("High-Interest Savings", "45698712", "Savings");
		account.deposit(new DollarAmount(3299));
		account.addTransaction(new Transaction(LocalDate.of(2016, 6, 11), "Deposit", new DollarAmount(10003)));
		account.addTransaction(new Transaction(LocalDate.of(2016, 6, 12), "Transfer", new DollarAmount(-6723)));
		accounts.add(account);
		
		account = new BankAccount("Priority Checking", "12349999", "Checking");
		account.deposit(new DollarAmount(50010));
		account.addTransaction(new Transaction(LocalDate.of(2016, 6, 11), "Deposit", new DollarAmount(130003)));
		account.addTransaction(new Transaction(LocalDate.of(2016, 6, 12), "Deposit", new DollarAmount(16723)));
		account.addTransaction(new Transaction(LocalDate.of(2016, 6, 12), "Amazon.com", new DollarAmount(-26723)));
		account.addTransaction(new Transaction(LocalDate.of(2016, 6, 12), "Redbox", new DollarAmount(-623)));
		account.addTransaction(new Transaction(LocalDate.of(2016, 6, 12), "Starbucks", new DollarAmount(-723)));
		account.addTransaction(new Transaction(LocalDate.of(2016, 6, 12), "Gas Bill", new DollarAmount(-16723)));
		accounts.add(account);
		
		return accounts;
	}
}
