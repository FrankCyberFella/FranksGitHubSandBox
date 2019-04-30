package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;
import com.techelevator.projects.model.Project;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		ArrayList<Employee> employeeList = new ArrayList<>();
		String sqlFindAllEmployees = "SELECT * "+
										   "FROM employee ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees);
		while(results.next()) {
			Employee employeeName = mapRowToEmployee(results);
			employeeList.add(employeeName);
		}
		return employeeList;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
			ArrayList<Employee> deptEmployeeList = new ArrayList<>();
			String sqlFindAllEmployees = "SELECT * " + 
										"FROM employee " + 
										"WHERE first_name = ? "+
										"AND last_Name = ? "
											   ;
			
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees, firstNameSearch, lastNameSearch);
			while(results.next()) {
				Employee employeeName = mapRowToEmployee(results);
				deptEmployeeList.add(employeeName);
			}
			
			return deptEmployeeList;
		}

	@Override
	public List<Employee> getEmployeesByDepartmentId(Long id) {
		
		ArrayList<Employee> deptEmployeeList = new ArrayList<>();
		String sqlFindAllEmployees = "SELECT * " + 
									"FROM employee " + 
									"WHERE department_id = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees, id);
		while(results.next()) {
			Employee employeeName = mapRowToEmployee(results);
			deptEmployeeList.add(employeeName);
		}
		return deptEmployeeList;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		ArrayList<Employee> empWithouProjectList = new ArrayList<>();
		String sqlFindAllEmplsWithouProjects = "SELECT * " + 
				"FROM employee LEFT JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
				"WHERE project_employee.employee_id IS NULL "
				;
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmplsWithouProjects);
		while(results.next()) {
			Employee employeeName = mapRowToEmployee(results);
			empWithouProjectList.add(employeeName);
		}
		return empWithouProjectList;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		ArrayList<Employee> activeProjectEmployeeList = new ArrayList<>();
		String sqlFindProjectEmployees = "SELECT * "
									+ "FROM employee JOIN project_employee ON project_employee.employee_id = employee.employee_id "
									+ "WHERE project_id = ? "
									;
				
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindProjectEmployees, projectId);
		while(results.next()) {
			Employee employeeName = mapRowToEmployee(results);
			activeProjectEmployeeList.add(employeeName);
		}
		return activeProjectEmployeeList;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String sqlUpdateEmpDept = "UPDATE employee "+
				"Set department_id = ? " +
				"WHERE employee_id =  ? ";

		jdbcTemplate.update(sqlUpdateEmpDept, departmentId, employeeId);

	}
	
	public Employee createEmployee(Employee newEmployee) {
		String sqlInsertDept = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date)" +
							   " Values(?, ?, ?, ?, ?, ?, ?) ";
		if(newEmployee.getId() == null ) {
			newEmployee.setId(getNextEmployeeId());
		}
		jdbcTemplate.update(sqlInsertDept, newEmployee.getId()
										 , newEmployee.getFirstName()
										 , newEmployee.getLastName()
										 , newEmployee.getBirthDay()
										 , newEmployee.getGender()
										 , newEmployee.getDepartmentId()
										 , newEmployee.getHireDate());
		
		return newEmployee;
	}
	
	private long getNextEmployeeId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_employee_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new employee");
		}
	}
	
	private Employee mapRowToEmployee(SqlRowSet results) { //ALWAYS SHOULD HAVE: create an object of the class and assign
		Employee employee = new Employee();	//Define an Obj to return   // assign the results form the SQL statement
		employee = new Employee();  //Instantiate object to return (run constructor)
//		if(results.next()) {
		employee.setFirstName(results.getString("first_name"));
		employee.setLastName(results.getString("last_name"));
		employee.setBirthDay(results.getDate("birth_date").toLocalDate());
		employee.setGender(results.getString("gender").charAt(0));
		employee.setHireDate(results.getDate("hire_date").toLocalDate());
		employee.setDepartmentId(results.getLong("department_id"));
		employee.setId(results.getLong("employee_id"));
//		}
		return employee; //return the object
	}

}
