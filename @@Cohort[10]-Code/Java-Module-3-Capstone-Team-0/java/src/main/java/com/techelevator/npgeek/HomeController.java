package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.park.JdbcParkDao;
import com.techelevator.model.park.Park;
import com.techelevator.model.park.ParkDao;
import com.techelevator.model.survey.Survey;
import com.techelevator.model.survey.SurveyConstants;
import com.techelevator.model.survey.SurveyDao;
import com.techelevator.model.weather.WeatherDao;

@Controller
@SessionAttributes("celsius")
public class HomeController {
	
	@Autowired
	private ParkDao parkDao;
	
	@Autowired
	private WeatherDao weatherDao;
	
	@Autowired
	private SurveyDao surveyDao;
	
	@RequestMapping(path={"/","index", "home"}, method=RequestMethod.GET)
	public String showHome(Model map) {
		
		map.addAttribute("parks",parkDao.getAllParks());
		
		return "index";
	}
	
	@RequestMapping(path= {"detail"}, method=RequestMethod.GET)
	public String showParkDetails(ModelMap map, @RequestParam String parkCode) {
		
		if(map.containsKey("celsius")) {
			if((int)map.get("celsius")!=0&&(int)map.get("celsius")!=1) {
				map.addAttribute("celsius",0);
			}
		}
		
		else {
			map.addAttribute("celsius",0);
		}
		
		Park thePark = parkDao.getParkByCode(parkCode);
		
		if(thePark == null) {
			return "error";
		}
		
		
		map.addAttribute("park", thePark);
		map.addAttribute("weathers", weatherDao.getWeatherByParkCode(parkCode));
		
		
		return "detail";
	}
	
	@RequestMapping(path= {"detail"}, method=RequestMethod.POST)
	public String setTempScale(ModelMap map, @RequestParam int celsius, @RequestParam String parkCode, RedirectAttributes ra) {
		
		map.addAttribute("celsius",celsius);

		return "redirect:detail?parkCode="+parkCode;
	}
	
	
	@RequestMapping(path="survey",method=RequestMethod.GET)
	public String showSurveyForm(ModelMap map) {
		
		map.addAttribute("parks",parkDao.getAllParks());
		map.addAttribute("states", SurveyConstants.getListOfStates() );
		map.addAttribute("activityLevels",SurveyConstants.getListOfActivityLevels());
		
		if(!map.containsAttribute("Survey")) {
			map.addAttribute("Survey", new Survey());
		}
		
		return "survey";
	}
	
	@RequestMapping(path="survey", method=RequestMethod.POST)
	public String submitSurveyForm(@Valid @ModelAttribute("Survey") Survey surveyValues, BindingResult result, RedirectAttributes flash) {
		
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Survey", result);
			flash.addFlashAttribute("Survey", surveyValues);
			return "redirect:/survey";
		}
		
		surveyDao.save(surveyValues);
		
		return "redirect:/favoriteParks";
	}
	
	@RequestMapping(path="favoriteParks",method=RequestMethod.GET)
	public String showFavoriteParks(ModelMap map) {
		
		map.addAttribute("surveys",surveyDao.getParkSurveyCount(parkDao));
		
		return "favoriteParks";
	}
	
	@RequestMapping(path="error",method=RequestMethod.GET)
	public String showErrorPage() {
		return "error";
	}
	
}
