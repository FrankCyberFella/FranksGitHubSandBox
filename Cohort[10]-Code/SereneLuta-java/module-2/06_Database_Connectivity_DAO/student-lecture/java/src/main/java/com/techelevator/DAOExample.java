package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
		// The application program must define a datasource and pass it to the DAO
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		//Use the DAO created for City table to access/update the City table data
		CityDAO dao = new JDBCCityDAO(worldDataSource); //Instantiate an instance of the DAO: gives
														// access to City DAO stuff
		
		City smallville = new City(); //make a city
		smallville.setCountryCode("USA"); //assign the data
		smallville.setDistrict("KS");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);
		
		dao.save(smallville); //calling method in  JDBCCityDAO to insert data in SQL DB
		
		City theCity = dao.findCityById(smallville.getId()); //search for the ID in Smallville
		System.out.println("ID:  " +theCity.getId() + " " + theCity.getName());
		
		City hometown = new City(); //Instantiate a new City obj
		hometown.setId(theCity.getId());
		hometown.setCountryCode("USA"); //assign the data
		hometown.setDistrict("CT");
		hometown.setName("Enfield");
		hometown.setPopulation(80000);
		
		dao.save(hometown); //updating theCity obj with the hometown values - ID should be unchanged
		theCity = dao.findCityById(hometown.getId());
		System.out.println("ID:  " +theCity.getId() + " " + theCity.getName());

	}

}
