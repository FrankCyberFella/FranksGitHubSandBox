package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO { 	// implement the interface for the City table

	private JdbcTemplate myJdbcTemplate;		// instantiate a Jdbctemplate object for the DAO
	
	public JDBCCityDAO(DataSource aDataSource) {			// Constructor for DAO - receive a datasource when instantiated
		this.myJdbcTemplate = new JdbcTemplate(aDataSource);// instantiate a JdbcTemplate object and assign class reference
	}

	@Override
	public void save(City newCity) { 	// Receive a City object and return nothign
									 	// Add the City object to the data base
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		myJdbcTemplate.update(sqlInsertCity, newCity.getId(),		// Replace the 1st ? with the value returned by getId - ID in the City passed
										  newCity.getName(),		// Replace the 2nd ? with the value returned by getName
										  newCity.getCountryCode(),	// Replace the 3rd ? with the value returned by getCountryCode
										  newCity.getDistrict(),	// Replace the 4th ? with the value returned by getDistrict
										  newCity.getPopulation());	// Replace the 5th ? with the value returned by getPopulation
	}
	
	@Override
	public City findCityById(long id) { // receive a long and return a City obect or null if nothing was found
		City theCity = null;			// city object to be returned if no result
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlFindCityById, id); // run the SELECT replace the ? with the value that was passed
		if(results.next()) {					// if there was a result from the most recent SQL statement
			theCity = mapRowToCity(results);	// pass the results to mapRowToCity() and assign the return object what comes back
		}
		return theCity; // return the object created in this method which is the city found or null
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
	public void update(City city) {	// receive a City object and update the database with the values
		City theCity = null;
		String theUpdate = "UPDATE city " +  	  // created the SQL UPDATE statement
				"SET         	 name = ? " + // to use the values in the object passed
				"        ,countrycode = ? " + 
				"	        ,district = ? " + 
				"         ,population = ? " +
				"WHERE		        id = ?;";
		// TODO Auto-generated method stub
		myJdbcTemplate.update(theUpdate		// Run the Update statement
				, city.getName()					// Replace the 1st ? with the name from object passed
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

	private City mapRowToCity(SqlRowSet results) { // create an object of the class and assign the results from SQL statement
		City theCity;			// Define an object to return
		theCity = new City();	// Instantiate object to return (run ctor)
		theCity.setId(results.getLong("id"));						// Get the Id from the results and assign to object
		theCity.setName(results.getString("name"));					// Get ..  Name ....
		theCity.setCountryCode(results.getString("countrycode"));	// Get ..  Countrycode ....
		theCity.setDistrict(results.getString("district"));			// Get ..  District ....
		theCity.setPopulation(results.getInt("population"));		// Get ..  Population ....
		return theCity;			// Return the object with the results
	}
}
