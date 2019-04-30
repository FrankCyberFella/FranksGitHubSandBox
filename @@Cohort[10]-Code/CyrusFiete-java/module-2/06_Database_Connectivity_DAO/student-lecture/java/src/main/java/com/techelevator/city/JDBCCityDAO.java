package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO { //implement the interface for the City table

	private JdbcTemplate myJdbcTemplate;      //define a jdbctemplate object for the DAO
	
	public JDBCCityDAO(DataSource aDataSource) {              //constructor for DAO - receives a datasource when instantiated
		this.myJdbcTemplate = new JdbcTemplate(aDataSource);  //instantiate a jdbctemplate object and assigning class reference
	}

	@Override
	public void save(City newCity) {  //receive a city object and return nothing; add the city object to the database
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		myJdbcTemplate.update(sqlInsertCity, newCity.getId(),            //replace first ? with the value getID()
										  	 newCity.getName(),
										  	 newCity.getCountryCode(),
										  	 newCity.getDistrict(),
										  	 newCity.getPopulation());
	}
	
	@Override
	public City findCityById(long id) {       //receive a long and return a City object or null if nothing was found
		City theCity = null;                  //City object to be returned
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlFindCityById, id);
		if(results.next()) {                  //if there was a result from the most recent SQL statement
			theCity = mapRowToCity(results);  //pass the results to mapRowToCity() and assign the return object what comes back
		}
		return theCity;   //return the object created in this method
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
	public void update(City city) {  //receive a City object and update the database with the values
		
		String theUpdate = "UPDATE city " +
						   "SET name = ?," +
						   "countryCode = ?," +
						   "district = ?," +
						   "population = ?" +
						   "WHERE id = ? ";
		myJdbcTemplate.update(theUpdate, city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation());
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

	private City mapRowToCity(SqlRowSet results) { //create an object of the class and assign the results from the SQL statement
		City theCity;							   //define an object to return
		theCity = new City();					   //instantiate object to return (run ctor)
		theCity.setId(results.getLong("id"));						//get the ID from the result and assign to object
		theCity.setName(results.getString("name"));				    //...
		theCity.setCountryCode(results.getString("countrycode"));   //...
		theCity.setDistrict(results.getString("district")); 		//...
		theCity.setPopulation(results.getInt("population")); 		//...
		return theCity;
	}
}
