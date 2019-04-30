package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

//import com.techelevator.city.City;
import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		ArrayList<Department> departmentList = new ArrayList<>();
		String sqlFindAllDepartments = "SELECT * "+
									   "FROM department ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllDepartments);
		while(results.next()) {
			Department departmentName = mapRowToDepartment(results);
			departmentList.add(departmentName);
		}
		return departmentList;
	}
	


	

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		ArrayList<Department> searchDepartmentList = new ArrayList<>();
		String sqlFindAllDepartments = "SELECT * "+
				   "FROM department " +
				   "WHERE name = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllDepartments, nameSearch);
		while(results.next()) {
			Department departmentNameSearch = mapRowToDepartment(results);
			searchDepartmentList.add(departmentNameSearch);
		}
		return searchDepartmentList;
	}
		

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlUpdateDept = "UPDATE department "+
							"Set name = ? " +
							"WHERE department_id =  ? ";
		
		jdbcTemplate.update(sqlUpdateDept, updatedDepartment.getName(), updatedDepartment.getId());
		
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlInsertDept = "INSERT INTO department(department_id, name)" +
							   " Values(?,?) ";
		if(newDepartment.getId() == null ) {
			newDepartment.setId(getNextDeptId());
		}
		jdbcTemplate.update(sqlInsertDept, newDepartment.getId(), newDepartment.getName());
		
		return newDepartment;
	}
	
	private long getNextDeptId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		}
	}

	
	@Override
	public Department getDepartmentById(Long id) {
		Department department = new Department();
		String sqlFindDepartments = "SELECT * "+
									"FROM department " +
									"WHERE department_id = ? ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindDepartments, id);
		if(results.next()  ) {
			department = mapRowToDepartment(results);
		}
		return department;
	}
	
	
	


	
	
	private Department mapRowToDepartment(SqlRowSet results) { //ALWAYS SHOULD HAVE: create an object of the class and assign
		Department department;	//Define an Obj to return   // assign the results form the SQL statement
		department = new Department();  //Instantiate object to return (run constructor)
		
		department.setName(results.getString("name")); //get name from the result and assign to object
		department.setId(results.getLong("department_id"));
		return department; //return the object
	}
	
	
}

