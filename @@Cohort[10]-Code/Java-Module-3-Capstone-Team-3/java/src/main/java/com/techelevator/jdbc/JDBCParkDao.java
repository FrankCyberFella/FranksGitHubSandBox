package com.techelevator.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.dao.ParkDao;
import com.techelevator.npgeek.model.Park;

@Component
public class JDBCParkDao implements ParkDao {

	
	private JdbcTemplate myJdbcTemplate;						// Define a jdbctemplate object for the DAO
	
	@Autowired
	public JDBCParkDao(DataSource aDataSource) {				// constructor for DAO - receive a data source
		this.myJdbcTemplate = new JdbcTemplate(aDataSource);    // instantiate a jdbctemplate object for the DAO
	}

	@Override
	public Park getParkByCode(String parkCode) {
		Park park = new Park();
		String sqlParkByCode = "SELECT * "+
							   "FROM park "+
							   "WHERE parkcode = ?";
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlParkByCode, parkCode);
		while(results.next()) {
			park = mapRowToPark(results);
		}
		
		return park;
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> parks = new ArrayList<>();
		String sqlParkByName = "SELECT * "+
							   "FROM park ";
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlParkByName);
		while(results.next()) {
			Park thePark = mapRowToPark(results);
			parks.add(thePark);
		}
		return parks;
	}
	
	private Park mapRowToPark(SqlRowSet results) {
		Park thePark;
		thePark = new Park();
		thePark.setParkCode(results.getString("parkcode").toLowerCase());
		thePark.setParkName(results.getString("parkname"));
		thePark.setState(results.getString("state"));
		thePark.setAcreage(results.getInt("acreage"));
		thePark.setElevationInFeet(results.getInt("elevationinfeet"));
		thePark.setMilesOfTrail(results.getFloat("milesoftrail"));
		thePark.setNumberOfCampsites(results.getInt("numberofcampsites"));
		thePark.setClimate(results.getString("climate"));
		thePark.setYearFounded(results.getInt("yearfounded"));
		thePark.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		thePark.setInspirationalQuote(results.getString("inspirationalquote"));
		thePark.setInspirationalSource(results.getString("inspirationalquotesource"));
		thePark.setParkDescription(results.getString("parkdescription"));
		thePark.setEntryFee(results.getInt("entryfee"));
		thePark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		return thePark;
	}
}
