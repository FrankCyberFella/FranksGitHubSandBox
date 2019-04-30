package com.techelevator.projects.model.jdbc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;
	

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		ArrayList<Project> projectList = new ArrayList<>();
		String sqlDisplayProjects = "SELECT * " + "FROM project";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplayProjects);
		while(results.next()) {
			Project projects = mapRowToProject(results);
			projectList.add(projects);
			
	}
		return projectList;
	}
	
	

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String theUpdate = "DELETE project_employee"
						   + "SET project_employee.project_id = ? " 
						   + "WHERE project_employee.employee_id = ? ";
		jdbcTemplate.update(theUpdate, projectId, employeeId);
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String theUpdate = "UPDATE project_employee " 
					       + "SET project_id = ? " 
					       + "WHERE employee_id = ? ";
		jdbcTemplate.update(theUpdate, projectId, employeeId);
	}
	
	private Project mapRowToProject(SqlRowSet results) throws NullPointerException{
		Project projects;
		projects = new Project();
		projects.setId(results.getLong("project_id"));
		projects.setName(results.getString("name"));
		//projects.setStartDate(results.getDate("from_date").toLocalDate());
	  	//projects.setEndDate(results.getDate("to_date").toLocalDate());
		return projects;
	}

}
