package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

		ArrayList<Slot> menuList = new ArrayList<Slot>();
		
		String fileName;
		
		public Inventory() {
		fileName = "vendingmachine.csv";
		Item.consumedMap.put("Chip", "Crunch Crunch, Yum!");
		Item.consumedMap.put("Candy", "Munch Munch, Yum!\n"+
			      " _____________,-.___     _\n"+
			      "|____        { {]_]_]   [_]\n"+
			      "|___ `-----.__\\ \\_]_]_    . `\n"+
			      "|   `-----.____} }]_]_]_   ,\n"+
			      "|_____________/ {_]_]_]_] , `\n"+
			      "              `-'");
		Item.consumedMap.put("Drink", "Glug Glug, Yum!");
		Item.consumedMap.put("Gum", "Chew Chew, Yum!");
		restock();
		}
		
		private void restock() {
			File inputFile = new File(fileName);
			String line = "";
			
			try(Scanner fileScanner = new Scanner(inputFile)) {
				while(fileScanner.hasNextLine()) {
					line = fileScanner.nextLine();
					if(line.length()!=0) {

						String[] inputLine = line.split("\\|"); // comeback and error proof the txt file

						menuList.add(new Slot(inputLine[0], new Item(inputLine[1], inputLine[3], Double.parseDouble(inputLine[2]))));

					}
				}
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("Oops");
			}
		}
		
		public void displayInventoryWithLoc() {
			for(int i=0;i<menuList.size();i++) {
				System.out.println(menuList.get(i));
			}
		}

		/**
		 * @return the menuList
		 */
		public ArrayList<Slot> getMenuList() {
			return menuList;
		}
		
}
