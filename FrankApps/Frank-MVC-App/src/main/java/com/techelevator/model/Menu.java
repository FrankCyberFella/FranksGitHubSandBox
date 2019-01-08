package com.techelevator.model;

public class Menu {
	
	private int itemId;
	private String itemName;
	private String grillable;
	private int cookoutId;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String isGrillable() {
		return grillable;
	}
	public void setGrillable(String grillable) {
		this.grillable = grillable;
	}
	public int getCookoutId() {
		return cookoutId;
	}
	public void setCookoutId(int cookoutId) {
		this.cookoutId = cookoutId;
	}
	
}
