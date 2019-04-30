package com.techelevator.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.dao.WeatherDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;

@Component
public class JDBCWeatherDao implements WeatherDao {
	
	
	private JdbcTemplate myJdbcTemplate;						// Define a jdbctemplate object for the DAO
	
	@Autowired
	public JDBCWeatherDao(DataSource aDataSource) {				// constructor for DAO - receive a data source
		this.myJdbcTemplate = new JdbcTemplate(aDataSource);    // instantiate a jdbctemplate object for the DAO
	}
	
	@Override
	public List<Weather> getFiveDayForecastByParkCode(String parkCode) {
		ArrayList<Weather> weather = new ArrayList<>();
		String sqlParkByName = "SELECT * "+
							   "FROM weather "+
							   "WHERE parkcode = ?";
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlParkByName, parkCode);
		while(results.next()) {
			Weather theWeather = mapRowToWeather(results);
			weather.add(theWeather);
		}
		return weather;
	}

	private Weather mapRowToWeather(SqlRowSet results) {
		Weather theWeather;
		theWeather = new Weather();
		theWeather.setParkCode(results.getString("parkcode"));
		theWeather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		theWeather.setLowF(results.getInt("low"));
		theWeather.setHighF(results.getInt("high"));
		theWeather.setLowC(results.getInt("low"));
		theWeather.setHighC(results.getInt("high"));
		theWeather.setForecast(results.getString("forecast").replaceAll(" ", ""));
		return theWeather;
	}
	
}
