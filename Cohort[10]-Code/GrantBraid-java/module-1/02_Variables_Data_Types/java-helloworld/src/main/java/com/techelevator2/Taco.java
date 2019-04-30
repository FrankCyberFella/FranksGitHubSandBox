package com.techelevator2;

import java.util.ArrayList;
import java.util.List;

public class Taco {

	private int quantity;
	private List<String> addOns; 
	private int price;
	
	
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the addOns
	 */
	public List<String> getAddOns() {
		return addOns;
	}

	/**
	 * @param addOns the addOns to set
	 */
	public void setAddOns(List<String> addOns) {
		this.addOns = addOns;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price*quantity;
	}

	public Taco(int quantity, int price) {
		this.quantity = quantity;
		this.price = price;
	}
	
	public Taco(int quantity, int price, List<String> addOns) {
		this.addOns = addOns;
		this.price = price;
		this.quantity = quantity;

			
		}
	@Override
	public String toString() {
		return "You have ordered " + quantity + " basic tacos. Your total price is : $" + getPrice();
	}
	}
	
	

