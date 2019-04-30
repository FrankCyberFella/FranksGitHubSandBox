package com.techelevator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
	
	private Map<String, Double> priceMap = new HashMap<String, Double>();
	private Map<String, String> nameMap = new HashMap<String, String>();
	
	private List<Item> shoppingCart = new ArrayList<Item>();
	
	public ShoppingCart() {
		
		this.priceMap.put("tomato", 2.99);
		this.priceMap.put("bellpepper", 1.99);
		this.priceMap.put("carrot", 0.99);
		this.priceMap.put("radish", 1.99);
		this.priceMap.put("cucumber", 0.99);
		
		this.nameMap.put("tomato", "Heirloom Tomatos");
		this.nameMap.put("bellpepper", "Bell Peppers");
		this.nameMap.put("carrot", "Carrots");
		this.nameMap.put("radish", "Radishes");
		this.nameMap.put("cucumber", "Cucumbers");
		
	}

	public String getItemName(String type) {
		return nameMap.get(type);
	}
	
	public double getItemPrice(String type) {
		return priceMap.get(type);
	}
	
	public void add(Item item) {
		shoppingCart.add(item);
	}
	
	public List<Item> getList() {
		return shoppingCart;
	}
}
