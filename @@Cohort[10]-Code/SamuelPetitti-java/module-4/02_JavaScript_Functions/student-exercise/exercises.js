/**********************************************************
 * STUDENT EXERCISE
 **********************************************************/
/*
 * Document this function
 */


/**
 * Checks to see if it is summer based on month, day and hemisphere
 * 
 * @param {string} month 
 * @param {number} [second Parameter = 1] 
 * @param {string} [third Parameter= northern] hemisphere 
 * @returns{boolean}
 */
function isSummer(month, day = 1, hemisphere = 'northern') {
  if (month === 7 || month === 8) {
    return hemisphere === 'northern';
  } else if (month === 6 && day >= 20) {
    return hemisphere === 'northern';
  } else if (month === 9 && day <= 20) {
    return hemisphere === 'northern';
  } else if (month === 1 || month === 2) {
    return hemisphere === 'southern';
  } else if (month === 12 && day >= 20) {
    return hemisphere === 'southern';
  } else if (month === 3 && day <= 20) {
    return hemisphere === 'southern';
  } else {
    return false;
  }
}

/**
 * Write a function called isAdmitted. It will check entrance
 * scores and return true if the students is admitted and
 * false if rejected. It takes three parameters:
 *
 *     * gpa
 *     * satScore (optional)
 *     * recommendation (optional)
 *
 * We admit them--return true--if:
 * gpa is above 4.0 OR
 * SAT score is above 1300 OR
 * gpa above 3.0 and they have a recommendation OR
 * SAT score is above 1200 and they have a recommendation
 * OTHERWISE reject it
 *
 * @param {number} gpa the GPA of the student, between 4.2 and 1.0
 * @param {number} [satScore=0] the student's SAT score
 * @param {boolean} [recommendation=false] does the student have a recommendation
 * @returns {boolean} true if they are admitted
 */

 function isAdmitted(gpa, satScore=0, recommendation= false){
     if((gpa > 4.0) || (satScore > 1300)){
       return true;
     } else {
       if((gpa > 3.0 && recommendation === true) ||
          (satScore > 1200 && recommendation === true)){
            return true;
          }
     } return false;
 }

/**
 * Write a function so that it takes an anonymous function and
 * uses that in `unfilteredArray` filter function. Return the result.
 *
 * @param {function} filterFunction the function to filter with
 * @returns {number[]} the filtered array
 */
let unfilteredArray = [1, 2, 3, 4, 5, 6];
function useParameterToFilterArray(filterFunction){
   return unfilteredArray.filter(filterFunction)
}

/**
 * Write a function called makeNumber to take two strings
 * of digits, concatenate them together, and then return
 * the value back as a number.
 *
 * So if two strings are passed in "42293" and "443", then this function
 * should return thnumber 42293443.
 *
 * @param {string} first first string of digits to concatenate
 * @param {string} [second='']  second string of digits to concatenate
 * @returns {number} the resultant number
 */
function makeNumber(first, second= ''){
  return parseInt(first+second);
}



/**
 * Write a function that takes an unknown number of parameters
 * and adds them all together. Return the result.
 *
 * @param {...number} num a series of numbers to add together
 * @returns {number} the sum of all the parameters (or arguments)
 */

function addAll(...num){
    if(arguments.length === 0){
      return 0;
    }
    return num.reduce((sum, num) => {
      return sum += num;
    });
  }
/*
 * Write and document a function called makeHappy that takes
 * an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array. Use the `map` function.
 */


/**
 *  attaches 'happy' to every index of the array
 * @param {String[]} array of Strings to concatenate to
 * @returns an array string
 */
function makeHappy(array){
   return array.map((element) => {
     return 'Happy '+ element;
   });
}




/*
 * Write and document a function called getFullAddressesOfProperties
 * that takes an array of associative arrays containing the
 * following keys:
 *     * streetNumber
 *     * streetName
 *     * streetType
 *     * city
 *     * state
 *     * zip
 *
 * and returns an array of strings that turns the associative array
 * into mailing addresses in the form of:
 *     streetNumber streetName streetType city state zip
 *
 * Use `map` and an anonymous function.
 */

 /**
  * 
  * takes an array of values relating to properties and returns full addresses
  * 
  * @param {[]properties} arrayOfProps an array of property objects
  * @returns an array of Strings  
  * 
  */
function getFullAddressesOfProperties(arrayOfProps){
   return arrayOfProps.map((element) => {
     return element.streetNumber + ' ' + element.streetName + ' ' +
            element.streetType + ' ' + element.city + ' ' +  element.state + ' ' + element.zip;
   });
}


/*
 * Create and document a function called findLargest.
 *
 * Using `forEach`, find the largest element in an array.
 * It should work for strings and numbers.
 */



 /**
  * 
  *  Find the largest element in the array(largest number, latest alphabetically)
  * 
  * @param {[]numbers or strings} array to find largest element of
  * @returns largest element in array
  * 
  */

// This was my original, worse solution :)

// function findLargest(array){
//   let numHolder = 0;
//   let stringHolder = 'a';
//   if(typeof(array[0]) === 'number'){
//     array.forEach((element) => {
//       if(element > numHolder){
//         numHolder = element;
//       }
//     });
//    return numHolder;
//   } else {
//       if(typeof(array[0]) === 'string'){
//       array.forEach((element) => {
//         if(element.charAt(0) >= stringHolder.charAt(0)){
//           stringHolder = element;
//         }
//       });
//       return stringHolder;
//     }
//   }
// }

function findLargest(array){
  let currentLargest = '';
  array.forEach((element) => {
    if(element > currentLargest){
      currentLargest = element;
    }
  });
  return currentLargest;
}


/*
 * CHALLENGE
 * Create and document a function called getSumOfSubArrayValues.
 *
 * Take an array of arrays and add up all sub values and return
 * the sum. For instance, if you got this array as a parameter:
 * [
 *   [1, 2, 3],
 *   [2, 4, 6],
 *   [5, 10, 15]
 * ];
 *
 * You would return 48. To do this, you will use two nested `reduce`
 * calls with two anonymous functions.
 *
 * Read the tests to verify you have the correct behavior.
 */

//  function getSumOfSubArrayValues(array){
//     return array.reduce((sum, element) => {
//         return sum.reduce((sum, num) => {
//         return sum + num;
//       });
//     });
//  }

function getSumOfSubArrayValues(array){
  
}