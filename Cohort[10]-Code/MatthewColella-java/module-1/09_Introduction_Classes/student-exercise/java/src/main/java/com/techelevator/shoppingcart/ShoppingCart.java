package com.techelevator.shoppingcart;

public class ShoppingCart {
	
int totalNumberOfItems = 0;
double totalAmountOwed = 0.0;

public double getAveragePricePerItem() {
	if(totalAmountOwed == 0.0) {
		return 0.0;
	}
	return totalAmountOwed / (double)totalNumberOfItems;
}
public void addItems(int numberOfItems, double pricePerItem) {
	totalNumberOfItems += numberOfItems;
	totalAmountOwed = totalAmountOwed + ((double)numberOfItems * pricePerItem);
}
public void empty() {
	totalNumberOfItems = 0;
	totalAmountOwed = 0.0;
	
}
	//
	// Write code here
	//
public int getTotalNumberOfItems() {
	return totalNumberOfItems;
}
public void setTotalNumberOfItems(int totalNumberOfItems) {
	this.totalNumberOfItems = totalNumberOfItems;
}
public double getTotalAmountOwed() {
	return totalAmountOwed;
}
public void setTotalAmountOwed(double totalAmountOwed) {
	this.totalAmountOwed = totalAmountOwed;
}
	
}
