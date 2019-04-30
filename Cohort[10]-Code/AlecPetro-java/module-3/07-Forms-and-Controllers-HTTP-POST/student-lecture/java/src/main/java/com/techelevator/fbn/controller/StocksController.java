package com.techelevator.fbn.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.fbn.model.DollarAmount;
import com.techelevator.fbn.model.Stock;

@Controller
@RequestMapping("/fbn")
@SessionAttributes("stocks")	//This data item should persist across sessions - instead deleting at end of request
public class StocksController {
	@RequestMapping(path={"/stocks"}, method=RequestMethod.GET)
	public String showStocksPage(ModelMap map){
		List<Stock> stocks = getStocks();		// Define a List called stocks loaded with the data from getStocks
		
		map.put("stocks", stocks);				// add List called stocks to ModelMap called map
		
		return "fbn/stocksLandingPage";			// return jsp name for the View to display
	}
	
	@RequestMapping(path={"/stockPurchase"}, method=RequestMethod.GET)
	public String buyStockForm(){
		return "fbn/stocksPurchasePage";
	}
	
	@RequestMapping(path={"/stockPurchase"}, method=RequestMethod.POST)
	public String buyStock(@RequestParam String ticker, @RequestParam int shares){
		System.out.println("You bought " + shares + " shares of " + ticker + "!");
		return "fbn/stocksLandingPage";
	}
	
	private List<Stock> getStocks() {
		List<Stock> stocks = new ArrayList<Stock>();
		Stock apple = new Stock();
		apple.setTicker("AAPL");
		apple.setName("Apple");
		apple.setPrice(new DollarAmount(4400));
		apple.setChange(0.5f);
		stocks.add(apple);

		Stock goog = new Stock();
		goog.setTicker("GOOG");
		goog.setName("Google");
		goog.setPrice(new DollarAmount(13400));
		goog.setChange(0.9f);
		stocks.add(goog);

		Stock msft = new Stock();
		msft.setTicker("MSFT");
		msft.setName("Microsoft");
		msft.setPrice(new DollarAmount(6400));
		msft.setChange(-2.0f);
		stocks.add(msft);

		return stocks;
	}
}