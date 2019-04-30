package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.park.Park;
import com.techelevator.model.park.ParkDAO;

@Controller 
public class CampgroundMVC {

	@Autowired 
	ParkDAO parkDao;

	@RequestMapping("/")
	public String showHomePage(ModelMap parkMap) {
//		List<Park> allParks = new ArrayList<Park>();
//		
//		allParks = parkDao.getAllParks();
//		
//		parkMap.addAttribute("parks", allParks);
		
		return "home";
	}
	
}
