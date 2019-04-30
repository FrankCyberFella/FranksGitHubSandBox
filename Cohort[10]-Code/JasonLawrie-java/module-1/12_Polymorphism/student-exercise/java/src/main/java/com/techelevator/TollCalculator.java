package com.techelevator;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class TollCalculator {
	public static void main(String[] args) {
		int myMiles=0;
		int totalMiles=0;
		double totalTolls=0;
		
		List<Vehicle> vehOnRoad = new ArrayList<Vehicle>();
		vehOnRoad.add(new Car(true));
		vehOnRoad.add(new Car(false));
		vehOnRoad.add(new Truck(4));
		vehOnRoad.add(new Tank());
		vehOnRoad.add(new Truck(5));
		vehOnRoad.add(new Truck(16));
		
		System.out.printf("  %-18s%16s%16s%16s\n", "Vehicle","Miles Driven","Toll Paid", "Toll Rate");
		System.out.println("**********************************************************************");
		Random rand = new Random();
		for(Vehicle vehicle:vehOnRoad) {
			myMiles=rand.nextInt(500)+10;
			totalMiles+=myMiles;
			totalTolls+=vehicle.calculateToll(myMiles);
			System.out.printf("* %-18s%16d%16.2f%16.3f *\n", vehicle.getDescription(),myMiles,vehicle.calculateToll(myMiles),vehicle.calculateToll(myMiles)/myMiles);
		}
		System.out.println("**********************************************************************");
		System.out.println();
		System.out.printf("Total miles traveled: %4d\n",totalMiles);
		System.out.printf("Total tolls collected: %.2f\n", totalTolls);
		
	}
}
