package com.techelevator.projects.view;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.ProjectsCLI;
import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;

public class DepartmentTests {
	
	private static final Long TEST_DEPARTMENT = 15L;
	
	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO dao;
	
	
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
		String sqlDepartment = "INSERT INTO department (department_id, name) VALUES(?, 'Physical Happiness Enforcement')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlDepartment, TEST_DEPARTMENT);
		dao = new JDBCDepartmentDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	
	private Department aDepartment = new Department();

	@Test
	public void getDepartmentById() {
		Department aDepartment = getDepartment(TEST_DEPARTMENT, "Physical Happiness Enforcement");
		fail("Not yet implemented");
	}
	
	private Department getDepartment(Long department_id, String name) {
		Department theDepartment = new Department();
		theDepartment.setId(department_id);;
		theDepartment.setName(name); 
		return theDepartment;
	}


}
