package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate JdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.JdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		Department theDept = null;
		List<Department> deptList = new ArrayList<Department>();

		
		String sqlFindDepartmentById = "SELECT * " +
										"FROM department; ";
		SqlRowSet results = JdbcTemplate.queryForRowSet(sqlFindDepartmentById);
		//System.out.println("Help me");
		while (results.next()) {
			
				theDept = mapRowToDept(results);
				//theDept.toString();
				deptList.add(theDept);
			
		}
		return deptList;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		Department theDept = null;
		List<Department> deptList = new ArrayList<Department>();
		
		String sqlFindDepartmentByName = "SELECT * " +
										"FROM department " +
										"WHERE name = ?";
		
		SqlRowSet results = JdbcTemplate.queryForRowSet(sqlFindDepartmentByName, nameSearch);
		
		while(results.next()) {
			
			theDept = mapRowToDept(results);
			deptList.add(theDept);
		}
		
		
		return deptList;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String SqlDeptUpdate = "UPDATE department " +
								"SET name = ? " +
								"WHERE department_id = ?";
		JdbcTemplate.update(SqlDeptUpdate, updatedDepartment.getName(),
												updatedDepartment.getId());
								
		
		
	}

	@Override
	public Department createDepartment(Department newDepartment) { // *****************************************
		String dept = "insert into department(department_id, name) " +
						"Values(?, ?); ";
		newDepartment.setId(getNextDepartmentId());
		JdbcTemplate.update(dept, newDepartment.getId(),
										newDepartment.getName());
		
		
	return newDepartment;
		
	}

	@Override
	public Department getDepartmentById(Long id) {
		return null;
	}
	
	private Department mapRowToDept(SqlRowSet results) {
		Department theDept = new Department(); 
		theDept.setId(results.getLong("department_Id"));
		theDept.setName(results.getString("name"));
		return theDept;
	}
	
	private long getNextDepartmentId() {
		SqlRowSet nextIdResult = JdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		}
		else {
			throw new RuntimeException("This stupid thing doesn't work");
		}
	}

}
