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
		List<Department> newDepartmentList = new ArrayList<Department>();
		
		String getAllDepartmentsStr = "SELECT * FROM Department";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(getAllDepartmentsStr);

		while (results.next()) {
			Department newDepartment = mapRowToDepartment(results);
			
			newDepartmentList.add(newDepartment);
		}
		
		return newDepartmentList;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		List<Department> newDepartmentList = new ArrayList<Department>();
		
		String searchDepartmentsByNameStr = "SELECT * FROM Department WHERE name ILIKE '%" + nameSearch + "%'";
		SqlRowSet results = jdbcTemplate.queryForRowSet(searchDepartmentsByNameStr);
		
		while (results.next()) {
			Department newDepartment = mapRowToDepartment(results);
			
			newDepartmentList.add(newDepartment);
		}
		
		return newDepartmentList;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		
		String saveDepartmentStr = "UPDATE Department SET name = ? WHERE department_id = ?";
		
		jdbcTemplate.update(saveDepartmentStr, updatedDepartment.getName(), updatedDepartment.getId());
	
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		
		String saveDepartmentStr = "INSERT INTO Department (name) VALUES (?)";
		
		jdbcTemplate.update(saveDepartmentStr, newDepartment.getName());
		
		String searchDepartmentsByNameStr = "SELECT * FROM Department WHERE name = '" + newDepartment.getName() + "'";

		SqlRowSet results = jdbcTemplate.queryForRowSet(searchDepartmentsByNameStr);
		
		results.next();
		Department newDepartmentFromResult = mapRowToDepartment(results);
		
		return newDepartmentFromResult;
	}

	@Override
	public Department getDepartmentById(Long id) {
		
		String searchDepartmentsByIdStr = "SELECT * FROM Department WHERE department_id = ? "; // + id;
		
		//We are concatenating an integer on to a string and saving it as a string ^^
		
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(searchDepartmentsByIdStr, id);  //<---? variable reference
		
		results.next();
		Department newDepartment = mapRowToDepartment(results);
		
		return newDepartment;
	}

	public Department mapRowToDepartment(SqlRowSet results) {
		
		Department mappedDepartment = new Department();
		
		mappedDepartment.setId(results.getLong("department_id"));
		mappedDepartment.setName(results.getString("name"));
		
		return mappedDepartment;
	}
	
}
