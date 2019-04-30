package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	
    private List<Vegetable> vegetableList = new ArrayList<Vegetable>();
	
	public void addVegetable(Vegetable vegetable) {
		vegetableList.add(vegetable);
	}
	
	public List<Vegetable> seeCart() {
		return vegetableList;
	}
	
	
	

}
