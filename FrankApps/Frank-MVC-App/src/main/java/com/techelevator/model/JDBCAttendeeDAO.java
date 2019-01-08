package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCAttendeeDAO implements AttendeeDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCAttendeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void createAttendee(String email, String firstName, String lastName, int cookoutId) {
		String sqlAddAttendee = "INSERT INTO attendee(email_address, a_first_name, a_last_name)" +
								" VALUES (?, ?, ?) RETURNING attendee_id";
		long id = jdbcTemplate.queryForObject(sqlAddAttendee, Long.class, email, firstName, lastName);
			
		int attendeeId = (int)id;
		
		String sqlAddCookoutAttendee = "INSERT INTO cookout_attendee(cookout_id, attendee_id)" +
											" VALUES (?, ?)";
		jdbcTemplate.update(sqlAddCookoutAttendee, cookoutId, attendeeId);
//		String sqlDeleteCookoutAttendee = "DELETE FROM cookout_attendee WHERE email_address = null"
		}
		
	
	public List<Attendee> displayAttendees(int cookoutId) {
		List<Attendee> attendees = new ArrayList<>();
		String sqlShowAttendees = "SELECT a_first_name, a_last_name, email_address FROM attendee" +
									" JOIN cookout_attendee" +
									" ON cookout_attendee.attendee_id = attendee.attendee_id" +
									" WHERE cookout_attendee.cookout_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlShowAttendees, cookoutId);
			while(results.next()) {
				attendees.add(mapRowToAttendee(results));
			}
			return attendees;
	}

	
	private Attendee mapRowToAttendee(SqlRowSet results) {
		Attendee attendee = new Attendee();
		attendee.setFirstName(results.getString("a_first_name"));
		attendee.setLastName(results.getString("a_last_name"));
		attendee.setEmail(results.getString("email_address"));
		return attendee;
	}

}
