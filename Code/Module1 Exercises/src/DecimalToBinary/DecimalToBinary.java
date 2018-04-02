package DecimalToBinary;

	/*
	Write a command line program which accepts a series of decimal integer values as command line arguments, 
	and displays each decimal value as itself and its binary equivalent

	$ DecimalToBinary 460 8218 1 31313 987654321
	460 in binary is 111001100
	8218 in binary is 10000000011010
	1 in binary is 1
	31313 in binary is 111101001010001
	987654321 in binary is 111010110111100110100010110001
	*/
	public class DecimalToBinary {

		public static void main(String[] args) {

			String[] DecNums = {"15", "3","9","81","27"};
			
			for(int ix = 0; ix < DecNums.length; ix++) {
				
				String binary = "";
				int base = 2;
				int decimal = Integer.parseInt(DecNums[ix]);
				for( ; decimal > 0; decimal = decimal / base) { // the first and last section of the for loop are optional.  Here, we do not do anything before the for loop begins.
					binary = (decimal % base) + binary;
				}
				
				System.out.println(DecNums[ix]+" in base " + base + " is "+binary);
			}
		}
	}

