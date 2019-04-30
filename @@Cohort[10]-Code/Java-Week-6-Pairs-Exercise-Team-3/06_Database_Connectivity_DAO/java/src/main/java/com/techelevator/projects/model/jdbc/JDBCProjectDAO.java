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
		ArrayList<Project> activeProjectList = new ArrayList<>();
		String sqlFindActiveProject = "SELECT * FROM project WHERE "
									+ "(CURRENT_DATE BETWEEN from_date AND to_date)"
									//+ "OR (CURRENT_DATE > from_date AND to_date IS NULL)"
									;
				
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindActiveProject);
		while(results.next()) {
			Project projectName = mapRowToProject(results);
			activeProjectList.add(projectName);
		}
		return activeProjectList;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sqlRemoveEmp = "DELETE FROM project_employee "+
				"WHERE employee_id =  ? " +
				"AND project_id = ? "
				;

		jdbcTemplate.update(sqlRemoveEmp, employeeId, projectId);
		
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sqlUpdateEmp = "INSERT INTO project_employee (project_id, employee_id) "+
							"VALUES( ?, ?) ";
				

		jdbcTemplate.update(sqlUpdateEmp, projectId, employeeId);
		
	}
	
	
	
	private Project mapRowToProject(SqlRowSet results) { //ALWAYS SHOULD HAVE: create an object of the class and assign
		Project project;	//Define an Obj to return   // assign the results form the SQL statement
		project = new Project();  //Instantiate object to return (run constructor)
		
		project.setId(results.getLong("project_id"));
		project.setName(results.getString("name"));
		project.setStartDate(results.getDate("from_date").toLocalDate());;
		project.setEndDate(results.getDate("to_date").toLocalDate());
		
		
		return project; //return the object
	}

}
