package com.techelevator.model;

import java.sql.SQLException;

import org.springframework.dao.DuplicateKeyException;

public interface UserDAO {

	public void saveUser(String emailAddress, String userName, String password, String role) throws DuplicateKeyException;

	public boolean searchForUsernameAndPassword(String userName, String password);

	public void updatePassword(String userName, String password);

	public Object getUserByUserName(String userName);

}
