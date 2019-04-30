package com.techelevator.projects.model.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.time.LocalDate;
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

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;

public class JDBCEmployeeDAOIntegrationTest {
	
	private static SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;
	
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
		LocalDate currentDate = LocalDate.of(2019, 02, 19);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String insertNewEmployee = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) "
											+ "	VALUES (999, 1, 'John', 'Wayne', ?, 'M', ?)";
	
		jdbcTemplate.update(insertNewEmployee, currentDate, currentDate);
		
		dao = new JDBCEmployeeDAO(dataSource);
		
	}
	
	@After
	public void rollback() throws SQLException{
		
		dataSource.getConnection().rollback();
		
	}
	
	//Tests
	@Test
	public void get_all_employees_test() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		List<Employee> employeeList = dao.getAllEmployees();
		String sqlSelectRowCount = "SELECT count(*) FROM Employee";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectRowCount);
		results.next();
		
		assertEquals(employeeList.size(), results.getInt(1));		
		
	}
	
	@Test
	public void search_employee_by_name_test() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		LocalDate currentDate = LocalDate.of(2019, 02, 19);
		
		List<Employee> employeeList = dao.searchEmployeesByName("John", "Wayne");
		
		Employee newEmployee = getEmployee((long)999, (long)1, "John", "Wayne", currentDate, 'M', currentDate);
		
		Employee savedEmployee = employeeList.get(0);
		
		assertEmployeesAreEqual(newEmployee, savedEmployee);	
		
	}
	
	@Test
	public void get_employee_by_department_test() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List <Employee> employeeList = dao.getEmployeesByDepartmentId((long)1);
		Employee targetEmployee = new Employee();
		LocalDate currentDate = LocalDate.of(2019, 02, 19);
		Employee newEmployee = getEmployee((long)999, (long)1, "John", "Wayne", currentDate, 'M', currentDate);
		
		
		for (Employee name : employeeList) {
			if (name.getFirstName().equals("John") && name.getLastName().equals("Wayne")) {
				targetEmployee = name;	
			}
		}
		
		assertEmployeesAreEqual(newEmployee, targetEmployee);
		
	}
	
	@Test
	public void get_employees_without_projects_test() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Employee targetEmployee = new Employee();
		
		List<Employee> employeeListNoProjects = dao.getEmployeesWithoutProjects();
		
		for (Employee employee : employeeListNoProjects) {
			if (employee.getFirstName().equals("John") && employee.getLastName().equals("Wayne")) {
				
				targetEmployee = employee;	
				
				List<Employee> employeeList = dao.searchEmployeesByName("John", "Wayne");
				
				assertEmployeesAreEqual(employeeList.get(0), targetEmployee);
			}
		}	
	}
	
	@Test
	public void get_employees_by_project_id_test() {
		
		List<Employee> employeesByProjectList = dao.getEmployeesByProjectId((long)6);
		
		assertEquals(2, employeesByProjectList.size());
		
	}
	
	@Test
	public void test_change_employee_department() {
		
		dao.changeEmployeeDepartment((long)999, (long)4);
		
		List<Employee> departmentList = dao.getEmployeesByDepartmentId((long)4);
		
		Employee targetEmployee = new Employee();
		
		for (Employee employee : departmentList) {
			if (employee.getFirstName().equals("John") && employee.getLastName().equals("Wayne")) {
				
				targetEmployee = employee;	
				
				List<Employee> employeeList = dao.searchEmployeesByName("John", "Wayne");
				
				assertEmployeesAreEqual(employeeList.get(0), targetEmployee);
			}
		}
		
	}
	
	
	
	
	private Employee getEmployee(Long employeeId, Long departmentId, String firstName, String lastName, LocalDate birthDay, char gender, LocalDate hireDate) {
		Employee theEmployee = new Employee();
		theEmployee.setId(employeeId);
		theEmployee.setDepartmentId(departmentId);
		theEmployee.setFirstName(firstName);
		theEmployee.setLastName(lastName);
		theEmployee.setBirthDay(birthDay);
		theEmployee.setGender(gender);
		theEmployee.setHireDate(hireDate);
		return theEmployee;
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
