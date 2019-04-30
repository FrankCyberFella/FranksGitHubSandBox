package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
	
		//The application program must define a datasource and pass it to the DAO
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		// Use the DAO created for City table to access/Update the City table data
		CityDAO dao = new JDBCCityDAO(worldDataSource); // Instantiate a CityDAO object
														// access to city Dao stuff 
		
		City smallville = new City();// make a city
		smallville.setCountryCode("USA"); // assign data
		smallville.setDistrict("KS");// assign data
		smallville.setName("Smallville");// assign data
		smallville.setPopulation(42080);// assign data
		
		dao.save(smallville); // call the CityDAO save() to write the new city to the database
		
		City theCity = dao.findCityById(smallville.getId());// search for id in smallville
	
		System.out.println("Id: " + theCity.getId(), + " + theCity.getName();  
		
	}

}
