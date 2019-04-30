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

    public List<Customer> searchAndSortCustomers(String search, String sort) {
    	List<Customer> customers = new ArrayList<Customer>();
    	String sqlSearchCustomers = "SElECT first_name, last_name, email, activebool " + 
    			"FROM customer " + 
    			"WHERE first_name LIKE ? " +
    			"	OR last_name LIKE ? " +
    			"ORDER BY " + sort;
    	SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchCustomers,
    													"%" + search + "%",
    													"%" + search + "%");
    	while (results.next()) {
    		customers.add(mapRowToCustomer(results));
    	}
    	return customers;
    }
    
    private Customer mapRowToCustomer(SqlRowSet results) {
    	Customer c = new Customer();
    	c.setFirstName(results.getString("first_name"));
    	c.setLastName(results.getString("last_name"));
    	c.setEmail(results.getString("email"));
    	c.setActive(results.getBoolean("activebool"));
    	return c;
    }

}