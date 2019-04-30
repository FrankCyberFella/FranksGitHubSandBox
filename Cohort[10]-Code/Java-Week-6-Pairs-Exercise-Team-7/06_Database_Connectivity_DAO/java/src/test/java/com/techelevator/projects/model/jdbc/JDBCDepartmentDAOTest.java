package com.techelevator.projects.model.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.*;

public class JDBCDepartmentDAOTest {
	

	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO dao;
	
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false); // turn autocommit off because you're doing testing
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException{
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		dao = new JDBCDepartmentDAO(dataSource);
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);
	}
	
	@After
	public void rollback() throws SQLException{
		dataSource.getConnection().rollback();
	}
	
	
	
	
	  @Test public void getDepartmentByDepartmentIdTest() { 
	
	  Department expected = getDepartment(500, "Testing Department"); 
	  dao.createDepartment(expected);
	  Department results = dao.getDepartmentById(500);
	  
	  System.out.println(expected.toString() + " " + results.toString());
	  
	  assertNotEquals(null, results); 
	  assertDepartmentsAreEqual(expected, results);
	  
	  }
	 
	
	@Test
	public void testSearchDepartmentByNameAndCreateDepartment() {
		String deptName = "Department 20";
		Department newDept = getDepartment(999, deptName);
		dao.createDepartment(newDept);
		List<Department> results  = dao.searchDepartmentsByName(deptName);
		System.out.println(results.get(0) + "   "  + newDept);
		System.out.println(results.get(0).getId() + "                "  + newDept.getId());
		assertNotEquals(null, results);
		assertDepartmentsAreEqual(newDept, results.get(0));
	}
	
	@Test
	public void testSaveDepartment() {
		String deptName = "Naming Department";
		Department newDept = getDepartment(2, deptName);
		dao.saveDepartment(newDept);
		List<Department> results = dao.searchDepartmentsByName(deptName);
		assertNotEquals(null, newDept.getId());
		assertEquals(results.get(0).getId(), 2);
		assertDepartmentsAreEqual(newDept, results.get(0));
		
	}
	
	
	
	
	
	private Department getDepartment(long id, String name) {
		Department testDepartment = new Department(); 
		testDepartment.setId(id);
		testDepartment.setName(name);
		return testDepartment;
	}
	
	
	private void assertDepartmentsAreEqual(Department expected, Department result) {
		assertEquals("Ids not the same", expected.getId(), result.getId());
		assertEquals("names s not the same", expected.getName(), result.getName());
	}
	
	
	
	
	
}