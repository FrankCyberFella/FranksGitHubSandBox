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
		ArrayList<Employee> employeeList = new ArrayList<>();
		String sqlDisplayEmployees = "SELECT * " + "FROM employee ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplayEmployees);
		while(results.next()) {
			Employee employees = mapRowToEmployee(results);
			employeeList.add(employees);
		}
		return employeeList;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		Employee employee = null;
		ArrayList<Employee> employeeList = new ArrayList<>();
		String sqlDisplayEmployees = "SELECT * " + "FROM employee " + "WHERE first_name = ? and last_name = ? "; // account for Like
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplayEmployees, firstNameSearch, lastNameSearch);
		if (results.next()) {
			employee = mapRowToEmployee(results);
			employeeList.add(employee);
		}
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		Employee employee = null;
		ArrayList<Employee> employeeList = new ArrayList<>();
		String sqlDisplayEmployees = "SELECT * " + "FROM employee " + "WHERE department_id = ?"; // account for Like
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplayEmployees, id);
		while(results.next()) {
			employee = mapRowToEmployee(results);
			employeeList.add(employee);
		}
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		Employee employee = null;
		ArrayList<Employee> employeeList = new ArrayList<>();
		String sqlDisplayEmployees = "SELECT * " 
									+ "FROM employee " 
									+ "LEFT JOIN department " 
									+ " ON employee.department_id = department.department_id "
									+ "WHERE project_id is null"; // account for Like
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplayEmployees);
		while(results.next()) {
			employee = mapRowToEmployee(results);
			employeeList.add(employee);
		}
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		ArrayList<Employee> employeeList = new ArrayList<>();
		String sqlDisplayDepts = "SELECT employee.employee_id " + "FROM employee " + " join project_employee on project_employee.employee_id = employee.employee_id "
				+ "join project on project_employee.project_id = project.project_id" + "WHERE proejct_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplayDepts, projectId);
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employeeList.add(employee);
		}
		return employeeList;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String theUpdate = "Update employee " + "SET department_id = ? " + "WHERE employee_id = ? ";
		jdbcTemplate.update(theUpdate, departmentId, employeeId);
	}
	

	public Employee createEmployee(Employee employee) {
		String sqlInsertEmployee = "INSERT INTO employee(employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) " + "VALUES(?, ?, ?, ?, ?, ?, ?)";
		if(employee.getId() == null) {
			employee.setId(getNextEmployeeId());
				jdbcTemplate.update(sqlInsertEmployee, employee.getId(), employee.getDepartmentId(), employee.getFirstName(), employee.getLastName(), employee.getBirthDay(), employee.getGender(), employee.getHireDate());
		} else if (employee.getId() != null) {
				jdbcTemplate.update(sqlInsertEmployee, employee.getId(), employee.getDepartmentId(), employee.getFirstName(), employee.getLastName(), employee.getBirthDay(), employee.getGender(), employee.getHireDate());

		}

		return employee;

	}
	
	private long getNextEmployeeId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("Select nextval('seq_employee_id')");
		if (nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an ID for the new department");
		}

	}
	

	
	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee employees;
		employees = new Employee();
		employees.setId(results.getLong("employee_id"));
		employees.setDepartmentId(results.getLong("department_id"));
		employees.setFirstName(results.getString("first_name"));
		employees.setLastName(results.getString("last_name"));
		employees.setBirthDay(results.getDate("birth_date").toLocalDate());
		employees.setGender(results.getString("gender").charAt(0));
		employees.setHireDate(results.getDate("hire_date").toLocalDate());
		return employees;
	}

}
