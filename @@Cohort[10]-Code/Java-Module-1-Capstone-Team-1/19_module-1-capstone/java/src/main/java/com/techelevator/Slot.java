package com.techelevator;

public class Slot {
	
	private int itemQuantity;
	private String location;
	private Item localItem;
	
	
	public Slot(String location, Item localItem) {
		itemQuantity = 5;
		this.location = location;
		this.localItem = localItem;
	}

	public Slot() {
	}

	/**
	 * @return the itemQuantity
	 */
	public int getItemQuantity() {
		return itemQuantity;
	}


	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}


	/**
	 * @return the localItem
	 */
	public Item getLocalItem() {
		return localItem;
	}
	
	@Override
	public String toString() {
		
		return String.format("\t %s %6.2f  %-20s", this.location, this.localItem.getPrice(), this.getLocalItem().getName());
	}
	
	public boolean removeItem() {
		if(itemQuantity > 0) {
			itemQuantity--;
			return true;
		}
		System.out.println("**********************************");
		System.out.println("*Slot selected is currently empty*");
		System.out.println("**********************************");
		return false;
	}
}
