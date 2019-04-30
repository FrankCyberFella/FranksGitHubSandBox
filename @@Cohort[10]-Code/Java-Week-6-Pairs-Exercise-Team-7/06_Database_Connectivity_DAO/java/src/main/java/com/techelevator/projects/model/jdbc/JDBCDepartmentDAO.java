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
		List<Department> departments = new ArrayList<Department>();
		String sqlGetAllDepartments = "SELECT * "+
										   "FROM  department"; 
										   
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllDepartments);
		while(results.next()) {
			Department theDepartment = mapRowToDepartment(results);
			departments.add(theDepartment);
		}
		
		return departments;
	}
	
	private Department mapRowToDepartment(SqlRowSet results) {
		Department theDepartment;
		theDepartment = new Department();
		theDepartment.setId(results.getLong("department_id"));
		theDepartment.setName(results.getString("name"));
		return theDepartment;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		List<Department> departments = new ArrayList<Department>();
		String sqlSearchDepartments = " SELECT * " + " FROM department" + " WHERE name LIKE ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchDepartments, "%" + nameSearch + "%");
		while(results.next()) {
			Department theDepartment = mapRowToDepartment(results);
			departments.add(theDepartment);
		
	}return  departments;
	}
	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlSaveDepartments = " UPDATE department " + " SET name = ? " + " WHERE department_id = ?";
		jdbcTemplate.update(sqlSaveDepartments, updatedDepartment.getName(), updatedDepartment.getId());
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlCreateDepartment = "INSERT INTO department(name, department_id)  " +
									 " VALUES(?, ?) ";
		jdbcTemplate.update(sqlCreateDepartment, newDepartment.getName(), newDepartment.getId());
		return newDepartment;
	}

	@Override
	public Department getDepartmentById(long i) {
		Department foundDepartment = new Department();
		String sqlDepartmentById = "SELECT * " + "FROM department " + " WHERE department_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDepartmentById, i);
		if(results.next()) {
		 foundDepartment = mapRowToDepartment(results);
		}
		return foundDepartment;
	}

}
