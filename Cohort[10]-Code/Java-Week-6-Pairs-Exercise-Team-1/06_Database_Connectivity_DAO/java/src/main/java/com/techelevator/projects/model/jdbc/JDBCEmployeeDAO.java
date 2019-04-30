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
		List<Employee> empList = new ArrayList<Employee>();
		
		Employee theEmp = null;
		String sqlGetAllEmployees = "Select employee_id, department_id, first_name, last_name " +
									"From employee ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllEmployees);
		
		while (results.next()) {
			
			theEmp = mapRowToEmp(results);
			empList.add(theEmp);
			
		}
		return empList;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		Employee employeeName = null;
		List<Employee> empList = new ArrayList<Employee>();
		
		String sqlEmployeeName = "Select employee_id, department_id, first_name, last_name " +
								"From employee " +
								"Where first_name = ? " +
								"AND last_name = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlEmployeeName, firstNameSearch, lastNameSearch);
		
		while(results.next()) {
			
			employeeName = mapRowToEmp(results);
			empList.add(employeeName);
		}
		return empList;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		Employee theEmployee = null;
		List<Employee> empList = new ArrayList<Employee>();		
		
		String sqlFindEmployeeById = "Select * " +
									 "From Employee " +
									 "Join department " +
									 "On employee.department_id = department.department_id " +
									 "Where department.department_id = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindEmployeeById, id);
		
		while(results.next()) {
			
			theEmployee = mapRowToEmp(results);
			empList.add(theEmployee);
		}
		
		
		
		
		return empList;
	}
//	Department theDept = null;
//	List<Department> deptList = new ArrayList<Department>();
//	
//	String sqlFindDepartmentByName = "SELECT * " +
//									"FROM department " +
//									"WHERE name = ?";
//	
//	SqlRowSet results = JdbcTemplate.queryForRowSet(sqlFindDepartmentByName, nameSearch);
//	
//	while(results.next()) {
//		
//		theDept = mapRowToDept(results);
//		deptList.add(theDept);
//	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		return new ArrayList<>();
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		return new ArrayList<>();
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		
	}
	private Employee mapRowToEmp(SqlRowSet results) {
		Employee theEmp = new Employee(); 
		theEmp.setId(results.getLong("employee_Id"));
		theEmp.setDepartmentId(results.getLong("department_id"));
		theEmp.setFirstName(results.getString("first_name"));
		theEmp.setLastName(results.getString("last_name"));
		//theEmp.setBirthDay(results.getDate("birth_date"));
		//****BIG ASS TURISKS!!****
		//theEmp.setGender(results.("gender"));
		//theEmp.setHireDate(results.getDate("hire_date"));
		return theEmp;
	}
}
