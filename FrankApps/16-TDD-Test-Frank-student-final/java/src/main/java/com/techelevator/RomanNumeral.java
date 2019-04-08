package com.techelevator;

public class RomanNumeral {
	// Roman Numeral Values
    // 1 = I, 5 = V, 10 = X, 50 = L, 100 = C, 500 = D, 1000 = M
    //
	
	private String romanNumeral;
	private int    decimalValue;
	
	public RomanNumeral(int decimalValue) {
		this.decimalValue = decimalValue;
		romanNumeral = determineRomanNumeral();
        	this.decimalValue = decimalValue; // required due to determine RomanNumeral() changing the value
                                         	  // test for getDecimalValue() will reveal the need for it
	}
	
	
	
        private String determineRomanNumeral()
        {
            String result = "";

            // The solution should get the students to 
            // notice that there is a repetitive while loop
            /*
                while (number >= 1)
                {
                    number -= 1;
                    result += "I";
                }   
                while (number >= 5)
                {
                    number -= 5;
                    result += "V";
                }   
            */


            result += ConvertDecimalToRoman(1000, "M");
            result += ConvertDecimalToRoman( 500, "D");
            result += ConvertDecimalToRoman( 100, "C");
            result += ConvertDecimalToRoman(  50, "L");
            result += ConvertDecimalToRoman(  10, "X");
            result += ConvertDecimalToRoman(   5, "V");
            result += ConvertDecimalToRoman(   1, "I");

            // Fix the long form to short form
            // CCCC -> CD
            // LXXXX -> XC
            result = FixLongFormToShortForm(result, "CCCC", "CD");
            result = FixLongFormToShortForm(result, "LXXXX", "XC");
            result = FixLongFormToShortForm(result, "XXXX", "XL");
            result = FixLongFormToShortForm(result, "VIIII", "IX");
            result = FixLongFormToShortForm(result, "IIII", "IV");

            return result;
        }

        private String FixLongFormToShortForm(String result, String find, String replace)
        {
            return result.replace(find, replace);
        }

        private String ConvertDecimalToRoman(int places, String romanNumeral)
        {
            String result = "";
            while (this.decimalValue >= places)
            {
                this.decimalValue -= places;
                result += romanNumeral;
            }

            return result;
        }

		/**
		 * @return the romanNumeral
		 */
		public String getRomanNumeral() {
			return romanNumeral;
		}

		/**
		 * @param romanNumeral the romanNumeral to set
		 */
		public void setRomanNumeral(String romanNumeral) {
			this.romanNumeral = romanNumeral;
		}



		/**
		 * @return the decimalValue
		 */
		public int getDecimalValue() {
			return decimalValue;
		}
		
    }

