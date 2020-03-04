package com.techelevator;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/* The @Controller annotation will make the Spring container aware 
 * of this controller as a managed bean. Controllers in Spring Web 
 * MVC are just plain old Java objects that are annotated to indicate 
 * that they are an MVC controller 
 * 
 * The @Controller annotation indicates to the Spring framework 
 * that this class should be treated as a controller
 * 
 * The <component-scan> element in springmvc-servlet.xml causes 
 * Spring to look at all of the classes in the package specified 
 * and look for classes with this annotation. This controller will
 * be found during the Spring component scan during application
 * startup.
 * 
 * Controllers (and pretty much everything else in Spring) can also be 
 * configured using XML.  However, annotations have become the 
 * suggested way of wiring together a Spring application. */

@Controller 
public class HelloController {
//
//	/* The @RequestMapping annotation is used to map resource paths to 
//	 * method calls.
//	 * 
//	 * This particular mapping says that any requests for the root 
//	 * should invoke this method.
//	 * 
//	 * All controller request handling methods should return a String 
//	 * that represents the "logical view name" */

@RequestMapping("/")
public String displayHomePage() {
		
		return "homePage";
	}
		

	 @RequestMapping(path="/greeting", method=RequestMethod.GET)

	 public String displayGreeting(@RequestParam String name, ModelMap modelHolder) {
		 	/*  
		 	 *  @RequestParam - accept query parameters by id	
		 	 *    
		 	 *          @RequestParam String name - Get value in query parameter called name
		 	 */
	        Greeter greeter = new Greeter(name);
	        modelHolder.put("greeting", greeter.getGreeting());
	        
	        /* Controller methods can return a variety of types of values, 
	         * but we will be using `String`.  The value of the returned 
	         * String is the *logical view name* to render.  The default 
	         * implementation is to map the logical view name directly to 
	         * a file, however we configured a different View Resolver 
	         * that maps logical view names to JSP files under WEB-INF/jsp 
	         * See springmvc-servlet.xml for details. */
	        return "greeting";
	    }
}
