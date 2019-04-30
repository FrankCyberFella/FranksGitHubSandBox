package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		
		ArrayList<Department> allDepartments = new ArrayList <Department>();
		String sqlTheDepartments = "SELECT * FROM department";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlTheDepartments);
		while(results.next()) {
			Department aDepartment = mapRowToDepartment(results);
			allDepartments.add(aDepartment);
		}
		return allDepartments;
		
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		
		List<Department> allDepartments = new ArrayList <Department>();
		String sqlTheDepartments = "SELECT * " +
								"FROM department " +
								"WHERE name = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlTheDepartments, nameSearch);
		while(results.next()) {
			Department aDepartment = mapRowToDepartment(results);
			allDepartments.add(aDepartment);
		}
		return allDepartments;
		
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String updater = "UPDATE department " +
				   		   "SET name = ? " +
				           "WHERE department_id = ? ";
		jdbcTemplate.update(updater, updatedDepartment.getName(), updatedDepartment.getId());
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlInsertCity = "INSERT INTO department(department_id, name) " +
				   "VALUES (?, ?)";
	   newDepartment.setId(getNextDepartmentId());
	   jdbcTemplate.update(sqlInsertCity, newDepartment.getId(),            
				  	 					newDepartment.getName());
	   return newDepartment;
	}

	@Override
	public Department getDepartmentById(Long id) {
		Department theDepartment = null;
		String sqlFindDepartmentById = "SELECT department_id, name " +
							   		   "FROM department "+
							   		   "WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindDepartmentById, id);
		if(results.next()) {                  
			theDepartment = mapRowToDepartment(results);
		}
		return theDepartment;
	}
	
	private Department mapRowToDepartment(SqlRowSet results) {
		Department theDepartment = new Department();
		theDepartment.setName(results.getString("name"));
		theDepartment.setId(results.getLong("department_id"));
		return theDepartment;
	}
	private long getNextDepartmentId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department.");
		}
	}
}
