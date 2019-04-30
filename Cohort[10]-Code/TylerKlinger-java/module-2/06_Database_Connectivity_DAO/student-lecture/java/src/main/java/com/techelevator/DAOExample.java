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
		
		//use teh DAO created for City table to access/update teh City table data
		CityDAO dao = new JDBCCityDAO(worldDataSource); //Instantiate the CityDAO object
		
		City smallville = new City();//Instantiate a City to add to database
		smallville.setCountryCode("USA");
		smallville.setDistrict("KS");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);
		
		dao.save(smallville);// call the CityDAO save() to write the new city to the database
		
		City theCity = dao.findCityById(smallville.getId());
		System.out.println("Id: " + smallville.getId() + " " + smallville.getName());
		
		City hometown = new City();// Instantiate a new City object with date to use in update
		hometown.setId(theCity.getId());
		hometown.setCountryCode("USA");
		hometown.setDistrict("CT");
		hometown.setName("Enfield");
		hometown.setPopulation(80000);
	
		dao.update(hometown);//Update City object with the hometown values - Id should be unchanged
		theCity = dao.findCityById(hometown.getId());
		System.out.println("Id: " + theCity.getId() + " " + theCity.getName());
	}

}
