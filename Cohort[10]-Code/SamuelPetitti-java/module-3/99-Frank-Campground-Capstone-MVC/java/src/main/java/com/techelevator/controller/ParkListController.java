package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techelevator.model.park.Park;
import com.techelevator.model.park.ParkDAO;

@Controller
public class ParkListController {

	@Autowired ParkDAO parkDao;
	
	@RequestMapping(path= "parkList", method= RequestMethod.GET)
	public String showParkList(ModelMap parkMap) {
		List<Park> parks = parkDao.getAllParks();
		parkMap.addAttribute("parks", parks);
		return "parkList";
	}
	


}
