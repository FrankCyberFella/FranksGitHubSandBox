package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class ItemTest {

	Item car = new Item("d4", "Mustang", "37000", "Chips");
	Item vacuum = new Item("e2", "Dyson", "275.00", "Candy");
	Item ketchup = new Item("a3", "Heinz", "4.23","Drink");
	
@Test
public void Test_Get_Slot_Number() {
	
	assertEquals("The slot should be d4", "d4", car.getSlotId());
	assertEquals("The slot should be e2", "e2", vacuum.getSlotId());
	assertEquals("The slot should be a3", "a3", ketchup.getSlotId());
	
	
}

@Test
public void Test_Get_Name() {
	

	assertEquals("The name should be Mustang", "Mustang", car.getName());
	assertEquals("The name should be Dyson", "Dyson", vacuum.getName());
	assertEquals("The name should be Heinz", "Heinz", ketchup.getName());
}
	
@Test
public void Test_Get_Price(){
	
	assertEquals("The price should be double 37000", 37000,.001, car.getPrice());
	assertEquals("The price should be double 275.00", 275.00,.001, vacuum.getPrice());
	assertEquals("The price should be double 4.23", 4.23,.001, ketchup.getPrice());
}

@Test
public void Test_To_String() {
	
	assertEquals("should return String Mustang - $37000", "Mustang - $37000", car.toString());
	assertEquals("should return String Dyson - $275.00", "Dyson - $275.00", vacuum.toString());
	assertEquals("should return String Heinz - $4.23", "Heinz - $4.23", ketchup.toString());
}

@Test
public void Test_To_Log_String() {
	
	assertEquals("should return String Mustang: d4", "Mustang: d4", car.toLogString());
	assertEquals("should return String Dyson: e2", "Dyson: e2", vacuum.toLogString());
	assertEquals("should return String Heinz: a3", "Heinz: a3", ketchup.toLogString());
	
}

}
