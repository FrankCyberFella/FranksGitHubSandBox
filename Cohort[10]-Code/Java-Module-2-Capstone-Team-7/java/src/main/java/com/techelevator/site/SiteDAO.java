package com.techelevator.site;

import java.time.LocalDate;


public interface SiteDAO {

	public void listSites(int id, LocalDate from_date, LocalDate to_date);


}
