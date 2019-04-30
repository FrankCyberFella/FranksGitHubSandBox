package com.techelevator.controller;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.model.park.ParkDAO;

@Controller
public class ParkListController {

	@Autowired
	private ParkDAO aParkDAO;
	
	@RequestMapping(path="/parkList")
	public String showParkList(ModelMap parkMap) {
		
		List<Park> parks = aParkDAO.getAllParks();
		parkMap.addAttribute("parks", parks);
		return "parkList";
	}
}
