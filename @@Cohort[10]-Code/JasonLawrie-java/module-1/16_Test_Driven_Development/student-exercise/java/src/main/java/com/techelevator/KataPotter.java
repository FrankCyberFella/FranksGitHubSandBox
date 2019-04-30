package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KataPotter {

	double cost;
	
	public KataPotter() {
		
	}
	
	public double getCost(int[] books) {
		
		//Establish how many bundles we will have - a bundle of one counts - and will equal the max number of a single book
		int maxBundles=0;
		for(int book:books) {
			maxBundles=Math.max(book,maxBundles);
		}

		//store an array for the number of books in each bundle, with array length == the number of bundles
		int[] bundleCount = new int[maxBundles];
		
		
		//one bundle at a time, make a bundle that puts the maximum number of books in each bundle
		for(int i=0;i<maxBundles;i++) {
			for(int j=0;j<books.length;j++) {
				if(books[j]>0) {
					bundleCount[i]+=1;
					books[j]-=1;
				}
			}
		}
		
		//calculate inefficient bundles! Create a map that pairs two that don't go well together
		Map<Integer, Integer> badBundle = new HashMap<Integer,Integer>();
		for(int i=books.length;i>2;i--) {
			for(int j=1;j<i;j++) {
				if(i*discountRate(i)*8+j*discountRate(j)*8<(i-1)*discountRate(i-1)*8+(j+1)*discountRate(j+1)*8) {
					badBundle.put(i, j);
				}
			}
		}
		
		Set<Integer> badBundleSet = badBundle.keySet();
		
		
		//going through the bundles, check if there are "inefficient" bundles - 5 and 3
		for(int i=0;i<maxBundles;i++) {
			for(int k:badBundleSet) {
				System.out.println(k + " " + badBundle.get(k));
				for(int j=i; j<maxBundles;j++) {
					if(bundleCount[i]==k&&bundleCount[j]==badBundle.get(k)) {
						bundleCount[i]=k-1;
						bundleCount[j]=badBundle.get(k)+1;
						//System.out.println("got here");
					}
				}
			
			}
			
			cost+=bundleCount[i]*8*(1-discountRate(bundleCount[i]));
		}
		
		return cost;	
		
	}
	private double discountRate(int numBooks) {
		switch(numBooks) {
			case 1:
				return 0;
			case 2:
				return .05;
			case 3:
				return .1;
			case 4:
				return .2;
			case 5:
				return .25;
		}
		return 0;
	}
}
