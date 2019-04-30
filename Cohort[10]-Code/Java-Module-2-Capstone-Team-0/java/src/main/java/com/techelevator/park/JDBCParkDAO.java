package com.techelevator.park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


public class JDBCParkDAO implements ParkDAO {
	private JdbcTemplate jdbcTemplate;
	
	// created a constructor. The parameters are of type DataSource. 
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// This is the required method from the interface. Hence the override
	@Override
	public List<Park> selectAllParks() {
		List<Park> parks = new ArrayList<Park>();
		String sqlSelectAllParks = "SELECT * FROM park ORDER BY name";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()) {
			Park thePark = mapRowToPark(results);
			parks.add(thePark);
		}
		return parks;
	}

	private Park mapRowToPark(SqlRowSet results) {
		Park thePark = new Park();
		thePark.setArea(results.getInt("area"));
		thePark.setDescription(results.getString("description"));
		thePark.setEstablishDate(results.getDate("establish_date").toLocalDate());
		thePark.setLocation(results.getString("location"));
		thePark.setName(results.getString("name"));
		thePark.setParkId(results.getInt("park_id"));
		thePark.setVisitors(results.getInt("visitors"));
		
		return thePark;
	}
	
	//This method will go through an ArrayList of parks and turn it into an ArrayList of strings of the name of the park
	public List<String> getParkNames(List<Park> parks) {
		List<String> parkNames = new ArrayList();
		for(Park thePark:parks) {
			parkNames.add(thePark.getName());
		}
		return parkNames;
	}
	
	
	
}
