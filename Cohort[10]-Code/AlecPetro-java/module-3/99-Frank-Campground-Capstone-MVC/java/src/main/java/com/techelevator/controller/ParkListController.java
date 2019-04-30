package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.model.park.Park;
import com.techelevator.model.park.ParkDAO;

@Controller
public class ParkListController {
	
	@Autowired
	private ParkDAO aParkDAO;
		
	@RequestMapping(path="/parkList") // Handle the /parkList URL path
	public String showParkList(ModelMap parkMap) {	// give me a ModelMap to share data with View
		
	List<Park> parks = aParkDAO.getAllParks();	// get the data from the Model
	parkMap.addAttribute("parks", parks);	// share the ModelMap with the View
		
		return "parkList"; // name of the jsp/View to be displayed
	}
	
	


}
