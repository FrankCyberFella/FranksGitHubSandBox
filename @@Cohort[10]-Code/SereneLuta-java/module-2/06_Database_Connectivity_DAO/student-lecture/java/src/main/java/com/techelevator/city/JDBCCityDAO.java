package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO { //implement the interface of CityDAO

	private JdbcTemplate myJdbcTemplate; //defined a Jdbctemplate Object for the DAO
	
	public JDBCCityDAO(DataSource aDataSource) { //Constructor for the DAO - receive a datasource 
												 //when its instantiated
		this.myJdbcTemplate = new JdbcTemplate(aDataSource); // instantiate a JdbcTemplate object and
		// this. = this object								// and assigning class reference
		// setting it up like this makes the code loosely coupled with the datasource
	}

	@Override //overriding a method in the interface
	public void save(City newCity) { //Receive a City object and return nothing
		
									//Add the City object to the data base
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)"; //?'s are parameter values
		newCity.setId(getNextCityId());//Generated ID
		myJdbcTemplate.update(sqlInsertCity, newCity.getId(),
										  //Replace the 1st ? with the value returned by getID()  - ID in the City passed
				
										  newCity.getName(),  		//Replace 2nd ? w/the value returned by getName()
										  newCity.getCountryCode(), //Replace 3rd ? w/the value returned by getCountryCode()
										  newCity.getDistrict(),	//Replace 4th ? w/the value returned by getDistrict()
										  newCity.getPopulation()); //Replace 5th ? w/the value returned by getPopulation()
	
	}
	
	@Override
	public City findCityById(long id) { //receive a long and returns a City object or null if nothing was found in database
		City theCity = null; //City object to be returned. "null" is we have nothing for it right now
		
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlFindCityById, id); // run the SELECT //replace ? with the value passed
		if(results.next()) {									//if there was a result from the most recent SQL statement
			theCity = mapRowToCity(results); //pass the result to the mapRowToCity() and assign the return object what comes back
		}
		return theCity; //return the object created in this method or null
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
	public void update(City city) {//receive a City obj and update the database with the values in that obj
		String theUpdate = "UPDATE city " +				//created the update statement
						   "SET name = ?" + 			// to use the values in the object passed
						   "	,countrycode = ? " +	
						   "	,district    = ? " +
						   "	,population  = ? " + 
						   " WHERE id   	= ? ";
		
		//Run the update statement //Replace the 1st ? //Replace 2nd ?		  //Replace 3rd ?     //Replace 4th ?       //Replace WHERE ID ?
		myJdbcTemplate.update(theUpdate, city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation(), city.getId());
		
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

	private City mapRowToCity(SqlRowSet results) { //ALWAYS SHOULD HAVE: create an object of the class and assign
		City theCity;	//Define an Obj to return   // assign the results form the SQL statement
		theCity = new City();  //Instantiate object to return (run constructor)
		theCity.setId(results.getLong("id"));  //Get the ID from the result and assign to object
		theCity.setName(results.getString("name")); //get name from the result and assign to object
		theCity.setCountryCode(results.getString("countrycode")); // get countrycode from the result and assign to object
		theCity.setDistrict(results.getString("district")); //get district from the result and assign to object
		theCity.setPopulation(results.getInt("population")); // get population from the result and assign to object
		return theCity; //return the object
	}
}
