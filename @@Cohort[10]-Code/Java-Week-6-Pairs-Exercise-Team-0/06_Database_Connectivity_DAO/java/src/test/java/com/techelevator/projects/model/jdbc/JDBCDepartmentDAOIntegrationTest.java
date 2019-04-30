package com.techelevator.projects.model.jdbc;

import com.techelevator.projects.model.Department;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JDBCDepartmentDAOIntegrationTest {
	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO dao;
	private static final Long TEST_ID = (long)999;
	
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
	public void set() {
		String sqlInsertDepartment = "INSERT INTO Department(department_id, name) VALUES (999,'Software Test Department')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertDepartment); 
		dao = new JDBCDepartmentDAO(dataSource); 
		
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void selects_test_department_by_id() {
		Department testDepartment = dao.getDepartmentById(TEST_ID);
		assertNotEquals(null,testDepartment);
		assertEquals(testDepartment.getName(), "Software Test Department");
	}
	
	@Test
	public void selects_test_department_by_name() {
		List<Department> testDepartment = dao.searchDepartmentsByName("Software Test Department");
		assertEquals(testDepartment.size(),1);
		assertEquals(testDepartment.get(0).getName(), "Software Test Department");
	}
	
	@Test
	public void updating_a_department() {
		Department theDepartment = getDepartment("Software Test Department", (TEST_ID));
		Department newDepartment = getDepartment("Geek Squad", (TEST_ID));
		dao.saveDepartment(newDepartment);
		assertDepartmentsAreEqual(newDepartment, dao.getDepartmentById(TEST_ID));
		
	}
	private void creating_a_department() {
		//use the create method and search by name
		
	}
	
	private void assertDepartmentsAreEqual(Department expected, Department actual) {
		Assert.assertEquals(expected.getName(),actual.getName());
		Assert.assertEquals(expected.getId(), actual.getId());
	}
	
	private Department getDepartment(String deptName, Long deptId) {
		Department theDepartment = new Department();
		theDepartment.setName(deptName);
		theDepartment.setId(deptId);
		return theDepartment;
	}
//	@Test
//	public void failTest () {
//		Assert.fail();
//	}
	
}
	
