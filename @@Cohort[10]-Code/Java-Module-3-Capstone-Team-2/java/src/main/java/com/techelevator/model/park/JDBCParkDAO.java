package com.techelevator.model.park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component 
public class JDBCParkDAO implements ParkDAO {
	
private JdbcTemplate jdbcTemplate;	

@Autowired
	public JDBCParkDAO(DataSource datasource) {
	this.jdbcTemplate = new JdbcTemplate(datasource);
}

// Method to retrieve all of our parks in a list through a query
	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<Park>();
		String sqlGetAllParks = "SELECT parkCode, "
				+ "parkName, "
				+ "state, "
				+ "acreage, "
				+ "elevationInFeet, "
				+ "milesOfTrail, "
				+ "numberOfCampsites, "
				+ "climate, "
				+ "yearFounded, "
				+ "annualVisitorCount, "
				+ "inspirationalQuote, "
				+ "parkDescription, "
				+ "entryFee, "
				+ "numberOfAnimalSpecies "
				+ "FROM park "
				+ "ORDER BY parkName ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);
		while(results.next()) {
			allParks.add(mapRowToPark(results));
		}
		// TODO Auto-generated method stub
		return allParks;
	}

	@Override
	public List<Park> getFavoriteParks() {
		// TODO Auto-generated method stub
		List<Park> favoriteParks = new ArrayList<Park>();
		String sqlGetFavorites = "select count(s.parkcode), p.parkname , p.parkcode "
								+"from survey_result s "
		                        +"inner join park p "
		                        +"on s.parkcode = p.parkcode "
		                        +"group by s.parkcode, p.parkname, p.parkcode "
		                        +"order by count desc, p.parkname";        
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetFavorites);
		while(results.next()) {
			Park favoritePark = new Park();
				favoritePark.setParkName(results.getString("parkname"));
				favoritePark.setParkVotes(results.getInt("count"));
				favoritePark.setParkCode(results.getString("parkcode"));
				favoriteParks.add(favoritePark);
		}
		return favoriteParks;
	}
	
	
	
	//	 Method to map our next query row set 
	private Park mapRowToPark(SqlRowSet results) {
		Park park = new Park();
		park.setParkCode(results.getString("parkCode"));
		park.setParkName(results.getString("parkName"));
		park.setState(results.getString("state"));
		park.setAcreage(results.getInt("acreage"));
		park.setElevationInFeet(results.getInt("elevationInFeet"));
		park.setMilesOfTrail(results.getDouble("milesOfTrail"));
		park.setNumberOfCampsites(results.getInt("numberOfCampsites"));
		park.setClimate(results.getString("climate"));
		park.setYearFounded(results.getInt("yearFounded"));
		park.setAnnualVisitorCount(results.getInt("annualVisitorCount"));
		park.setInspirationalQuote(results.getString("inspirationalQuote"));
		park.setParkDescription(results.getString("parkDescription"));
		park.setEntryFee(results.getInt("entryFee"));
		park.setNumberOfAnimalSpecies(results.getInt("numberOfAnimalSpecies"));
		return park;
	}


}
