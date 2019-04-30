package com.techelevator.farm;

public class Principal {
	 
	public static void main(String[] args) {
		 Person p = new Employee();
		 p.firstName = "John";
		 p.lastName = "Smith";
		 
		 p.title = "Instructor"; // not allowed
		 System.out.println(p.getDescription());
		 System.out.println(p.correctExams());
		 }
		 
		}
