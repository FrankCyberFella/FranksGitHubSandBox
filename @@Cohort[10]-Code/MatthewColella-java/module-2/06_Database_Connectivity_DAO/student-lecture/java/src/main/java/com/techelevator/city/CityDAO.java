package com.techelevator.city;

import java.util.List;

public interface CityDAO {           //OUR DAO, All the methods that must be provided

	public void save(City newCity);
	public City findCityById(long id);
	public List<City> findCityByCountryCode(String countryCode);
	public List<City> findCityByDistrict(String district);
	public void update(City city);
	public void delete(long id);
}
