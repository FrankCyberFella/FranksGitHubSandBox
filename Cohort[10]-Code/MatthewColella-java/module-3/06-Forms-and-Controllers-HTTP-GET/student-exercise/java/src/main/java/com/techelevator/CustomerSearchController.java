package com.techelevator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.model.Customer;

@Controller
public class CustomerSearchController {

    @Autowired
    private CustomerDao customerDao;
    
    @RequestMapping("/customerSearch")
    public String showCustomerSearchForm() {
        return "customerList";
     }

    @RequestMapping("/customerList")
    public String searchCustomers(HttpServletRequest request) {
    	
    	List<Customer> matchingCustomers = customerDao.searchAndSortCustomers(request.getParameter("name"), request.getParameter("sort"));
    			
    	request.setAttribute("customers", matchingCustomers);
    	
    	return"customerList";
    }
}