package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCMenuDAO implements MenuDAO {

	private JdbcTemplate JdbcTemplate;
	
	@Autowired
	public JDBCMenuDAO(DataSource dataSource) {
		this.JdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	// Used to display all menu items on the for menu creation.
	public List<Menu> displayAllMenuItems() {
		List<Menu> menu = new ArrayList<>();
		String sqlDisplayAllItems = "SELECT * FROM menu_items";
		SqlRowSet results = JdbcTemplate.queryForRowSet(sqlDisplayAllItems);
		while(results.next()) {
			menu.add(mapRowToMenuItems(results));
		}
		return menu;
	}


	
	// Displays on the menu items that have been selected for a specific cookout. Displays on the cookout details page.
	@Override
	public List<Menu> displayCookoutMenu(int cookoutId) {
		List<Menu> cookoutMenu = new ArrayList<>();
		String sqlShowCookoutMenu = "SELECT cookout_menu.item_id, cookout_menu.cookout_id, menu_items.item_name, menu_items.grillable FROM cookout_menu " + 
				"		JOIN cookout " + 
				"		ON (cookout.cookout_id = cookout_menu.cookout_id) " + 
				"		JOIN menu_items " + 
				"		ON (menu_items.item_id = cookout_menu.item_id) " + 
				"		WHERE cookout_menu.cookout_id = ?";
		SqlRowSet results = JdbcTemplate.queryForRowSet(sqlShowCookoutMenu, cookoutId);
		while(results.next()) {
			cookoutMenu.add(mapRowToMenu(results));
		}
		return cookoutMenu;
	}
	
	
	
	// Displays only grillable items for the item selection screen so users can only choose from grillable items for their order.
	@Override
	public List<Menu> displayGrillableCookoutMenu(int cookoutId) {
		List<Menu> grillableMenu = new ArrayList<>();
		String sqlShowCookoutMenu = "SELECT cookout_menu.item_id, cookout_menu.cookout_id, menu_items.item_name, menu_items.grillable FROM cookout_menu " + 
				"		JOIN cookout " + 
				"		ON (cookout.cookout_id = cookout_menu.cookout_id) " + 
				"		JOIN menu_items " + 
				"		ON (menu_items.item_id = cookout_menu.item_id) " + 
				"		WHERE cookout_menu.cookout_id = ? AND grillable = ?";
		SqlRowSet results = JdbcTemplate.queryForRowSet(sqlShowCookoutMenu, cookoutId, "Yes");
		while(results.next()) {
			grillableMenu.add(mapRowToMenu(results));
		}
		return grillableMenu;
	}

	

	//this needs some work-- trying to send through a series of inserts inside a for loop
	@Override
	public void saveMenu(int[] selection, int cookoutId) {
		for(int i=0; i<selection.length; i++) {
			String sqlInsertMenuItems = "INSERT INTO cookout_menu(cookout_id, item_id) VALUES(?, ?)";
			JdbcTemplate.update(sqlInsertMenuItems, cookoutId, selection[i]);
		}
	}
	
	
	
	// Un-used method for phase 2 where users will be able to create their own menu items.
	@Override
	public void addMenuItem(String itemName, String grillable) {
		
	}
	
	
	private Menu mapRowToMenu(SqlRowSet results) {
		Menu menu = new Menu();
		menu.setItemId(results.getInt("item_id"));
		menu.setItemName(results.getString("item_name"));
		menu.setGrillable(results.getString("grillable"));
		menu.setCookoutId(results.getInt("cookout_id"));
		return menu;
	}
	
	
	private Menu mapRowToMenuItems(SqlRowSet results) {
		Menu menu = new Menu();
		menu.setItemId(results.getInt("item_id"));
		menu.setItemName(results.getString("item_name"));
		menu.setGrillable(results.getString("grillable"));
		return menu;
	}
	
}


