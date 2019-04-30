package com.techelevator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
public class HomePartyController {
	@Autowired
	private ReviewDao reviewDao;
	
	@RequestMapping("/")
	public String displayWelcomePage(HttpServletRequest request) {
		List<Review> allReviews = new ArrayList<>();
		allReviews = reviewDao.getAllReviews();
		request.setAttribute("reviews", allReviews);
		System.out.println(allReviews.get(6).getTitle());
		
		return "welcomeToTheParty";
	}
	
	@RequestMapping(path="/submitPartyReview", method=RequestMethod.GET)
	public String displayReviewForm() {

		return "submitPartyReview";
	}
	
	@RequestMapping(path="/submitPartyReview", method=RequestMethod.POST)
	public String processReviewForm(@RequestParam String userName,
									@RequestParam int rating, 				
									@RequestParam String reviewTitle, 
									@RequestParam String reviewMessage) {
		
		Review review = new Review();
		review.setUsername(userName);
		review.setTitle(reviewTitle);
		review.setRating(rating);
		review.setText(reviewMessage);
		review.setDateSubmitted(LocalDateTime.now());
		reviewDao.save(review);

			
		return "redirect:/";
	}

}











