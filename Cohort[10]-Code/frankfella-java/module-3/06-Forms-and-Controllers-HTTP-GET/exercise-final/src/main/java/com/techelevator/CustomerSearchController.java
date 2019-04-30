package com.techelevator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dao.CustomerDao;

@Controller
public class CustomerSearchController {

    @Autowired
    private CustomerDao customerDao;
    
    @RequestMapping("/customerSearch")
    public String displayCustomerSearch() {
    	return "customerList";
    }
    
    @RequestMapping("/customerList")
    public String displayCustomerList(@RequestParam String search,
    								  @RequestParam String sort,
    								  ModelMap model) {
    	model.put("customers", customerDao.searchAndSortCustomers(search.toUpperCase(), sort));
    	return "customerList";
    }
    

}