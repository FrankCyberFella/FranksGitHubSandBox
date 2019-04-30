package com.techelevator.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.JwtTokenHandler;
import com.techelevator.authentication.UnauthorizedException;
import com.techelevator.authentication.UserCreationException;
import com.techelevator.model.JdbcUpdateStatement;
import com.techelevator.model.JdbcRestaurantDao;
import com.techelevator.model.JdbcUserDao;
import com.techelevator.model.Restaurant;
import com.techelevator.model.RestaurantDao;
import com.techelevator.model.User;
import com.techelevator.model.updateStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * AccountController
 */
@CrossOrigin
@RestController
public class AccountController {

    
	@Autowired
    private AuthProvider auth;

    @Autowired
    private JwtTokenHandler tokenHandler;

    @Autowired
    private JdbcUserDao userDao;
    
    @Autowired
    private JdbcRestaurantDao rdao;
    
    @RequestMapping(path= {"/login"}, method=RequestMethod.POST)
    public String login(
        @RequestBody User user,
        RedirectAttributes flash
    ) throws UnauthorizedException {
        if(auth.signIn(user.getUsername(), user.getPassword())) {
            User currentUser = auth.getCurrentUser();
            return tokenHandler.createToken(user.getUsername(), currentUser.getRole());
        } else {
            throw new UnauthorizedException();
        }
    }



    @RequestMapping(path="/register", method=RequestMethod.POST)
    public String register(
        @Valid @RequestBody User user,
        BindingResult result
    )
    	throws UserCreationException {
        if(result.hasErrors()) {
            String errorMessages = "";
            System.out.println("\n\n\n\nTHIS IS NOT WORKING \n\n\n\n");
            for(ObjectError error : result.getAllErrors()) {
            	System.out.println(error);
                errorMessages += error.getDefaultMessage() + "\n";
            }
            throw new UserCreationException(errorMessages);
        }
        System.out.println("\n\n\n\nTHIS IS WORKING!!! \n\n\n\n");
        auth.register(user.getUsername(), user.getPassword(), user.getRole(), user.getCity(),user.getState(), user.getCurrent_preference());
        return "{\"success\":true}";
    }
    
    @RequestMapping(path="/like", method=RequestMethod.POST)
    public String saveRestaurant(
        @Valid @RequestBody Restaurant restaurant,
        BindingResult result) {

        System.out.println("\nTHIS IS WORKING!!!\n");
        User currentUser = auth.getCurrentUser();
        rdao.saveRestaurant(restaurant, currentUser);


        return "{\"success\":true}";
  
    }
    
    @RequestMapping(path="/retrieveLike", method=RequestMethod.GET)
    public ArrayList<Restaurant> getLikes() {
    	ArrayList<Restaurant> results = new ArrayList<>();
    	User currentUser = auth.getCurrentUser();
    	
    	results = rdao.getLikes(currentUser);
    	for (Restaurant r: results) {
    		System.out.println(r.getName());
    	}
    	return results;
    }
    
    @RequestMapping(path="/link", method=RequestMethod.POST)
    public String saveLink(
        @Valid @RequestBody Restaurant restaurant,
        BindingResult result) {

        System.out.println("\nTHIS IS WORKING!!!\n");
        User currentUser = auth.getCurrentUser();
        
        rdao.saveLink(restaurant, currentUser);

        return "{\"success\":true}";
  
    }
    
    @RequestMapping(path="/preference", method=RequestMethod.GET)
    public String getLoggedUser(HttpServletRequest request) {
    	User currentUser = auth.getCurrentUser();
    	User finalUser =userDao.getUserByUsername(currentUser.getUsername());
    	System.out.println(finalUser.getCurrent_preference());
    	return finalUser.getCurrent_preference();
    	
    }
    
    @RequestMapping(path="/city", method=RequestMethod.GET)
    public String[] getCityState(HttpServletRequest request) {
    	User currentUser = auth.getCurrentUser();
    	String[] result = {currentUser.getCity(), currentUser.getState()};
    	return result;
    }
    
    @RequestMapping(path="/profile", method=RequestMethod.POST)
    public String updateUserPreferences(HttpServletRequest request,
    		@Valid @RequestBody updateStatement update) {
    	
    	System.out.println("patch request");
    	
    	User currentUser = auth.getCurrentUser();
    	
    	
    	userDao.updateUser(update, currentUser);
    	
    	return "{\"success\":true}";
    	
    }
    

    @RequestMapping(path="/visited", method=RequestMethod.POST)
    public void restaurantVisit(HttpServletRequest request,
    		@Valid @RequestBody Restaurant restaurant) {
    	
    	System.out.println(restaurant.getId());
    	
    	User currentUser = auth.getCurrentUser();
    	    	
    	rdao.visitRestaurant(restaurant, currentUser);
    	
    }
    
    
    @RequestMapping(path="/deleteFav", method= RequestMethod.POST)
    public void deleteRestFromFavs(HttpServletRequest request,
    		@Valid @RequestBody Restaurant restaurant) {
    		User currentUser = auth.getCurrentUser();
    		rdao.deleteRestaurantFromFavs(restaurant, currentUser);
      }

}