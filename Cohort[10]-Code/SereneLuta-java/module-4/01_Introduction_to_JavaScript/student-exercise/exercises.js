function sumDouble(x, y) {
    if(x==y) {
        return (x + y) * 2
    }
    return x + y;
}

function hasTeen(x, y, z) {
    if((x >= 13  &&  x <= 19) || (y >= 13  &&  y <= 19) || (z >= 13  &&  z <= 19)) {
        return true;
    }
    return false;
}

function lastDigit(x,y) {
    if(x % 10 ==  y % 10) {
        return true;
    }
    return false;
}

function seeColor(x) {
    if(x.substring(0, 3 ) == 'red') {
        return 'red';
    }
    else {
        if(x.substring(0, 4) == 'blue') {
            return 'blue';
        }
        else{
            return '';
        }
    }
}

function oddOnly(x) {
    let odd = [];
    for (let i = 0; i < x.length; i++) {
        if(x[i] % 2 != 0) {
            odd.push(x[i]);
        } 
    }
        return odd;
}

function frontAgain(x) {
    if(x.substr(0,2) === x.substring(x.length-2, x.length)) {
        return true;
    }
    return false;
}

function cigarParty(x, isWeekend) {
    if((x <= 60 && x>= 40) && (isWeekend == false)) {
        return true;
    } else {
        if((x >= 40) && (isWeekend == true)) {
            return true;
        }
        return false;
    }
}

function fizzBuzz(x) {
    if(x % 3 == 0 && x % 5 == 0) {
        return 'FizzBuzz';
    } if(x % 5 == 0) {
            return 'Buzz';
    } if(x % 3 == 0) {
            return 'Fizz';
    }
    return x;
}

function filterEvens(x) {
    let evens = [];
    for (let i = 0; i < x.length; i++) {
        if(x[i] % 2 == 0) {
            evens.push(x[i]);
        } 
    }
        return evens;
}

function filterBigNumbers(x) {
    let bigNumbers = [];
    for (let i = 0; i < x.length; i++) {
        if(x[i] >= 100) {
            bigNumbers.push(x[i]);
        } 
    }
        return bigNumbers;
}


function filterMultiplesOfX(x,y) {
    let multiples = [];
    for (let i = 0; i < x.length; i++) {
        if(x[i] % y == 0) {
            multiples.push(x[i]);
        } 
    }
        return multiples;
}

function createObject(firstName, lastName, age) {
    const person = {
        firstName: "Serene",
        lastName: "Luta",
        age: 31
    }
       return person;

}