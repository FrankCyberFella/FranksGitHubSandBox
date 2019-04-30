package com.techelevator;

import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;

@Controller 
public class ReviewController {
	
	@Autowired
	private ReviewDao reviewDao;
	
	@RequestMapping(path="/reviewPage", method=RequestMethod.GET)
	public String showReviewPage() {
		return "reviewPage";
	}
	
	@RequestMapping(path="/reviewPage", method=RequestMethod.POST)
	public String postReview(@RequestParam String username, @RequestParam int rating, @RequestParam String title, @RequestParam String text) {
		
		Review newReview = new Review();
		
		newReview.setUsername(username);
		newReview.setRating(rating);
		newReview.setTitle(title);
		newReview.setText(text);
		newReview.setDateSubmitted(LocalDateTime.now());
		
		reviewDao.save(newReview);
		
		return "redirect:/homePage";
	}
}
