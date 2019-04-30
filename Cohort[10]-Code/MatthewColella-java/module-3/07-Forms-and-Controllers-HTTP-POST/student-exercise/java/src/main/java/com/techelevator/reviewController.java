package com.techelevator;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;


@Controller
public class reviewController {
	
	@Autowired
	private ReviewDao reviewDao;
	
	@RequestMapping(path="/reviewView", method=RequestMethod.GET)
	public String showReviews(ModelMap map) {
		
		map.put("reviews", reviewDao.getAllReviews());
		
		return "reviewView";
	}
	
	@RequestMapping("/reviewPost")
	public String showPostInput(){
		return "reviewPost";
	}
	
	
	@RequestMapping(path="/reviewPost", method=RequestMethod.POST)
	public String makePost(@RequestParam String username, @RequestParam String title,
						   @RequestParam String text, @RequestParam int rating) {
		
		Review reviewy = new Review();
		
		reviewy.setDateSubmitted(LocalDateTime.now());
		reviewy.setUsername(username);
		reviewy.setTitle(title);
		reviewy.setText(text);
		reviewy.setRating(rating);

		
		reviewDao.save(reviewy);
		
		return "redirect:/reviewView";
	}

}
