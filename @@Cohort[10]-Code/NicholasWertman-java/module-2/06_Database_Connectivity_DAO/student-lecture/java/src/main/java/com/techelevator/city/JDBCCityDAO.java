package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO { //implement interface for City table

	private JdbcTemplate myJdbcTemplate;	//define a JDBC template object for the DAO
	
	public JDBCCityDAO(DataSource aDataSource) {	//Ctor for the DAO - receive datasource when instantiated
		this.myJdbcTemplate = new JdbcTemplate(aDataSource);	//  instantiate a JdbcTemplate object and assign class reference
	}

	@Override		//Overriding the method in the interface 
	public void save(City newCity) {	//   Receive a City object and return nothing
										//   Add the City object to the data base 
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		myJdbcTemplate.update(sqlInsertCity, newCity.getId(),			//Replace the first question mark with the value returned by getID()  -  ID in the City passed
										     newCity.getName(),			//Replace the second question mark with the value returned by getName()  -  Name in the City passed
										     newCity.getCountryCode(),	//Replace the third question mark with the value returned by getCountryCode()  -  Country Code in the City passed
										     newCity.getDistrict(),		//Replace the fourth question mark with the value returned by getDistrict()  -  District in the City passed
										     newCity.getPopulation());	//Replace the fifth question mark with the value returned by getPopulation()  -  Population in the City passed
	}
	
	@Override
	public City findCityById(long id) {
		City theCity = null;
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlFindCityById, id);
		if(results.next()) {
			theCity = mapRowToCity(results);
		}
		return theCity;
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
		
		String theUpdate = "UPDATE city " 			 +	// created SQL UPDATE statement 
								" SET name     = ? " +	// to use the values in the object
								" ,countrycode = ? " +	// passed
								" ,district    = ? " +
								" ,population  = ? " +
								"WHERE id      = ? " ;
		myJdbcTemplate.update(theUpdate					//run the update statement 
							,city.getName()				//Replace the first question mark with the name from the object passed 
							,city.getCountryCode()		//Replace the second question mark with the name from the object passed 
							,city.getDistrict()			//Replace the third question mark with the name from the object passed 
							,city.getPopulation()		//Replace the fourth question mark with the name from the object passed 
							,city.getId()				//Replace the fifth question mark with the name from the object passed 
				);
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
