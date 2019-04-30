package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Chips extends Items {
	//private String name;
	
	
	@Override
	public void Consumed() {
		System.out.println("Crunch, Crunch, Yum!");
	}
	
	
	
	public Chips(String slotNumber, String name, double price) {
		super(slotNumber,name, price);
		//this.name = name;
	}
@Override
	public String toString() {
		return super.getName();
}

}
