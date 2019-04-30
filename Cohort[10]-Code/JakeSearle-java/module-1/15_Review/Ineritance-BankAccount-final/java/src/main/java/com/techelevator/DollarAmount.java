package com.techelevator;

public class DollarAmount {

    public static final DollarAmount ZERO_DOLLARS = new DollarAmount(0);
    //*************************************************************************************
    //member data - instance data - each instance of the class gets one copy of this data
    //*************************************************************************************
    
    private int totalAmountInCents;
    
    public DollarAmount(int totalAmountInCents) {       // method that receives one-int-param, and has no return.
        this.totalAmountInCents = totalAmountInCents;   // same name as class, no return makes it a ctor. ctor is still a
    }                                                   // method. () indicates its a method. Same name as class & no return
                                                        // means it is a constructor. Constructors never have returns. Meths. do.
    													// initializes member data to what was passed. 
    
    
    
    public DollarAmount(int dollars, int cents) {       // 2 argument ctor. Receives two ints. initializes data member.
        totalAmountInCents = (dollars * 100) + cents;
    }
    
    public int getTotalAmountInCents() {                // this is a member function. Getter. 
        return this.totalAmountInCents;
    }
    
    public int getCents() {
        return (int)(totalAmountInCents % 100);
    }
    
    public int getDollars() {
        return totalAmountInCents / 100;
    }
    
    public boolean isGreaterThan(DollarAmount amountToCompare) {                // these are methods to compare objects of the class
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
    
    public boolean isNegative() {                    // method to ask if value is negative
        return totalAmountInCents < 0;
    }
    
    public DollarAmount minus(DollarAmount amountToSubtract) {                        // methods to do simple math
        return new DollarAmount(this.totalAmountInCents - amountToSubtract.totalAmountInCents);
    }
    
    public DollarAmount plus(DollarAmount amountToAdd) {
        return new DollarAmount(this.totalAmountInCents + amountToAdd.totalAmountInCents);
    }

    public int compareTo(DollarAmount amountToCompare) {  // this method is used with a Java Comparator class
        if(this.isGreaterThan(amountToCompare)) {
            return 1;                                     // return 1 if first is greater than second
        } else if(this.isLessThan(amountToCompare)) {
            return -1;                                    // return -1 if first is less than second
        } else {
            return 0;                                     // return 0 if amounts are equal 
        }
    }
    
    @Override
    public boolean equals(Object obj) {                                                 // object class overrides so we can perform
        if(obj != null && obj instanceof DollarAmount) {                                // common Java  processing with our object 
            return this.totalAmountInCents == ((DollarAmount)obj).totalAmountInCents;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
    	return totalAmountInCents;
    }
                                                         //ALWAYS OVERRIDE EQUALS, HASHCODE, AND TOSTRING
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
