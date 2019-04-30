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
	public Department department = new Department();

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		ArrayList<Department> departmentList = new ArrayList<>();
		String sqlDisplayDepts = "SELECT * " + "FROM department ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplayDepts);
		while (results.next()) {
			Department departments = mapRowToDepartment(results);
			departmentList.add(departments);
		}
		return departmentList;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		Department departments = null;
		ArrayList<Department> departmentList = new ArrayList<>();
		String sqlDisplayDepts = "SELECT * " + "FROM department " + "WHERE name = ?"; // account for Like
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplayDepts, nameSearch);
		if (results.next()) {
			departments = mapRowToDepartment(results);
			departmentList.add(departments);
		}
		return departmentList;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String theUpdate = "Update department " + "SET name = ? " + "WHERE department_id = ? ";
		jdbcTemplate.update(theUpdate, updatedDepartment.getName(), updatedDepartment.getId());
	}


	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlInsertDepartment = "INSERT INTO department(department_id, name) " + "VALUES(?, ?)"; // changed id to
		// department_id
		if(newDepartment.getId() == null) {
			newDepartment.setId(getNextDepartmentId());
				jdbcTemplate.update(sqlInsertDepartment, newDepartment.getId(), newDepartment.getName());
		} else if (newDepartment.getId() != null) {
				jdbcTemplate.update(sqlInsertDepartment, newDepartment.getId(), newDepartment.getName());

		}

		return newDepartment;

	}

	@Override
	public Department getDepartmentById(Long id) {
		String sqlDisplayDepts = "SELECT * " + "FROM department " + "WHERE department_id = ?"; // account for Like
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplayDepts, id);
		results.next(); 
		Department departments = mapRowToDepartment(results);
		return departments;
	}

	private long getNextDepartmentId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("Select nextval('seq_department_id')");
		if (nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an ID for the new department");
		}

	}
	
	

	private Department mapRowToDepartment(SqlRowSet results) {
		Department departments;
		departments = new Department();
		departments.setId(results.getLong("department_id"));
		departments.setName(results.getString("name"));
		return departments;
	}
}
