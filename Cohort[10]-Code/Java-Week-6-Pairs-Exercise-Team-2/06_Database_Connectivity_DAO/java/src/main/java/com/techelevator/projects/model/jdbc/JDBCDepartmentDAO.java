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
		ArrayList<Department>departments = new ArrayList<>();
		String sqlFindDepartment =  "Select *" +
									"From department; "
									;
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindDepartment);
		while(results.next()) {
			Department department = mapRowToDepartment(results);
			departments.add(department);
		}
		return departments;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		ArrayList<Department>departments = new ArrayList<>();
		String sqlFindDepartment =  "Select * " +
									"From department " +
									"Where name = ? "
									;
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindDepartment, nameSearch);
		while(results.next()) {
			Department department =mapRowToDepartment(results);
			departments.add(department);
		}
		return departments;
}

	@Override
	public void saveDepartment(Department newDepartment) {
		String theUpdate = "UPDATE department           " +
				           "SET  name             =  ?  " +
				           "WHERE department_id   =    ? " ;
		 System.out.println(newDepartment.getName());
		 System.out.println(newDepartment.getId());
		
		jdbcTemplate.update(theUpdate,
  			 newDepartment.getName(),
  			 newDepartment.getId());
	}
		
	@Override
	public Department createDepartment(Department newDepartment) {
		   String sqlInsertDepartment = "INSERT INTO department(department_id, name) " +
								   "VALUES(?, ?)";
			
			newDepartment.setId(getNextDepartmentId());
//			jdbcTemplate.update(sqlInsertDepartment, newDepartment.getId(),
//													 newDepartment.getName());
			return newDepartment;
	
	}
		 
	@Override
	public Department getDepartmentById(Long id) {
		Department department = null;
		String sqlFindDeparmentById = "SELECT *" +
									  "FROM department " +
									  "WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindDeparmentById, id);
		if(results.next()) {
			department = mapRowToDepartment(results);
		}
		return department;
	}
	
	public Department mapRowToDepartment(SqlRowSet results) {
		Department department;
		department = new Department();
		department.setName(results.getString("name"));
		department.setId(results.getLong("department_id"));
		return department;
	}
  
	   private long getNextDepartmentId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		}else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		}
	}


}
