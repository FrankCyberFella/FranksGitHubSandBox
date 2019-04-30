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
		
		List<Project> newActiveProjectList = new ArrayList<Project>();
		
		String getAllActiveProjectsStr = "SELECT * FROM Project WHERE (CURRENT_DATE BETWEEN from_date AND to_date)";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(getAllActiveProjectsStr);

		while (results.next()) {
			Project newProject = mapRowToProject(results);
			
			newActiveProjectList.add(newProject);
		}
		
		return newActiveProjectList;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		
		String removeEmployeeFromProject = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";
		
		jdbcTemplate.update(removeEmployeeFromProject, projectId, employeeId);
		
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		
		String addEmployeeToProjectStr = "INSERT INTO project_employee (project_id, employee_id) VALUES (?, ?) ";
				
		
		jdbcTemplate.update(addEmployeeToProjectStr, projectId, employeeId);
	
	}
	
public Project mapRowToProject(SqlRowSet results) {
		
		Project mappedProject = new Project();
		
		mappedProject.setId(results.getLong("project_id"));
		mappedProject.setName(results.getString("name"));
		mappedProject.setStartDate(results.getDate("from_date").toLocalDate());
		mappedProject.setEndDate(results.getDate("to_date").toLocalDate());

		return mappedProject;
	}

}
