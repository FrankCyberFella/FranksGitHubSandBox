package com.techelevator.projects.model.jdbc;
import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.time.LocalDate;
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


public class JDBCEmployeeDAOIntegrationTest {
	private static SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;
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
		String sqlInsertEmployee = "INSERT INTO Employee(employee_id,department_id,first_name,last_name,birth_date,gender,hire_date) VALUES (?,2,'Joy','Smith','2009/12/13','F','2019/04/12')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertEmployee, TEST_ID); 
		dao = new JDBCEmployeeDAO(dataSource); 
	}
	
	

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void test_search_employee_by_name() {
		LocalDate birthDate = LocalDate.of(2009, 12, 13);
		LocalDate hireDate = LocalDate.of(2019, 04, 12);
		Employee theEmployee = getEmployee(TEST_ID,(long)2,"Joy","Smith",birthDate,'F',hireDate);
		List<Employee> testEmployee = dao.searchEmployeesByName("Joy", "Smith");
		assertNotEquals(null, testEmployee);
		assertEmployeesAreEqual(theEmployee, testEmployee.get(0));
	}
	
	@Test
	public void test_add_search_employee_by_department_id() {
		LocalDate birthDate = LocalDate.of(2009, 12, 13);
		LocalDate hireDate = LocalDate.of(2019, 04, 12);
		Employee theEmployee = dao.searchEmployeesByName("Joy", "Smith").get(0);
		int numberOfEmployees = dao.getEmployeesByDepartmentId((long)4).size();
		dao.changeEmployeeDepartment(theEmployee.getId(),(long)4);
		int totalEmployees = dao.getEmployeesByDepartmentId((long)4).size();
		assertEquals(numberOfEmployees + 1, totalEmployees);
	}
	
	

	
	private Employee getEmployee(Long employeeId, Long departmentId,String firstName,String lastName,LocalDate birthDate,char gender,LocalDate hireDate) {
		Employee theEmployee = new Employee();
		theEmployee.setFirstName(firstName);
		theEmployee.setLastName(lastName);
		theEmployee.setId(employeeId);
		theEmployee.setDepartmentId(departmentId);
		theEmployee.setBirthDay(birthDate);
		theEmployee.setGender(gender);
		theEmployee.setHireDate(hireDate);
		return theEmployee;
	}
	private void assertEmployeesAreEqual(Employee expected, Employee actual) {
		assertEquals(expected.getBirthDay(),actual.getBirthDay());
		assertEquals(expected.getDepartmentId(),actual.getDepartmentId());
		assertEquals(expected.getFirstName(),actual.getFirstName());
		assertEquals(expected.getGender(),actual.getGender());
		assertEquals(expected.getHireDate(),actual.getHireDate());
		assertEquals(expected.getId(),actual.getId());
		assertEquals(expected.getLastName(),actual.getLastName());
	}
}
