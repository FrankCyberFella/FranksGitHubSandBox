/**
 * Takes a number array and multiplier and return a new array where
 * the elements of the result are the original elements multiplied by
 * the multiplier.
 * 
 * @param {number[]} arrayOfNumbers a collection of numbers to multiply
 * @param {*number} multiplier what to multiply the array elements by
 * @returns {number[]} resultant array of the multiplication   
 */
function multiplyEverything(arrayOfNumbers, multiplier) {
    return arrayOfNumbers.map(
        (element) => {
            return element * multiplier;
        }
    );
}


multiplyEverything([1,2,3], 5);


