package com.techelevator.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.ParkDao;
import com.techelevator.model.Survey;
import com.techelevator.model.SurveyDao;
import com.techelevator.model.WeatherDao;

@Controller
public class SurveyController {

	@Autowired
	ParkDao parkDao;
	
	@Autowired
	WeatherDao weatherDao;
	
	@Autowired
	SurveyDao surveyDao;
	
	@RequestMapping("/survey")
	public String displayHomeRoot(HttpServletRequest request, ModelMap surveyMap){
		if(!surveyMap.containsAttribute("Survey")) {
			surveyMap.addAttribute("Survey", new Survey());
		}
		request.setAttribute("parks", parkDao.getAllParks());
		return "survey";
	}
	
//	@RequestMapping("/parkDetail")
//	public String displayParkDetail(HttpServletRequest request) {
//		String parkCode = request.getParameter("parkCode");
//		request.setAttribute("park", parkDao.getParkById(parkCode));
//		request.setAttribute("weather", weatherDao.getWeatherByCode(parkCode));
//		return"parkDetail";
//	}
//	
	
	@RequestMapping(path="/surveyResults", method=RequestMethod.GET)
	public String showSurveyResults(HttpServletRequest request) {
		
		request.setAttribute("mappyResults", surveyDao.getSurveyResults());
		request.setAttribute("county", surveyDao.getTotalCount());

		
		return "surveyResults";
	}
	
	@RequestMapping(path="/surveyResults", method=RequestMethod.POST)
	public String submitSurveyResults(@Valid @ModelAttribute("Survey") Survey surveyValues,
									  BindingResult result, RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Survey", result);
			flash.addFlashAttribute("Survey", surveyValues);
			return "redirect:/survey";

		}
		Survey survey = new Survey();
		
		survey.setEmailAddress(surveyValues.getEmailAddress());
		survey.setParkCode(surveyValues.getParkCode());
		survey.setState(surveyValues.getState());
		survey.setActivityLevel(surveyValues.getActivityLevel());
		survey.setParkCode(surveyValues.getParkCode());
		
		surveyDao.save(survey);
		

	
		
		
		return "redirect:/surveyResults";
	}
}