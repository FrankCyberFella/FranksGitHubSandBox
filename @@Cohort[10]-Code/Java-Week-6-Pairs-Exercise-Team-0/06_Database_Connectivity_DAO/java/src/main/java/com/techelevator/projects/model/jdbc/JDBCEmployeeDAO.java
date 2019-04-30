package com.techelevator.projects.model.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sqlGetAllEmployees = "SELECT * " + "FROM employee";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllEmployees);
		while (results.next()) {
			Employee theEmployee = mapRowToEmployee(results);
			employees.add(theEmployee);
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employeeList = new ArrayList();
		String sqlSearchEmployeesByName = "SELECT * FROM employee WHERE first_name iLike '%'||?||'%' AND last_name ilike '%'||?||'%'";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchEmployeesByName,firstNameSearch,lastNameSearch);
		while (results.next()) {
			Employee theEmployee = mapRowToEmployee(results);
			employeeList.add(theEmployee);
		}		
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		List<Employee> employeeDepartment = new ArrayList();
		String sqlGetEmployeesByDepartmentID = "SELECT * FROM employee WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesByDepartmentID,id);
		while(results.next()) {
			Employee theEmployee = mapRowToEmployee(results);
			employeeDepartment.add(theEmployee);
		}
		
		return employeeDepartment;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employeeNoProject = new ArrayList();
		String sqlGetEmployeesWithoutProjects = "SELECT * FROM employee e FULL OUTER JOIN project_employee pe ON e.employee_id=pe.employee_id WHERE pe.project_id IS NULL";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesWithoutProjects);
		while(results.next()) {
			Employee theEmployee = mapRowToEmployee(results);
			employeeNoProject.add(theEmployee);
		}
		return employeeNoProject;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employeeEachProject = new ArrayList();
		String sqlGetEmployeesByProjectId = "SELECT * FROM employee e JOIN project_employee pe ON e.employee_id=pe.employee_id WHERE pe.project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesByProjectId,projectId);
		while(results.next()) {
			Employee theEmployee = mapRowToEmployee(results);
			employeeEachProject.add(theEmployee);
		}
		return employeeEachProject;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		List<Employee> employeeDepartments = new ArrayList();
		String sqlUpdateDepartment = "UPDATE employee " +
				                     "SET department_id = ? " +
				                     "WHERE employee_id = ? ";
		jdbcTemplate.update(sqlUpdateDepartment, departmentId, employeeId);
	}

	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee theEmployee = new Employee();
		theEmployee.setId(results.getLong("employee_id"));
		theEmployee.setDepartmentId(results.getLong("department_id"));
		theEmployee.setDepartmentId(results.getLong("department_id"));
		theEmployee.setFirstName(results.getString("first_name"));
		theEmployee.setLastName(results.getString("last_name"));
		theEmployee.setBirthDay(results.getDate("birth_date").toLocalDate());
		theEmployee.setGender(results.getString("gender").toCharArray()[0]);
		theEmployee.setHireDate(results.getDate("hire_date").toLocalDate());

		return theEmployee;
	}
}
