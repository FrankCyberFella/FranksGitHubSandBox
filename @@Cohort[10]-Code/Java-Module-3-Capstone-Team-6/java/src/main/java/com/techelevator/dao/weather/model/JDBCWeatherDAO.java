package com.techelevator.dao.weather.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JDBCWeatherDAO implements WeatherDao {

private JdbcTemplate jdbcTemplate;	
	
@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	
}
	@Override
	public List<Weather> getTodayWeather(String code) {
		List<Weather> allWeather = new ArrayList<Weather>();
		String sqlGetWeather = "SELECT * FROM weather Where parkcode = ? and fivedayforecastvalue = 1";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetWeather, code);
		while (results.next()) {
			allWeather.add(mapRowToWeather(results));
		}
		return allWeather;
	}
	
	@Override
	public List<Weather> getFourWeather(String code) {
		List<Weather> allWeather = new ArrayList<Weather>();
		String sqlGetWeather = "SELECT * FROM weather Where parkcode = ? and fivedayforecastvalue != 1";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetWeather, code);
		while (results.next()) {
			allWeather.add(mapRowToWeather(results));
		}
		return allWeather;
	}
	
	private Weather mapRowToWeather(SqlRowSet results) {
		Weather w = new Weather();
		w.setParkCode(results.getString("parkcode"));
		w.setFiveDayValue(results.getInt("fivedayforecastvalue"));
		w.setLow(results.getInt("low"));
		w.setHigh(results.getInt("high"));
		w.setForecast(results.getString("forecast"));
		w.setLowCel(results.getInt("low"));
		w.setHighCel(results.getInt("high"));
		
		return w;
	}

}
