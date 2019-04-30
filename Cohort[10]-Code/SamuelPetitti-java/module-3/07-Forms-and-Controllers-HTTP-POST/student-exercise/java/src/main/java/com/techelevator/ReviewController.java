package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;


@Controller
public class ReviewController {

@Autowired ReviewDao reviewDao;

	@RequestMapping(path={"/","/reviewHomePage"},method= RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request) {
		List<Review> reviews = reviewDao.getAllReviews();
		request.setAttribute("reviews", reviews);
		return "reviewHomePage";
	}
	
	@RequestMapping("/submitReview")
	public String displaySubmitReview() {
		return "submitReview";
	}
	
	
    @RequestMapping(path= "/submitReview", method=RequestMethod.POST)
    public String processReviewSubmit(@RequestParam String username,
    								  @RequestParam int rating,
    								  @RequestParam String title,
    								  @RequestParam String review)
    								  throws FileNotFoundException, IOException {
    	LocalDateTime now = LocalDateTime.now();
    	Review newReview = new Review();
    	newReview.setDateSubmitted(now);
    	newReview.setRating(rating);
    	newReview.setTitle(title);
    	newReview.setUsername(username);
    	newReview.setText(review);
    	reviewDao.save(newReview);
    	return "redirect:/reviewHomePage";
    }
}

