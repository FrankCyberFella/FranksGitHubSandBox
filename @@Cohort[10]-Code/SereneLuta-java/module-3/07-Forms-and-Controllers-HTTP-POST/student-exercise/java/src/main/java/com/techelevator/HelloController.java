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
	private ReviewDao reviewDao;

	@RequestMapping("/")	
	public String displayGreeting(HttpServletRequest request) {
		List<Review> bookReview = reviewDao.getAllReviews();
		request.setAttribute("reviewKey", bookReview);
		
		return "greeting";
	}
	
	@RequestMapping(path="/postBookReview", method=RequestMethod.GET)
	public String makeABookReview() {
		return "postBookReview";
	}
	
	@RequestMapping(path="/postBookReview", method=RequestMethod.POST)
	public String submitBookReview(@RequestParam String userName, @RequestParam String title,@RequestParam int rating, @RequestParam String text) {
		Review review = new Review();
		LocalDateTime datePosted = LocalDateTime.now();
		review.setDateSubmitted(datePosted);
		review.setRating(rating);
		review.setTitle(title);
		review.setUsername(userName);
		review.setText(text);
		reviewDao.save(review);
		return "redirect:/";
	}
	
}
