package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		
		ArrayList<Employee> allEmployees = new ArrayList <Employee>();
		String sqlTheEmployees = "SELECT * FROM employee";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlTheEmployees);
		while(results.next()) {
			Employee anEmployee = mapRowToEmployee(results);
			allEmployees.add(anEmployee);
		}
		return allEmployees;
		
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		
		ArrayList<Employee> allEmployees = new ArrayList <Employee>();
		String sqlTheEmployees = "SELECT * FROM employee WHERE first_name = ? AND last_name = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlTheEmployees, firstNameSearch, lastNameSearch);
		while(results.next()) {
			Employee anEmployee = mapRowToEmployee(results);
			allEmployees.add(anEmployee);
		}
		return allEmployees;
		
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		
		ArrayList<Employee> employeesByID = new ArrayList <Employee>();
		String sqlFindEmployeeByDepartmentID = "SELECT * FROM employee WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindEmployeeByDepartmentID, id);
		while(results.next()) {                  
			Employee anEmployee = mapRowToEmployee(results);
			employeesByID.add(anEmployee);
		}
		return employeesByID;
		
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		
		ArrayList<Employee> employeesWithoutProjects = new ArrayList <Employee>();
		String sqlFindEmployeesWithoutProjects = "SELECT * FROM employee FULL OUTER JOIN project_employee ON employee.employee_id = project_employee.employee_id WHERE project_employee.employee_id IS NULL";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindEmployeesWithoutProjects);
		while(results.next()) {
			Employee anEmployee = mapRowToEmployee(results);
			employeesWithoutProjects.add(anEmployee);
		}
		return employeesWithoutProjects;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		
		ArrayList<Employee> employeesByProjectID = new ArrayList <Employee>();
		String sqlFindEmployeeByProjectID = "SELECT * FROM employee INNER JOIN project_employee ON employee.employee_id = project_employee.employee_id WHERE project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindEmployeeByProjectID, projectId);
		while(results.next()) {                  
			Employee anEmployee = mapRowToEmployee(results);
			employeesByProjectID.add(anEmployee);
		}
		return employeesByProjectID;
		
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		
		String updater = "UPDATE employee " +
		   		   "SET department_id = ? " +
		           "WHERE employee_id = ? ";
		jdbcTemplate.update(updater, departmentId, employeeId);

	}
	
	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee anEmployee = new Employee();
		anEmployee.setId(results.getLong("employee_id"));
		anEmployee.setDepartmentId(results.getLong("department_id"));
		anEmployee.setFirstName(results.getString("first_name"));
		anEmployee.setLastName(results.getString("last_name"));
		anEmployee.setBirthDay(results.getDate("birth_date").toLocalDate());
		anEmployee.setGender(results.getString("gender").charAt(0));
		anEmployee.setHireDate(results.getDate("hire_date").toLocalDate());
		return anEmployee;
	}

}
