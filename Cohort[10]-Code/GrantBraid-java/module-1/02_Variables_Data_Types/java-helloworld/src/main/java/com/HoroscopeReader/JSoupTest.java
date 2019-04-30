package com.HoroscopeReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JSoupTest {

	private static Document site;

	public static void main(String[] args) {

		String ans = "";
		try {
			//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String testUrl = "https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=7";
			//site = Jsoup.connect(reader.readLine()).timeout(0).get();
			site = Jsoup.connect(testUrl).timeout(0).get();
			
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
		System.out.println(ans);
		
		String[] holder = ans.split("[.]");
	
		System.out.println(holder.length);
		for (String s: holder) {
			System.out.println(s+".");
		}

	}
	

}
