package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
	
//	The application program must define a datasource and pass it to the DAO
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
// Use the DAO created for the city table to access and update the City table data
		CityDAO dao = new JDBCCityDAO(worldDataSource);	//Instantiate a CityDao object 
		//--> access to all CityDao stuff
		
		City smallville = new City();
		smallville.setCountryCode("USA");
		smallville.setDistrict("KS");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);
		
		dao.save(smallville);		// call the CityDAO save() to write the new city to the database
		
		City theCity = dao.findCityById(smallville.getId());
		
		City hometown = new City();
		hometown.setId(theCity.getId());
		hometown.setCountryCode("USA");
		hometown.setDistrict("CT");
		hometown.setName("Enfield");
		hometown.setPopulation(80000);
		
		dao.update(hometown);
		theCity = dao.findCityById(hometown.getId());
		System.out.println("ID: " + theCity.getId() + " " +  theCity.getName());
	}

}
