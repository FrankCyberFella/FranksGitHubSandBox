function sumDouble(n1, n2) {
    if (n1 === n2){
        return 2*(n1+n2)
    }
    return n1+n2;
}

function hasTeen(n1, n2,n3){
    if ((n1 >= 13 && n1 <= 19) || (n2 >= 13 && n2 <= 19) || (n3 >= 13 && n3 <= 19)){
        return true;
    }
    return false;
}

function lastDigit(n1,n2) {
    n1 = n1;
    n2 = n2;

    if (n1%10 == n2%10){
        return true;
    }
    return false;
}

function seeColor(color) {
    if (color.startsWith("blue")){
        return "blue";
    }
    if (color.startsWith("red")){
        return "red";
    }
    return "";
}

function oddOnly(x) {
    let result = [];
    for (let i = 0; i < x.length; i++){
        if (x[i]%2 == 1){
            result.push(x[i]);
        }
    }

    return result;
}

function frontAgain(x) {
    if (x.length < 2) {
        return false;
    }
    if (x.substr(0,2) == x.substring(x.length-2)){
        return true;
    }
    return false;
}

function cigarParty(x, y) {
    if (x >= 40){
        if (y == true || x <= 60) {
            return true;
        }
    }
    return false;
}

function fizzBuzz(x) {
    if (x % 3 == 0 && x % 5 == 0) {
        return "FizzBuzz";
    }
    if (x % 3 == 0) {
        return "Fizz";
    }
    if (x % 5 == 0 ){
        return "Buzz";
    }
    return x;
}

function filterEvens(x) {
    let result = [];
    for (let i = 0; i < x.length; i++){
        if (x[i] % 2 == 0) {
            result.push(x[i]);
        }
    }
    return result;
}

function filterBigNumbers(x) {
    let result = [];
    for (let i = 0; i < x.length; i++) {
        if (x[i] >= 100) {
            result.push(x[i]);
        }
    }
    return result;
}

function filterMultiplesOfX(y,x) {
    let result = [];
    for (let i = 0; i < y.length; i++) {
        if (y[i] % x == 0) {
            result.push(y[i]);
        }
    }
    return result;
}

function createObject() {
    const person = {
        firstName: "Grant",
        lastName: "Braid",
        age: 23
    };
    return person;
}