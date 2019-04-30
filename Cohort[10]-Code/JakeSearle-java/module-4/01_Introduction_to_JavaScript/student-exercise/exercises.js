//1
function sumDouble(x, y) {
    if(x === y) {
        return (x + y) * 2;
    }
    else {
        return x + y;
    }
}
//2 
function hasTeen(a, b, c) {
    if (a >= 13 && a <= 19 || b >= 13 && b <= 19 || c >= 13 && c <= 19) {
        return true;
    }
    else {
        return false;
    }
}
//3
function lastDigit(x, y) {
    if (x % 10 === y % 10) {
        return true;
    }
    else {
        return false;
    }
}
//4
function seeColor(string) {
    if (string.substring(0, 3) === "red") {
        return "red";
    }
    else if (string.substring(0, 4) === "blue") {
        return "blue";
    }
    else {
        return "";
    }

}
//5
function oddOnly(numsArray) {
    let nums = [];
    for (let int, i = 0; i < numsArray.length; i++) {
        if(numsArray[i] % 2 != 0) {
            nums.push(numsArray[i]);
        }
    }
    return nums;
}
//6 
function frontAgain(string) {
    if (string.length == 2) {
        return true;
    }
    else if (string.substring(0,2) === string.substring(string.length - 2, string.length)) {
        return true;
    }
    else {
        return false;
    }
    
}
//7
function cigarParty(numberOfCigars, isWeekend) {
    if(numberOfCigars < 40 || numberOfCigars > 60 && isWeekend == false) {
        return false;
    }
    else if (numberOfCigars > 40 && numberOfCigars < 60 && isWeekend == false) {
            return true;
        }
    
    else if (numberOfCigars > 60 && isWeekend == true) {
            return true;
        }
    else if (numberOfCigars == 40) {
        return true;
    }
    else if( numberOfCigars == 60) {
        return true;
    }
    
    else {
        return false;
    }
}
//8
function fizzBuzz(num) {
    if (num % 3 == 0 && num % 5 == 0) {
        return "FizzBuzz";
    }
    else if (num % 5 == 0) {
        return "Buzz";
    }
    else if (num % 3 == 0){
        return "Fizz";
    }
    else {
        return num;
    }
}
//9
function filterEvens(numsArray) {
    let nums = [];
    for (let int, i = 0; i < numsArray.length; i++) {
        if(numsArray[i] % 2 == 0) {
            nums.push(numsArray[i]);
        }
    }
    return nums;
}
//10
function filterBigNumbers(numsArray) {
    let nums = [];
    for (let int, i = 0; i < numsArray.length; i++) {
        if(numsArray[i] >= 100) {
            nums.push(numsArray[i]);
        }
    }
    return nums;
}
//11
function filterMultiplesOfX(numsArray, x) {
    let nums = [];
    for (let int, i = 0; i < numsArray.length; i++) {
        if(numsArray[i] % x == 0) {
            nums.push(numsArray[i]);
        }
    }
    return nums;
}
//12
function createObject() {




    
}