package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
	
		// The application program must define a datasource and pass it to the DAO
		
		BasicDataSource worldDataSource = new BasicDataSource(); 		// Defines data source and passes it to DAO
		worldDataSource.setUrl("jdbc:postgresql://localhost:5433/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		// Use the DAO created for City table to access\Updtae the City table data
		CityDAO dao = new JDBCCityDAO(worldDataSource); // Instantiate a CityDAO object - access to City DAO stuff
		
		City smallville = new City();
		smallville.setCountryCode("USA");
		smallville.setDistrict("KS");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);
		
		dao.save(smallville);	// call the CityDAO save() to write the new city to the database
		
		City theCity = dao.findCityById(smallville.getId());
		System.out.println("ID: " + theCity.getId() + ", Name: " + theCity.getName());
		
		
		City hometown = new City();			// Instantiate a new City object wth date to use in the update
		hometown.setId(theCity.getId());
		hometown.setCountryCode("USA");
		hometown.setDistrict("CT");
		hometown.setName("Enfield");
		hometown.setPopulation(80000);
		

		dao.update(hometown);				// update theCity object with the hometown values - id should be unchanged
		theCity = dao.findCityById(hometown.getId());
		System.out.println("ID: " + theCity.getId() + ", Name: " + theCity.getName());
		
	}

}
