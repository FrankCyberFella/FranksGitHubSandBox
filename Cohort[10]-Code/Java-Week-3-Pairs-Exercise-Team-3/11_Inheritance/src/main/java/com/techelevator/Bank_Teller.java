package com.techelevator;

import java.math.BigDecimal;
import java.util.List;

public class Bank_Teller {

	public static void main(String[] args) {

	/****************************************************************************
	 * 
	 * Use this application program to test your classes.
	 * You should instantiate objects of your class using each of the ctors
	 * created for the class.
	 * 
	 * Use those objects to test each of the methods you have for a class.
	 * 
	 * (Hint: The exercise description has "Sample usage", feel free to use)
	 * 
	 * Consider adding a "show()" method to each class which will display the
	 * values in the data members of the object used to invoke it to make it
	 * easy to verify the processing of your methods
	 * 
	 ****************************************************************************
	 */

		BankAccount aBankAccount = new BankAccount();
		BankAccount anotherAcct = new BankAccount("031952", new BigDecimal("19.95"));
		
		BankAccount aCheckingAccount = new SimpleChecking();
		BankAccount anotherCheckAcct = new SimpleChecking("083112", new BigDecimal ("14.92"));
		BankAccount aSavingsAccount = new SavingsAccount();
		BankAccount anotherSaveAcct = new SavingsAccount("07041776", new BigDecimal ("17.89"));
		
		BigDecimal amountToDeposit = new BigDecimal ("1.00");
		BigDecimal newBalance = aCheckingAccount.deposit(amountToDeposit);
		
		System.out.println(newBalance);
		
		BigDecimal amountToTranser = new BigDecimal (".50");
		aCheckingAccount.transfer(aSavingsAccount, amountToTranser);
		
		aSavingsAccount.addInterest();
		
		
		BankAccount checkingAccount = new SimpleChecking(); 
		BankAccount savingsAccount = new SavingsAccount();
		BankCustomer jayGatsby = new BankCustomer(); 
		jayGatsby.addAccount(savingsAccount); 
		jayGatsby.addAccount(checkingAccount);
		System.out.println(String.format("Jay Gatsby has %s accounts.", jayGatsby.getAccounts().size()));
		
		List<BankAccount> accounts = jayGatsby.getAccounts();
		for(BankAccount account: accounts) {
			System.out.println(account.getBalance());
		}
		
		jayGatsby.showBankAccount();/// ShowBankAccount method created 
			
//		System.out.println(jayGatsby.getAccounts());
		
		
		
	}

}
