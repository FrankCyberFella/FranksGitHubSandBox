// - two slashes in a row indicate a comment - ignored by compiler
// - a comment is information for any human looking at code

package com.techelevator; // identifies the package the program belongs to

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

// provides a context for names

public class PopUpProject {	// Add text reminders and post them

	public static void main(String[] args) { 
		
		Scanner keyboard = new Scanner(System.in);
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("REMINDER!!!");
		
	//	System.out.print("What do you want to remind yourself? ");
		
	//	String reminder = keyboard.nextLine();
											 
		String reminder = JOptionPane.showInputDialog("What do you need to do?");
		
		JOptionPane.showMessageDialog(null, "Remember to " + reminder);
		
		
	}

}
