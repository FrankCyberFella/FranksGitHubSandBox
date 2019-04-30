package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
//  The application program must define a datasource and pass it to the DAO.	
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");

		// use DAO created for City table to access/update the City table data		
		CityDAO dao = new JDBCCityDAO(worldDataSource); // instantiate a DAO object
		// gives access to City DAO stuff
		
		City smallville = new City();   // create city
		smallville.setCountryCode("USA");
		smallville.setDistrict("KS");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);
		
		dao.save(smallville);  // call the City DAO save() method to write the new city to the database
		
		City theCity = dao.findCityById(smallville.getId()); // search for the id in smallville, seeing if the insert really worked
		
		City hometown = new City();   // create city to use in the update
		hometown.setId(theCity.getId());
		hometown.setCountryCode("USA");
		hometown.setDistrict("CT");
		hometown.setName("Enfield");
		hometown.setPopulation(80000);
		
		dao.update(hometown);  // update the city object with the hometown values-- id should be unchanged
		theCity = dao.findCityById(hometown.getId()); //  ?
		System.out.println("Id: " + theCity.getId() + " " + theCity.getName());
	}

}
