package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		ArrayList<Project> projects = new ArrayList<>();
		String sqlGetAllActiveProjects = "SELECT project_id,name,from_date,COALESCE(to_date,'2099/12/31') AS to_date "+
								         "FROM Project "+
								         "WHERE from_date IS NOT NULL "+
								         "AND from_date<current_date "+
								         "AND (to_date>current_date OR to_date IS NULL)";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllActiveProjects);
		while(results.next()){
			Project theProject = mapRowToProject(results);
			projects.add(theProject);
		}
		return projects;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sqlRemoveEmployeeFromProject = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";
		jdbcTemplate.update(sqlRemoveEmployeeFromProject,projectId,employeeId);
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sqlAddEmployeeToProject = "INSERT INTO project_employee (project_id,employee_id) VALUES (?,?)";
		jdbcTemplate.update(sqlAddEmployeeToProject,projectId,employeeId);
	}

	private Project mapRowToProject(SqlRowSet results) {
		Project theProject = new Project();
		theProject.setId(results.getLong("project_id"));
		theProject.setName(results.getString("name"));
		theProject.setStartDate(results.getDate("from_date").toLocalDate());
		theProject.setEndDate(results.getDate("to_date").toLocalDate());
		//Date now = new Date();	
		//if(now.getTime()>results.getDate("to_date").getTime()) {
		return theProject;
	}
}
