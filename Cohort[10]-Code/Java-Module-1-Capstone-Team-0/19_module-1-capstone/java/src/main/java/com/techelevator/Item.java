package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Item {

	private String productName;
	private String productType;

	public Item(String productName, String productType) {
		
		this.productName = productName;
		this.productType = productType;
		
	}

	
	
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	

	public String makeSound() {
		if (productType.equals("Chip")) {
			return "Crunch Crunch, Yum!";
		}
		else if (productType.equals("Candy")) {
			return "Munch Munch, Yum!";
		}
		else if (productType.equals("Drink")) {
			return "Glug Glug, Yum!";
		}
		else if (productType.equals("Gum")) {
			return "Chew Chew, Yum!";
		}
		return "Doesn't Exist";
	}
	
	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}
	


	@Override
	public String toString() {
		return productName + " " + productType;
	}

}
