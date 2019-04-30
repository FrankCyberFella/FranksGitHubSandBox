package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.JdbcReviewDao;
import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;

@Controller 
public class HelloController {
	
	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	JdbcReviewDao theReviewDao;

	@RequestMapping("/greeting")
	public String displayGreeting(HttpSession session) {
		
		return "greeting";
	}
	
	@RequestMapping({"/","/homepage"})
	public String displayHomepage(HttpServletRequest request) {
		
		
		List<Review> reviewList = new ArrayList<Review>();
		
		reviewList = reviewDao.getAllReviews();
		
		request.setAttribute("reviews", reviewList);
		
		return "homepage";
	}
	
	@RequestMapping(path={"/forumPostInput"}, method=RequestMethod.GET)
	public String showForumPostInput() {
		return "forumPostInput";
	}
	
	@RequestMapping(path= {"/forumPostInput"}, method=RequestMethod.POST)
	public String processForumSubmit (@RequestParam String username,
										@RequestParam int rating,
										@RequestParam String reviewTitle,
										@RequestParam String reviewText) throws FileNotFoundException, IOException {
		
		LocalDateTime date = LocalDateTime.now();
		
		Review theReview = new Review();
		theReview.setRating(rating);
		theReview.setText(reviewText);
		theReview.setTitle(reviewTitle);
		theReview.setUsername(username);
		theReview.setDateSubmitted(date);	

		
		reviewDao.save(theReview);
		
		return "redirect:/forumPostFinish";
	}
	
	@RequestMapping("/forumPostFinish")
	public String displayFinishPost () {
		return"forumPostFinish";
	}
}
