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
		ArrayList<Employee>employees= new ArrayList<>();
			String sqlGetEmployees =  "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " + 
									  "FROM employee ";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployees);
			while(results.next()) {
				Employee employee = mapRowToEmployee(results);
				employees.add(employee);
			}
			return employees;
		}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		ArrayList<Employee>employees = new ArrayList<>();
		String sqlFindEmployee =    "Select * " +
									"From employee " +
									"Where first_name  = ? " +
									"and last_name = ? ";
									
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindEmployee, firstNameSearch, lastNameSearch);
		while(results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		ArrayList<Employee>employees = new ArrayList<>();
		String sqlFindEmployeeByDepartment = "Select * " +
											 "From employee " +
											 "Where department_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindEmployeeByDepartment, id);
		while(results.next()){
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
		
		
	
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		ArrayList <Employee> employees = new ArrayList<Employee>();
		String getEmployeesWithoutProject = "SELECT * " +
											"FROM employee " +
											"full outer join project_employee on employee.employee_id = project_employee.employee_id " +
											"Where project_employee.employee_id is null" ;
		SqlRowSet results = jdbcTemplate.queryForRowSet(getEmployeesWithoutProject);
		while(results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		ArrayList <Employee> employees = new ArrayList<Employee>();
		String getEmployeesByProjectId = "SELECT * " +
									     "FROM employee " +
									     "inner join " +
									     "project_employee " +
									     "on employee.employee_id = project_employee.employee_id "+	
									     "WHERE project_employee.employee_id = ? " ;
		SqlRowSet results = jdbcTemplate.queryForRowSet(getEmployeesByProjectId, projectId);
		while(results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}
	

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String theUpdate = "UPDATE employee " +       
				"SET  department_id =  ? " +
				"WHERE employee_id  = ? " ;
				//System.out.println(newDepartment.getName());
				//System.out.println(newDepartment.getId());

				jdbcTemplate.update(theUpdate,
						departmentId.longValue(),
						employeeId.longValue());
	}
	

	public Employee mapRowToEmployee(SqlRowSet results) {
		Employee employee = new Employee();
		
		employee.setId(results.getLong("employee_id"));
		employee.setDepartmentId(results.getLong("department_id"));
		employee.setFirstName(results.getString("first_name"));
		employee.setLastName(results.getString("last_name"));
		employee.setBirthDay(results.getDate("birth_date").toLocalDate());
		employee.setGender(results.getString("gender").charAt(0));
		employee.setHireDate(results.getDate("hire_date").toLocalDate());
		return employee;
	}

}
