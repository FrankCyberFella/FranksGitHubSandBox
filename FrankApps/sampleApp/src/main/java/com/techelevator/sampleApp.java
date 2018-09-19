package com.techelevator;

//import com.techelevator.ginzUtilities.*;

public class sampleApp {

	public static void main(String[] args) {
        
        /*
        INSTRUCTIONS

       The primary purposes of this program is to provide a skeleton application that students can
       modify as they learn new concepts.
       
       Please refer to the TODO comments for directions on what is required
        		
        */
		
		sampleAppCLI mySampleAppCLI = new sampleAppCLI(); // object to represent Command Line Interface (CLI) given
//		ginzUtilities myUtils = new ginzUtilities();
		
		String playerName = "";                           // variable to gold Player's name
		int atBats = 0;									 // variable to hold Players atBats
		int singles = 0;									 // variable to hold number of Singles player hit
		int doubles = 0;									 // variable to hold number of Doubles player hit
		int triples = 0;									 // variable to hold number of Triples player hit
		int homeRuns = 0;								 // variable to hold number of HomeRuns player hit
		int strikeOuts = 0;								 // variable to hold the number of times player struck out
		int walks = 0;									 // variable to hold the number of times player walked
		int hitByPitch = 0;								 // variable to hold the number of times player was hit by a pitch
		int totalHits = 0;								 // variable to hold the number of total hits (singles + doubles + triples + home runs)
		double battingAverage = 0.0;						 // variable to hold batting average total hits divided by at bats
		double sluggingPctg = 0.0;						 // variable to hold slugging percentage (total bases divided by at bats)
		                                                  // single = 1 base; double = 2 bases  triple = 3 bases   home run = 4 bases)
/*		
		playerName = mySampleAppCLI.getName();            		// get name from keyboard using CLI object
		System.out.println("Name entered was: " + playerName);  	// display name entered
		
		atBats = mySampleAppCLI.getWholeNumber("Please enter the number of at bats for " + playerName);
		singles = mySampleAppCLI.getWholeNumber("Please enter the number of singles for " + playerName);
		doubles = mySampleAppCLI.getWholeNumber("Please enter the number of at doubles for " + playerName);
		triples = mySampleAppCLI.getWholeNumber("Please enter the number of at triples for " + playerName);
		homeRuns = mySampleAppCLI.getWholeNumber("Please enter the number of at home runs for " + playerName);
		strikeOuts = mySampleAppCLI.getWholeNumber("Please enter the number of strike outs for " + playerName);
		hitByPitch = mySampleAppCLI.getWholeNumber("Please enter the number of hit by pitch for " + playerName);
		totalHits = singles + doubles + triples + homeRuns;
		battingAverage = (double)totalHits / atBats;
		sluggingPctg = (singles + (doubles * 2) + (triples * 3) +(homeRuns*4)) / (double) atBats;
		
		System.out.println("Total Hits: " + totalHits);
		System.out.println("      Bavg: " + ginzUtilities.ginzRound(battingAverage, 3));
		System.out.println("      Bavg: " + ginzUtilities.ginzDecFormat(battingAverage, 5, 3));
		System.out.println(" Slug Pctg: " + sluggingPctg);
	*/
		System.out.println("ginzDecFormat(12.3456,5,3) returns \"" +  ginzUtilities.ginzDecFormat(12.3456,5,3) + '\"');
		System.out.println("ginzDecFormat(12.3456,5,2) returns \"" +  ginzUtilities.ginzDecFormat(12.3456,5,2) + '\"');
		System.out.println("ginzDecFormat(12.3456,5,1) returns \"" +  ginzUtilities.ginzDecFormat(12.3456,5,1) + '\"');
		System.out.println("ginzDecFormat(12.3456,1,1) returns \"" +  ginzUtilities.ginzDecFormat(12.3456,1,1) + '\"');
		System.out.println("ginzDecFormat(12.3456,5,0) returns \"" +  ginzUtilities.ginzDecFormat(12.3456,5,0) + '\"');
		System.out.println("ginzDecFormat(12.3456,1,0) returns \"" +  ginzUtilities.ginzDecFormat(12.3456,1,0) + '\"');
		System.out.println("ginzDecFormat(12.3456,5,5) returns \"" +  ginzUtilities.ginzDecFormat(12.3456,5,5) + '\"');
		System.out.println("ginzDecFormat(12.9876,5,0) returns \"" +  ginzUtilities.ginzDecFormat(12.9876,5,0) + '\"');
		System.out.println("ginzDecFormat(12.3456,5,6) returns \"" +  ginzUtilities.ginzDecFormat(12.3456,5,6) + '\"');
	/*	
		System.out.println("------------------------------------------------");
		System.out.println("Rounding 3.12345678 to 4 decimal places using   CEILING: " + ginzUtilities.ginzRound(3.12345678, 4, "CEILING"));
		System.out.println("Rounding 3.12345678 to 4 decimal places using     FLOOR: " + ginzUtilities.ginzRound(3.12345678, 4, "FLOOR"));
		System.out.println("Rounding 3.12345678 to 4 decimal places using        UP: " + ginzUtilities.ginzRound(3.12345678, 4, "UP"));
		System.out.println("Rounding 3.12345678 to 4 decimal places using      DOWN: " + ginzUtilities.ginzRound(3.12345678, 4, "DOWN"));
		System.out.println("Rounding 3.12345678 to 4 decimal places using   HALF_UP: " + ginzUtilities.ginzRound(3.12345678, 4, "HALF_UP"));
		System.out.println("Rounding 3.12345678 to 4 decimal places using HALF_DOWN: " + ginzUtilities.ginzRound(3.12345678, 4, "HALF_DOWN"));
	*/	
	}
}
