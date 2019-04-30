package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Slot {

		private String name;
		private DollarAmount price;
		private List<Item> items = new ArrayList<Item>();
		private static final int MAX_QUANTITY = 5;
		private String type;
		private int currentQuantity = 0;
		private String itemName;
		private int pendingQuanitity = 0;
		
		public Slot(String name, String price, String type, String itemName) {
			this.name = name;
			this.price = DollarAmount.convertToDollarAmount(price);
			this.type = type;
			this.itemName = itemName;
			while(currentQuantity < MAX_QUANTITY) {
				Item item = new Item(itemName , type);
				items.add(item);
				currentQuantity++;
			}
		}
		
		public String toString() {
			String slot = "";
			slot += "Slot name: " + itemName + "\n";
			slot += "Slot price: " + price + "\n";
			slot += "Slot contains: " + currentQuantity + " " + type + "s\n";
			return slot;
		}




public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public DollarAmount getPrice() {
	return price;
}

public void setPrice(DollarAmount price) {
	this.price = price;
}

public List<Item> getItems() {
	return items;
}

public void setItems(List<Item> items) {
	this.items = items;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public int getCurrentQuantity() {
	return currentQuantity;
}

public void setCurrentQuantity(int currentQuantity) {
	this.currentQuantity = currentQuantity;
}

public void decrementCurrentQuantity() {
	this.currentQuantity--;
}

public String getItemName() {
	return itemName;
}

public void setItemName(String itemName) {
	this.itemName = itemName;
}

public static int getMaxQuantity() {
	return MAX_QUANTITY;
}

public String consumeSound() {
	String sound = "";
	switch (type){
		
	case "Chip":
		 sound = "Crunch Crunch, Yum!";
		 break;
	case "Beverage":
		 sound = "Glug Glug, Yum!";
		 break;
	case "Gum":
		 sound = "Chew Chew, Yum!";
		 break;
	case "Candy":
		 sound = "Munch Munch, Yum!";
		 break;		
	}
	
	return sound;
}


}