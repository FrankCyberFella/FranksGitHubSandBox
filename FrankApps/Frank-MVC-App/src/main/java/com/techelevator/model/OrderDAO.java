package com.techelevator.model;

import java.util.List;

import javax.swing.text.View;

import org.springframework.stereotype.Component;

public interface OrderDAO {
	
	public void addOrderItems(String orderName, int cookoutId, int[] itemId, String[] comments, int[] quantity);
	
	public List<Order> displayOrders(int cookoutId);
	
	public List<Order> showOrderSummary(int cookoutId); 
	
	public void completeOrder(int[] orderId);
	
}
