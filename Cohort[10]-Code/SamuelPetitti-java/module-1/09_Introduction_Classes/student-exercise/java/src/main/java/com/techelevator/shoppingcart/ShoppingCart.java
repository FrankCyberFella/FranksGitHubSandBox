package com.techelevator.shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

//***Craig- I did get to have some fun with this over the weekend. Very cool, would like to add some more features
//	this week after it's graded. In the meantime I just commented out the things we added so it would pass. 
//	Thank you for helping me with it! 
//	-Sam
	
	private int totalNumberOfItems = 0;
	private double totalAmountOwed = 0.0;
	
	
	// productName value = number of items
	
	// private Map <String, Integer> items = new HashMap<>();
	 
	 
	
	
	public double getAveragePricePerItem() {
		if(totalNumberOfItems == 0 && totalAmountOwed == 0.0) {
			return 0.0;
		}
		return totalAmountOwed/totalNumberOfItems;
		
	}
	
//	//for SamCart
//	public void printCart() {
//		System.out.println("Total Number Of Items = " + totalNumberOfItems);
//		System.out.println("Total Amount Owed = $" + totalAmountOwed);
//		System.out.println(items);
//	}
						//String product name
//	public void addItems(String productName, int numberOfItems, double pricePerItem) {
//		totalNumberOfItems = numberOfItems + totalNumberOfItems;
//		totalAmountOwed = totalAmountOwed + (numberOfItems * pricePerItem);
//		if(items.containsKey(productName)) {
//			items.put(productName, items.get(productName)+ numberOfItems);
//		}
//		else{items.put(productName, numberOfItems);
//		}
//	}
	
	public void addItems(int numberOfItems, double pricePerItem) {
		totalNumberOfItems = numberOfItems + totalNumberOfItems;
		totalAmountOwed = totalAmountOwed + (numberOfItems * pricePerItem);
	}
	
	
	
	
	
	
	
	public void empty() {
		totalNumberOfItems = 0;
		totalAmountOwed = 0.0;
		//items = new HashMap<>();
	}
	
//	public void getItems(items) {
//		return items;
//	}

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
	
	
	

}
