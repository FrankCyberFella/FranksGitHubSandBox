package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.model.park.Park;
import com.techelevator.model.park.ParkDAO;

@Controller
public class ParkListController {
	
	@Autowired
	private ParkDAO parkDao;

	@RequestMapping(path="/parkList")
	public String displayParks(ModelMap parkMap) {
		List<Park> allParks = new ArrayList<Park>();
		
		allParks = parkDao.getAllParks();
		
		parkMap.addAttribute("parks", allParks);
		
		return "parkList";
	}
	

	
}
