package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.techelevator.model.park.Park;
import com.techelevator.model.park.ParkDAO;
import com.techelevator.model.survey.Survey;
import com.techelevator.model.survey.SurveyDAO;
import com.techelevator.model.user.User;
import com.techelevator.model.weather.Weather;
import com.techelevator.model.weather.WeatherDAO;

@Controller
public class homePageController {
	
@Autowired
public ParkDAO parkDao;

@Autowired
public WeatherDAO weatherDao;

@Autowired
public SurveyDAO surveyDao;

	@RequestMapping(path= {"/", "homePage"}, method=RequestMethod.GET)
	public String getHomePage(HttpServletRequest request) {
	List<Park> parkList = new ArrayList<Park>();
	parkList = parkDao.getAllParks();
	request.setAttribute("parkList", parkList);
		return "homePage";
	}
	
	@RequestMapping(path="/parkInfo", method=RequestMethod.GET)
	public String showParkInfo(HttpServletRequest request, HttpSession session) {
		List<Weather> weatherList = new ArrayList<Weather>();
		String parkCode = request.getParameter("parkCode");
		String tempChoice = getTempChoice(session);
		for(Park p : parkDao.getAllParks()) {
			if(p.getParkCode().equals(parkCode)) {
				request.setAttribute("park", p);
			}
		}
		weatherList = weatherDao.getForecastByCode(parkCode);
		System.out.print("low  = " + weatherList.get(0).getLow() +
						"low celcius = " + weatherList.get(0).getLowCelcius());
		request.setAttribute("weather", weatherList);
		return "parkInfo";
	}
	
	
//*******************************Celcius and Fahrenheit converter***********************************************
	@RequestMapping(path="/parkInfo", method=RequestMethod.POST)
	public String celciusAndFahrenheit(@RequestParam String tempChoice, 
									   @RequestParam String parkCode,
									   HttpSession session
									   ) {
		session.setAttribute("tempChoice", tempChoice);
		return "redirect:/parkInfo?parkCode=" + parkCode;
	}
	
	@RequestMapping(path="survey", method=RequestMethod.GET)
    public String getSurveyPage(ModelMap surveyHolder) {
		if(!surveyHolder.containsAttribute("Survey")) {
			surveyHolder.addAttribute("Survey",new Survey());
		}
		List<Park> parkList = new ArrayList<Park>();
		parkList = parkDao.getAllParks();
		surveyHolder.addAttribute("parkList", parkList);
		
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String surveyPage(@Valid @ModelAttribute("Survey") Survey newSurvey,
			BindingResult result, 
			RedirectAttributes flash) {
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Survey", result);
			flash.addFlashAttribute("Survey", newSurvey);
			return "redirect:/survey";
		}
		surveyDao.saveSurvey(newSurvey);
		return "redirect:/surveyResult";
	}
	
	@RequestMapping(path="/surveyResult", method=RequestMethod.GET)
	public String showSurveyResults(HttpServletRequest request) {
		List<Park> favoriteParks = parkDao.getFavoriteParks();
		System.out.println(favoriteParks.size());
		request.setAttribute("favoriteParks", favoriteParks);
//		List<Survey> surveyList = new ArrayList<Survey>();
//		surveyList = surveyDao.getAllSurveys();
//		System.out.println(surveyList.size());
//		request.setAttribute("surveyList", surveyList );
     	return "surveyResult";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String showRegisterForm(Model modelHolder) {
		if( ! modelHolder.containsAttribute("User")) {		
			modelHolder.addAttribute("User", new User());	
		}
		return "login";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String submitRegisterForm(
			@Valid @ModelAttribute("User") User newUser,		
			BindingResult result,			
			RedirectAttributes flash) {
		
		if(result.hasErrors()) {			
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "User", result);  
			flash.addFlashAttribute("User", newUser);				
			return "redirect:/login";				
		}
		
		flash.addFlashAttribute("message", "You have successfully registered."); 
		return "redirect:/loginConfirmation";
	}

	@RequestMapping(path="loginConfirmation", method=RequestMethod.GET)
	public String showLoginConfirmationView() {
		return "loginConfirmation";
	}
	
	
	
	private String getTempChoice(HttpSession session) {
		String tempChoice = (String)session.getAttribute("tempChoice");
		if(tempChoice == null) {
			tempChoice = "F";
			session.setAttribute("tempChoice", tempChoice);
		}
		return "tempChoice";
	}
	
	
}
