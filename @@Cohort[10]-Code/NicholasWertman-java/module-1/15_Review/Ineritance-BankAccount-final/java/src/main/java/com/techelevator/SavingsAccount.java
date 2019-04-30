package com.techelevator;

public class SavingsAccount extends BankAccount implements InterestAccount {
	
    public SavingsAccount(String accountHolder, String accountNumber, DollarAmount balance) {
        super(accountHolder, accountNumber, balance);
    }

    public SavingsAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    @Override
    public DollarAmount withdraw(DollarAmount amountToWithdraw) {
        // only perform transaction of positive $
        if (!getBalance().minus(amountToWithdraw).isNegative()) {
            super.withdraw(amountToWithdraw);
            // Assess $2 fee if it goes below $150
            if (getBalance().getDollars() < 150) {
                super.withdraw(new DollarAmount(200));
            }                
        }
        return getBalance();
    }

	/* (non-Javadoc)
	 * @see com.techelevator.InterestAccount#addInterest()
	 */
	@Override
	public DollarAmount addInterest() {
		double interest = 0.00;	//initialize to 0
		//multiply the balance in the the account by the interest rate
		
		interest = super.getBalance().getTotalAmountInCents() * intRate;
		// update the balance with interest (add interest to balance)
		
		super.deposit(new DollarAmount((int)interest));
		// return the new balance
		return super.getBalance();
	}
    
}
