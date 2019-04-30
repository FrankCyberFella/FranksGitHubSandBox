

		function sumDouble(x, y) {
			if(x === y){
                return 2 * (x+y);
            }
			return x + y;
        }
        
        
        function hasTeen(num1, num2, num3){
             if(num1 >= 13 && num1<= 19){
                return true;
            } else {
                if(num2 >= 13 && num2<= 19){
                    return true
                } else {
                    if(num3 >= 13 && num3<= 19){
                        return true;
                    }
                }  return false;
            }
         }


        function lastDigit(num1 , num2){
            let lastCharNum1 = String(num1);
            lastCharNum1 = lastCharNum1.charAt(lastCharNum1.length-1);
            console.log(lastCharNum1);
            let lastCharNum2 = String(num2);
            lastCharNum2 = lastCharNum2.charAt(lastCharNum2.length-1);
            console.log(lastCharNum2);
            if(lastCharNum1 === lastCharNum2){
                return true;
            } return false;
        }
        
       
        function seeColor(color){
            let answer = "";
            if(color.substring(0,3) === "red"){
                answer += "red";
            } else {
                if(color.substring(0,4) === "blue"){
                    answer += "blue";
                }
            }return answer;
        }


        
        function oddOnly(numArray){
           if(numArray.length === 0){
               return numArray;
           }
           let odds  = numArray.filter((num) => {
               return num % 2 === 1;
           });
           return odds;
        }

       
        
        function frontAgain(string){
            let first2 = string.substring(0, 2);
            let last2 = string.substring(string.length-2, string.length);   
            if(first2 === last2){
                return true;
            } 
            return false;
        }

        // 7. **cigarParty** When squirrels get together for a party, they like to have cigars. 
        // A squirrel party is successful when the number of cigars is between 40 and 60,
        //  inclusive. Unless it is the weekend, in which case there is no upper bound on the 
        //  number of cigars. Write a squirrel party function that return true if the party with
        //   the given values is successful, or false otherwise.

		// cigarParty(30, false) → false
		// cigarParty(50, false) → true
        // cigarParty(70, true) → true
        
        function cigarParty(num, boolean){
            if((num >= 40 && num <= 60) && boolean === false){
                return true;
            } else {
                if((num >= 60) && boolean === true){
                    return true;
                } 
            } return false;
        }


        // 8. **fizzBuzz** Because you know you can't live without it, FizzBuzz.


		// fizzBuzz(3) → "Fizz"
		// fizzBuzz(1) → 1
		// fizzBuzz(10) → "Buzz"
		// fizzBuzz(15) → "FizzBuzz"
        // fizzBuzz(8) → 8
        
        function fizzBuzz(num){
            if((num % 3 === 0) && (num%5 === 0)){
                return "FizzBuzz";
            } else {
                if(num % 3 === 0){
                    return "Fizz";
                } else {
                    if(num % 5 === 0){
                        return "Buzz";
                    }
                }
            } return num;
        }


// 9. **filterEvens** Write a function that filters an array to only include even numbers.

// ```
// filterEvens([]) → []
// filterEvens([1, 3, 5]) → []
// filterEvens([2, 4, 6]) → [2, 4, 6]
// filterEvens([100, 8, 21, 24, 62, 9, 7]) → [100, 8, 24, 62]
// ```

        function filterEvens(numArray){
            if(numArray.length === 0){
                return numArray;
            }
            let answer = numArray.filter((num) => {
                return num % 2 === 0;
            });
            return answer;
        }


    // 10. **filterBigNumbers** Write a function that filters numbers greater than or equal to 100.

    //     ```
    //     filterBigNumbers([7, 10, 121, 100, 24, 162, 200]) → [121, 100, 162, 200]
    //     filterBigNumbers([3, 2, 7, 1, -100, -120]) → []
    //     filterBigNumbers([]) → []
    //     ```   
        
        function filterBigNumbers(numArray){
            let answer = numArray.filter((num) => {
                return num >= 100;
            });
            return answer;
        }


// 11. **filterMultiplesOfX** Write a function to filter numbers that are a multiple of a paremeter, `x` passed in.

// 	```
// 	filterMultiplesOfX([3, 5, 1, 9, 18, 21, 42, 67], 3) → [3, 9, 18, 21, 42]
// 	filterMultiplesOfX([3, 5, 10, 20, 18, 21, 42, 67], 5) → [5, 10, 20]
// 	``


        function filterMultiplesOfX(numArray, multiple){
            let answer = numArray.filter((num) => {
                return num % multiple === 0;
            });
            return answer;
        }

//  12. **createObject** Write a function that creates an object with a property 
//   called firstName, lastName, and age. Populate the properties with your values.

// 	```
// 	createObject() →

// 	{
// 		firstName,
// 		lastName,
// 		age
// 	}
// 	```
       
        function createObject(){
            let firstName = Sam;
            let lastName = Peters;
            let age = 18;

            return firstName + " " + lastName + " " + age;
        }   


function createObject() {
  const person = {
    firstName: "Sammy",
    lastName: "Davis Jr.",
    age: 32
  }
    return person;
};