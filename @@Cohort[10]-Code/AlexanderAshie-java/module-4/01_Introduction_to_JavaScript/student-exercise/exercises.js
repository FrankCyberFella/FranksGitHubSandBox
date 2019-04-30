function sumDouble(num1, num2) {

    if (num1 === num2) {
        return (num1 + num2) * 2;
    }
    
    else {
        return num1 + num2;

    }
}

function hasTeen(num1, num2, num3) {
    if ((num1 >= 13 && num1 <= 19) || (num2 >= 13 && num2 <= 19) || (num3 >= 13 && num3 <= 19)) {
        return true;
    }

    else {
        return false;
    }
}

function lastDigit(num1, num2) {

    if (num1 % 10 === num2 % 10) {
        return true;
    }

    else {
        return false;
    }

}

function seeColor(str) {
    if (str.substr(0, 3) == "red") {
        return "red";
    }

    else if (str.substr(0, 4) == "blue") {
        return "blue";
    }

    else {
        return "";
    }
}

function checkOdd(num) {

    if (num % 2 != 0) {
        return  num;
    }
}

function oddOnly(givenNums) {

    let newNums = givenNums.filter(checkOdd);
    
    return newNums;
}

function frontAgain(str) {
    if (str.substr(0,2) === str.substr(str.length - 2, str.length)) {
        return true;
    }

    else {
        return false;
    }
}

function createObject() {

    const Dog  = {
        firstName: "spot",
        lastName: "filo",
        age: 7
    }

    return Dog;
}

function checkEven(num) {

    if (num % 2 === 0) {
        return  num;
    }
}

function filterEvens(givenNums) {

    let newNums = givenNums.filter(checkEven);
    
    return newNums;
}