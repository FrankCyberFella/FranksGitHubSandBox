package com.techelevator.projects.model.jdbc;
	import com.techelevator.projects.model.Department;
	import com.techelevator.projects.model.Employee;
	import com.techelevator.projects.model.Project;
	
	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertNotEquals;
	import static org.junit.Assert.assertNotNull;

	import java.sql.SQLException;
	import java.time.LocalDate;
	import java.util.List;

	import org.apache.commons.dbcp2.BasicDataSource;
	import org.junit.After;
	import org.junit.AfterClass;
	import org.junit.Assert;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.jdbc.datasource.SingleConnectionDataSource;
	
	public class JDBCProjectDAOIntegrationTest {
		private static SingleConnectionDataSource dataSource;
		private JDBCEmployeeDAO daoEmp;
		private JDBCProjectDAO daoPro;
		private static final Long TEST_ID = (long)999; 


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
		public void set() {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			daoEmp = new JDBCEmployeeDAO(dataSource);
			daoPro = new JDBCProjectDAO(dataSource);
		}
		
		
		@After
		public void rollback() throws SQLException {
			dataSource.getConnection().rollback();
		}

		
		//WHAT ARE WE TESTING?
		//EMPLOYEE:
		//GET EMPLOYEES WITHOUT PROJECT getEmployeesWithoutProjects()
		//GET EMPLOYEES BY PROJECT ID getEmployeesByProjectId(Long projectId)
		//PROJECT:
		//get all active projects?
		//removeEmployeeFromProject(Long projectId, Long employeeId)
		//addEmployeeToProject(Long projectId, Long employeeId)
		
		
		
		@Test //For this test let's FIND ONE EMPLOYEE WHO DOESN'T HAVE A PROJECT, THE FIRST ACTIVE PROJECT, 
				//THE NUMBER OF PEOPLE ON THE PROJECT, ADD AN EMPLOYEE TO THE PROJECT, AND THEN THE NEW NUMBER OF PEOPLE ON THE PROJECT 
		public void add_employee_to_project() {
			//get an employee who doesn't have a project by calling employees without projects and taking the first one in the list
			Employee theEmployee = daoEmp.getEmployeesWithoutProjects().get(0);
			
			//get an active project by calling all active projects and taking the first one in the list
			Project firstActive = daoPro.getAllActiveProjects().get(0);
			//find the number of employees assigned to the first active project by calling get employees by project id and getting the size of it
			int numOnProjStart = daoEmp.getEmployeesByProjectId(firstActive.getId()).size();
			//find the number of employees with no project at all
			int numIdleEmployees = daoEmp.getEmployeesWithoutProjects().size();
			
			
			//move our first idle employee ONTO the first active project
			daoPro.addEmployeeToProject(firstActive.getId(), theEmployee.getId());
			int numOnProjFinish = daoEmp.getEmployeesByProjectId(firstActive.getId()).size();
			int newNumIdleEmployees = daoEmp.getEmployeesWithoutProjects().size();
			assertEquals(numOnProjStart+1,numOnProjFinish);
			assertEquals(numIdleEmployees-1,newNumIdleEmployees);
		
		}
		
		@Test
		public void remove_employee_from_project() {

			//get an active project by calling all active projects and taking the first one in the list
			Project firstActive = daoPro.getAllActiveProjects().get(0);
			//find the number of employees assigned to the first active project by calling get employees by project id and getting the size of it
			int numOnProjStart = daoEmp.getEmployeesByProjectId(firstActive.getId()).size();
			//get one of the employees on the project (BE AWARE IT MAY BE NULL)
			Employee theEmployee = daoEmp.getEmployeesByProjectId(firstActive.getId()).get(0);
			
			//removing our first employee who IS on the project FROM the project
			daoPro.removeEmployeeFromProject(firstActive.getId(), theEmployee.getId());
			int numOnProjFinish = daoEmp.getEmployeesByProjectId(firstActive.getId()).size();
			assertEquals(numOnProjStart-1,numOnProjFinish);

		}
	
	
}
