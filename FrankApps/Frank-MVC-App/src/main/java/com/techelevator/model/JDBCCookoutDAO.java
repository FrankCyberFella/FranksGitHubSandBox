package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.style.ValueStyler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCCookoutDAO implements CookoutDAO{

	private JdbcTemplate JdbcTemplate;
	
	@Autowired
	public JDBCCookoutDAO(DataSource dataSource) {
		this.JdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	// This will create a new cookout by the host where they will enter all of the parameters.  - also need to add the host to the cookout_users table
	@Override
	public int saveCookoutDetails(Cookout cookout) {
		String SqlInsertCookoutDetails = "INSERT INTO cookout (cookout_name, description, cookout_host, cookout_date, start_time, end_time, street, city, cookout_state, zip)" +
										 " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING cookout_id";
		long id = JdbcTemplate.queryForObject(SqlInsertCookoutDetails, Long.class, cookout.getCookoutName(),cookout.getDescription(), cookout.getHost(),
												cookout.getCookoutDate(), cookout.getStartTime(), cookout.getEndTime(),
												cookout.getStreet(), cookout.getCity(), cookout.getState(), cookout.getZip());
		int cookoutId = (int)id;	
		cookout.setCookoutId(cookoutId);
		
		return cookoutId;
	}

	// This will UPDATE an existing cookout by the host where they will enter all of the parameters.  - also need to add the host to the cookout_users table
	@Override
	public void updateCookoutDetails(Cookout cookout, int cookoutId) {
		String SqlUpdateCookoutDetails = "UPDATE cookout " +
										"SET cookout_name = ?, description = ?, cookout_date = ?, start_time = ?, end_time = ?, street = ?, city = ?, cookout_state = ?, zip = ? " +
									    "WHERE cookout_id = ?";
		JdbcTemplate.update(SqlUpdateCookoutDetails, cookout.getCookoutName(),cookout.getDescription(),
												cookout.getCookoutDate(), cookout.getStartTime(), cookout.getEndTime(),
												cookout.getStreet(), cookout.getCity(), cookout.getState(), cookout.getZip(), cookoutId);
	}
	
	
	
	// This will display all of the cookouts --> only displays based on the logged in user and only displays future cookouts.
	@Override
	public List<Cookout> displayAllCookouts() {
		List<Cookout> cookoutList = new ArrayList<>();
		String sqlSelectAllCookouts = "SELECT * FROM cookout WHERE cookout_date >= now()";
		SqlRowSet results = JdbcTemplate.queryForRowSet(sqlSelectAllCookouts);
		while (results.next()) {
			cookoutList.add(mapRowToCookout(results));
		}
		return cookoutList;
	}
	



	// Add attendees to the attendees table and add them as attendees
	@Override
	public void addAttendees() {
		
	}
	
	

	//Adds items to the cookout_menu table based off of items that are available from the menu items table 
	@Override
	public void createCookoutMenu(int cookoutId, int itemId) {
		String sqlInsertMenuItems = "INSERT INTO cookout_menu (cookout_id, item_id) VALUES (?, ?)";
		JdbcTemplate.update(sqlInsertMenuItems, cookoutId, itemId);
	}
	
	
	// Displays only the cookouts related to a logged in user.
	@Override
	public List<Cookout> getCookoutByUserName(String userName) {
			List<Cookout> cookoutList = new ArrayList<>();
			String sqlSelectAllCookouts = "SELECT cookout_id, cookout_name, description, cookout_date FROM users JOIN cookout ON cookout.cookout_host = users.user_id WHERE users.username = ?";
			SqlRowSet results = JdbcTemplate.queryForRowSet(sqlSelectAllCookouts, userName);
			while (results.next()) {
				cookoutList.add(mapRowToHostCookout(results));
			}
			return cookoutList;
	}

	
	// Gets the cookouts only based on the logged in user as well as only for future cookouts.
	@Override
	public List<Cookout> getCookoutByUserNameAndDate(String userName) {
		List<Cookout> cookoutList = new ArrayList<>();
		String sqlSelectAllCookouts = "SELECT cookout_id, cookout_name, description, cookout_date FROM users JOIN cookout ON cookout.cookout_host = users.user_id WHERE users.username = ? AND cookout.cookout_date >= now() ORDER BY cookout.cookout_date";
		SqlRowSet results = JdbcTemplate.queryForRowSet(sqlSelectAllCookouts, userName);
		while (results.next()) {
			cookoutList.add(mapRowToHostCookout(results));
		}
		return cookoutList;
}


	// Used to display all cookout info
	private Cookout mapRowToCookout(SqlRowSet results) {
		Cookout cookout = new Cookout();
		cookout.setCookoutId(results.getInt("cookout_id"));
		cookout.setCookoutName(results.getString("cookout_name"));
		cookout.setDescription(results.getString("description"));
		cookout.setCookoutDate(results.getDate("cookout_date").toLocalDate());
		cookout.setStartTime(results.getTime("start_time").toLocalTime());
		cookout.setEndTime(results.getTime("end_time").toLocalTime());
		cookout.setStreet(results.getString("street"));
		cookout.setCity(results.getString("city"));
		cookout.setState(results.getString("cookout_state"));
		cookout.setZip(results.getInt("zip"));
		//cookout.setHost(results.getInt("cookout_host"));
		return cookout;
	}

	
	
	// Used for logged in page to only show cookout details summary.
	private Cookout mapRowToHostCookout(SqlRowSet results) {
		Cookout cookout = new Cookout();
		cookout.setCookoutId(results.getInt("cookout_id"));
		cookout.setCookoutName(results.getString("cookout_name"));
		cookout.setDescription(results.getString("description"));
		cookout.setCookoutDate(results.getDate("cookout_date").toLocalDate());
		return cookout;
	}


}

