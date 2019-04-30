package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkDao implements ParkDao {
	
    private JdbcTemplate jdbcTemplate;

    @Autowired
	public JdbcParkDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

	
	public List<Park> getAllParks() {
		Park getParks = new Park();
		List<Park> parkList = new ArrayList<Park>();
		String row = "SELECT * FROM park ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(row);
		while (results.next()) {
			getParks = mapRowToPark(results);
			parkList.add(getParks);
		}
		return parkList;
	}
	
	
	public Park getParkById(String parkCode) {
		Park getPark = new Park();
		String row = " SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(row, parkCode);
		if(results.next()) {
			getPark = mapRowToPark(results);
		
		}
		return getPark;
	}
	
	public Park getParkByParkName(String parkName) {
		Park getPark = new Park();
		String row = " SELECT * FROM park WHERE parkname = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(row, parkName);
		if(results.next()) {
			getPark = mapRowToPark(results);
		
		}
		return getPark;
	}
	
	private Park mapRowToPark(SqlRowSet results) {
		Park thePark = new Park();
		thePark.setParkCode(results.getString("parkcode"));
		thePark.setParkName(results.getString("parkname"));
		thePark.setState(results.getString("state"));
		thePark.setAcreage(results.getInt("acreage"));
		thePark.setElevationInFeet(results.getInt("elevationinfeet"));
		thePark.setMilesOfTrail(results.getDouble("milesoftrail"));
		thePark.setNumberOfCampsites(results.getInt("numberofcampsites"));
		thePark.setClimate(results.getString("climate"));
		thePark.setYearFounded(results.getInt("yearfounded"));
		thePark.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		thePark.setInspirationalQuote(results.getString("inspirationalquote"));
		thePark.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		thePark.setParkDescription(results.getString("parkdescription"));
		thePark.setEntryFee(results.getInt("entryfee"));
		thePark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		
		return thePark;
	}

}
