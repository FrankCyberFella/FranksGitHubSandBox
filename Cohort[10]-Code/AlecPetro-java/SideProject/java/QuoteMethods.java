import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class QuoteMethods {

	private List<Quote> quotes = new ArrayList<>(); 
  	private List<Integer> small = new ArrayList<>();
  	private List<Integer> medium = new ArrayList<>();
    private List<Integer> large = new ArrayList<>();

	public List<Quote> getQuotes(){    
	    try {
	   URL url = new URL("https://ron-swanson-quotes.herokuapp.com/v2/quotes/1000");
	   HttpURLConnection con = (HttpURLConnection) url.openConnection();
	   con.setRequestMethod("GET");
	   BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	   String[] output = br.readLine().split("\",\"");
	   System.out.println("Output from Server .... \n");
	   for(String q : output) {
		   Quote quote = new Quote(q);
		   quotes.add(quote);
	   }
	   
	   con.disconnect();
	   
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException f) {
		f.printStackTrace();
	}
	}
	
	
	
	if(quote.getWordCount() <= 4) {
   		small.add(quotes.size() - 1);
   } else if(quote.getWordCount() >= 5 && quote.getWordCount() <=12) {
   		medium.add(quotes.size() - 1);
   } else if(quote.getWordCount() > 12) {
   		large.add(quotes.size() - 1);
   }
   }
