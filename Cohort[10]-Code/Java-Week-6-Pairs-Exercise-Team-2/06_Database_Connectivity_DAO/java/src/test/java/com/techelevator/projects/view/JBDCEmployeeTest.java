package com.techelevator.projects.view;

import static org.junit.Assert.*;

import java.sql.Date;
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

public class JBDCEmployeeTest {
	private static final long TEST_EMPLOYEE_ID = 3L;
    private static final long TEST_DEPARTMENT_ID = 3L;
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
		dataSource.setAutoCommit(false);
	}
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		String sqlInsertEmployee = "INSERT INTO employee (department_id, first_name, last_name, birth_date, gender, hire_date)"
				+ "Values (?, 'Sam', 'Peters', '1986-04-03', 'M', '2000-12-25')" ;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertEmployee, TEST_DEPARTMENT_ID);
		dao = new JDBCEmployeeDAO(dataSource);
	}

	
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	
@Test
        public void  Search_an_Employee_By_Name() {
			List <Employee> actualEmployees = dao.searchEmployeesByName("Sam", "Peters");
			assertEquals("Array size should only be one", 1, actualEmployees.size()); 
			assertEquals("First name must be =", "Sam", actualEmployees.get(0).getFirstName());
			assertEquals("Last name must be =", "Peters", actualEmployees.get(0).getLastName());
	}
	

@Test
	public void Change_Employee_Department_() {
			List <Employee> employee = dao.searchEmployeesByName("Sam", "Peters");
			Long employeeId = employee.get(0).getId();
			dao.changeEmployeeDepartment(employeeId, 2L);
			assertEquals("department_id should =", 2L, employee.get(0).getDepartmentId()); 
			
	}

	
	
	private Employee setEmployee(Long employee_id, Long department_id, String first_name, String last_name, LocalDate birth_date, char gender, LocalDate hire_date) {
		Employee employee = new Employee();
		employee.setId(employee_id);
		employee.setDepartmentId(department_id);
		employee.setFirstName(first_name);
		employee.setLastName(last_name);
		employee.setBirthDay(birth_date);
		employee.setGender(gender);
		employee.setHireDate(hire_date);
		return employee;
	}

}
