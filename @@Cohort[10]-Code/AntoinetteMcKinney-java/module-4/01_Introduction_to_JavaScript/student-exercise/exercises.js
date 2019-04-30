
// number 1 


function sumDouble(x, y) {
    if(x === y) {
      return 2*(x+y);  
}else{
        return x + y;  
    }
}
// number 2 
function hasTeen (x,y,z) {
    if((x >= 13) && ( x <= 19)) {
        return true;
    } else if((y >= 13) && ( y <= 19)){
        return true;
    } else if ((z >= 13) && ( z <= 19)){
        return true;
    } else {
        return false;
    }
}// number 3 
    // **lastDigit** Given two non-negative int values, return true if they have the same last digit, such as with 27 and 57.

	// 	lastDigit(7, 17) → true
	// 	lastDigit(6, 17) → false
	// 	lastDigit(3, 113) → true

function lastDigit(x,y){
    
    var digitX =  x.toString();                      // tostring method to convert int into string    
    var digitY = y.toString();
    var lastDigitX = digitX.charAt(digitX.length-1); //CharAt method lets to select a character
    var lastDigitY = digitY.charAt(digitY.length-1);

    if(lastDigitX == lastDigitY){
        return true;
    } else {
        return false;
    }
}

        // 4. **seeColor** Given a string, if the string begins with "red" or "blue" return that color string, otherwise return the empty string.

		// seeColor("redxx") → "red"
		// seeColor("xxred") → ""
		// seeColor("blueTimes") → "blue"
            
function seeColor(x){
    
    if(x.startsWith("red")) {
    return "red";
    } else if (x.startsWith("blue")) {
        return "blue";
    } else {
        return ""; 
    } 
} 


        // 5. **oddOnly** Write a function that given an array of integer of any length, filters out the even number, 
                        // and returns a new array of just the the odd numbers.

		// oddOnly([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]) → [1, 3, 5, 7, 9, 11];
        // oddOnly([2, 4, 8, 32, 256]); → []

function oddOnly (x){
    var odd = [];
    for( var i = 0; i < x.length; i++) {//  for every element i loops through size of array 
        if( x[i] % 2 !== 0 ) {           //  gets postition i and only return numbers not modulus 2 
                odd.push(x[i]); //add odd number to array
        }
    } 
    return odd;
}
        

       
        // 6 **frontAgain** Given a string, return true if the first 
        //     2 chars in the string also appear at the end of the string, such as with "edited".

		// frontAgain("edited") → true
		// frontAgain("edit") → false
        // frontAgain("ed") → true
    
function frontAgain(y) {
    var firstTwo = y.startsWith('ed'); 
    var lastTwo = y.endsWith('ed');
    
    if (y.length < 2) {
        return false;
    } else if ( firstTwo === lastTwo) {
        return true;  
    } else { 
        return false;
    }
}

// 7. **cigarParty** When squirrels get together for a party, they like to have cigars. 
// A squirrel party is successful when the number of cigars is between 40 and 60, inclusive. 
// Unless it is the weekend, in which case there is no upper bound on the number of cigars. 
// Write a squirrel party function that return true if the party with the given values is successful, 
// or false otherwise.

// 		cigarParty(30, false) → false
// 		cigarParty(50, false) → true
// 		cigarParty(70, true) → true
function cigarParty(cigars, isWeekend) {
    if (isWeekend && cigars >= 40){
        return true;
    }else if (!isWeekend && (cigars >=40 && cigars <= 60)){
        return true;
    } else {
        return false;
    }
  }
// 8. **fizzBuzz** Because you know you can't live without it, FizzBuzz.


// 		fizzBuzz(3) → "Fizz"
// 		fizzBuzz(1) → 1
// 		fizzBuzz(10) → "Buzz"
// 		fizzBuzz(15) → "FizzBuzz"
// 		fizzBuzz(8) → 8

function fizzBuzz(nums) {
    if ((nums % 3 === 0) && (nums % 5 === 0)) {
        return "FizzBuzz";
    } else if (nums % 3 === 0) {
        return "Fizz";
    } else if (nums % 5 === 0) {
        return "Buzz";

    } else {
        return nums;
    }

}
// 9. **filterEvens** Write a function that filters an array to only include even numbers.

// 	```
// 	filterEvens([]) → []
// 	filterEvens([1, 3, 5]) → []
// 	filterEvens([2, 4, 6]) → [2, 4, 6]
//     filterEvens([100, 8, 21, 24, 62, 9, 7]) → [100, 8, 24, 62]


    
    // // 10. **filterBigNumbers** Write a function that filters numbers greater than or equal to 100.

	// // ```
	// // filterBigNumbers([7, 10, 121, 100, 24, 162, 200]) → [121, 100, 162, 200]
	// // filterBigNumbers([3, 2, 7, 1, -100, -120]) → []
	// // filterBigNumbers([]) → []
	// // ```
       
function filterBigNumbers(x){
    var big = [];
    for( var i = 0; i < x.length; i++) {//  for every element i loops through size of array 
        if( x[i] >= 100 ) {           //  gets postition i and only return numbers not modulus 2 
                big.push(x[i]); //add odd number to array
        }
    } 
    return big;
}  
