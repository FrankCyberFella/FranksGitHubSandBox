package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;

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
		
List<Employee> newEmployeeList = new ArrayList<Employee>();
		
		String getAllEmployeesStr = "SELECT * FROM Employee";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(getAllEmployeesStr);

		while (results.next()) {
			Employee newEmployee = mapRowToEmployee(results);
			
			newEmployeeList.add(newEmployee);
		}
		
		return newEmployeeList;
		
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> newEmployeeList = new ArrayList<Employee>();
		
		String searchEmployeesByNameStr = "SELECT * FROM Employee WHERE first_name ILIKE '" + firstNameSearch + "' AND last_name ILIKE '" + lastNameSearch + "' ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(searchEmployeesByNameStr);
		
		while (results.next()) {
			Employee newEmployee = mapRowToEmployee(results);
			
			newEmployeeList.add(newEmployee);
		}
		
		return newEmployeeList;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		List<Employee> newEmployeeList = new ArrayList<Employee>();
		
		String searchEmployeeDepartmentId= "SELECT * FROM Employee WHERE department_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(searchEmployeeDepartmentId, id);
		
		while (results.next()) {
			Employee newEmployee = mapRowToEmployee(results);
			
			newEmployeeList.add(newEmployee);
		}
		
		return newEmployeeList;
	}
	

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> newEmployeeList = new ArrayList<Employee>();
		
		String employeesWithoutProjects = "SELECT * " +
										  "FROM employee " +
										  "JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
										  "WHERE employee.employee_id NOT IN (SELECT project_id FROM project_employee)";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(employeesWithoutProjects);
		
		while (results.next()){
			Employee newEmployee = mapRowToEmployee(results);
			newEmployeeList.add(newEmployee);
		}
		return newEmployeeList;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> newEmployeeList = new ArrayList<Employee>();
		
		String searchEmployeeByProjectId = "SELECT * "
										 + "FROM project_employee pe "
										 + "JOIN employee e "
										 + "ON pe.employee_id = e.employee_id "
										 + "WHERE e.employee_id IN (SELECT employee_id "
										 						 + "FROM project_employee "
										 						 + "WHERE project_id = ?) ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(searchEmployeeByProjectId, projectId);
										 						
		while (results.next()) {
			Employee newEmployee = mapRowToEmployee(results);
			newEmployeeList.add(newEmployee);
			
		}
		
		return newEmployeeList;
	
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		
		String changeEmployeeDept = "UPDATE employee SET department_id = ? WHERE employee_id = ?";
		
		jdbcTemplate.update(changeEmployeeDept, departmentId, employeeId);
		
	}

public Employee mapRowToEmployee(SqlRowSet results) {
		
		Employee mappedDepartment = new Employee();
		
		mappedDepartment.setId(results.getLong("employee_id"));
		mappedDepartment.setFirstName(results.getString("first_name"));
		mappedDepartment.setLastName(results.getString("last_name"));
		mappedDepartment.setBirthDay(results.getDate("birth_date").toLocalDate());
		mappedDepartment.setGender(results.getString("gender").charAt(0));
		mappedDepartment.setHireDate(results.getDate("hire_date").toLocalDate());
		mappedDepartment.setDepartmentId(results.getLong("department_id"));
		
		
		return mappedDepartment;
	}
	
}
