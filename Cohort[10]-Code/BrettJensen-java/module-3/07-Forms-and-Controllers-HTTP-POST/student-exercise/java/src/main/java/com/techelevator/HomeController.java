package com.techelevator;

import java.time.LocalDate;
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
public class HomeController {

	@Autowired
	ReviewDao reviewDao;
	
	@RequestMapping(path= {"/", "/homePage"}, method=RequestMethod.GET)
	public String displayHome(HttpServletRequest request) {
		
		List<Review> reviews = reviewDao.getAllReviews();
		
		request.setAttribute("reviews", reviews);
		return "homePage";
	}
	
	@RequestMapping(path="/reviewInput", method=RequestMethod.GET)
	public String showReviewInput() {
		
		return "reviewInput";
	}
	
	@RequestMapping(path="/reviewInput", method=RequestMethod.POST)
	public String postReviewInput(@RequestParam String userName,
								  @RequestParam String rating,
								  @RequestParam String title, 
								  @RequestParam String message) {
		
		LocalDateTime now = LocalDateTime.now();
		
		Review review = new Review();
		review.setUsername(userName);
		review.setRating(Integer.parseInt(rating));
		review.setTitle(title);
		review.setText(message);
		review.setDateSubmitted(now);
		
		reviewDao.save(review);
			
		return "redirect:/homePage";
	}
}
