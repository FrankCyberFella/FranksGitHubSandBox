package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.dao.park.model.Park;
import com.techelevator.dao.park.model.ParkDao;
import com.techelevator.dao.weather.model.Weather;
import com.techelevator.dao.weather.model.WeatherDao;
import com.techelevator.survey.model.Survey;
import com.techelevator.survey.model.SurveyDAO;


@Controller
@Scope("session")
public class ParkController {

@Autowired
private ParkDao parkDao;
@Autowired
private WeatherDao weatherDao;
@Autowired
private SurveyDAO surveyDao;
	
	@RequestMapping(path= {"/", "/home"}, method=RequestMethod.GET)
	public String parkIndex(ModelMap modelHolder, HttpSession session) {
		
		if (session.isNew()) {
		session.setAttribute("temp", "Fahrenheit");
		} 
		modelHolder.addAttribute("parks", parkDao.getAllParks());
		return "homePage";
	}
	
	@RequestMapping(path="parkDetail", method=RequestMethod.GET)
	public String showParkDetail(HttpServletRequest request, HttpSession session) {
		session.setAttribute("temp", request.getParameter("mySubmit"));
		
		String code = request.getParameter("parkcode");
		
		
		for(Park park : parkDao.getAllParks()) {
			if(park.getParkCode().equals(code)) {
				request.setAttribute("detail", park);
		
			}
		}
		request.setAttribute("today", weatherDao.getTodayWeather(code));	
		request.setAttribute("four", weatherDao.getFourWeather(code));
		return "parkDetail";
	}
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String showSurveyForm(ModelMap modelHolder) {
		modelHolder.addAttribute("parks", parkDao.getAllParks());
		
		if( ! modelHolder.containsAttribute("Survey")) {
			modelHolder.addAttribute("Survey", new Survey());
		}
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String submitSurveyForm(
			@Valid @ModelAttribute("Survey") Survey registerFormValues,
			
			BindingResult result,		//object to hold the result of validation
			RedirectAttributes flash	//define a flash object (exist only for the next request)
	){
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Survey", result);
			flash.addFlashAttribute("Survey", registerFormValues);
			return "redirect:/survey";
		}
		
		
		surveyDao.saveSurvey(registerFormValues);
		return "redirect:/results";
	}

	@RequestMapping(path="/results", method=RequestMethod.GET)
	public String showLoginConfirmationPage(ModelMap modelHolder) {
		modelHolder.addAttribute("park", parkDao.getParkCount());
		return "results";
	}
}
