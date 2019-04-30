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
		List<Project> activeProjects = new ArrayList<Project>();
		String something = "SELECT * " + " FROM project " +  " WHERE (current_date BETWEEN from_date AND to_date)";
		SqlRowSet results = jdbcTemplate.queryForRowSet(something);
		
		while(results.next()) {
			Project activeProject = mapRowToProject(results);
			activeProjects.add(activeProject);
			
		}
		return activeProjects;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String someguy = " DELETE FROM project_employee " + " WHERE employee_id = ? ";
		jdbcTemplate.update(someguy,employeeId);
				
		
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		
	}

	private Project mapRowToProject(SqlRowSet results) {
		Project theProject;
		theProject = new Project();
		theProject.setId(results.getLong("project_id"));
		theProject.setName(results.getString("name"));
		theProject.setStartDate(results.getDate("from_date").toLocalDate());
		theProject.setEndDate(results.getDate("to_date").toLocalDate());
		return theProject;
	}

}
