package com.techelevator.npgeek.controller;


import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.techelevator.dao.ParkDao;
import com.techelevator.dao.SurveyDao;
import com.techelevator.dao.WeatherDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.Weather;


@Controller
@SessionAttributes("temp")
public class ParksController {

	@Autowired
	private ParkDao parkDao;
	
	@Autowired
	public WeatherDao weatherDao;
	
	@Autowired
	public SurveyDao surveyDao;
	
	@RequestMapping(path= {"/", "/home"}, method=RequestMethod.GET)
	public String showHomepage(HttpServletRequest request) {
		
		List<Park> parkList = parkDao.getAllParks();
		
		request.setAttribute("parks", parkList);
		
		return "homepage";
	}
	
	@RequestMapping(path="/parkDetails", method=RequestMethod.GET)
	public String showParkDetails(ModelMap map, HttpServletRequest request) {
		
		String theParkCode = request.getParameter("theCode").toUpperCase();
		Park thePark = parkDao.getParkByCode(theParkCode);		
		List<Weather>theWeather = weatherDao.getFiveDayForecastByParkCode(theParkCode);
		map.put("days", getDaysOfWeek());
		map.put("park", thePark);
		map.put("weather", theWeather);
		
		return "parkDetails";
	}
	
	@RequestMapping(path="/parkDetails", method=RequestMethod.POST)
	public String showParkDetailsCelcius(ModelMap map, HttpServletRequest request, @RequestParam String temperature) {
		
		String theParkCode = request.getParameter("theCode").toUpperCase();
		Park thePark =parkDao.getParkByCode(theParkCode);		
		List<Weather>theWeather = weatherDao.getFiveDayForecastByParkCode(theParkCode);
		
		map.put("temp", temperature);
		map.put("days", getDaysOfWeek());
		map.put("park", thePark);
		map.put("weather", theWeather);
		
		
		return "parkDetails";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String showSurvey(Model modelHolder) {
		if(! modelHolder.containsAttribute("Survey")) {
			modelHolder.addAttribute("Survey", new Survey());
		}
		
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String surveySubmit(@Valid @ModelAttribute("Survey") Survey survey,
									BindingResult result,
									RedirectAttributes flash) {
		if(result.hasErrors()) {
            flash.addFlashAttribute("Survey", survey);
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Survey", result);
             return "redirect:/survey";
        }
		
		String parkCode = survey.getParkCode();
		String email = survey.getEmailAddress();
		String state = survey.getState();
		String activityLevel = survey.getActivityLevel();
		
		surveyDao.saveSurvey(parkCode, email, state, activityLevel);
		
        return "redirect:/favoriteParks";
	}
	
	@RequestMapping(path="/favoriteParks", method=RequestMethod.GET)
	public String showFavoriteParks(Model modelHolder) {
		Map<String, Integer> surveyCount = surveyDao.getAllSurveyCounts();
		
		
		modelHolder.addAttribute("surveys", surveyCount);
		
		return "favoriteParks";
	}
	
	public String[] getDaysOfWeek() {
		  Calendar now = Calendar.getInstance();
		  String[] fiveDays = new String[5];
		  String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday",
		        "Friday", "Saturday" };
		  int day = now.get(Calendar.DAY_OF_WEEK);
		  fiveDays[0] = strDays[day-1];
		  for(int i=1; i<5; i++) {
			  int dayOfWeek = day + i;
			  if(dayOfWeek > 7) {
				  dayOfWeek = dayOfWeek - 7;
			  } 
			  fiveDays[i] = strDays[dayOfWeek-1];
		  }
		  
		 return fiveDays;
	}
	
}
