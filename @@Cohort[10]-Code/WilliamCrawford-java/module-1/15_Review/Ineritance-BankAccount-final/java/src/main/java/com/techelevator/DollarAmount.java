package com.techelevator;

public class DollarAmount {
	//***********************************************************************************************************
    public static final DollarAmount ZERO_DOLLARS = new DollarAmount(0);
    //    static means Only-one and shared by all instances- an object of the class is not needed to access it
    //    final means it is a constant and cannot be changed 
    //allows us to reference a 0.00 balance instead of resetting it each time with "new"
    //***********************************************************************************************************
    private int totalAmountInCents;//encapsulated/protected by private access
    
    public DollarAmount(int totalAmountInCents) {//method receives one-int-parm and has no return
    											//same name as class and has no-return = contructor
        this.totalAmountInCents = totalAmountInCents;//intialize the member data to what was passed in
    }

    public DollarAmount(int dollars, int cents) {  //2-arg ctor- receives two ints
        totalAmountInCents = (dollars * 100) + cents; //initialize data member with values passed
    }
    
    public int getTotalAmountInCents() {
        return this.totalAmountInCents;
    }
    
    public int getCents() {
        return (int)(totalAmountInCents % 100);
    }
    
    public int getDollars() {
        return totalAmountInCents / 100;
    }
    
    public boolean isGreaterThan(DollarAmount amountToCompare) {
        return this.totalAmountInCents > amountToCompare.totalAmountInCents;
    }
    
    public boolean isGreaterThanOrEqualTo(DollarAmount amountToCompare) {
        return this.totalAmountInCents >= amountToCompare.totalAmountInCents;
    }
    
    public boolean isLessThan(DollarAmount amountToCompare) {
        return this.totalAmountInCents < amountToCompare.totalAmountInCents;
    }
    
    public boolean isLessThanOrEqualTo(DollarAmount amountToCompare) {
        return this.totalAmountInCents <= amountToCompare.totalAmountInCents;
    }
    
    public boolean isNegative() {
        return totalAmountInCents < 0;
    }
    
    public DollarAmount minus(DollarAmount amountToSubtract) {
        return new DollarAmount(this.totalAmountInCents - amountToSubtract.totalAmountInCents);
    }
    
    public DollarAmount plus(DollarAmount amountToAdd) {
        return new DollarAmount(this.totalAmountInCents + amountToAdd.totalAmountInCents);
    }

    public int compareTo(DollarAmount amountToCompare) {
        if(this.isGreaterThan(amountToCompare)) {
            return 1;
        } else if(this.isLessThan(amountToCompare)) {
            return -1;
        } else {
            return 0;
        }
    }
    // should always override equals, hashCode, and toString
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof DollarAmount) {
            return this.totalAmountInCents == ((DollarAmount)obj).totalAmountInCents;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
    	return totalAmountInCents;
    }
    
    @Override
    public String toString() {
        long absAmount = Math.abs(totalAmountInCents);
        StringBuilder str = new StringBuilder();
        if(totalAmountInCents < 0) {
                str.append("-");
        }
        str.append("$");
        if(absAmount >= 100) {
                str.append(absAmount / 100);
        } else {
                str.append("0");
        }
        str.append(".");
        if(absAmount % 100 < 10) {
                str.append("0");
        }
        str.append(absAmount % 100);
        return str.toString();
    }

}
