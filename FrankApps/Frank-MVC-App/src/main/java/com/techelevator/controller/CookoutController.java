package com.techelevator.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Attendee;
import com.techelevator.model.AttendeeDAO;
import com.techelevator.model.Cookout;
import com.techelevator.model.CookoutDAO;
import com.techelevator.model.Menu;
import com.techelevator.model.MenuDAO;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Controller
public class CookoutController {

		private CookoutDAO cookoutDAO;
		private MenuDAO menuDAO;
		private UserDAO userDAO;
		private AttendeeDAO attendeeDAO;
		
		@Autowired
		public CookoutController(CookoutDAO cookoutDAO, MenuDAO menuDAO, UserDAO userDAO, AttendeeDAO attendeeDAO) {
			this.cookoutDAO = cookoutDAO;
			this.menuDAO = menuDAO;
			this.userDAO = userDAO;
			this.attendeeDAO = attendeeDAO;
		}
		
		
		/*This method will show the 'guest' view. To view page, user will need to have received a link form the 'Host'
			Need to confirm that this user (as entered by Host) was invited (ie: able to view this page). This view will have all
			the same information displayed as the Host view, except for the 'Update Guest List' button. */
		@RequestMapping(path="/details", method=RequestMethod.GET)
		public String showCookoutDetail(ModelMap modelholder, @RequestParam Integer cookoutId, HttpSession session) {
			for(Cookout c : cookoutDAO.displayAllCookouts()) {
				if((c.getCookoutId() == cookoutId) // confirm that user is authorized to view the details page
						)
				{
					modelholder.put("cookout", c);
					session.setAttribute("cookout", c);
					session.setAttribute("cookoutId", c.getCookoutId());
				}
			modelholder.put("menu", menuDAO.displayCookoutMenu(cookoutId));
		}
			return "/details";

		}
		
		
		
		// This method shows the first page of the 'Create New Cookout' workflow (basically a form for the cookout details)
		@RequestMapping(path="/createCookoutDetails", method=RequestMethod.GET)
		public String showCookOutDetailsForm(ModelMap modelHolder) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		    LocalDateTime now = LocalDateTime.now();  
	
			if(!modelHolder.containsKey("cookout")) {
				modelHolder.put("cookout",new Cookout());
				modelHolder.put("currentDate", dtf.format(now));
			}
			return "/createCookoutDetails";
		}
		
		
		/*This method will submit the cookout details
			and assign a host. Need to confirm we qre pulling 'User' id info correctly.
			user will be redirected to 'Add to Menu' stage of workflow. */
		@RequestMapping(path="/createCookoutDetails", method=RequestMethod.POST)
		public String submitCookoutDetails(@Valid @ModelAttribute Cookout newCookout,
										  BindingResult result,
										  HttpSession session,  
										  RedirectAttributes flashScope) {
			
			if(result.hasErrors()) {
				flashScope.addFlashAttribute("cookout", newCookout);
				flashScope.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "cookout", result);
				return "redirect:/createCookoutDetails";
			}
			
			newCookout.setHost(userDAO.getUserIdByName(((User)session.getAttribute("currentUser")).getUserName()));
			
			
			cookoutDAO.saveCookoutDetails(newCookout); 
			session.setAttribute("cookoutId", newCookout.getCookoutId());
			flashScope.addFlashAttribute("detailMessage", "Cookout Details Submitted!");
						
			return "redirect:/addMenuItems";
		}
		
		// This method will allow a user to edit an existing cookout
		@RequestMapping(path="/updateCookoutDetails", method=RequestMethod.GET)
		public String updateCookOutDetailsForm(ModelMap modelHolder, HttpSession session) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		    LocalDateTime now = LocalDateTime.now();  
	
			modelHolder.put("cookout", session.getAttribute("cookout"));
			modelHolder.put("currentDate", dtf.format(now));
			
			return "/updateCookoutDetails";
		}
		
		
		/*This method will UPDATE an existing cookout */
	@RequestMapping(path="/updateCookoutDetails", method=RequestMethod.POST)
	public String updateCookoutDetails(@Valid @ModelAttribute Cookout updatedCookout,
									  BindingResult result,
									  HttpSession session,  
									  RedirectAttributes flashScope) {
		
//		if(result.hasErrors()) {
//			flashScope.addFlashAttribute("cookout", updatedCookout);
//			flashScope.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "cookout", result);
//			return "redirect:/createCookoutDetails";
//		}
		
		cookoutDAO.updateCookoutDetails(updatedCookout, (int)session.getAttribute("cookoutId")); 
		flashScope.addFlashAttribute("detailMessage", "Cookout Updated!");
					
		return "redirect:/details?cookoutId="+(int)session.getAttribute("cookoutId");
	}

		
		
		
		// This displays all of the menu items in the "menu_items" table so a user can select which items they want to add to their cookout.
		@RequestMapping(path="/addMenuItems", method=RequestMethod.GET)
		public String showAddItemsForm(ModelMap modelHolder) {
			modelHolder.put("menuOptions", menuDAO.displayAllMenuItems());	

			return "/addMenuItems";
		}
		
		
		
		// This method saves all of the selected items to the specific cookout menu.
		@RequestMapping(path="/addMenuItems", method=RequestMethod.POST)
		public String submitCookoutMenu(@RequestParam int[] item,	
				   HttpSession session,  
				   RedirectAttributes flashScope) {
			menuDAO.saveMenu(item, (int)session.getAttribute("cookoutId"));
	
			return "/addAttendees";
		}
		
		@RequestMapping(path="/addAttendees", method=RequestMethod.GET)
		public String showAddAttendeesForm(ModelMap modelHolder, HttpSession session) {
			int cookoutId = (int)session.getAttribute("cookoutId");
			modelHolder.put("attendees", attendeeDAO.displayAttendees(cookoutId));
			modelHolder.put("cookoutId", (int)session.getAttribute("cookoutId"));
			return "/addAttendees";
		}
		
		@RequestMapping(path="/addAttendees", method=RequestMethod.POST)
		public String addAttendee(@RequestParam String email, 
									@RequestParam String firstName, 
									@RequestParam String lastName,
									HttpSession session,
									RedirectAttributes flashScope) {
			
			attendeeDAO.createAttendee(email, firstName, lastName, (int)session.getAttribute("cookoutId"));
			
			flashScope.addFlashAttribute("message", "Attendees successfully added!");
									
			
			return "redirect:/addAttendees?cookoutId="+ (int)session.getAttribute("cookoutId");
		}
		
		
		@RequestMapping(path="/addAttendees2", method=RequestMethod.POST)
		public String submitAttendees(@RequestParam String email, 
				@RequestParam String firstName, 
				@RequestParam String lastName,
				HttpSession session,
				RedirectAttributes flashScope) {
			attendeeDAO.createAttendee(email, firstName, lastName, (int)session.getAttribute("cookoutId"));
			return "redirect:/details?cookoutId="+ (int)session.getAttribute("cookoutId");
		}

}
