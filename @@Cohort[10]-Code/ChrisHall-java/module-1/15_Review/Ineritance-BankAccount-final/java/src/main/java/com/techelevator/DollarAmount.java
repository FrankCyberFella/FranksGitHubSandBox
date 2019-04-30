package com.techelevator;

public class DollarAmount {

    public static final DollarAmount ZERO_DOLLARS = new DollarAmount(0); // establish a constant to represent a zero amount.
    
    private int totalAmountInCents;
    
    public DollarAmount(int totalAmountInCents) { // a method that receives one int parameter, has not return.
    // has same name as class and has no return -- is a constructor.
        this.totalAmountInCents = totalAmountInCents; // initialize member data to what was passed in
    }

    public DollarAmount(int dollars, int cents) {  // 2-arg constructor
        totalAmountInCents = (dollars * 100) + cents; // initialize member data (AKA instance data)
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
  // methods to allow people to compare objects of the class.  
    //  Need to do this, the alternative, they would have to write soemthing like 
    //  DollarAmt amt1 = new DollarAmt(100);
    //  DollarAmt amt2 = new DollarAmt(100);
    
    //  if (amt1.getTotalinCents()==amt2.getTotalAmtincents()0;
    // of  if(amt1.equals(amt2));
    
    //  >>>> lots of code to write  >>> easier to create methods for user, as below
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
// method used with a Java Comparator class:
    public int compareTo(DollarAmount amountToCompare) {
        if(this.isGreaterThan(amountToCompare)) {
            return 1; // return 1 uf furst us GT second
        } else if(this.isLessThan(amountToCompare)) {
            return -1; // return -1 if first is LT second
        } else {
            return 0; //return 0 if they are equal
        }
    }
   
    //  Object class overrides so we can perform common Java processing with our object
    // always override equals 
    //  always override toString, 
    
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
