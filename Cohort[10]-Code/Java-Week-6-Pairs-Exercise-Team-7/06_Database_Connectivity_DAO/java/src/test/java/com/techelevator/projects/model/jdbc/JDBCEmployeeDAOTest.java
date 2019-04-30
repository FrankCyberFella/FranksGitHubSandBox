package com.techelevator.projects.model.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;

public class JDBCEmployeeDAOTest {

	private static SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;
	
	
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
		dao = new JDBCEmployeeDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException{
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void getEmployeeByNameTest() {
	Employee newEmp = getEmployee("Sam", "Jones", (long)900, (long)2, LocalDate.of(1998, 03, 12), (char)'M', LocalDate.of(2012, 05, 17));
	dao.createEmployee(newEmp);
	List<Employee> results  = dao.searchEmployeesByName(newEmp.getFirstName(), newEmp.getLastName());
	System.out.println(results.get(0) + "   "  + newEmp);
	System.out.println(results.get(0).getId() + "                "  + newEmp.getId());
	assertNotEquals(null, results);
	assertEmployeesAreEqual(newEmp, results.get(0));
}
	private void assertEmployeesAreEqual(Employee newEmp, Employee employee) {
		assertEquals("Employee Ids not the same", newEmp.getId(), employee.getId());
		assertEquals(" not the same first name", newEmp.getFirstName(), employee.getFirstName());
		assertEquals(" not the same last name", newEmp.getLastName(), employee.getLastName());
	}

	private Employee getEmployee(String first_name, String last_name, long employee_id, long department_id, LocalDate birth_date, 
			char gender, LocalDate hire_date) {
			Employee testEmployee = new Employee(); 
			testEmployee.setFirstName(first_name);
			testEmployee.setLastName(last_name);
			testEmployee.setId(employee_id);
			testEmployee.setDepartmentId(department_id);
			testEmployee.setBirthDay(birth_date);
			testEmployee.setGender(gender);
			testEmployee.setHireDate(hire_date);
		 
		return  testEmployee;
	}
	
}
