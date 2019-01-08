package com.techelevator.model;

import java.util.ArrayList;

public interface UserDAO {

	public boolean searchForUsernameAndPassword(String userName, String password);

	public void updatePassword(String userName, String password);

	public Object getUserByUserName(String userName);

	public void saveUser(String firstName, String lastName, String userName, String password);
	
	public int getUserIdByName(String username);
	
	

	// public Object getFirstName(String firstName);

}
