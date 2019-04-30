package com.techelevator.projects.model.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;
import java.time.LocalDate;
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
import com.techelevator.projects.model.Employee;

public class JDBCEmployeeDAOTest {
	
	private static SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;
	private JDBCProjectDAO daoProject;
	private final long TEST_ID = 999;
	
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
		String sqlInsertEmployee = "INSERT INTO employee ( department_id, first_name, last_name, birth_date, gender, hire_date) VALUES( 1, 'Brett', 'Jensen', '1991-01-24', 'M', '2019-01-14' ) ";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.batchUpdate(sqlInsertEmployee);
		dao = new JDBCEmployeeDAO(dataSource);
		daoProject = new JDBCProjectDAO(dataSource);
	}
	
	@After
	public void  rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	
	@Test
	public void test_get_employee_by_department_id() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	
		String sqlCount = "SELECT count(*) AS counts " + 
						  "FROM employee " + 
						  "WHERE department_id = 1 " + 
						  "GROUP BY department_id ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCount);
		results.next();
		int myint = results.getInt("counts");
		
		assertEquals("Test get employee by department: values did not equal", 2, results.getInt("counts"));
	}
	
	@Test
	public void test_create_employee() {
		LocalDate birthDate = LocalDate.of(1991,01,24);
		LocalDate hireDate = LocalDate.of(2019,01,14);
		Employee aEmployee = getEmployee( (long)1, "Brett", "Jensen", birthDate, 'M', hireDate);
		
		assertNotEquals(null, aEmployee);		
	}
	
	@Test
	public void test_search_employee_by_name() {
		LocalDate birthDate = LocalDate.of(1991,01,24);
		LocalDate hireDate = LocalDate.of(2019,01,14);
		Employee aEmployee = getEmployee((long) 1, "Brett", "Jensen", birthDate, 'M', hireDate);
		List <Employee> testEmployee = new ArrayList<Employee>();
		testEmployee.add(aEmployee);
		testEmployee = dao.searchEmployeesByName("Brett", "Jensen");
		
		assertEmployeeAreEqual(aEmployee, testEmployee.get(0));
		
	}
	
	@Test
	public void test_change_employee_department() {
		// Getting list of employee by name and storing employee Id
		// Storing current employee department Id
		// comparing expect department Id with return department Id
		Employee testEmployee = dao.searchEmployeesByName("Brett", "Jensen").get(0);
		long employeeId = testEmployee.getId();
		long deptId = testEmployee.getDepartmentId();	
		assertEquals("Not expected department Id", 1, deptId);
		// Changing department Id to 3
		// Getting employee with new department Id
		// Comparing new expected department with returned employee department
		dao.changeEmployeeDepartment(employeeId, (long) 3);
		Employee testEmployeeNewId = dao.searchEmployeesByName("Brett", "Jensen").get(0);
		long newDeptId = testEmployeeNewId.getDepartmentId();
		assertEquals("Not expected department Id", 3, newDeptId);
		

	}
	
	@Test
	public void test_get_employee_without_project() {
		// Getting list of employee without projects
		// Storing size of returned array
		// comparing expect size with return size
		List<Employee> testEmployees = dao.getEmployeesWithoutProjects();
		int employeesWithoutProjects = testEmployees.size();
		assertEquals("Not expected amount of employees", 3, employeesWithoutProjects);
		// Got first employee from list and added to project
		// comparing expected size with returned size
		Employee newEmployee = testEmployees.get(0);
		long employeeId = newEmployee.getId();
		daoProject.addEmployeeToProject((long) 4, employeeId);
		List<Employee> newTestEmployees = dao.getEmployeesWithoutProjects();
		int newEmployeesWithoutProjects = newTestEmployees.size();
		assertEquals("Not expected amount of employees", 2, newEmployeesWithoutProjects);		
	}
	
	@Test
	public void test_get_employee_by_project_id() {
		// Getting list of employee with project 3
		// Storing size of returned array
		// comparing expect size with return size
		List<Employee> testEmployees = dao.getEmployeesByProjectId((long)4);
		int employeesWithProject = testEmployees.size();
		System.out.println(employeesWithProject);
		assertEquals("Not expected amount of employees", 2, employeesWithProject);
		// Got first employee without a project and added to project 4
		// comparing expected size with returned size
		Employee newEmployee = dao.getEmployeesWithoutProjects().get(0);
		long employeeId = newEmployee.getId();
		daoProject.addEmployeeToProject((long) 4, employeeId);
		List<Employee> newTestEmployees = dao.getEmployeesByProjectId((long)4);
		int newEmployeesWithProject = newTestEmployees.size();
		System.out.println(newEmployeesWithProject);
		assertEquals("Not expected amount of employees", 3, newEmployeesWithProject);		
	}
	
	private Employee getEmployee(Long department_id, String first_name, String last_name, LocalDate birth_date, char gender,LocalDate hire_date) {
		Employee theEmployee = new Employee();
		theEmployee.setDepartmentId(department_id);
		theEmployee.setFirstName(first_name);
		theEmployee.setLastName(last_name);
		theEmployee.setBirthDay(birth_date);
		theEmployee.setGender(gender);
		theEmployee.setHireDate(hire_date);
		return theEmployee;
	}
	
	private void assertEmployeeAreEqual(Employee expected, Employee actual) {
//		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getFirstName(), actual.getFirstName());
		assertEquals(expected.getLastName(), actual.getLastName());
		assertEquals(expected.getBirthDay(), actual.getBirthDay());
		assertEquals(expected.getGender(), actual.getGender());
		assertEquals(expected.getHireDate(), actual.getHireDate());
	}




	
	
	
	
}
