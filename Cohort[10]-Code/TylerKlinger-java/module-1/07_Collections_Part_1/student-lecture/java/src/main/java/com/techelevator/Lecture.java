package com.techelevator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		
//ArrayList is a type of List; starts at [0] like arrays
//To define one: List<datatype-to-be-stored> name = new ArrayList<datatype-to-be-stored>();
		
		List<String> names = new ArrayList<String>();//empty ArrayList of strings
		names.add("Frodo");//.add() -- adds elements to end of ArrayList
		names.add("Sam");
		names.add("Pippin");
		names.add("Merry");
		names.add("Gandalf");
		names.add("Aragorn");
		names.add("Boromir");
		names.add("Gimli");
		names.add("Legolas");
		
		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		
		//.size()--returns the number of elements in the ArrayList
		//the elements will be returned in the same order they were added
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));//.get() -- retrieves the element at index
		}
		
		
		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		names.add("Sam");
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		names.add(2, "David");//places David before index 2
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		names.remove(2);//removes the element at target index
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");	

		boolean inList = names.contains("Samwise");//searches list for name, returns true if in ArrayList
		System.out.println("Samwise is in the list of names: " + inList);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
	
		String[] namesArray = names.toArray(new String[names.size()]);//toArray converts ArrayList to a "normal" array
		for(int i = 0; i < namesArray.length; i++) {
			System.out.println(namesArray[i]);
		}
		
		

		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");
		
		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation 
		 * of a primitive value */
		Integer employees = new Integer(25);       // here we call a constructor that "wraps" a primitive int value in an object
		Integer piecesOfCake = new Integer("24");  // here we call a constructor that converts a String into an Integer
		
		if(employees > piecesOfCake) {
			System.out.println("Burn the building down");
		}
		
		Double accountBalance = null;
		// double newBalance = accountBalance + 100;  // this causes a NullPointerException because we are trying to "unbox" a null value

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
//foreach loop - Always goes from beginning to end, one element at a time
//can only start at the beginning; can only stop at the end
//can't skip elements
		// Let's loop through names again, but this time using a for-each loop
		    // for each name in names
		for(String anElement : names) {
//every time through the loop, anElement will be assigned an element in names
			// print the current value from names (anElement)
			System.out.println(anElement);
		}
		
		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();

		Queue<String> priorities = new LinkedList<String>();

		priorities.offer("Clean the dishes");//add an element to the queue at the end
		priorities.offer("Wash the counters");//''
		priorities.offer("Sweep the floor");//''
		priorities.offer("Scrub the floor");//''

		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////
		while (priorities.size() > 0) {
			String nextPriority = priorities.poll();
			System.out.println("NEXT PRIORITY " + nextPriority);
		}

		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();

		Stack<String> browserStack = new Stack<String>();

		////////////////////
		// PUSHING ITEMS TO THE STACK
		//////////////////// 
		browserStack.push("http://www.google.com");//adds element to stack at the top
		browserStack.push("http://www.cnn.com");//''
		browserStack.push("http://www.google.com");//''
		browserStack.push("http://www.techelevator.com");//''
		browserStack.push("http://www.si.com");//''

		////////////////////
		// POPPING THE STACK
		////////////////////
		while(browserStack.size() > 0)
		{
			String previousPage = browserStack.pop();
			System.out.println("PREVIOUS PAGE: " + previousPage);
		}
	}
}
