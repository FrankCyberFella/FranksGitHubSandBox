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

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;

@Controller 
public class HelloController {
@Autowired
private ReviewDao reviewDao;

//	@RequestMapping(path={"/","/homePage"}, method=RequestMethod.GET)
//	public String displayHomePage(HttpSession session) {
//		return "homePage";
//	}
	
	@RequestMapping("/submitAReview")
	public String displayReviewForm() {
		return "submitAReview";
	}
	
	@RequestMapping(path="/homePage", method=RequestMethod.POST)
	public String submitAReview(@RequestParam String username,
										@RequestParam int rating,
										@RequestParam String reviewTitle,
										@RequestParam String reviewText)
										throws FileNotFoundException, IOException {
	LocalDateTime now = LocalDateTime.now();
	Review review = new Review();
	review.setUsername(username);
	review.setRating(rating);
	review.setTitle(reviewTitle);
	review.setText(reviewText);
	review.setDateSubmitted(now);
	reviewDao.save(review);
	return "redirect:/homePage";
	}
	
	@RequestMapping(path={"/","/homePage"}, method=RequestMethod.GET)
	public String showHomePage(HttpServletRequest request) {
		List<Review> reviews = new ArrayList<>();
		reviews = reviewDao.getAllReviews();
		request.setAttribute("reviews", reviews);
		return "/homePage";
	}
}
