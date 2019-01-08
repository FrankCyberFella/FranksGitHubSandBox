package com.techelevator.model;

public class Order {
	
	private int orderId;
	private int itemId;
	private String comments;
	private int quantity;
	private String orderName;
	private String finished;
	private int cookoutId;
	private String itemName;
	private int totalQuantity;

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getCookoutId() {
		return cookoutId;
	}
	public void setCookoutId(int cookoutId) {
		this.cookoutId = cookoutId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getFinished() {
		return finished;
	}
	public void setFinished(String finished) {
		this.finished = finished;
	}
	
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
}
