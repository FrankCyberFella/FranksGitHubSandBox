package com.techelevator.dao;

import com.techelevator.dao.model.Customer;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * JDBCCustomerDao
 */
@Component
public class JDBCCustomerDao implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCCustomerDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Customer> searchAndSortCustomers(String search, String sort) {
    	 List<Customer> matchingCustomers = new ArrayList<>();
         String customerSearchSql = "SELECT first_name, last_name, activebool, email " +
        		 					   "FROM customer " +
        		 					   "WHERE first_name ILIKE ? OR last_name ILIKE ? " +
        		 					   "ORDER BY "+sort+";";
         SqlRowSet results = jdbcTemplate.queryForRowSet(customerSearchSql, "%" + search + "%", "%" + search + "%");
         while(results.next()) {
        	 	matchingCustomers.add(mapRowToCustomer(results));
         }
         return matchingCustomers;
    }
    
    private Customer mapRowToCustomer(SqlRowSet results) {
		Customer temp = new Customer();
		temp.setFirstName(results.getString("first_name"));
		temp.setLastName(results.getString("last_name"));
		temp.setEmail(results.getString("email"));
		temp.setActive(results.getBoolean("activebool"));
		return temp;
	}
}