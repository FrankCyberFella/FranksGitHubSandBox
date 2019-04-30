import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class QuoteController {
    private List<Quote> quotes = new ArrayList<>(); 
    private List<Integer> small = new ArrayList<>();
    private List<Integer> medium = new ArrayList<>();
    private List<Integer> large = new ArrayList<>();

    public static void main(String[] args){
        //call API
        try {
        URL url = new URL("https://ron-swanson-quotes.herokuapp.com/v2/quotes");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String output;
        System.out.println("Output from Server .... \n");
        while((output = br.readLine()) != null) {
            System.out.println(output);
        }
        con.disconnect();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}