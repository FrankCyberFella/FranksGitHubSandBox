package com.techelevator.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.ParkDao;
import com.techelevator.model.WeatherDao;

@Controller
@Scope("session")
public class HomeController {

	@Autowired
	ParkDao parkDao;
	
	@Autowired
	WeatherDao weatherDao;
	
	@RequestMapping(value={"/","/home"})
	public String displayHomeRoot(HttpServletRequest request, HttpSession session){
		if(session.isNew()) {
			session.setAttribute("degrees", "F");;
		}
		request.setAttribute("parks", parkDao.getAllParks());
		return "home";
	}
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String displayParkDetail(HttpServletRequest request, HttpSession session) {
		String parkCode = request.getParameter("parkCode");
		session.setAttribute("degrees", request.getParameter("degrees"));
		request.setAttribute("park", parkDao.getParkById(parkCode));
		request.setAttribute("weather", weatherDao.getWeatherByCode(parkCode));
		return"parkDetail";
	}
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.POST)
	public String displayParkDetailPost(HttpSession session, HttpServletRequest request) {
		session.setAttribute("degrees", request.getParameter("degrees"));
		return "redirect:/parkDetail";
		
	}
	
}
