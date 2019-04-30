package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO { // implement the interface for the City table, requires us to use the methods in the interface
											  // data her is in CityDAO

	private JdbcTemplate myJdbcTemplate; // defined a JCBtemplate object 
	
	public JDBCCityDAO(DataSource aDataSource) { // constructor for DAO recieve the datasource when its instantiated 
		this.myJdbcTemplate = new JdbcTemplate(aDataSource); // instaniate a JdbcTemplate object and assign class reference
		//this. is this object myJDBCTemplate
	}

	@Override // Ovrride indicates your overing a method in superclass or interface,
	public void save(City newCity) { // recieve a city object and return nothing 
									// Add city the City object to the data base 
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		myJdbcTemplate.update(sqlInsertCity, newCity.getId(),        // Replace the 1st ? with the value returned by getID() - ID in the City Passed in 
										  newCity.getName(),         // Replace the 2nd ? with the value returned by getName() -  
										  newCity.getCountryCode(),  //Replaced the 3rd ? wit the value returned by getCoutnryCode- countrycode
										  newCity.getDistrict(),     //Replaced the 4th ? with the value returned by getdistricr()
										  newCity.getPopulation());  //Replaced the 5th ? with the value returned by getPopulaiton()
	}
	
	@Override
	public City findCityById(long id) { // recieve a long and return a City object. So we need to setup a city object ot be returned. or null if nothing was found 
		City theCity = null;
		
		
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlFindCityById, id); // run the SELECT replace ? with value passed
		if(results.next()) { // making sure if there was a result formt the most recent SQL statment 
			theCity = mapRowToCity(results); // pass the results to the mapRowToCity method and assign the return object what comes back
		}
		return theCity; // return the object created in this method whti is the City found or null
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
	public void update(City city) { // recieve a City object and update the database with the values in that object
		/*// first thing to do is make a string  
		second this is a Where clause to select keys
		second thing is to 
		all this data is is from JBCE city 
		*/
		String theUpdate = "UPDATE city " + 
							"SET  name     = ? " +
							" ,countryCode = ? " +
							" ,distric     = ? " +
							" ,countryCode = ? " +
							" ,population   = ? " 
							" WHERE id     = ? " ;
							
			myJdbcTemplate.batchUpdate(theUpdate // from line 17 and used the update word to update statemt 
		//used the object that got passed that was city from line 69 this will replace the first question mark with a name from the object passed. 
			,city.getName()
			,city.getCountryCode()
			,city.getDistrict()
			,city.getPopulation()
			,city.getId()
			);
			
			// now go to the applicaton  and run it 
		

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

	private City mapRowToCity(SqlRowSet results) { // should always have a method that creates an object of the class and assign the results fromt he SQL statement
		City theCity; //Define an object to return
		theCity = new City(); // Instantiate object to return (run constructor)
		theCity.setId(results.getLong("id")); 						//Get the ID from the result and assign to object
		theCity.setName(results.getString("name")); 				//Get the Name from the result and assign to object
		theCity.setCountryCode(results.getString("countrycode"));	//Get the CountryName from the result and assign to object
		theCity.setDistrict(results.getString("district"));			//Get the District from the result and assign to object
		theCity.setPopulation(results.getInt("population"));		//Get the Population from the result and assign to object
		return theCity; // Return the object with the results
		//refer to JDBCCITYDOA to know the datat type of the results. example getString bec name is a string
	}
}
