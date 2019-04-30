package com.techelevator.campground;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCampgroundDAO implements CampgroundDAO{
	
	private JdbcTemplate JdbcTemplate;
	
	public JDBCCampgroundDAO(DataSource dataSource) {
		this.JdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Campground> getAllCampgrounds(String parkName) {
		Campground allCampgrounds = null;
		List<Campground> campList = new ArrayList<Campground>();
		
		String sqlAllParkCampgrounds = "select * " +
										"from campground " +
										"join park " +
										"on park.park_id = campground.park_id " +
										"where park.name = ? ";
		
		SqlRowSet results = JdbcTemplate.queryForRowSet(sqlAllParkCampgrounds, parkName);
		
		while (results.next()) {
			allCampgrounds = mapRowToCamp(results);
			campList.add(allCampgrounds);
			
		}
	
		return campList;	
	}
	
	private Campground mapRowToCamp(SqlRowSet results) {
		Campground theCamp = new Campground();
		theCamp.setCampgroundId(results.getLong("campground_id"));
		theCamp.setParkId(results.getLong("park_id"));
		theCamp.setName(results.getString("name"));
		theCamp.setOpenFromMonth(results.getString("open_from_mm"));
		theCamp.setOpenToMonth(results.getString("open_to_mm"));
		theCamp.setDailyFee(results.getString("daily_fee"));
		
		return theCamp;
	}

}
