/**********************************************************
 * STUDENT EXERCISE
 **********************************************************/
/*
 * Document this function
 */
/**
 * takes a month, day, and hemisphere and returns 
 * whether it is summer
 * @param {number} month takes any integer expects a 1-12
 * @param {number} day takes any integer and defaults to 1
 * @param {string} hemisphere takes 'northern' or 'southern'
 * @returns {boolean} true if summer
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
function isAdmitted(gpa, satScore=0,recommendation=false){
  return gpa>4||satScore>1300||gpa>3&&recommendation||satScore>1200&&recommendation;


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
 * should return thnumber 42293443.
 *
 * @param {string} first the first string of digits to concatenate
 * @param {string} [second=''] the second string of digits to concatenate
 * @returns {number} the resultant number
 */
function makeNumber(first,second=''){
  return Number.parseInt(first.concat(second));
}
/**
 * Write a function that takes an unknown number of parameters
 * and adds them all together. Return the result.
 *
 * @param {...number} num a series of numbers to add together
 * @returns {number} the sum of all the parameters (or arguments)
 */
function addAll(...num){
  return num.length>0? num.reduce((sum,n)=>sum+n):0;
}
/*
 * Write and document a function called makeHappy that takes
 * an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array. Use the `map` function.
 */
function makeHappy(strArray){
  return strArray.map((happy)=>'Happy '.concat(happy));
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
function getFullAddressesOfProperties(setOfAddresses){
  return setOfAddresses.map((address)=>address.streetNumber+" "+
                                      address.streetName+" "+address.streetType+
                                      " "+address.city+" "+address.state+" "+address.zip);
}
/*
 * Create and document a function called findLargest.
 *
 * Using `forEach`, find the largest element in an array.
 * It should work for strings and numbers.
 */
function findLargest(theArray){
  //return numArray.reduce((max,comparer)=>max>comparer?max:comparer);
  let theMax;
  if(theArray.length>0){
    theMax=theArray[0];
  }
  
  theArray.forEach((element)=>{
    if(element>theMax){
      theMax=element;
    }
  });
  return theMax;
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
function getSumOfSubArrayValues(nestedArray){
  if(!nestedArray) return 0;
  if(nestedArray.length>0){
    nestedArray.unshift([0]);
    return nestedArray.reduce((sum,elemArray)=>Number.parseInt(sum)+Number.parseInt(elemArray.reduce((sum2,elem)=>sum2+elem)));
    // return nestedArray.reduce((sum,elemArray)=>{
    //   if(sum=Number.parseInt(sum)){
    //     return sum.reduce((sum2,elem)=>sum2+elem)+elemArray.reduce((sum2,elem)=>sum2+elem);
    //   } else{
    //     return sum+elemArray.reduce((sum2,elem)=>sum2+elem);
    //   }
    // })
  } else{
    return 0;
  }
  
}