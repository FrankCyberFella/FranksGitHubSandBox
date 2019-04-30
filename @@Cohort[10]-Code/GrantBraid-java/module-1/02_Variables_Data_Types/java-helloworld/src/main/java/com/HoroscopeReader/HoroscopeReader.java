
// - two slashes in a row indicate a comment - ignored by compiler
// - a comment is information for any human looking at code

package com.HoroscopeReader; // identifies the package the program belongs to

import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.techelevator.view.Menu;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLConnection;



// provides a context for names

public class HoroscopeReader {	// Add text reminders and post them

	private static Document site;
	private Menu menu;   // Menu object to be used by an instance of this class
	//private Menu menu2;
	public HoroscopeReader(Menu menu) {  // Constructor - user will pas a menu for this class to use
		this.menu = menu;                  // Make the Menu the user object passed, our Menu
	}
	
	
	public static void main(String[] args) throws IOException { //throws an exception for IO to work in program makes bufferedReader work
		String[] zodiacList = new String[12];
		int count = 0; //for first website to access the proper page for zodiac sign
		String websiteLine = null; // start my website line as null to start going to change later when writing website
		

		
		// URL for first horoscope website
		String urlOne = ("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=");
		//URL urlOne = new URL("https://en.wikipedia.org/wiki/Purton_F.C.");
		//get the input stream through URL connection

		
		
		// list of all zodiac signs
		zodiacList[0] = "aries";
		zodiacList[1] = "taurus";
		zodiacList[2] = "gemini";
		zodiacList[3] = "cancer";
		zodiacList[4] = "leo";
		zodiacList[5] = "virgo";
		zodiacList[6] = "libra";
		zodiacList[7] = "scorpio";
		zodiacList[8] = "sagittarius";
		zodiacList[9] = "capricorn";
		zodiacList[10] = "aquarius";
		zodiacList[11] = "pisces";
		
	
		
		String zodiac = "";
		boolean isNotZodiac = true;
		
		System.out.print("What is you zodiac sign? \n");
		for (String z: zodiacList) {
			System.out.println((count+1) + ") "+ zodiacList[count]);
			count++;
		}
		System.out.println("\n");
		
		count = 0;
		Scanner keyboard = new Scanner(System.in);
		int finalCount = 0;
		while(isNotZodiac) { // while loop to determine if the user input is actually a zodiac
			 
			System.out.print("Enter you zodiac: ");
			zodiac = keyboard.nextLine().toLowerCase();
			
			switch (zodiac) {
			case "1":
				zodiac = zodiacList[0];
				break;
			case "2":
				zodiac = zodiacList[1];
				break;
			case "3":
				zodiac = zodiacList[2];
				break;
			case "4":
				zodiac = zodiacList[3];
				break;
			case "5":
				zodiac = zodiacList[4];
				break;
			case "6":
				zodiac = zodiacList[5];
				break;
			case "7":
				zodiac = zodiacList[6];
				break;
			case "8":
				zodiac = zodiacList[7];
				break;
			case "9":
				zodiac = zodiacList[8];
				break;
			case "10":
				zodiac = zodiacList[9];
				break;
			case "11":
				zodiac = zodiacList[10];
				break;
			case "12":
				zodiac = zodiacList[11];
				break;
			}
			
			for (String name : zodiacList) {
				count++;
				if (name.equals(zodiac)) {
					isNotZodiac = false;
					finalCount = count;
					
				}
				
			}
			if (isNotZodiac == true) {
				System.out.println("Thats not a valid zodiac sign try again");
				count = 0;
			}
			
			
		}

		//capitalize first character
		zodiac = zodiac.substring(0,1).toUpperCase() + zodiac.substring(1);
		System.out.println("Your Zodiac is: " + zodiac +"\n\n"); // Print out what zodiac you have chosen
		urlOne += finalCount;

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Your daily horoscope is: ");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ans = "";
		try {
			
			//site = Jsoup.connect(reader.readLine()).timeout(0).get();
			site = Jsoup.connect(urlOne).timeout(0).get();
			
			Elements tags = site.select("html body div main div div p");
			
			for (int i = 0; i < tags.size() ; i++) {
				String hold = tags.get(i).toString();
				if (hold.contains("strong class=")) {
					ans = hold;
				}
				//System.out.println(tags.get(i));
				//.attr("href")
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		ans=ans.substring(ans.indexOf("-")+2,ans.length()-4);

		
		String[] holder = ans.split("[.]");
	
		for (int i = 0; i < holder.length; i++) {
			if (i == 0 ) {
				continue;
			}
			holder[i] = holder[i].substring(1);
		}
		
		for (String s: holder) {
			System.out.println(s+".");
		}		
				
		
	}

}
