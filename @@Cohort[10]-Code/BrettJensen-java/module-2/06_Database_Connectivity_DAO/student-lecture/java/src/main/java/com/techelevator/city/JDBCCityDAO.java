package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO {					// implement the interface for the city table

	private JdbcTemplate myJdbcTemplate;						// Define a jdbctemplate object for the DAO
	
	public JDBCCityDAO(DataSource aDataSource) {				// constructor for DAO - receive a data source
		this.myJdbcTemplate = new JdbcTemplate(aDataSource);    // instantiate a jdbctemplate object for the DAO
	}

	@Override
	public void save(City newCity) {		// Receive city object and return nothing
											// add the city object to the datebase
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		myJdbcTemplate.update(sqlInsertCity, newCity.getId(),
										  newCity.getName(),
										  newCity.getCountryCode(),
										  newCity.getDistrict(),
										  newCity.getPopulation());
	}
	
	@Override
	public City findCityById(long id) {			// receive a ong and return a City object or null if nothing was found 
		City theCity = null;					// null city object to return
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlFindCityById, id);  // run the select and repalce the ? with value passed
		if(results.next()) {					// If there was a result from sql statement
			theCity = mapRowToCity(results);	// pass results to mapRowToCity method and assign return object what comes back
		}
		return theCity;							// return the object created in this method which is the city found or null
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		ArrayList<City> cities = new ArrayList<>();
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population "+
										   "FROM city "+
										   "WHERE countrycode = ?";
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);
		while(results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		}
		return cities;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(City city) {
		String sqlUpdateCity = "UPDATE city " 		   +
							   "SET name          = ? "+
							   "	,countryCode  = ? "+
							   "	,district     = ? "+
							   "	,population   = ? "+
							   "Where id          = ? ";
		
		myJdbcTemplate.update(sqlUpdateCity, 
								city.getName()
								, city.getCountryCode()
								, city.getDistrict()
								, city.getPopulation()
								, city.getId());
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	private long getNextCityId() {
		SqlRowSet nextIdResult = myJdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}

	// Should always have a method to create an object of the class and assign the results from the sql statement
	private City mapRowToCity(SqlRowSet results) {
		City theCity;
		theCity = new City();
		theCity.setId(results.getLong("id"));
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity;
	}
}
