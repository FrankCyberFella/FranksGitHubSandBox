package com.alecpetro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class QuotesMethods {
	
	private List<Integer> smallList = new ArrayList<Integer>();
	private List<Integer> mediumList = new ArrayList<Integer>();
	private List<Integer> largeList = new ArrayList<Integer>();
	private List<Quote> quotes = new ArrayList<Quote>();
	private Random rnd;
	
	public QuotesMethods() {
		rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());
		getQuotes();
	}
	
	public List<Quote> getQuotes() {
		
		 try {
			   URL url = new URL("https://ron-swanson-quotes.herokuapp.com/v2/quotes/1000");
			   HttpURLConnection con = (HttpURLConnection) url.openConnection();
			   con.setRequestMethod("GET");
			   BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			   String[] output = br.readLine().split("\",\"");
			   System.out.println("Output from Server .... \n");
			   int counter = 0;
			   for(String q : output) {
				   Quote quote = new Quote(q);
				   quotes.add(quote);
				   //conditionals
				   if(quote.getWordCount() <  5) {
					   addToSmall(counter);
				   } 
				   if(quote.getWordCount() >= 5 && quote.getWordCount() <= 12) {
					   addToMedium(counter);
				   }
				   if(quote.getWordCount() > 12) {
					   addToLarge(counter);
				   }
				   counter++;
				   
			   }
			   
			   con.disconnect();
			   return quotes;
			   
			   
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException f) {
				f.printStackTrace();
			}
		 		return quotes;
			}
	
	
		public void addToSmall(int index){
			smallList.add(index);
		}
		
		public void addToMedium(int index){
			mediumList.add(index);
		}
	
		public void addToLarge(int index){
			largeList.add(index);	
		}
		
		public Quote getSmallQuote() {
			int smallIndex = rnd.nextInt(smallList.size());
			int quoteIndex = smallList.get(smallIndex);
			Quote quote = quotes.get(quoteIndex);
			return quote;
		}
		
		public Quote getMediumQuote() {
			int mediumIndex = rnd.nextInt(mediumList.size()); 
			int quoteIndex = mediumList.get(mediumIndex);
			Quote quote = quotes.get(quoteIndex);
			return quote;
		}
		
		public Quote getLargeQuote() {
			int largeIndex = rnd.nextInt(largeList.size()); 
			int quoteIndex = largeList.get(largeIndex);
			Quote quote = quotes.get(quoteIndex);
			return quote;
		}
		


}
