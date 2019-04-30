package com.techelevator.site;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.Campground;


public interface SiteDAO {
	
	

	public List <Site> listOfSites(Long id, String beginDate, String departureDate);
	
	public double costOfStay(String beginDate, String departureDate);

}
