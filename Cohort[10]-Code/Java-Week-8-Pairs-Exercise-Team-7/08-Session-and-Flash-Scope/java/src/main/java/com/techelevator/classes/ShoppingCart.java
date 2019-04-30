package com.techelevator.classes;

import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {

	private List<Item> item = new ArrayList<Item>();
	

public void add(Item item){
	this.item.add(item);
}


public List<Item> seeCart() {

	return item;
}
}
