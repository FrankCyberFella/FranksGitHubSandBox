package com.techelevator.projects.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;

public class JDBCDepartmentDAOIntegrationTest {

	private static final long TEST_DEPARTMENT = 50;

	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO dao;

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/*
		 * The following line disables autocommit for connections returned by this
		 * DataSource. This allows us to rollback any changes after each test
		 */
		dataSource.setAutoCommit(false);
	}

	/*
	 * After all tests have finished running, this method will close the DataSource
	 */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	// Run before each test is done
	@Before
	public void setup() {
//			String sqlInsertDepartment = "INSERT INTO department (department_id, name) VALUES (?, 'Finance')";
//			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//			jdbcTemplate.update(sqlInsertDepartment, TEST_DEPARTMENT);
		dao = new JDBCDepartmentDAO(dataSource);
	}

	/*
	 * After each test, we rollback any changes that were made to the database so
	 * that everything is clean for the next test
	 */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void test_update_name() {
		Department theDepartment = getDepartment((long) 4, "Department4");
		dao.saveDepartment(theDepartment);
		Department savedDepartment = dao.getDepartmentById((long) 4);
		assertNotEquals(null, theDepartment.getId());
		assertDepartmentsAreEqual(theDepartment, savedDepartment);
	}
	
	
	@Test
	public void test_search_name() {
		Department theDepartment = getDepartment((long) 12, "Department12");

		dao.createDepartment(theDepartment);

		List<Department> results = new ArrayList<>();
		results.add(theDepartment);

		assertEquals(results.toString(), dao.searchDepartmentsByName("Department12").toString());
	}

	@Test
	public void test_show_all() {
		//Department theDepartment = getDepartment((long) 12, "Department12");
		//Department theDepartmentTwo = getDepartment((long) 13, "Department13");

		//dao.createDepartment(theDepartment);
		//dao.createDepartment(theDepartmentTwo);

		//List<Department> results = new ArrayList<>();
		//results.add(theDepartment);
		//results.add(theDepartmentTwo);
		
		dao.getAllDepartments().size();
		
		//List<String> newList = new ArrayList<>();
		/*
		 * String[] results =
		 * dao.getAllDepartments().toString().substring(0).split(",");
		 * System.out.println(results); Department test = new Department(); for (String
		 * result: results){ if (dao.getAllDepartments().contains(result)) {
		 * test.setName(result);
		 * 
		 * } }
		 * 
		 * 
		 * assertEquals(true, dao.getAllDepartments().contains(test));
		 */
		 
		assertEquals(7, dao.getAllDepartments().size());
		
		//assertEquals(results.toString(), dao.getAllDepartments().subList(7, 9).toString());
	}

	@Test
	public void test_department_add_new_department() throws SQLException {
		Department theDepartment = getDepartment((long) 8, "Department8");
		dao.createDepartment(theDepartment);
		Department savedDepartment = dao.getDepartmentById(theDepartment.getId());
		assertNotEquals(null, theDepartment.getId());
		assertDepartmentsAreEqual(theDepartment, savedDepartment);

	}

	// method to construct a City object
	private Department getDepartment(Long id, String name) {
		Department theDepartment = new Department();
		theDepartment.setId(id);
		theDepartment.setName(name);
		return theDepartment;
	}

	private void assertDepartmentsAreEqual(Department expected, Department actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
	}
}
