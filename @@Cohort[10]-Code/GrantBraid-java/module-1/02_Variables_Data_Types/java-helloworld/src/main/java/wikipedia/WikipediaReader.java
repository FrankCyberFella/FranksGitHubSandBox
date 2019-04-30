package wikipedia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WikipediaReader {

	private static Document site;
	
	public static void main(String[] args) throws IOException {
		File wikipediaHeaders = new File ("wikipedia.txt");
		List<String> linkHolder = new ArrayList<>();
		String ans = "";
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a keyword to find: ");
		String word = keyboard.next();
		word = word.toLowerCase();
		int numberOfTimes = 0;
		
		
		if (wikipediaHeaders.exists()) {
			wikipediaHeaders.delete();
		}
		wikipediaHeaders.createNewFile();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("wikipedia.txt"));
		
		
		try {
			numberOfTimes++;
			//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String testUrl = "https://en.wikipedia.org/wiki/Cheddar_cheese";
			//site = Jsoup.connect(reader.readLine()).timeout(0).get();
			site = Jsoup.connect(testUrl).timeout(0).get();
			
			Elements tags = site.select("a");
			Elements tag = site.select("h1");
			
			
			String header = tag.get(0).toString();
			header = header.substring(header.indexOf(">") + 1);
			header = header.substring(0,header.indexOf("<"));
			writer.write(numberOfTimes + ") " + header + "\n");
			System.out.println(header);
			
			for (int i = 0; i < tags.size() ; i++) {
				String hold = tags.get(i).attr("href").toString();
				if (hold.startsWith("/wiki/")) {
					if (hold.contains("talk:") || hold.contains("MediaWiki") || hold.contains("User:") || hold.contains("User talk:") || hold.contains("Template talk:") || hold.contains("Template:") || hold.contains("Help:") || hold.contains("File:") || hold.contains("Category:") || hold.contains("Special:") || hold.contains("Portal:") || hold.contains("Main_Page") || hold.contains("Wikipedia:")) {
						continue;
					}
					else {
						
						
						//System.out.println(hold);
						linkHolder.add(hold);
					}
				}
				
				
				//.attr("href")
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		boolean isFalse = true;

		
		while (isFalse) {
			numberOfTimes++;
			
			int count = linkHolder.size();
			int linkToUse = (int)(Math.random()*count);
			String newUrl = "https://en.wikipedia.org" + linkHolder.get(linkToUse);
			
			
			linkHolder.clear();
			
			
			site = Jsoup.connect(newUrl).timeout(0).get();
			
			Elements tags = site.select("a");
			Elements tag = site.select("h1");
			
			String header = tag.get(0).toString();
			header = header.substring(header.indexOf(">") + 1);
			header = header.substring(0,header.indexOf("<"));
			writer.write(numberOfTimes + ") " + header + "\n");
			System.out.println("\n" + header + "\n");		
			///////////////////////////////////
			// this is your tester for now!!!
			///////////////////////////////////
			if (header.toLowerCase().contains(word)) {
				isFalse = false;
			}			
			//////////////////////////////////
			
			for (int j = 0; j < tags.size() ; j++) {
				String hold = tags.get(j).attr("href").toString();
				if (hold.startsWith("/wiki/")) {
					if (hold.contains("talk:") || hold.contains("MediaWiki") || hold.contains("User:") || hold.contains("User talk:") || hold.contains("Template talk:") || hold.contains("Template:") || hold.contains("File:") || hold.contains("Category:") || hold.contains("Special:") || hold.contains("Portal:") || hold.contains("Main_Page") || hold.contains("Wikipedia:") || hold.contains("Help:")) {
						continue;
					} else {
						
						linkHolder.add(hold);
						
						
					}
				}
			}
		}
		writer.close();
		System.out.println("The number of wikipedia pages visited to find " + word + " was: " + numberOfTimes);
		

	}
	

}
