package com.techelevator;

import com.techelevator.dao.CustomerDao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerSearchController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value="/customerList", method=RequestMethod.GET)
    public String showCustomerSearchScreen() {
    	return "customerList";
    }
    @RequestMapping(value="/customerList", method=RequestMethod.GET,params= {"custName","sortBy"})
    public String listedSortedCustomers(HttpServletRequest request) {
    	request.setAttribute("customers", customerDao.searchAndSortCustomers(request.getParameter("custName"), request.getParameter("sortBy")));
    	return "customerList";
    }
}