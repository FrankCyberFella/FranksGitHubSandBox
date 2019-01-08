package com.techelevator.model;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCOrderDAO implements OrderDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCOrderDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	// This will first create an order in the "orders" table then it will insert the items for the order in the "order_items" table.
	@Override
	public void addOrderItems(String orderName, int cookoutId, int[] itemId, String[] comments, int[] quantity) {
		String sqlCreateOrder = "INSERT INTO orders (cookout_id, order_name) VALUES (?, ?) RETURNING order_id";
		long id = jdbcTemplate.queryForObject(sqlCreateOrder, Long.class, cookoutId, orderName);
		
		int orderId = (int)id;
		
		for(int i=0; i<itemId.length; i++) {
			String sqlAddOrderItems = "INSERT INTO order_items (order_id, item_id, comments, quantity)" +
									  " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sqlAddOrderItems, orderId, itemId[i], comments[i], quantity[i]);
		}
	}

	
	
	// This is what the chef will use to view all of the orders and the individuals who placed them.
	@Override
	public  List<Order> displayOrders(int cookoutId) {
		List<Order> orders = new ArrayList<>();
		String sqlShowOrders = "SELECT orders.order_id, order_items.item_id, orders.order_name, menu_items.item_name, order_items.quantity, order_items.comments, orders.finished FROM menu_items " + 
				"JOIN order_items " + 
				"ON (menu_items.item_id = order_items.item_id) " + 
				"JOIN orders " + 
				"ON (order_items.order_id = orders.order_id) " + 
				"JOIN cookout " + 
				"ON (cookout.cookout_id = orders.cookout_id) " + 
				"WHERE cookout.cookout_id = ? AND order_items.quantity <> 0" +
				" ORDER BY finished ASC, order_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlShowOrders, cookoutId);
		while(results.next()) {
			orders.add(mapRowToOrder(results));
		}
		
		jdbcTemplate.update("DELETE FROM order_items WHERE quantity = 0");
		
		return orders;

	}

	

	// This will mark the orders complete on the displayOrders and OrderSummary Lists
	@Override
	public void completeOrder(int[] orderId) {
		String sqlUpdateOrder = "UPDATE orders SET finished = 'Yes' WHERE order_id = ?";
		for(int i=0; i<orderId.length; i++) {
		jdbcTemplate.update(sqlUpdateOrder, orderId[i]);
		}

	}
	
	
	
	// This will show the chef a total summary of items ordered so they can plan the items needed to grill.
	@Override
	public List<Order> showOrderSummary(int cookoutId) {
		List<Order> orders = new ArrayList<>();
		String sqlShowSummary = "SELECT item_name AS Food_Items, SUM(order_items.quantity) AS Total_Quantity " + 
				" FROM order_items " + 
				" JOIN menu_items " + 
				" ON order_items.item_id = menu_items.item_id " + 
				" JOIN orders " + 
				" ON order_items.order_id = orders.order_id " + 
				" JOIN cookout " + 
				" ON cookout.cookout_id = orders.cookout_id " + 
				" WHERE cookout.cookout_id = ? GROUP BY menu_items.item_name;";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlShowSummary, cookoutId);
			while(results.next()) {
				orders.add(mapRowToSummary(results));
			}
		return orders;
	}
	
	
	
	private Order mapRowToOrder(SqlRowSet results) {
		Order order = new Order();
		order.setOrderId(results.getInt("order_id"));
		order.setItemId(results.getInt("item_id"));
		order.setComments(results.getString("comments"));
		order.setQuantity(results.getInt("quantity"));
		order.setOrderName(results.getString("order_name"));
		order.setItemName(results.getString("item_name"));
		order.setFinished(results.getString("finished"));
		return order;
	}
	
	private Order mapRowToSummary(SqlRowSet results) {
		Order order = new Order();
		order.setItemName(results.getString("Food_Items"));
		order.setTotalQuantity(results.getInt("Total_Quantity"));
		return order;
	}
	
}
	





