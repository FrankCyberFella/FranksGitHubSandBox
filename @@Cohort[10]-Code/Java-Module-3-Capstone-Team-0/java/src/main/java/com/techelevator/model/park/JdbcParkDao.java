package com.techelevator.model.park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.authentication.PasswordHasher;

@Component
public class JdbcParkDao implements ParkDao {

	private JdbcTemplate jdbcTemplate;
    /**
     * Create a new park dao with the supplied data source
     * 
     * @param dataSource an SQL data source
     */
    @Autowired
    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    
	@Override
	public List<Park> getAllParks() {
		List<Park> parks=new ArrayList<Park>();
		String sqlGetAllParks = "SELECT * FROM park ORDER BY parkname";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);
		while(results.next()) {
			parks.add(mapRowToPark(results));
		}
		
		return parks;
	}

	@Override
	public Park getParkByCode(String parkCode) {
		Park newPark = null;
		String sqlGetParkByCode = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParkByCode, parkCode);
		
		if(results.next()) {
			newPark = mapRowToPark(results);
		}
		
		return newPark;
	}

	private Park mapRowToPark(SqlRowSet result) {
		Park thePark = new Park();
		thePark.setAcreage(result.getInt("acreage"));
		thePark.setAnnualVisitorCount(result.getInt("annualvisitorcount"));
		thePark.setClimate(result.getString("climate"));
		thePark.setElevationInFeet(result.getInt("elevationinfeet"));
		thePark.setEntryFee(result.getInt("entryfee"));
		thePark.setInspirationQuote(result.getString("inspirationalquote"));
		thePark.setInspirationQuoteSource(result.getString("inspirationalquotesource"));
		thePark.setMilesOfTrail(result.getDouble("milesoftrail"));
		thePark.setNumberOfAnimalSpecies(result.getInt("numberofanimalspecies"));
		thePark.setNumberOfCampsites(result.getInt("numberofcampsites"));
		thePark.setParkCode(result.getString("parkcode"));
		thePark.setParkDescription(result.getString("parkdescription"));
		thePark.setParkName(result.getString("parkname"));
		thePark.setState(result.getString("state"));
		thePark.setYearFounded(result.getInt("yearfounded"));
		return thePark;
	}
}
