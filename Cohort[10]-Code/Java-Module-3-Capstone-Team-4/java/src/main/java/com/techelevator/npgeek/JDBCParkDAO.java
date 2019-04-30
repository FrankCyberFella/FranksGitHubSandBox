package com.techelevator.npgeek;

import java.util.ArrayList;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Park;

@Component	
public class JDBCParkDAO implements ParkDAO {

private JdbcTemplate jdbcTemplate;
@Autowired	
	public JDBCParkDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParkList = new ArrayList<Park>();
		String sqlGetAllParks = "SELECT * FROM park ORDER BY parkname";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);
		while (results.next()) {
			allParkList.add(mapRowToPark(results));
		}
		return allParkList;
	}
	
//	@Override
//	public List<Weather> getForecast(String code) {
//		List<Weather> forecastList = new ArrayList<Weather>();
//		String sqlGetForecast = "SELECT * FROM weather where parkcode=?";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetForecast, code);
//		while (results.next()) {
//			forecastList.add(mapRowToWeather(results));
//		}
//		return forecastList;
//	}


	
	private Park mapRowToPark(SqlRowSet results) {
		Park p = new Park();
		p.setParkCode(results.getString("parkcode"));
		p.setParkName(results.getString("parkname"));
		p.setState(results.getString("state"));
		p.setAcreage(results.getLong("acreage"));
		p.setElevationFeet(results.getLong("elevationinfeet"));
		p.setMilesOfTrail(results.getDouble("milesoftrail"));
		p.setNumberOfCampsites(results.getLong("numberofcampsites"));
		p.setClimate(results.getString("climate"));
		p.setYearFounded(results.getLong("yearfounded"));
		p.setVisitors(results.getLong("annualvisitorcount"));
		p.setQuote(results.getString("inspirationalquote"));
		p.setQuoteSource(results.getString("inspirationalquotesource"));
		p.setDescription(results.getString("parkdescription"));
		p.setEntryFee(results.getInt("entryfee"));
		p.setNumberOfSpecies(results.getInt("numberofanimalspecies"));
		return p;
	}

//	private Weather mapRowToWeather(SqlRowSet results) {
//		Weather f = new Weather();
//		f.setDay(results.getInt("fivedayforecastvalue"));
//		f.setLow(results.getInt("low"));
//		f.setHigh(results.getInt("high"));
//		f.setForecast(results.getString("forecast"));
//		
//		return f;
//	}
	
		

}
