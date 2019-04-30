package com.techelevator.projects.model.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

public class JDBCProjectDAOIntegrationTest {
	
	private static final String PROJECT_NAME = "Test Name";
	
	private static SingleConnectionDataSource dataSource;
	private JDBCProjectDAO dao;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		
		String sqlInsertIntoProject = "INSERT INTO project (name, from_date, to_date) VALUES (?, ?, ?)";
		
		LocalDate fromDate = LocalDate.of(2019, 02, 19);
		LocalDate toDate = LocalDate.of(2020, 02, 19);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertIntoProject, PROJECT_NAME, fromDate, toDate);
		
		dao = new JDBCProjectDAO(dataSource);
		
	}
	
	@After
	public void rollback() throws SQLException{
		
		dataSource.getConnection().rollback();
		
	}
	
	//Tests
	@Test
	public void test_get_all_active_projects() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Long bigIdNumber = (long) 9999;
		LocalDate fromDate = LocalDate.of(2019, 02, 19);
		LocalDate toDate = LocalDate.of(2020, 02, 19);
		
		List<Project> projectList = dao.getAllActiveProjects();
		
		assertEquals(2, projectList.size());
		
	}
	
	@Test
	public void test_add_employee_to_project() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		dao.addEmployeeToProject((long)4, (long)4);
		
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT count(*) FROM project_employee WHERE project_id = 4");
		
		results.next();
		assertEquals(3, results.getInt(1));
	
	}
	
	@Test
	public void test_remove_employee_to_project() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		dao.addEmployeeToProject((long)4, (long)4);
		
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT count(*) FROM project_employee WHERE project_id = 4");
		
		results.next();
		assertEquals(3, results.getInt(1));
		
		dao.removeEmployeeFromProject((long)4, (long)4);
		
		results = jdbcTemplate.queryForRowSet("SELECT count(*) FROM project_employee WHERE project_id = 4");

		results.next();
		assertEquals(2, results.getInt(1));
	}
	
	
	private Project getProject(Long project_id, String name, LocalDate from_date, LocalDate to_date) {
		Project theProject = new Project();
		theProject.setId(project_id);
		theProject.setName(name);
		theProject.setStartDate(from_date);
		theProject.setEndDate(to_date);
		return theProject;
	}
	
	private void assertProjectsAreEqual(Project expected, Project actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getStartDate(), actual.getStartDate());
		assertEquals(expected.getEndDate(), actual.getEndDate());
	}
	
	
	
}
