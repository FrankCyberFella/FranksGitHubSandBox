package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RomanNumeral {
 /**********************************************************************************************************
 * This class will store a Roman Numeral equivalent of a given Decimal Value
 * 
 *  Decimal values to Roman Numeral 
 *        1 = I, 5 = V, 10 = X, 50 = L, 100 = C, 500 = D, 1000 = M
 ************************************************************************************************************/	
/************************************************************************************************************
 *  member data
 ************************************************************************************************************/ 
    private String romanNumeral;
	private int    decimalValue;

	/************************************************************************************************************ 
	 * V3.0 -Added Map to hold decimal value to ROman Numeral conversion
	 * V3.5 - Made Map static (class variable) rather than in instance variable 
     *
     * Map to hold the values of each Roman numeral        
     *    Key=decValue value=RomanNumeral       
     ************************************************************************************************************/   
 static TreeMap<Integer, String> romanNumeralMap = new TreeMap<Integer, String>();

 static {
 romanNumeralMap.put(1000,"M");
 romanNumeralMap.put( 500,"D");
 romanNumeralMap.put( 100,"C");
 romanNumeralMap.put(  50,"L");
 romanNumeralMap.put(  10,"X");
 romanNumeralMap.put(   5,"V");
 romanNumeralMap.put(   1,"I");
 romanNumeralMap.put(   4,"IV"); // Added in V4.0 to handle edge cases
 romanNumeralMap.put(   9,"IX"); // Added in V4.0 to handle edge cases
 romanNumeralMap.put(  90,"XC"); // Added in V4.0 to handle edge cases
 romanNumeralMap.put(  40,"XL"); // Added in V4.0 to handle edge cases
 romanNumeralMap.put( 900,"CM"); // Added in V4.0 to handle edge cases
 romanNumeralMap.put( 400,"XD"); // Added in V4.0 to handle edge cases
 }

 /************************************************************************************************************
  *  Constructor
  ************************************************************************************************************/ 	
	public RomanNumeral(int decimalValue) {
	   	this.decimalValue = decimalValue;
	    romanNumeral = determineRomanNumeral_V27();
	}
/************************************************************************************************************
 *  member functions
 ************************************************************************************************************/ 

/************************************************************************************************************
 *  v5.0 - Add code so ctor does not change the decimal value passed to it
 *  
 *  Added currentDecimalValue local variable initialized to instance variable decimalNumber 
 *  for use in calculations
 *  
 *  Changed references to decimalVaue in logic to currentDecimalValue
 ************************************************************************************************************/ 
	private String determineRomanNumeral_V50(){
        String result = "";	
        
        int currentDecimalValue = decimalValue;  
      
		while (currentDecimalValue > 0) {		
	   		  result += romanNumeralMap.get(romanNumeralMap.floorKey(currentDecimalValue));
	   		currentDecimalValue -= romanNumeralMap.floorKey(currentDecimalValue);
		}
		return result;  	
    }

/************************************************************************************************************
 * V4.0 - Test for multi digit Roman Numeral conversion - edge cases (IV, IX, XL, XC, etc)
 *  
 *  Added edge case values to static class variable romanNumeralMap TreeMap instantiated at top of class
 *  No change to determineRomanNumeral() method from V3.0
 ************************************************************************************************************* 
 * V3.5 - Re-factored TreeMap instance variable to be static (class variable)
  ************************************************************************************************************* 
 * V3.0 - Test for multiples of 10, 100, 1000 - no edge cases (XL, XC, CD, CM)
 * 
 *  Re-factored determineRomanNumeral_27() method to use instance variable TreeMap 
 *  to convert decimal values to Roman Numeral - note TreeMap class used to allow use of floorKey() method
 ************************************************************************************************************/ 
		private String determineRomanNumeral_V30(){
	        String result = "";	
	      
			while (decimalValue > 0) {		
		   		  result += romanNumeralMap.get(romanNumeralMap.floorKey(decimalValue));
		   		  decimalValue -= romanNumeralMap.floorKey(decimalValue);
			}
			return result;  	
	    }
/************************************************************************************************************* 
 * V2.7 -Test for multi digit Roman Numeral conversion - edge cases (IV, IX, XC, etc)
 * 
 * Added code to brute force edge cases
 ************************************************************************************************************/ 
		private String determineRomanNumeral_V27(){
	        String result = "";	
			      
	        while (decimalValue >= 1000) {		
		   		  result += "M";
		   		  decimalValue -= 1000;
				}
	        while (decimalValue >= 500) {		
		   		  result += "D";
		   		  decimalValue -= 500;
				}
	        while (decimalValue >= 100) {		
		   		  result += "C";
		   		  decimalValue -= 100;
				}
	        while (decimalValue >= 50) {		
		   		  result += "L";
		   		  decimalValue -= 50;
				}
			while (decimalValue >= 10) {		
		   		  result += "X";
		   		  decimalValue -= 10;
				}
			while (decimalValue >= 5) {		
				  result += "V";
				  decimalValue -= 5;
				}
			while (decimalValue >= 1) {		
				  result += "I";
				  decimalValue -= 1;
				}
			result = result.replace("DCCCC", "CM");
			result = result.replace("CCCC" , "CD");
			result = result.replace("LXXXX", "XC");
			result = result.replace("XXXX" , "XL");
			result = result.replace("VIIII", "IX");
			result = result.replace("IIII" , "IV");
				
			return result;  	
	   }
/************************************************************************************************************* 
 * V2.5 -Test for multi digit Roman Numeral conversion - no edge cases (IV, IX, XC, etc)
 * 
 * re-factored when student's discovered the order of testing values matters
 ************************************************************************************************************/ 
		private String determineRomanNumeral_V25(){
			String result = "";	
					      
			while (decimalValue >= 1000) {		
				     result += "M";
	  	   		     decimalValue -= 1000;
					}
			while (decimalValue >= 500) {		
					result += "D";
					decimalValue -= 500;
					}
			while (decimalValue >= 100) {		
			  	    result += "C";
				    decimalValue -= 100;
					}
			while (decimalValue >= 50) {		
					result += "L";
		   		    decimalValue -= 50;
					}
			while (decimalValue >= 10) {		
					result += "X";
					decimalValue -= 10;
					}
			while (decimalValue >= 5) {		
					result += "V";
					decimalValue -= 5;
					}
			while (decimalValue >= 1) {		
					result += "I";
					decimalValue -= 1;
					}
			return result;  	
			}
/************************************************************************************************************* 
 * V2.0 -Test for multi digit Roman Numeral conversion - no edge cases (IV, IX, XC, etc)
 ************************************************************************************************************/ 
				private String determineRomanNumeral_V20(){
			        String result = "";	
			      
					while (decimalValue > 1) {		
				   		  result += "I";
				   		  decimalValue -= 1;
					}
					while (decimalValue > 5) {		
				   		  result += "V";
				   		  decimalValue -= 5;
					}
					while (decimalValue > 10) {		
				   		  result += "X";
				   		  decimalValue -= 10;
					}
					return result;  	
			    }
	
/************************************************************************************************************* 
* V1.0 - Test for single digit Roman Numeral conversion
************************************************************************************************************/ 
								private String determineRomanNumeral_V10(){
							        String result = "";	
							      
									if (decimalValue > 1) {		
								   		  result += "I";
									}
									if (decimalValue > 5) {		
								   		  result += "V";
									}
									if (decimalValue > 10) {		
								   		  result += "X";
									}
									return result;  	
							    }
/************************************************************************************************************
 *  getter / setters
 ************************************************************************************************************/ 

     public String getRomanNumeral() {
			return romanNumeral;
		}
     public int getDecimalValue() {
			return decimalValue;
		}	
    }
/************************************************************************************************************
 *  End of Roman Numeral Class
 ************************************************************************************************************/ 

