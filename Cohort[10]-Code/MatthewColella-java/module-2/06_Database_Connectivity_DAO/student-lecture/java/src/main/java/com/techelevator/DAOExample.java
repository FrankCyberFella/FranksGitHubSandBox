package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
	
		BasicDataSource worldDataSource = new BasicDataSource();			//Defines Data Source
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		//Using the DAO created to access and Update the City table Data
		
		CityDAO dao = new JDBCCityDAO(worldDataSource);		//instantiate the DAO
		//Allows us to access th  dao stuff
		City smallville = new City();
		smallville.setCountryCode("USA");
		smallville.setDistrict("KS");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);
		
		dao.save(smallville); //calls CityDAO save method, which is the JBDCCityDAO save method
		
		City theCity = dao.findCityById(smallville.getId());
		
		System.out.println(theCity.getId() + " " + theCity.getName());
		
		City hometown = new City();
		
		hometown.setId(theCity.getId());
		hometown.setCountryCode("USA");
		hometown.setDistrict("AK");
		hometown.setName("Onesf");
		hometown.setPopulation(33);
		
		dao.update(hometown);
		 theCity = dao.findCityById(hometown.getId());
		
		System.out.println(theCity.getId() + " " + theCity.getName());
		
	}

}
