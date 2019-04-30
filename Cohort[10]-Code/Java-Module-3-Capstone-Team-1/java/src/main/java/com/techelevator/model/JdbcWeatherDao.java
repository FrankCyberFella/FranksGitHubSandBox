package com.techelevator.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component

public class JdbcWeatherDao implements WeatherDao{
	
	private JdbcTemplate jdbcTemplate;

    @Autowired
	public JdbcWeatherDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }
    

	@Override
	public List<Weather> getWeatherByCode(String parkCode) {
		Weather getWeather = new Weather();
		List<Weather> weatherList =  new ArrayList<Weather>();
		String row = "SELECT * " + 
				"FROM weather " + 
				"WHERE parkcode = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(row, parkCode);
		while(results.next()) {
			getWeather = mapRowToWeather(results);
			weatherList.add(getWeather);
		}
		return weatherList;
	}
	
	private Weather mapRowToWeather(SqlRowSet results) {
		Weather theWeather = new Weather();
		theWeather.setFiveDayWeather(results.getInt("fivedayforecastvalue"));
		theWeather.setForecast(results.getString("forecast"));
		theWeather.setHigh(results.getInt("high"));
		theWeather.setLow(results.getInt("low"));
		theWeather.setParkCode(results.getString("parkcode"));
		theWeather.setWeatherDate(LocalDate.now().plusDays(results.getInt("fivedayforecastvalue")));
		
		double lowDouble= new Double(results.getInt("low"));
		double lowCDouble = ((lowDouble - 32.0) * (5.0/9.0));
		theWeather.setLowC((int)(Math.round(lowCDouble)));
		
		double highDouble= new Double(results.getInt("high"));
		double highCDouble = ((highDouble - 32.0) * (5.0/9.0));
		theWeather.setHighC((int)(Math.round(highCDouble)));
		

		return theWeather;
		
	}
	
	

}
