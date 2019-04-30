package com.techelevator.projects.model.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Department;

public class JDBCDepartmentDAOTest {

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
		String sqlInsertDepartment = "INSERT INTO department (name) VALUES('Billing Department')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.batchUpdate(sqlInsertDepartment);
		dao = new JDBCDepartmentDAO(dataSource);
		
	}
	
	@After
	public void  rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test_create_department() throws SQLException{
		String newDepartmentName = "New Department";
		Department newDepartment = new Department();
		newDepartment.setName(newDepartmentName);
		dao.createDepartment(newDepartment);
		
//		Department savedDepartment = (dao.searchDepartmentsByName(newDepartment.getName()).get(0));
		Department savedDepartment = (dao.getDepartmentById(newDepartment.getId()));
		assertNotEquals(null, newDepartment.getId());
		assertDepartmentAreEqual(newDepartment, savedDepartment);
		
	}
	
	@Test
	public void test_save_department() throws SQLException {
		Department newDepartment = new Department();
		String newDepartmentName = "Sales Department";
		Long newDeptId = dao.searchDepartmentsByName("Billing Department").get(0).getId();
		
		newDepartment = getDepartment(newDepartmentName, newDeptId);
		dao.saveDepartment(newDepartment);
		
		Department savedDepartment = (dao.getDepartmentById(newDepartment.getId()));
		assertDepartmentAreEqual(newDepartment, savedDepartment);
		
	}
	
	private Department getDepartment(String name, Long id) {
		Department theDepartment = new Department();
		theDepartment.setName(name);
		theDepartment.setId(id);
		return theDepartment;
	}
	
	
	private void assertDepartmentAreEqual(Department expected, Department actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
	}
	
	
}
