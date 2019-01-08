package com.techelevator.model;

import java.util.List;

public interface MenuDAO {

	public List<Menu> displayAllMenuItems();
	
	public void addMenuItem(String itemName, String grillable);

	public void saveMenu(int[] selection, int cookoutId);
	
	public List<Menu> displayCookoutMenu(int cookoutId);
	
	public List<Menu> displayGrillableCookoutMenu(int cookoutId);
	
}
