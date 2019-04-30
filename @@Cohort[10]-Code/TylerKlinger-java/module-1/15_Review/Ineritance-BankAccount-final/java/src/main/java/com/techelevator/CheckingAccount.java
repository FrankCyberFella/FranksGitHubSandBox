package com.techelevator;

public class CheckingAccount extends BankAccount {//extends indicates inheritance, making CheckingAccount a subclass of BankAccount
													// BankAccount is the super class
													//inherits all data and methods of super class
													//we only provide any additional behavior/methods
													// no additional attributes / data
	
	//a subclass ctor must get the data required by the superclass and call/invoke the superclass cotr
	//super() - invokes the super class ctor
	public CheckingAccount(String accountHolder, String accountNumber, DollarAmount balance) {
        super(accountHolder, accountNumber, balance); // invokes the super class 3-argument ctor with data we received
    }

    public CheckingAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }
    
    //need to override super class withdraw method beause more needs to be done than what the method does on its own

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

