package com.techelevator.projects.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.time.LocalDate;
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
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;

public class JDBCEmployeeDAOIntegrationTest {

	private static final long TEST_DEPARTMENT = 50;

	private static SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;

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
		dao = new JDBCEmployeeDAO(dataSource);
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
	public void test_search_employees_by_name() {
		LocalDate birth = LocalDate.of(1980, 05, 22);
		LocalDate hire = LocalDate.of(1999, 06, 15);
		Employee employee = getEmployee((long) 16, (long) 3, "Dave", "Dougan", birth , "M".charAt(0), hire);

		dao.createEmployee(employee);
		List<Employee> results = new ArrayList<>();
		results.add(employee);
		
		assertEquals(results.toString() , dao.searchEmployeesByName("Dave", "Dougan").toString());
		
	}
	
	@Test
	public void change_employee_department() {
		LocalDate birth = LocalDate.of(1980, 05, 22);
		LocalDate hire = LocalDate.of(1999, 06, 15);
		Employee employee = getEmployee((long) 16, (long) 3, "Dave", "Dougan", birth , "M".charAt(0), hire);
		dao.createEmployee(employee);
		dao.changeEmployeeDepartment((long) 16, (long) 1);
		List<Employee> results = dao.getEmployeesByDepartmentId(1);

		assertEquals(employee.getDepartmentId(), results.contains(employee));
	}
	
	
	


	private Employee getEmployee(Long id, Long departmentId, String firstName, String lastName, LocalDate birthDay, char gender, LocalDate hireDate) {
		Employee employees = new Employee();
		employees = new Employee();
		employees.setId(id);
		employees.setDepartmentId(departmentId);
		employees.setFirstName(firstName);
		employees.setLastName(lastName);
		employees.setBirthDay(birthDay);
		employees.setGender(gender);
		employees.setHireDate(hireDate);
		return employees;
	}

	private void assertEmployeesAreEqual(Employee expected, Employee actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getDepartmentId(), actual.getDepartmentId());
		assertEquals(expected.getFirstName(), actual.getFirstName());
		assertEquals(expected.getLastName(), actual.getLastName());
		assertEquals(expected.getBirthDay(), actual.getBirthDay());
		assertEquals(expected.getGender(), actual.getGender());
		assertEquals(expected.getHireDate(), actual.getHireDate());
	}
}
