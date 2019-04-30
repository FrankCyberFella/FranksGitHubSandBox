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
	ReviewDao reviewDao;

	@RequestMapping("/")
	public String displayGreeting(HttpSession session) {
		
		List<Review> posts = new ArrayList<Review>();
		
		posts = reviewDao.getAllReviews();
		
		session.setAttribute("posts", posts);
		
		return "greeting";
	}
	
	@RequestMapping(path={"/forum"}, method=RequestMethod.GET)
	public String displayForumPost(HttpServletRequest request) {
		
		return "forum";
	}
	
	@RequestMapping(path= {"/forum"}, method=RequestMethod.POST)
	public String displayForumInfo(@RequestParam String username,
								   @RequestParam String text,
								   @RequestParam String title,
								   @RequestParam String rating) throws FileNotFoundException, IOException {
		
		Review thePost = new Review();
		
		LocalDateTime date = LocalDateTime.now();
		
		thePost.setTitle(title);
		thePost.setText(text);
		thePost.setUsername(username);
		thePost.setRating(Integer.parseInt(rating));
		thePost.setDateSubmitted(date);
		
		reviewDao.save(thePost);
		
		return "greeting";
	}
}

