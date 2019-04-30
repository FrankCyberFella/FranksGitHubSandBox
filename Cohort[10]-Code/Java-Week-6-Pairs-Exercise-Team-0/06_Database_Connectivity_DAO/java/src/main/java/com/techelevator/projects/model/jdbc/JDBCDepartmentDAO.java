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
		ArrayList<Department> departments = new ArrayList<>();
		String sqlGetAllDepartments = "SELECT * "+
										"FROM Department";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllDepartments);
		while(results.next()) {
			Department theDepartment = mapRowToDepartment(results);
			departments.add(theDepartment);
		}
		return departments;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		ArrayList<Department> departmentList = new ArrayList<>();
		String sqlSearchDepartmentName = "SELECT * " +
										"FROM DEPARTMENT " +
										 "WHERE name iLIKE '%'||?||'%' "; 
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchDepartmentName,nameSearch );
		while(results.next()) {
			Department theDepartment = mapRowToDepartment(results);
			departmentList.add(theDepartment);
		}
		return departmentList;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlUpdateDepartment = "UPDATE department " +
									 "SET name = ? " +
									"WHERE department_id = ? ";
		jdbcTemplate.update(sqlUpdateDepartment, updatedDepartment.getName(),
												 updatedDepartment.getId());
														
	}

	@Override
	public Department createDepartment(Department newDepartment) { 
		String sqlInsertDepartment = "INSERT INTO department(department_id, name) " + "VALUES(?, ?)";
		newDepartment.setId(getNextDepartmentId());
		jdbcTemplate.update(sqlInsertDepartment, newDepartment.getId(), newDepartment.getName());
		return newDepartment;
	}

	@Override
	public Department getDepartmentById(Long id) {
		Department theDepartment = null;
		String sqlSearchDepartmentName = "SELECT * " +
										"FROM DEPARTMENT " +
										 "WHERE department_id = ? "; 
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchDepartmentName,id );
		if(results.next()) {
			theDepartment = mapRowToDepartment(results);
		}
		return theDepartment;
	}
	private Department mapRowToDepartment(SqlRowSet results) {
		Department theDepartment = new Department();
		theDepartment.setId(results.getLong("department_id"));
		theDepartment.setName(results.getString("name"));
		return theDepartment;
	}

	private Long getNextDepartmentId() {
		SqlRowSet getNextDepartmentId = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')"); 
		if (getNextDepartmentId.next()) {
			return getNextDepartmentId.getLong(1);
		} else {
			throw new RuntimeException("someting went wrong while getting the Department ID");
		}
	}
}
