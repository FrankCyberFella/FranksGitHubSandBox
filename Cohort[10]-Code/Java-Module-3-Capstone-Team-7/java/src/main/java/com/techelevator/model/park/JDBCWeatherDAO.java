package com.techelevator.model.park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCWeatherDAO implements WeatherDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCWeatherDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Weather> getAllWeather(String parkCode) {
		List<Weather> allWeatherList = new ArrayList<Weather>();
		String sqlGetAllWeather = "SELECT * FROM weather WHERE parkCode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllWeather, parkCode);
		while(results.next()) {
			allWeatherList.add(mapRowToWeather(results));
		}
		return allWeatherList;
		
	}
	
	private Weather mapRowToWeather(SqlRowSet results) {
		Weather w = new Weather();
		w.setParkCode(results.getString("parkcode"));
		w.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		w.setLowF(results.getInt("low"));
		w.setHighF(results.getInt("high"));
		w.setLowC(results.getInt("low"));
		w.setHighC(results.getInt("high"));
		w.setForecast(results.getString("forecast").replaceAll(" ", ""));
		return w;
	}
}
