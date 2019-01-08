package com.techelevator.model;

import java.util.ArrayList;

import javax.sql.DataSource;
import javax.validation.constraints.Pattern.List;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.security.PasswordHasher;

@Component
public class JDBCUserDAO implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	private PasswordHasher hashMaster;

	@Autowired
	public JDBCUserDAO(DataSource dataSource, PasswordHasher hashMaster) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.hashMaster = hashMaster;
	}
	
	@Override
	public void saveUser(String firstName, String lastName, String userName, String password) {
		byte[] salt = hashMaster.generateRandomSalt();
		String hashedPassword = hashMaster.computeHash(password, salt);
		String saltString = new String(Base64.encode(salt));
		
		jdbcTemplate.update("INSERT INTO users(first_name, last_name,username, password, salt) VALUES (?, ?, ?, ?, ?)",
				firstName, lastName, userName, hashedPassword, saltString);
	}

	@Override
	public boolean searchForUsernameAndPassword(String username, String password) {
		String sqlSearchForUser = "SELECT * "+
							      "FROM users "+
							      "WHERE username = ?";
		
		SqlRowSet user = jdbcTemplate.queryForRowSet(sqlSearchForUser, username);
		if(user.next()) {
			String dbSalt = user.getString("salt");
			String dbHashedPassword = user.getString("password");
			String givenPassword = hashMaster.computeHash(password, Base64.decode(dbSalt));
			return dbHashedPassword.equals(givenPassword);
		} else {
			return false;
		}
	}

	@Override
	public void updatePassword(String userName, String password) {
		jdbcTemplate.update("UPDATE users SET password = ? WHERE username = ?", password, userName);
	}

	@Override
	public Object getUserByUserName(String userName) {
		String sqlSearchForUsername ="SELECT * "+
		"FROM users "+
		"WHERE UPPER(username) = ?";

		SqlRowSet user = jdbcTemplate.queryForRowSet(sqlSearchForUsername, userName.toUpperCase()); 
		User thisUser = null;
		if(user.next()) {
			thisUser = new User();
			thisUser.setUserName(user.getString("username"));
			thisUser.setPassword(user.getString("password"));
		}

		return thisUser;
	}

	@Override
	public int getUserIdByName(String username) {
		ArrayList<User> user = new ArrayList<>();
		String sqlGetUserId = "SELECT user_id FROM users WHERE username = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetUserId, username);
		while(results.next()) {
			user.add(mapIdToUser(results));
		}
		
		int userId = user.get(0).getUserId();
		
		return userId;
	}

	private User mapRowToUser(SqlRowSet results) {
		User user = new User();
		user.setFirstName(results.getString("first_name"));
		user.setLastName(results.getString("last_name"));
		user.setUserId(results.getInt("user_id"));
		user.setUserName(results.getString("username"));
		return user;
	}
	
	private User mapIdToUser(SqlRowSet results) {
		User user = new User();
		user.setUserId(results.getInt("user_id"));
		return user;
	}
	
	
		



}
