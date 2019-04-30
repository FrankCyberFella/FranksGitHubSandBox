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
		List<Customer> customers = new ArrayList<Customer>();
		String sqlSearchAndSort = "SELECT first_name, last_name, email, activebool FROM customer "+
									"WHERE first_name ilike ? OR last_name ilike ?"+
									"ORDER BY ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchAndSort,"%"+search+"%","%"+search+"%",sort);
		while(results.next()) {
			customers.add(mapRowsToCustomer(results));
		}
		return customers;
	}
	private Customer mapRowsToCustomer(SqlRowSet results) {
		Customer theCustomer = new Customer();
		theCustomer.setActive(results.getBoolean("activebool"));
		theCustomer.setEmail(results.getString("email"));
		theCustomer.setFirstName(results.getString("first_name"));
		theCustomer.setLastName(results.getString("last_name"));
		return theCustomer;
	}
    
}