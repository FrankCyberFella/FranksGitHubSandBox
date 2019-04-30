package com.techelevator;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;

@Controller
public class CigarPartyController {
	Autowired
	private ReviewDao reviewDao;
	
	@RequestMapping("/")
	public String displayWelcomePage(HttpServletRequest request) {
		List<Review> allReviews = new Arraylist<>();
		allReviews = reviewDao.getAllReviews();
		request.setAttribute("reviews", allReviews);
		System.out.println(allReviews.get(6).getTitle());
		
		return "welcomeToTheParty";
	}
	@RequestMapping(path="/submitPartyReview", method=RequestMethod.GET)
	public String displayReviewForm() {
		
	return "submitPartyReview";	
	}
	@RequestMapping(path="/submitPartyReview", method=RequestMetod.POST)
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
