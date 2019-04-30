package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

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
		ArrayList <Project> getProjects = new ArrayList<Project>();
		String sqlGetProjects = "SELECT * " + 
				"FROM project " + 
				"WHERE to_date IS NULL";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetProjects);
		while(results.next()){
			Project project = mapRowToProject(results);
			getProjects.add(project);
		}
		return getProjects;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		
	}
//********************************************************************************//
//					Needs attention												  //	
//********************************************************************************//
	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String theUpdate = "UPDATE project " +       
				"SET  department_id =  ? " +
				"WHERE employee_id  = ? " ;
				//System.out.println(newDepartment.getName());
				//System.out.println(newDepartment.getId());

				jdbcTemplate.update(theUpdate,
						projectId.longValue(),
						employeeId.longValue());
	}
	
	public Project mapRowToProject(SqlRowSet results) {
		Project project = new Project();
		project.setId(results.getLong("project_id"));
		project.setName(results.getString("name"));
		//project.setStartDate(results.getDate("from_date").toLocalDate());
		//project.setEndDate(results.getDate("to_date").toLocalDate());
		return project;
	}

	
}
