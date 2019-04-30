function sumDouble(x, y) {
    if(x == y) {
        return (x +y) * 2;
    }
    return x + y;
}

function hasTeen(x, y ,z) {
    if((x >= 13 && x <= 19) || (y >= 13 && y <= 19) || (z >= 13 && z <= 19)) {
        return true;
    } else {
        return false;
    }
}

function lastDigit(x, y) {
   if(x.toString().slice(-1) == y.toString().slice(-1)){
       return true;
   } else{
       return false;
   }
}

function seeColor(x){
    if(x.substring(0, 3) == 'red'){
        return 'red';
    } else if(x.substring(0,4) == 'blue') {
        return 'blue';
    } else if(x.substring(0,6) == '') {
        return '';
    } else {
        return '';
    }
}

function oddOnly(arr) {
    let x = [];
    for(let i = 0; i < arr.length; i++){
        if(arr[i] % 2 == 1){
            x.push(arr[i]);
        }
    }  
    return x;
}

function frontAgain(str) {
    if(str.substring(0, 2) == str.substr(str.length-2)){
        return true;
    } else {
        return false;
    }
}

function cigarParty(x, y) {
    if( x >= 40 && y == true) {
        return true;
    } else if(x >= 40 && x <=60) {
        return true;
    } else {
        return false;
    }
}

function fizzBuzz(x) {
    if(x % 3 == 0 && x % 5 == 0) {
        return 'FizzBuzz';
    } else if(x % 5 == 0) {
        return 'Buzz';
    } else if(x % 3 == 0){
        return 'Fizz';
    } else {
        return x;
    }
}

function filterEvens(x) {
    let arr = [];
    for(let i = 0; i < x.length; i++){
        if(x[i] % 2 == 0){
            arr.push(x[i]);
        } 
    } 
    return arr;
}

function filterBigNumbers(x) {
    let arr = [];
    for(let i = 0; i < x.length; i++){
        if(x[i] >= 100){
            arr.push(x[i]);
        }
    }
    return arr;
}

function filterMultiplesOfX(arr, x){
    let y = [];
    for(let i = 0; i < arr.length; i++){
        if(arr[i] % x == 0){
            y.push(arr[i]);
        }
    }
    return y;
}

function createObject() {
    let person = {firstName: 'Alec', lastName: 'Petro', age: 26}
    return person;
}