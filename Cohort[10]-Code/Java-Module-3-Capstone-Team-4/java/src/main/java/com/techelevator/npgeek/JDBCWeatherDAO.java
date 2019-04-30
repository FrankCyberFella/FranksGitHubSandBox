package com.techelevator.npgeek;

import java.util.ArrayList;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Weather;

@Component	
public class JDBCWeatherDAO implements WeatherDAO {

private JdbcTemplate jdbcTemplate;
@Autowired	
	public JDBCWeatherDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}


	
	@Override
	public List<Weather> getForecast(String code) {
		List<Weather> forecastList = new ArrayList<Weather>();
		String sqlGetForecast = "SELECT * FROM weather where parkcode=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetForecast, code);
		while (results.next()) {
			forecastList.add(mapRowToWeather(results));
		}
		return forecastList;
	}
	



	private Weather mapRowToWeather(SqlRowSet results) {
		Weather f = new Weather();
		f.setDay(results.getInt("fivedayforecastvalue"));
		f.setLow(results.getInt("low"));
		f.setHigh(results.getInt("high"));
		f.setForecast(results.getString("forecast"));
		
		return f;
	}
	
		

}
