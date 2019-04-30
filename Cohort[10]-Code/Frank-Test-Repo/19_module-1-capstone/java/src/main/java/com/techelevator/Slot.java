package com.techelevator;

public class Slot {

	


	// VARIABLES OR DATA MEMBERS
	int numberOfItemstoHold;
	int itemsLeftInSlot;
	Item stuffToEat;
	String slotNumber;

				// CONSTRUCTORS // method to create an instance of a class.
	public Slot(int totalSlots, Item stuffToEat,String slotNumber) {
		this.numberOfItemstoHold = totalSlots;
		this.stuffToEat = stuffToEat;
		this.itemsLeftInSlot = totalSlots;
		this.slotNumber = slotNumber;
	}

	//	Methods
	
	/* first check the slot if a product what has run out should indicate it is SOLD Out 
	 * When a person purchases an item, that item is subtracted from the slot
	 */
	public void ItemRelease(int purchaseItem,  int itemsInSlot ) { 
		if(itemsInSlot == 0) {
			System.out.println("SOLD OUT");
		}else {
		
		itemsInSlot = itemsInSlot - purchaseItem; 
		System.out.println("Thank You for your Purchase, Great Day!!");
		}
		
	}

	/*GETTERS & SETTERS 
	*Getters & Setters are public.
	*They allow the values for the private 
	*variabless to be set to a given value and retrive that value when used */

	public int getNumberOfItemstoHold() {
		return numberOfItemstoHold;
	}

	public String getSlotNumber() {
return slotNumber;
}


	public Item getStuffToEat() {
		return stuffToEat;
	}

	public int getItemsLeftInSlot() {
		return itemsLeftInSlot;
	}
}
