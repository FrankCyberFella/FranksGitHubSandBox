package com.survivorpoolcle.model.castmembers;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;



public class JdbcCastMemberDAO implements CastMemberDAO {

	private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCastMemberDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	
public List<CastMember> getAllCastMembers() {
	List<CastMember> allCastMembers = new ArrayList<CastMember>();
	 String sql = "SELECT * FROM castmembers";
     SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

     while(results.next()) {
         CastMember aCastMember = mapRowToCastMember(results);
         allCastMembers.add(aCastMember);
     }
   
	return allCastMembers;
	
}
private CastMember mapRowToCastMember(SqlRowSet SqlResults) {
	CastMember aCastMember = new CastMember();
	return aCastMember;
}
}
