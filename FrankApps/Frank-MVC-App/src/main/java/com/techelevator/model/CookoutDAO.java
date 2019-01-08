package com.techelevator.model;

import java.util.List;

public interface CookoutDAO {
	
	public int saveCookoutDetails(Cookout cookout);
	
	public void updateCookoutDetails(Cookout cookout, int cookoutId);
	
	public List<Cookout> displayAllCookouts();
	
	public void addAttendees();
	
	public void createCookoutMenu(int cookoutId, int itemId);

	public Object getCookoutByUserName(String userName);

	public List<Cookout> getCookoutByUserNameAndDate(String userName);
	
}
