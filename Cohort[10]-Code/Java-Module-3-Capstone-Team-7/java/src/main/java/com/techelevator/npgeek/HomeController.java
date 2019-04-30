package com.techelevator.npgeek;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.park.Park;
import com.techelevator.model.park.ParkDao;
import com.techelevator.model.park.Survey;
import com.techelevator.model.park.SurveyDao;
import com.techelevator.model.park.Weather;
import com.techelevator.model.park.WeatherDao;

@Controller
@SessionAttributes("temp")
public class HomeController {
	
	@Autowired
	ParkDao parkDao;
	
	@Autowired
	WeatherDao weatherDao;
	
	@Autowired
	SurveyDao surveyDao;
	
	@RequestMapping(path={"/","/homePage"}, method=RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request) {
		
		List<Park> displayParks = new ArrayList<Park>();
		
		displayParks = parkDao.getAllParks();
		
		request.setAttribute("park", displayParks);
		
		return "homePage";
	}
	
	@RequestMapping(path="/detailPage", method=RequestMethod.GET)
	public String showParkDetail(ModelMap map, HttpServletRequest request) {
	
		String parkCode = request.getParameter("parkCode");
		
		Park parkDetail = new Park();
		List<Weather> parkWeather = new ArrayList<Weather>();
		
		parkDetail = parkDao.getParkByCode(parkCode);
		parkWeather = weatherDao.getAllWeather(parkCode);
		
		map.put("park", parkDetail);
		map.put("weather", parkWeather);
		
		return "detailPage";
	}
	
	@RequestMapping(path="/detailPage", method=RequestMethod.POST)
	public String showParkDetailsTemp(ModelMap map, HttpServletRequest request, @RequestParam String temperature) {
		
		String parkCode = request.getParameter("parkCode");
		
		Park parkDetail = new Park();
		List<Weather> parkWeather = new ArrayList<Weather>();
		
		parkDetail = parkDao.getParkByCode(parkCode);
		parkWeather = weatherDao.getAllWeather(parkCode);
		System.out.println(temperature);
		map.put("temp", temperature);
		map.put("park", parkDetail);
		map.put("weather", parkWeather);
		System.out.println(map.get("temp"));
		
		return "detailPage";
	}
	
	@RequestMapping(path= {"/surveyPage"}, method=RequestMethod.GET)
	public String showSurveyPage(HttpServletRequest request, ModelMap surveyMap) {
		if (!surveyMap.containsAttribute("Survey")) {
			surveyMap.addAttribute("Survey", new Survey());
		}
		
		request.setAttribute("park", parkDao.getAllParks());
		
		
		return "surveyPage";
	}

	@RequestMapping(path= {"/favParks"}, method = RequestMethod.GET)
	public String showSurveyPage(HttpServletRequest request) {
		
		request.setAttribute("surveys", surveyDao.getAllSurveys());
		
		
		return "/favParks";
	}
	
	@RequestMapping(path = { "/favParks" }, method = RequestMethod.POST)
	public String showSurveyPage(@Valid @ModelAttribute("Survey") Survey surveyResults, 
								 BindingResult result, RedirectAttributes flash) {

		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Survey", result);
			flash.addFlashAttribute("Survey", surveyResults);
			return "redirect:/surveyPage";
		}
		Survey theSurvey = new Survey();
		
		theSurvey.setEmailAddress(surveyResults.getEmailAddress());
		theSurvey.setState(surveyResults.getState());
		theSurvey.setParkCode(surveyResults.getParkCode());
		theSurvey.setActivityLevel(surveyResults.getActivityLevel());
		theSurvey.setSurveyId(surveyResults.getSurveyId());

		surveyDao.save(theSurvey);

		return "redirect:/favParks";
	}

}
