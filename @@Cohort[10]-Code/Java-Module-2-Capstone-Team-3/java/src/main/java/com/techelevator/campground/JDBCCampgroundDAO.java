package com.techelevator.campground;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;



public class JDBCCampgroundDAO implements CampgroundDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Campground> getAllCampgrounds(String name) {
		ArrayList<Campground> campgroundsList = new ArrayList<>();
		
		String sqlFindAllCampgrounds = "SELECT * " + 
									   "FROM campground JOIN park " +
									   "ON campground.park_id = park.park_id " +
									   "WHERE park.name = ? "
									   ;
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllCampgrounds, name);
		while(results.next()) {
			Campground campgroundName = mapRowToCampground(results);
			campgroundsList.add(campgroundName);
		}
		return campgroundsList;
	}
	@Override
	public List<Campground> searchCampgroundsByName(String nameSearch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Campground getCampgroundById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private Campground mapRowToCampground(SqlRowSet results) { //ALWAYS SHOULD HAVE: create an object of the class and assign
		Campground campground = new Campground();	//Define an Obj to return   // assign the results form the SQL statement
			
			campground.setCampgroundId(results.getLong("campground_id"));
			campground.setParkId(results.getInt("park_id"));
			campground.setName(results.getString("name"));
			campground.setOpenFrom(results.getString("open_from_mm"));
			campground.setOpenTo(results.getString("open_to_mm"));
			campground.setDailyFee(results.getDouble("daily_fee"));
		
		return campground; //return the object
	}

}
