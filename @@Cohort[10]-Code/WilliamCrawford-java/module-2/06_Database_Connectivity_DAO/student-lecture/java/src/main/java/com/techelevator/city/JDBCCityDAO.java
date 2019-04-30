package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO { //implement the interface for the City table

	private JdbcTemplate myJdbcTemplate;// defined a JdbcTemplate object for the DAO
	
	public JDBCCityDAO(DataSource aDataSource) {             //constructor for DAO - receive a datasource when instantiated
		this.myJdbcTemplate = new JdbcTemplate(aDataSource); //instantiate a JdbcTemplate object and assign class reference
	}

	@Override
	public void save(City newCity) { // receive a City object and return nothing
									// Add the City object to the data base
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		myJdbcTemplate.update(sqlInsertCity, newCity.getId(),          // Replace the 1st ? with the value returned by getID() - ID in the City passed
										     newCity.getName(),        // Replace the 2nd ? with the value returned by getName() - Name in the City passed
										     newCity.getCountryCode(), // Replace the 3rd ? with the value returned by getCountryCode() - CountryCode in the City passed
										     newCity.getDistrict(),    // Replace the 4th ? with the value returned by getDistrict() - District in the City passed
										     newCity.getPopulation()); // Replace the 5th ? with the value returned by getPopulation() - Population in the City passed
	}
	
	@Override
	public City findCityById(long id) { //receive a lon and return a City object or null if nothing was found
		City theCity = null;// City object to be returned
		
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							     "FROM city "+
							     "WHERE id = ?";
		
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlFindCityById, id);// run the SELECT replace ? with value passed
		if(results.next()) {                 // if there was a result from the SQL statement
			theCity = mapRowToCity(results); //  pass the results to  mapRowToCity() and assign the return object what comes back
		}
		return theCity;   // return the object created in this method which is the City found or null
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {     //receive a City object and update the database with the values in that object
		
	String theUpdate = "UPDATE city"
						"SET name       = ?"+
			            "   ,countryCode= ?"+
	                    "   ,district   = ?"+
                        "   ,population = ?"+
                        "WHERE id       = ?";
	
	myJdbcTemplate.update(theUpdate
						,city.getName()	
						,city.getcountyCode()
						,city.getdistrict()
						,city.getpopulation()
						,city.getName()
	}

	private long getNextCityId() {
		SqlRowSet nextIdResult = myJdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}

	private City mapRowToCity(SqlRowSet results) { //create an object of the class and assign the SQL statement
		City theCity;             // Define an object to return
		theCity = new City();		//Instantiate object to return (run ctor)
		theCity.setId(results.getLong("id"));                     // Get the ID from the result and assign to object
		theCity.setName(results.getString("name"));               // Get the name from the result and assign to object
		theCity.setCountryCode(results.getString("countrycode")); // Get the countrycode from the result and assign to object
		theCity.setDistrict(results.getString("district"));       // Get the district from the result and assign to object
		theCity.setPopulation(results.getInt("population"));      // Get the population from the result and assign to object
		return theCity;
	}
}
