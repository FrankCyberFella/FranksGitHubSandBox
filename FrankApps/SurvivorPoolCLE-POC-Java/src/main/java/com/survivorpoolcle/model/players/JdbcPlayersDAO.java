package com.survivorpoolcle.model.players;

	import java.util.ArrayList;
	import java.util.List;

	import javax.sql.DataSource;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.jdbc.support.rowset.SqlRowSet;



	public class JdbcPlayersDAO implements PlayersDAO {

		private JdbcTemplate jdbcTemplate;

	    @Autowired
	    
	    public JdbcPlayersDAO(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	    
	    public List<Players> allPlayers = new ArrayList<Players>(); {
	    	
	    }
	}
	    

	
