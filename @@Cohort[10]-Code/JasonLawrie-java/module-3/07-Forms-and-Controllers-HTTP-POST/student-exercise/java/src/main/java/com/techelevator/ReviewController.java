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
public class ReviewController {

	@Autowired
	ReviewDao reviewDao;
	
	@RequestMapping(path= {"/home","/"})
	public String showHomePage(ModelMap map) {
		
		map.addAttribute("reviews", reviewDao.getAllReviews());
		return "home";
	}
	
	@RequestMapping(path="/reviewPost", method=RequestMethod.GET)
	public String showSubmissionForm() {
		return "reviewPost";
	}
	
	@RequestMapping(path="/reviewPost", method=RequestMethod.POST)
	public String submitReviewForm(@RequestParam String username,
									@RequestParam int rating,
									@RequestParam String title,
									@RequestParam String text) {
		Review post = new Review();
		LocalDateTime now = LocalDateTime.now();
		post.setDateSubmitted(now);
		post.setRating(rating);
		post.setText(text);
		post.setTitle(title);
		post.setUsername(username);
		reviewDao.save(post);
		return "redirect:home";
	}
	
}
