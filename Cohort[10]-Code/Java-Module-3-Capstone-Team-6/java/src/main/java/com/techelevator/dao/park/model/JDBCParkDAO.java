package com.techelevator.dao.park.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCParkDAO implements ParkDao {

	private JdbcTemplate jdbcTemplate;
	
@Autowired
	public JDBCParkDAO(DataSource datasource) {
	this.jdbcTemplate = new JdbcTemplate(datasource);
}
	
	
	@Override
	public List<Park> getAllParks() {
		List<Park> allParkList = new ArrayList<Park>();
		String sqlGetAllParks = "SELECT * FROM park ORDER BY parkname asc";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);
		while (results.next()) {
			allParkList.add(mapRowToPark(results));
		}
		return allParkList;
	}
	
	
	@Override
	public List<Park> getTopParkSurvey() {
		List<Park> park = new ArrayList<Park>();
		String sqlGetSurvey = "SELECT * FROM park where parkcode IN (SELECT parkcode FROM (SELECT parkcode, COUNT (*) FROM survey_result GROUP BY parkcode ORDER BY COUNT desc, parkcode) AS frank)";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetSurvey);
		while (results.next()) {
			park.add(mapRowToPark(results));
		}
		return park;
	}
	
	@Override
	public List<Park> getParkCount() {
		List<Park> votes = new ArrayList<Park>();
		String sqlGetSurvey = "SELECT park.parkname, park.parkcode as parkcode, COUNT(park.parkcode) as countsurvey\n" + 
				"FROM park\n" + 
				"INNER JOIN survey_result ON survey_result.parkcode = park.parkcode \n" + 
				"GROUP BY  park.parkcode, park.parkname\n" + 
				"ORDER BY countsurvey desc, park.parkname";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetSurvey);
		while (results.next()) {
			Park parkVotes = new Park();
			parkVotes.setParkCode(results.getString("parkcode"));
			parkVotes.setParkName(results.getString("parkname"));
			parkVotes.setParkCount(results.getInt("countsurvey"));
			votes.add(parkVotes);
		}
		return votes;
	}


	private Park mapRowToPark(SqlRowSet results) {
		Park p = new Park();
		p.setParkCode(results.getString("parkcode"));
		p.setParkName(results.getString("parkname"));
		p.setState(results.getString("state"));
		p.setAcreage(results.getInt("acreage"));
		p.setElevationInFeet(results.getInt("elevationinfeet"));
		p.setMilesOfTrail(results.getFloat("milesoftrail"));
		p.setNumberOfCampsites(results.getInt("numberofcampsites"));
		p.setClimate(results.getString("climate"));
		p.setYearFounded(results.getInt("yearfounded"));
		p.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		p.setInspirationalQuote(results.getString("inspirationalquote"));
		p.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		p.setParkDescription(results.getString("parkdescription"));
		p.setEntryFee(results.getInt("entryfee"));
		p.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		return p;
	}
	
	private Park mapRowToParkWithCount(SqlRowSet results) {
		Park p = new Park();
		p.setParkCode(results.getString("parkcode"));
		p.setParkCount(results.getInt("count"));
		return p;
	}
	
	
	
	

}
