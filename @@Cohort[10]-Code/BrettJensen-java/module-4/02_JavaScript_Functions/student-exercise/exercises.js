/**********************************************************
 * STUDENT EXERCISE
 **********************************************************/
/*
 * Document this function 
 */
/**
 * Takes in a month, day, and hemisphere and
 * returns boolean if it is summer in that hemisphere
 * 
 *   *month
 *   *day (optional)
 *   *hemisphere (optional)
 * 
 * Will return NaN if exactly two numbers are not
 * given.
 * 
 * @param {number} month number to represent month
 * @param {number} [day=1] number to represent day of month
 * @param {string} [hemisphere='northern'] string to represent the hemisphere
 * @returns {boolean} if it summer for that hemisphere at that time of the year
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
 function isAdmitted(gpa, satScore = 0, recommendation = false){
  let gpaAndRec = (gpa > 3.0) && recommendation;
  let satAndRec = (satScore > 1200) && recommendation;
  if(gpa > 4.0 || satScore > 1300 || gpaAndRec || satAndRec){
    return true;
  }
  return false;
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
  return unfilteredArray.filter(filterFunction);
}

/**
 * Write a function called makeNumber to take two strings
 * of digits, concatenate them together, and then return
 * the value back as a number.
 *
 * So if two strings are passed in "42293" and "443", then this function
 * should return the number 42293443.
 *
 * @param {string} first the first string of digits to concatenate
 * @param {string} [second=''] the second string of digits to concatenate
 * @returns {number} the resultant number
 */
function makeNumber(first, second=''){
  return parseInt(first + second);
}
/**
 * Write a function that takes an unknown number of parameters
 * and adds them all together. Return the result.
 *
 * @param {...number} num a series of numbers to add together
 * @returns {number} the sum of all the parameters (or arguments)
 */
function addAll(){
  results = 0;
  for(let i = 0; i < arguments.length; i++){
    results += arguments[i];
  }
  return results;
}
/*
 * Write and document a function called makeHappy that takes
 * an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array. Use the `map` function.
 */

 /**
 * 
 * Takes an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array.
 * 
 *   *arrayOfWords
 * 
 * @param {array} anArray array of strings
 * @returns {array} of new strings
 */
function makeHappy(anArray){
  return anArray.map((word) => {
    return 'Happy ' + word;
  })
}
/**
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
 * 
 * @param {array} anArray of associative arrays
 * @returns {array} newArray of strings
 */
function getFullAddressesOfProperties(anArray){
return anArray.map((address) => {
  return address.streetNumber + ' ' + address.streetName + ' ' + address.streetType + ' ' + address.city + ' ' + address.state + ' ' + address.zip;
});
}
/*
 * Create and document a function called findLargest.
 *
 * Using `forEach`, find the largest element in an array.
 * It should work for strings and numbers.
 */
/**
 * @param {array} anArray of data
 * @returns {data} largest
 */
function findLargest(anArray){
  let largestValue = null;
  anArray.forEach((value) => {
    if(typeof value == 'number'){
      if(largestValue == null || value > largestValue){
        largestValue = value;
      }
    } else {
      if(largestValue == null || value.charAt(0) > largestValue.charAt(0)){
        largestValue = value;
      }
    }
  });
  return largestValue;
  
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

/**
 * 
 * @param {array} arr as an array of arrays
 * @returns {number} as sum of arrays
 */

// cannot use 'reduce' call until I understand it better
function getSumOfSubArrayValues(arr=0){
let total = 0;
if(arr == 0){
  return total;
}
arr.forEach((subArray) => {
  subArray.forEach((number) => {
    total += number;
  });
});
  return total;
}