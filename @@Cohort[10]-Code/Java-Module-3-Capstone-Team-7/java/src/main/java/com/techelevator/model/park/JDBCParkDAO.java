package com.techelevator.model.park;

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
			String sqlGetAllParks = "SELECT * from park ORDER BY parkName";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);
			while (results.next()) {
				allParkList.add(mapRowToPark(results));
			}
			return allParkList;
		}
		
		private Park mapRowToPark(SqlRowSet results) {
			Park p = new Park();
			p.setParkCode(results.getString("parkCode"));
			p.setParkName(results.getString("parkName"));
			p.setState(results.getString("state"));
			p.setAcreage(results.getInt("acreage"));
			p.setElevationInFeet(results.getInt("elevationInFeet"));
			p.setMilesOfTrail(results.getDouble("milesOfTrail"));
			p.setNumberOfCampsites(results.getInt("numberOfCampsites"));
			p.setClimate(results.getString("climate"));
			p.setYearFounded(results.getInt("yearFounded"));
			p.setVisitorCount(results.getInt("annualVisitorCount"));
			p.setInspirationalQuote(results.getString("inspirationalQuote"));
			p.setInspirationalQuoteSource(results.getString("inspirationalQuoteSource"));
			p.setParkDescription(results.getString("parkDescription"));
			p.setEntryFee(results.getInt("entryFee"));
			p.setNumberOfAnimalSpecies(results.getInt("numberOfAnimalSpecies"));
			return p;
		}
		
		@Override
		public Park getParkByCode(String parkCode) {
			Park parkByCode = new Park();
			String sqlGetParkById = "SELECT * FROM park WHERE parkCode = ?";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParkById, parkCode);
			if(results.next()) {
				parkByCode = mapRowToPark(results);
				
			}
			return parkByCode;
		}

}
