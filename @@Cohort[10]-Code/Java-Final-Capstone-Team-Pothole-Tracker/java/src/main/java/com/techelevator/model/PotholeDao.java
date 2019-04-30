package com.techelevator.model;

import java.util.List;

public interface PotholeDao {

	public List<Pothole> getAllPotholes();
	
	public void savePothole(Pothole pothole);
	
	public void updateRepairStatus(Pothole pothole);
	
	public Pothole getAPothole(Long id);
	
	public List<Pothole> getAllPotholesInspectedReported();
	
	public List<Pothole> getAllPotholesRepaired();
	
	public void updatePotholeSeverity(Pothole pothole);
	
	public void deleteDuplicatePothole(Pothole pothole);
	
}
