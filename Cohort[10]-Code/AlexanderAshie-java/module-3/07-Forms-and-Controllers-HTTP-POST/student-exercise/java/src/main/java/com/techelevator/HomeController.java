package com.techelevator;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.ReviewDao;

@Controller 
public class HomeController {
	
	@Autowired
	private ReviewDao reviewDao;

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showRootPage(ModelMap map) {
		
		map.put("reviews", reviewDao.getAllReviews());
		
		return "homePage";
	}
	
	@RequestMapping(path="/homePage", method=RequestMethod.GET)
	public String showHomePage(ModelMap map) {
		
		map.put("reviews", reviewDao.getAllReviews());
		
		return "homePage";
	}
}
