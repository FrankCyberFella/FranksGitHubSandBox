package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Practice {

	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();
		names.add("Frodo");
		names.add("Sam");
		names.add("Pippin");
		names.add("Merry");
		names.add("Gandalf");
		names.add("Antoinette");
		names.add("Boromir");
		names.add("Gimli");
		names.add("Legolas");
		names.add(2, "David");

		
		
		for (int i = 0; i < 1; i++) {
			System.out.println(names.get(0));
			System.out.println(names.get(1));
			System.out.println(names.get(3));
			System.out.println(names.get(6));
			System.out.println(names.get(7));
		}
	}

}
