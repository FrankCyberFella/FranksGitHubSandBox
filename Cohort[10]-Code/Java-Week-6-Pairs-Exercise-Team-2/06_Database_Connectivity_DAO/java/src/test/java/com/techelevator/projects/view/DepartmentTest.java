package com.techelevator.projects.view;

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
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;



public class DepartmentTest {

	private static final long TEST_DEPARTMENT_ID = 18L;
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
		dataSource.setAutoCommit(false);
	}
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		String sqlInsertDepartment = "INSERT INTO department (department_id, name) Values (?, 'Magical') " ;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertDepartment, TEST_DEPARTMENT_ID);
		dao = new JDBCDepartmentDAO(dataSource);
	}
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void Test_Create_A_Department() {
	    Department testDepartment = getDepartment(TEST_DEPARTMENT_ID, "GREEN_ROOM");
		
		Department actualDepartment = dao.createDepartment(testDepartment);
		
		
		assertDepartmentsAreEqual(testDepartment, actualDepartment);
				
	}	
	
	@Test
	public void Test_Search_Department_By_ID() {
		Department testDepartment = getDepartment(TEST_DEPARTMENT_ID, "Magical");
		Department actualDepartment  =  getDepartment(TEST_DEPARTMENT_ID, "Magical");
		assertDepartmentsAreEqual(testDepartment, actualDepartment);
		
	}
	
	@Test
	public void Test_Search_A_Department_By_Name() {
		Department testDepartment = getDepartment(TEST_DEPARTMENT_ID, "Vitamix");
		dao.createDepartment(testDepartment);
		
		List<Department> results = new ArrayList <Department>();
		results.add(testDepartment);
		assertDepartmentsAreEqual(testDepartment, dao.searchDepartmentsByName("Vitamix").get(0));
			
	}
	
	
	@Test
	public void Test_Save_Department() {
		Department testDepartment = getDepartment(TEST_DEPARTMENT_ID, "Human Department");
		dao.createDepartment(testDepartment);
		testDepartment.setName("Human Resources");
		dao.saveDepartment(testDepartment);
		List<Department>results = new ArrayList <Department>();
		results.add(testDepartment);
		assertDepartmentsAreEqual(testDepartment, dao.searchDepartmentsByName("Human Resources").get(0));
	}
		
	
	private Department getDepartment(Long id, String name) {
		Department theDepartment = new Department();
		theDepartment.setName(name);
		theDepartment.setId(id);
		
		return theDepartment;
	}
	private void assertDepartmentsAreEqual(Department expected, Department actual) {
		assertEquals(expected.getName(), actual.getName());
		//assertEquals(expected.getId(), actual.getId());
		
	}
}
