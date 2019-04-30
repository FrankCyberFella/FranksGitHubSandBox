package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Park;
import com.techelevator.model.Survey;
import com.techelevator.model.Weather;
import com.techelevator.npgeek.ParkDAO;
import com.techelevator.npgeek.SurveyDAO;
import com.techelevator.npgeek.WeatherDAO;

@Controller
public class ParkListController {
	
	@Autowired
	private ParkDAO parkDao;
	@Autowired
	private WeatherDAO weatherDao;
	@Autowired
	private SurveyDAO surveyDao;

	@RequestMapping("/")
	public String showHomePage(ModelMap parkMap, HttpSession session) {
		List<Park> allParks = new ArrayList<Park>();
		
		
		session.setAttribute("temp",0);
		
		
		allParks = parkDao.getAllParks();

		parkMap.addAttribute("parks", allParks);
		
		return "home";
	}
	@RequestMapping("/home")
	public String homePage(ModelMap parkMap, HttpSession session) {
		List<Park> allParks = new ArrayList<Park>();
		
		allParks = parkDao.getAllParks();

		parkMap.addAttribute("parks", allParks);
		
		return "home";
	}
	
	@RequestMapping(path="/parkList")
	public String displayParks(ModelMap parkMap) {
		List<Park> allParks = new ArrayList<Park>();
		
		allParks = parkDao.getAllParks();
		
		parkMap.addAttribute("parks", allParks);
		
		return "parkList";
	}
	@RequestMapping(path="/parkInfo" , method=RequestMethod.GET)
	public String displayInfo(ModelMap infoMap , @RequestParam("parkcode") String code, HttpSession session) {
		if (session.getAttribute("temp") == null) {
			session.setAttribute("temp", 0);
		}
		List<Park> allInfo = new ArrayList<Park>();
		Park thePark = null;
		allInfo = parkDao.getAllParks();
		for (Park park : allInfo ) {
			if (park.getParkCode().equals(code)) {
				thePark = park;
				infoMap.addAttribute("park", park);
			}			
		}
		List<Weather> allForecast = new ArrayList<Weather>();
		allForecast = weatherDao.getForecast(thePark.getParkCode());
		int tempType = getTemp(session);
		if (tempType == 1) {
			int high;
			int low;
			for (Weather w: allForecast) {
				high = w.getHigh();
				low = w.getLow();
				high = (int)(((double)high - 32)*(5.0/9));
				low = (int)(((double)low - 32)*(5.0/9));
				w.setHigh(high);
				w.setLow(low);
			}
		}
		infoMap.addAttribute("forecasts", allForecast);
		return "parkInfo";
	}
	@RequestMapping(path="/parkSurvey", method=RequestMethod.GET)
	public String displaySurvey(ModelMap model) {
		List<Park> allParks = new ArrayList<Park>();
		allParks = parkDao.getAllParks();
		model.addAttribute("Survey",new Survey());
		model.addAttribute("parks",allParks);
		return "parkSurvey";
	}
	
	@RequestMapping(path="/parkSurvey", method=RequestMethod.POST)
	public String displayResults(@Valid @ModelAttribute Survey survey,
								  BindingResult result,
								  RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Survey", result);
			flash.addFlashAttribute("Survey", survey);
			return "redirect:/parkSurvey";
		}
		surveyDao.insertSurvey(survey);
		return "redirect:/surveyResult";
	}
	@RequestMapping(path="/surveyResult", method=RequestMethod.GET)
	public String displaySurveyResults(ModelMap map) {
		List<Survey> allSurveys = surveyDao.getAllSurveys();
		List<Park> allParks = parkDao.getAllParks();
		int[] surveyNum = new int[allParks.size()];
		int count = 0;
		for (Park p: allParks) {
			for (Survey s: allSurveys) {
				if (s.getParkCode().equals(p.getParkCode())) {
					surveyNum[count] += 1;
				}
				
			}
			p.setNumOfSurvey(surveyNum[count]);
			count++;
		}
		List<Park> result = new ArrayList<Park>();
		
		while (allParks.size()>0){
			int max = 0;
			for (Park p: allParks) {
				if (max < p.getNumOfSurvey()) {
					max = p.getNumOfSurvey();
				}
			}
			if (max == 0) {
				break;
			}
			for (Park p: allParks) {
				if (p.getNumOfSurvey() == max) {
					Park pa = new Park();
					pa.setNumOfSurvey(p.getNumOfSurvey());
					pa.setParkName(p.getParkName());

					result.add(pa);
					p.setNumOfSurvey(0);
				}
			}
		}
		
		map.addAttribute("parks",result);

		return "SurveyResult";
	}
	
	@RequestMapping(path="/changeTemp")
	public String changeTemp(HttpSession session) {
		if (session.getAttribute("temp") == null) {
			session.setAttribute("temp", 0);
		}
		
	int temp = getTemp(session);
		
		if (temp == 0) {
			session.setAttribute("temp",1);
		} else {
			session.setAttribute("temp",0);
		}
		return "temp";
	}
	
	private int getTemp(HttpSession session) {
		int tempSetting = (int)session.getAttribute("temp");

		if (session.getAttribute("temp") == null) {
			tempSetting = 0;
			session.setAttribute("temp", tempSetting);
		}
		return tempSetting;
	}
}
