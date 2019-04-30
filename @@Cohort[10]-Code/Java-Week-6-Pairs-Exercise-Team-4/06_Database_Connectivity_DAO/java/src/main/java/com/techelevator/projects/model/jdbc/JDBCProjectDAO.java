package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		
		ArrayList<Project> allActiveProjects = new ArrayList <Project>();
		String sqlTheProjects = "SELECT * FROM project WHERE to_date IS NULL";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlTheProjects);
		while(results.next()) {
			Project aProject = mapRowToProject(results);
			allActiveProjects.add(aProject);
		}
		return allActiveProjects;
		
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String updater = "UPDATE project_employee " +
		   		   "SET project_id IS NULL " +
		           "WHERE project_id = ? AND employee_id = ? ";
		jdbcTemplate.update(updater, projectId, employeeId);
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		
		String sqlInsertEmployeeIntoProject = "INSERT INTO project_employee (project_id, employee_id) " +
				   "VALUES (?, ?)";
		jdbcTemplate.update(sqlInsertEmployeeIntoProject, projectId, employeeId);
	 
	}
	
	private Project mapRowToProject(SqlRowSet results) {
		Project aProject = new Project();
		aProject.setId(results.getLong("project_id"));
		aProject.setName(results.getString("name"));
//		aProject.setStartDate(results.getDate("from_date").toLocalDate());
//		aProject.setEndDate(results.getDate("to_date").toLocalDate());
		return aProject;
	}
}
