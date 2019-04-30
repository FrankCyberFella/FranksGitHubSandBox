package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
	
		// The application program must define a data source and pass it to the DAO
		
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		// Use the DAO created for the City table to access/update the city table data
		
		CityDAO dao = new JDBCCityDAO(worldDataSource);	//Instantiate a city DAO object
		
		City smallville = new City();
		smallville.setCountryCode("USA");
		smallville.setDistrict("KS");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);
		
		dao.save(smallville);	// call the cityDAO save() to the write the city to the database
		
		City theCity = dao.findCityById(smallville.getId());
		System.out.println("Id: " + theCity.getId() + "Name: " + theCity.getName());
		
		City hometown = new City();
		hometown.setId(theCity.getId());
		hometown.setCountryCode("USA");
		hometown.setDistrict("CT");
		hometown.setName("Enfield");
		hometown.setPopulation(80000);
		
		dao.update(hometown);
		theCity = dao.findCityById(hometown.getId());
		System.out.println("Id: " + theCity.getId() + "Name: " + theCity.getName());
	}

}
