package com.techelevator;

public class CheckingAccount extends BankAccount {

	
	//no additional attributes / data
	
		// a subclass ctor must get data required by the superclass and call/invoke the super class ctor
	public CheckingAccount(String accountHolder, String accountNumber, DollarAmount balance) { //extends means this is a superclass of BankAccout
        super(accountHolder, accountNumber, balance);										// BankAccount is a superclass
        																					//  inherit all data and methods of the superclass
    }
	

    public CheckingAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    @Override
    public DollarAmount withdraw(DollarAmount amountToWithdraw) {
        // Only allow the withdraw if the balance isn't going to go below -$100
        if (getBalance().minus(amountToWithdraw).getDollars() > -100) {
            // Withdraw the $$
            super.withdraw(amountToWithdraw);
            // If the balance dips below 0, assess $10 charge
            if (getBalance().isNegative()) {
                super.withdraw(new DollarAmount(10, 00));
            }
        }
        return getBalance();            
    }
}

