package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO { // implement the interface for City table

	private JdbcTemplate myJdbcTemplate;// define a JDBCtemplate object for the DAO
	
	public JDBCCityDAO(DataSource aDataSource) { // constructor for DAO - receives a datasource when instantiated
		this.myJdbcTemplate = new JdbcTemplate(aDataSource);//instantiate a JdbcTemplate object and assign class reference
	}

	@Override
	public void save(City newCity) { //Receive a City object and return nothing
									// Add the City object to the data base
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		myJdbcTemplate.update(sqlInsertCity, newCity.getId(), //Replace the first "?" with the value returned by getID() - ID in the City passed
										  newCity.getName(),//Replace the second "?" with the value returned by getName() - Name in the City passed
										  newCity.getCountryCode(),//Replace the third "?" with the value returned by getCountrycode() - CountryCode in the City passed
										  newCity.getDistrict(),//Replace the fourth "?" with the value returned by getDistrict() - District in the City passed
										  newCity.getPopulation());//Replace the fifth "?" with the value returned by getPop() - Population in the City passed
	}
	
	@Override
	public City findCityById(long id) {// receive a long and return a City object or null if nothing found in database
		City theCity = null; // City object to be returned
		
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlFindCityById, id);// run the SELECT replace "?" with value passed
		if(results.next()) {//if there was a result from the most recent SQL statement...
			theCity = mapRowToCity(results);//...pass the result to mapRowToCity() and assign the return object what comes back 
		}
		return theCity;//return the object created in the method which is the City found or null
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
	public void update(City city) {// receive a City object and update the database with the values
		
		String theUpdate = "UPDATE city " + // created SQL Update statement...
							" SET name = ? " +//...to use the values in the object
							" ,countryCode = ? " + //passed
							" ,district = ? " +
							" population = ? " +
							" ,WHERE id = ? ";
		
		myJdbcTemplate.batchUpdate(theUpdate  // run the update statement
							,city.getName()//replace the first "?" with the name from the object passed
							,city.getCountryCode()
							,city.getDistrict()
	}						,city.getPopulation()
							,city.getId()
							);

	@Override
	public void delete(long id) {
		
		
	}

	private long getNextCityId() {
		SqlRowSet nextIdResult = myJdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}

	private City mapRowToCity(SqlRowSet results) {// create an object of the class and assign the results from SQL statement
		City theCity; // the object to return 
		theCity = new City();// instantiate object to return (run constructor)
		theCity.setId(results.getLong("id")); // get the Id from result and assign to object; repeat for each method  
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity; // return the object with the results
	}
}
