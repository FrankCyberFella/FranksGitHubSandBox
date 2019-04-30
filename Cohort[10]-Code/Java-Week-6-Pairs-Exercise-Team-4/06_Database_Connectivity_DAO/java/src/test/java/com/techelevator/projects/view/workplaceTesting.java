package com.techelevator.projects.view;

import static org.junit.Assert.*;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test; 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.ProjectsCLI;

import org.junit.Test;

public class workplaceTesting {
	
	private static final String TEST_EMPLOYEE = "Kermit Frog";
	
	private static SingleConnectionDataSource dataSource;
	private ProjectsCLI projects;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		String sqlInsertEmployee = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) VALUES (?, ?, 'Kermit', 'Frog', 1914/12/31, Male, 2015/01/28)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertEmployee, TEST_EMPLOYEE);
		projects = new ProjectsCLI();
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
//	@Test
//	public void return_employee_by_employee_id() throws SQLException {
//		ProjectsCLI employeeIDTest = getName(1);
//		
//		dao.save(theCity);
//		City savedCity = dao.findCityById(theCity.getId());
//		
//		assertNotEquals(null, theCity.getId());
//		assertCitiesAreEqual(theCity, savedCity);
//	}
//	
//	@Test
//	public void save_new_department_and_read_it_back() throws SQLException {
//		ProjectsCLI theDepartment = getDepartment();
//		
//		dao.save(theCity);
//		City savedCity = dao.findCityById(theCity.getId());
//		
//		assertNotEquals(null, theCity.getId());
//		assertCitiesAreEqual(theCity, savedCity);
//	}
//	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
//	
//	private ProjectsCLI getEmployee(int id) {
//		ProjectsCLI anEmployee = new ProjectsCLI();
//		anEmployee.
	}

//}
