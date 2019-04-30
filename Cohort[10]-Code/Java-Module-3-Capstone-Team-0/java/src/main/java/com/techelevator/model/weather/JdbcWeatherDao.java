package com.techelevator.model.weather;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWeatherDao implements WeatherDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcWeatherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Weather> getWeatherByParkCode(String parkCode) {
		List<Weather> weathers = new ArrayList<Weather>();
		String sqlWeathersByCode = "SELECT * FROM weather WHERE parkcode = ? ORDER BY fivedayforecastvalue";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlWeathersByCode, parkCode);
		
		while(results.next()) {
			weathers.add(mapRowToWeather(results));
		}
		
		return weathers;
	}
	
	public Weather mapRowToWeather(SqlRowSet results) {
		Weather theWeather = new Weather();
		theWeather.setParkCode(results.getString("parkcode"));
		theWeather.setFivedayForecastValue(results.getInt("fivedayforecastvalue"));
		theWeather.setLow(results.getInt("low"));
		theWeather.setHigh(results.getInt("high"));
		theWeather.setForecast(results.getString("forecast").replaceAll("partly cloudy", "partlyCloudy"));
		return theWeather;
	}

}
