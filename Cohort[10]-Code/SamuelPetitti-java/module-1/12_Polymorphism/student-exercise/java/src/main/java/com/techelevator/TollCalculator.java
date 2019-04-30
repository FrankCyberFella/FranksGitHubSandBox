
package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class TollCalculator {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		List <Vehicle> vehicles = new ArrayList<Vehicle>();
		Car Car1 = new Car(true);
		Car Car2 = new Car(false);
		Car Car4 = new Car(true);
		Truck Truck = new Truck(4);
		Tank Tank1 = new Tank();
		Truck Truck1 = new Truck(6);
		Truck Truck2 = new Truck(8);
		Car Car55 = new Car(false);
		Truck Truck44 = new Truck(4);
	
		
		vehicles.add(Car1);
		vehicles.add(Truck);
		vehicles.add(Tank1);
		vehicles.add(Car2);
		vehicles.add(Car4);
		vehicles.add(Truck1);
		vehicles.add(Truck2);
		vehicles.add(Truck44);
		vehicles.add(Car55);
		
		
		
		
		
		
		
		
		System.out.println("*Vehicle            Distance Traveled      $ Toll*");
		System.out.println("**************************************************");
		
		int totalMilesTraveled = 0;
		double totalTollRevenue = 0;
		for(Vehicle car : vehicles) {
			int distance = (int)(Math.random() * 230);
		
		double tollFee = car.calculateToll(distance);
		System.out.printf("%-17s  %-20d   $%5.2f   \n",
						 car.getDescription(),
						 distance,
				
						 tollFee);
						 totalMilesTraveled += distance;	
						 totalTollRevenue += tollFee;
		
					}
		
		System.out.println("Total Miles Traveled: " + totalMilesTraveled);
		System.out.printf("Total Tollbooth Revenue: $ %.2f \n",
				 			totalTollRevenue);
	
				
			}
		
	}
		
		
		
		
//		public static void showTest(Worker aWorker, int hoursWorked) {		
//
//			System.out.printf("%s %s working for %d hours makes $%.2f per week\n", 
//			                 aWorker.getFirstName(),
//			                 aWorker.getLastName(),
//			                 hoursWorked,
//			                 aWorker.calculateWeeklyPay(hoursWorked));
//		
//		
//		
		
		
//		TollCalculator.java
//
//		Create a command line program named TollCalculator. The application will not accept any input.
//
//		Following the approach discussed in the lecture, create a List<Vehicle> that represents all of the vehicles that travel through a particular tollbooth. Using a random number for distance (10 to 240) calculate the tolls for each vehicle so that you can:
//
//		Indicate each vehicle type, the distance traveled, and the calculated toll
//		Indicate the sum of all miles traveled and total tollbooth revenue
//		You should not need to check the type of Vehicle in the main method when displaying the output
//		Expected output using **random** distances
//
//		Vehicle            Distance Traveled      Toll $
//		------------------------------------------------
//		Car                100                    $2.00
//		Car (with trailer) 75                     $2.50
//		Tank               240                    $0.00
//		Truck (4 axels)    150                    $6.75
//		Truck (6 axels)    101                    $4.55
//		Truck (8 axels)    180                    $8.64
//
//		Total Miles Traveled: 846
//		Total Tollbooth Revenue: $24.44
//
//	}
//
//}
