package com.techelevator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;

@Controller 
public class HelloController {
	
	@Autowired
	private ReviewDao review;

	@RequestMapping("/")
	public String displayGreeting(HttpServletRequest request) {
		List<Review> reviews = review.getAllReviews();
		request.setAttribute("reviews", reviews);
		return "greeting";
	}
	
	@RequestMapping(path="submitNewReview", method=RequestMethod.GET)
	public String getToSubmitPage(HttpServletRequest request) {
		return "submitNewReview";
	}
	
	@RequestMapping(path="submitNewReview", method=RequestMethod.POST)
	public String submitNewReview(@RequestParam String username, 
			@RequestParam String rating, 
			@RequestParam String title, 
			@RequestParam String text) {
		LocalDateTime now = LocalDateTime.now();
		
		
		Review newReview = new Review();
		newReview.setUsername(username);
		newReview.setText(text);
		newReview.setTitle(title);
		newReview.setRating(Integer.parseInt(rating));
		newReview.setDateSubmitted(now);
		
		review.save(newReview);
		
		
		return "redirect:/";
	}
	
}
