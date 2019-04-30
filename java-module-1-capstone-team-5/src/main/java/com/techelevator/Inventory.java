package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.experimental.theories.Theories;

public class Inventory {
	private Map<Snack, Integer> inventory = new HashMap<Snack, Integer>();					// key is a snack object, value is the count of the each specific snack
	private Scanner inputScanner;
	private ArrayList<String> listTypes = new ArrayList<String>();
	
	/*
	 * Constructor for the Inventory class
	 */
	public Inventory(Scanner inputScanner) { 
		this.inputScanner = inputScanner;
		setting(inputScanner);
	}

	public ArrayList<String> getListTypes() {
		return this.listTypes;
	}
	
	
	public Map<Snack, Integer> setting(Scanner inputScanner) {
		while (inputScanner.hasNextLine()) {
			String line = inputScanner.nextLine();
			String[] productInfo = line.split("\\|"); 
			Snack snack = new Snack(productInfo[0], productInfo[1], Double.parseDouble(productInfo[2]), productInfo[3]);     // Creating a snack object by a product name
			inventory.put(snack, 5);
		}
		
		return inventory; 
	}
	
	public Map<Snack, Integer> getInventory() {
		return this.inventory;
	}
	
	public void setInventory(Map<Snack, Integer> newInventory) {
		this.inventory = newInventory;
	}
	
	
	public double subtract(String slot) {
		double price = 0.0;
		
		for (Map.Entry<Snack, Integer> snackEntry : inventory.entrySet()) {
			if (snackEntry.getKey().getSlot().equals(slot)) {
				inventory.replace(snackEntry.getKey(), snackEntry.getValue()-1);
				price = snackEntry.getKey().getCost();
				listTypes.add(snackEntry.getKey().getType());
				}
			}
		return price;
		
	}
	
	public boolean slotExist(String slot) {
		boolean exist = false;
		
		for (Map.Entry<Snack, Integer> snackEntry : inventory.entrySet()) {
			if (snackEntry.getKey().getSlot().equals(slot)) {
				exist =true;
			}
		}
		return exist;
	}
	
	public boolean isSoldOut(String slot) {
		boolean isSoldOut = true;
		
		for (Map.Entry<Snack, Integer> snackEntry : inventory.entrySet()) {
			if (snackEntry.getKey().getSlot().equals(slot)) {
				if (snackEntry.getValue()>0)
					isSoldOut = false;
			}
		}
		
		return isSoldOut;
	}
	
	

}
