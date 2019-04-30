package com.GraphingCalculator;

import java.awt.*;
import java.awt.List;
import java.util.*;

import javax.swing.JFrame;

public class PlayingWithGraphics extends Canvas{
	


	public static void main(String[] args) {
		

	
		JFrame frame = new JFrame("Graphing Calculator");	    // Instantiating new frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // want to close window when done graphing
	
		PlayingWithGraphics graph = new PlayingWithGraphics();  // creating a new object of the class we are in
		
		frame.add(graph); 										// adding our object graph to the set up frame
		frame.setSize(600,600);			// setting standard size for the frame being used
		frame.setVisible(true);									// making frame visible
					
	}
	
	//***************************************************************************************************
	// Paint method
	//***************************************************************************************************
	public void paint(Graphics g) {
		
		Scanner keyboard = new Scanner(System.in); 					// Setting up keyboard for inputs
		System.out.print("What function would you like to graph? ");	// 
		FunctionCalculator equation = new FunctionCalculator();
		String kb = keyboard.nextLine();


		equation.setFunction(kb);
		String function = equation.turnFunction();

		
		//System.out.println(holder);



		int i;
		function = function.replaceAll("x","(i-300)");
		//System.out.println(function);
		String[] functionArray = function.split("i");

//		for (String word: functionArray) {
//			System.out.print(word + " ");
//		}

		double autoScale = (int)Math.pow(300,1);					//Initializing varialbe to autoscale of funtion to frame size
		
		g.drawLine(300,0,300,600);									// Drawing coordinate axis
		g.drawLine(0, 300, 600, 300);								// Drawing coordinate axis
		
		
		ArrayList<Integer> x = new ArrayList<Integer>();			//Creating new array for x values for size of frame
		ArrayList<Integer> y = new ArrayList<Integer>();			//Creating new array for y values for size of frame
		
		int[] x2 = new int[600];
		int[] y2 = new int[600];
		
		int lastX = 0;												//Placeholder x value for last value for graphing lines
		int lastY = 0;												//Placeholder y value for last value for graphing lines


		
		for (i = 0; i < 600 ; i++) {			//for loop to add corresponding x and y values for graphing purposes
			function = ""; 						// start function as alwasy containing nothing
			for (String word: functionArray) { 	// run a for each loop for converting string to integer
				function += word+i; 			// adding to our string
			}
			///////// im confused

			if (i < 10) {
				function = function.substring(0,function.length()-1); // if our variable is less than ten cut it off at the end
			}
			if (i >= 10 && i < 100) {
				function = function.substring(0,function.length()-2); // if our variable is in the tens cut this out at the end
			}
			if (i >= 100) {
				function = function.substring(0,function.length()-3); // if our varialbe is in the hundreds cut this out at the end
			}

			System.out.println(function);
			
		
			x.add(i); // this is used for arrayList method
			x2[i] = i;
			double finalFunction = 0;
			//System.out.println(finalFunction);
			//finalFunction = Double.valueOf(function);

			//System.out.println(finalFunction);

			//Double.par
			
			y2[i] = (-1*(int)((finalFunction)/autoScale) +300);
			y.add(-1*(int)((finalFunction)/autoScale) +300);	// changing y value with calculation for arrayList method
				//y.add(-1*(int)((Math.pow(i-300, 2))/autoScale) + 300); // functioning x^2 test
			

			
		}

		
		for (i = 0; i< x.size(); i++) { // adding out data points onto the frame

			g.setColor(Color.BLUE);
	
			try {													// Used to delay drawing so it all wont just pop up
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			g.fillOval(x.get(i),y.get(i),1,1); 		//******* this is weird				// filling data points		
			g.drawLine(x.get(i), y.get(i), lastX, lastY); 			// drawing lines between each data point on graph
			
			//g.fillOval(x2[i],y2[i],1,1); 		//******* this is weird				// filling data points		
			//g.drawLine(x2[i], y2[i], lastX, lastY); 
			
			if (i == 0) {
				
			} else {												// Storing values for x and y for drawing the line properly
				lastX = i;
				int finalFunction = 0;
				try {
					finalFunction = Integer.getInteger(function);
				} catch (NullPointerException e) {
					
				}
				lastY = (-1*(int)((finalFunction)/autoScale) +300);	// changing y value with calculation
				//lastY = -1*(int)((Math.pow(i-300, 2))/autoScale) + 300; // functioning x^2 test
			}
		
			
		}
	}


		
		

}
