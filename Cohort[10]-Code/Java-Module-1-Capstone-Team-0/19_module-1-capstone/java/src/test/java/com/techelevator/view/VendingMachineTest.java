package com.techelevator.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import org.junit.After;
import org.junit.Assert; 
import org.junit.Before; 
import org.junit.Test;

import com.techelevator.Item;
import com.techelevator.Slot;
import com.techelevator.Transaction;

public class VendingMachineTest {

	@SuppressWarnings("deprecation")
	@Test
	public void does_balance_start_at_0() {

		 Transaction account = new Transaction(0.00);
		Assert.assertEquals("Balance did not start at 0 ", 0.00 , account.getBalance(), .00);
	}
	

	@Test
	public void does_item_sound_occur() {
		//Transaction account = new Transaction(0.00);
		Item item = new Item("Stackers", "Chip");
		
		Assert.assertEquals("Chips did not make Crunch Crunch, Yum! sound ", "Crunch Crunch, Yum!" , item.makeSound());
	}
	
	@Test
	public void does_item_give_correct_name() {
		//Transaction account = new Transaction(0.00);
		Item item = new Item("Stackers", "Chip");
		
		Assert.assertEquals("Chips did not return correct name ", "Stackers" , item.getProductName());
	}
	
	@Test
	public void does_slot_give_correct_slot_number() {
		Stack<Item> stackOfItems = new Stack<Item>();
		Slot slot = new Slot("A1", 3.15, stackOfItems);
		
		Assert.assertEquals("Slot did not give correct slot number ", "A1" , slot.getSlotNumber());
	}
	
	@Test
	public void does_slot_give_correct_price() {
		Stack<Item> stackOfItems = new Stack<Item>();
		Slot slot = new Slot("A1", 3.15, stackOfItems);
		
		Assert.assertEquals("Slot did not give correct price of 3.15 ", 3.15 , slot.getPrice(), .00);
	}
	
	@Test
	public void does_item_purchase_return_balance_change() {
		Transaction account = new Transaction(0.00);
		Stack<Item> stackOfItems = new Stack<Item>();
		Slot slot = new Slot("A1", 3.50, stackOfItems);
		account.setBalance(5.00);
		
		Assert.assertEquals("Slot did not give correct transaction change ", 1.50 , (account.getBalance() - slot.getPrice()), .00);
	}
	
	
	@Test
	public void does_inventory_contain_slot() {
		Stack<Item> stackOfItems = new Stack<Item>();
		Slot slot = new Slot("A1", 3.50, stackOfItems);
		List<Slot> inventory = new ArrayList<Slot>();
		inventory.add(slot);
		
		Assert.assertTrue("Inventory does not contain slot ", inventory.contains(slot));
	}
	
	@Test
	public void can_inventory_remove_slot() {
		Stack<Item> stackOfItems = new Stack<Item>();
		Slot slot = new Slot("A1", 3.50, stackOfItems);
		List<Slot> inventory = new ArrayList<Slot>();
		inventory.add(slot);
		inventory.remove(slot);
		
		Assert.assertTrue("Inventory does not contain slot ", inventory.contains(slot) == false);
	}
	
	
	
	
	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Test public void does_audit_log_transaction() { Transaction account = new
	 * Transaction(0.00); Assert.assertEquals("Balance did not start at 0 ", 0.00 ,
	 * account.getBalance(), .00); }
	 * 
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Test public void does_sales_report_tally_item_purchase() { Transaction
	 * account = new Transaction(0.00);
	 * Assert.assertEquals("Balance did not start at 0 ", 0.00 ,
	 * account.getBalance(), .00); }
	 */
	
}
