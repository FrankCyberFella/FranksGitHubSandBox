package com.techelevator.projects.model.jdbc;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JDBCProjectDAOTest {
	private static SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;
	
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
		String sqlInsertEmployee = "INSERT INTO employee ( department_id, first_name, last_name, birth_date, gender, hire_date) VALUES( 1, 'Brett', 'Jensen', '1991-01-24', 'M', '2019-01-14' ) ";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.batchUpdate(sqlInsertEmployee);
		dao = new JDBCEmployeeDAO(dataSource);
		
	}
	
	@After
	public void  rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	

}
