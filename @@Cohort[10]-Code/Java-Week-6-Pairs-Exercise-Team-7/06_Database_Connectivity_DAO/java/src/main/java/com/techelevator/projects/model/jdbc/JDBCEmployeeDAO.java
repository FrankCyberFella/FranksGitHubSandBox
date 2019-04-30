package com.techelevator.projects.model.jdbc;

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
		List<Employee> allEmployees = new ArrayList<Employee>();
		String gotEmployees = "SELECT * " + " FROM Employee ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(gotEmployees);
		while(results.next()) {
			Employee theEmployees = mapRowToEmployees(results);
			allEmployees.add(theEmployees);
		}
		
		return allEmployees;
	}

	private Employee mapRowToEmployees(SqlRowSet results) {
		Employee theEmployees;
		theEmployees = new Employee();
		theEmployees.setId(results.getLong("employee_id"));
		theEmployees.setDepartmentId(results.getLong("department_id"));
		theEmployees.setFirstName(results.getString("first_name"));
		theEmployees.setLastName(results.getString("last_name"));
		theEmployees.setBirthDay(results.getDate("birth_date").toLocalDate());
		theEmployees.setGender(results.getString("gender").charAt(0));
		theEmployees.setHireDate(results.getDate("hire_date").toLocalDate());
		return theEmployees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> matchedEmployees = new ArrayList<Employee>();
		String sqlSearchEmployees = " SELECT * " + " FROM employee" + " WHERE first_name LIKE ? AND last_name LIKE ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchEmployees, "%" + firstNameSearch + "%", "%" + lastNameSearch + "%" );
		
		while(results.next()) {
			Employee theEmployee = mapRowToEmployees(results);
			matchedEmployees.add(theEmployee);
		
	}return  matchedEmployees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		List<Employee> matchedEmployees = new ArrayList<Employee>();
			String sqlDeptEmployees = "SELECT * " + "FROM employee " + " WHERE department_id = ? ";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDeptEmployees, id);
			
			while(results.next()) {
			Employee foundEmployee = mapRowToEmployees(results);
			matchedEmployees.add(foundEmployee);
			
		}
			
		return matchedEmployees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> matchedEmployees = new ArrayList<Employee>();
		String sqlDeptEmployees = "SELECT * " + "FROM employee " + " WHERE employee_id = (SELECT employee_id FROM project_employee WHERE project_id IS NULL) ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDeptEmployees);
		
		while(results.next()) {
			Employee foundEmployee = mapRowToEmployees(results);
			matchedEmployees.add(foundEmployee);
			
		}
		return matchedEmployees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> matchedEmployees = new ArrayList<Employee>();
		String sqlDeptEmployees = "SELECT * " + "FROM employee " + " WHERE employee_id = (SELECT employee_id FROM project_employee WHERE project_id = ?) ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDeptEmployees, projectId);
		
		while(results.next()) {
			Employee foundEmployee = mapRowToEmployees(results);
			matchedEmployees.add(foundEmployee);
			
		}
		return matchedEmployees;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		System.out.println(employeeId + " " + departmentId);
		String sqlSaveDepartments = " UPDATE employee " + " SET department_id = ? " + " WHERE employee_id = ?";
		jdbcTemplate.update(sqlSaveDepartments, departmentId, employeeId);
	}

	public Employee createEmployee(Employee newEmployee) {
	
		String sqlCreateEmployee = "INSERT INTO employee(first_name, last_name, employee_id, department_id, birth_date, gender, hire_date)  " +
				 " VALUES(?, ?, ?, ?, ?, ?, ?) ";
			jdbcTemplate.update(sqlCreateEmployee, newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getId(), 
					newEmployee.getDepartmentId(), newEmployee.getBirthDay(), newEmployee.getGender(), newEmployee.getHireDate());
			
			return newEmployee;
	}


	}
	
	

