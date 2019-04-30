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
	private ReviewDao dao;

	@RequestMapping("/greeting")
	public String displayGreeting(HttpSession session) {
		
		return "greeting";
	}
	
	@RequestMapping("/post")
	public String displayPost(HttpSession session) {
		
		return "post";
	}
	
	@RequestMapping(path="/post", method=RequestMethod.POST)
	public String forumSubmission(@RequestParam String username,
								  @RequestParam String rating,
								  @RequestParam String title,
								  @RequestParam String text) {   
		
		Review post = new Review();
		post.setUsername(username);
		post.setRating(Integer.parseInt(rating));
		post.setTitle(title);
		post.setText(text);
		post.setDateSubmitted(LocalDateTime.now());
		
		dao.save(post);
		
	
		return "redirect:/messageBoard";  
		
	}
	
	@RequestMapping("/messageBoard")
	public String displayMessageBoard(HttpServletRequest request) {
		
		List<Review> list = dao.getAllReviews();
		request.setAttribute("reviews", list);
		
		return "messageBoard";
	}
}
