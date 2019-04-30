package com.techelevator.shoppingcart;

public class ShoppingCart {

private int totalNumberOfItems = 0;
private double totalAmountOwed = 0.0;
	//
	// Write code here
	//
/**
 * @return the totalNumberOfItems
 */
public int getTotalNumberOfItems() {
	return totalNumberOfItems;
}
/**
 * @param totalNumberOfItems the totalNumberOfItems to set
 */
public void setTotalNumberOfItems(int totalNumberOfItems) {
	this.totalNumberOfItems = totalNumberOfItems;
}
/**
 * @return the totalAmountOwed
 */
public double getTotalAmountOwed() {
	return totalAmountOwed;
}
/**
 * @param totalAmountOwed the totalAmountOwed to set
 */
public void setTotalAmountOwed(double totalAmountOwed) {
	this.totalAmountOwed = totalAmountOwed;
}
	
public double getAveragePricePerItem() { 
	if (totalNumberOfItems == 0) {
		return 0;
	}
	return totalAmountOwed / totalNumberOfItems; 
}

public void addItems (int numberOfItems, double pricePerItem) {
	totalNumberOfItems += numberOfItems;
	totalAmountOwed = pricePerItem * numberOfItems + totalAmountOwed; 
}

public void empty() {
	totalNumberOfItems = 0;
	totalAmountOwed = 0.0;
	
	
}

}