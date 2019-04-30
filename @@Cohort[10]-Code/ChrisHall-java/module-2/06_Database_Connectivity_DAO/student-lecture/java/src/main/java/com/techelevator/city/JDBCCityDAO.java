package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO {  //implement the interface for the City table

	private JdbcTemplate myJdbcTemplate;  // define a JdbcTemplate object for the DAO
	
	public JDBCCityDAO(DataSource aDataSource) {  // constructor for DAO - receive a datasource when instantiated
		
		this.myJdbcTemplate = new JdbcTemplate(aDataSource); //instantiate a JdbcTemplate object and assign class reference
	}

	@Override // override the interface method, only used to override the interface (generic) methods
	// don't need for other methods we make (not in the interface)
	public void save(City newCity) { // receive a City object and return nothing
									// add the city object to the database
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		myJdbcTemplate.update(sqlInsertCity, 	newCity.getId(),  //replace the first ? with value returned by getId(), the id in the city that was passed
										  		newCity.getName(),//replace the second ? with value returned by getName(), the name in the city that was passed
										  		newCity.getCountryCode(),   //    etc
										  		newCity.getDistrict(),
										  		newCity.getPopulation());
	}
	
	@Override
	public City findCityById(long id) { // receive a long id and return a City object, or null if nothing was found in the dbase
		City theCity = null;  // need to setup a City object to be returned 
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlFindCityById, id); // run the SELECT and replace the ?
		if(results.next()) {  // makes sure there was a result from the most recent SQL statement..
			theCity = mapRowToCity(results);// ... pass the results to mapRowToCity() method and assign the return object what comes back
		}
		return theCity;  // return the object created in this method, which is the City found (or null)
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
		 theUpdate = "UPDATE city " +   				// created the SQL UPDATE statement 
							"SET 	name 			= ? "+ // to use the values in the object passed
							" 		,countryCode 	= ? "+
							"		,district 		= ? "+
							" 		,population 	= ? "+
							"WHERE 	id 				= ? ";
		
		myJdbcTemplate.update(theUpdate,	theCity.getName(),				
									theCity.getCountryCode(),		
											city.getDistrict(),			
											city.getPopulation(),					
											city.getId());
		
		}
		
	}

	@Override // we will write this method, see tape
	// receives a City object and update the database with the values in that object
	public void update(City city) {
		// TODO Auto-generated method stub
		
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

	//  **** should always have a method to create an object of the class and assign the results from the SQL statement
	//  *********
	private City mapRowToCity(SqlRowSet results) {  
		City theCity; // define and object to return
		theCity = new City(); // Instantiate an object to return
		theCity.setId(results.getLong("id"));  // get the id from the result and assign to object
		theCity.setName(results.getString("name")); //   etc
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity;// return the object
	}
}
