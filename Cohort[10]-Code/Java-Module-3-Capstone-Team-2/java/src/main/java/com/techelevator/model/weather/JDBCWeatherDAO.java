package com.techelevator.model.weather;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component 
public class JDBCWeatherDAO implements WeatherDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
		public JDBCWeatherDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
		public List<Weather> getAllWeatherForecasts() {
		List<Weather> weatherList = new ArrayList<>();
		String sqlGetAllWeather = "SELECT parkCode, "
								+ "fiveDayForecastValue, "
								+ "low, "
								+ "high, "
								+ "forecast "
								+ "FROM weather "
								+ "ORDER BY parkCode ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllWeather);
		while(results.next()) {
			weatherList.add(mapRowToWeather(results));
		}
	return weatherList;
	}
	
	@Override
	public List<Weather> getForecastByCode(String parkCode){
		List<Weather> weatherList = new ArrayList<>();
		String sqlGetAllWeather = "SELECT parkCode, "
								+ "fiveDayForecastValue, "
								+ "low, "
								+ "high, "
								+ "forecast "
								+ "FROM weather "
								+ "WHERE parkCode = ?"
								+ "ORDER BY parkCode, fiveDayForecastValue ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllWeather, parkCode);
		while(results.next()) {
			weatherList.add(mapRowToWeather(results));
		}
		return weatherList;
		}
		
		
	
	
	private Weather mapRowToWeather(SqlRowSet results) {
		Weather w = new Weather();
		w.setParkcode(results.getString("parkCode"));
		w.setFiveDayForecastValue(results.getInt("fiveDayForecastValue"));
		w.setLow(results.getInt("low"));
		w.setHigh(results.getInt("high"));
		w.setForecast(results.getString("forecast").replaceAll(" ", ""));
		
		double lowDouble = (results.getInt("low"));
		double lowCDouble = ((lowDouble-32)*(5.0/9));
		w.setLowCelcius((int)Math.round(lowCDouble));
		
//		int cLow = (int)Math.round(((results.getInt("low") - 32) * (5/9)));
//		w.setLowCelcius(results.getInt(cLow));
		
		double highDouble = (results.getInt("high"));
		double highCDouble = ((highDouble-32)*(5.0/9));
		w.setHighCelcius((int)Math.round(highCDouble));
//		
//		int cHigh =  (int)Math.round(((results.getInt("high") - 32) * (5/9)));
//		w.setHighCelcius(results.getInt(cHigh));
		return w;
	}
}
