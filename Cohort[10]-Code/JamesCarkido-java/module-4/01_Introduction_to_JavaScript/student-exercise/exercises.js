function sumDouble(int1, int2){
    if(int1 === int2) {
        return (int1 + int2)*2;
    }else{
        return int1 + int2;
    }  
}

function hasTeen(int1, int2, int3) {
    if((int1 <= 19 && int1 >=13) ||(int2 <= 19 && int2 >=13) || (int3 <= 19 && int3 >= 13)){
        return true;
    }else{
        return false;
    }
}

function lastDigit(int1, int2){
    let a = int1 % 10;
    let b = int2 % 10;
    if(a === b){
        return true;
    }else{
        return false;
    }
}

function seeColor(str){
    if(str.substr(0,3) === 'red' || str.substr(str.length-4,3) === 'red'){
        return 'red';
    }else{
        if(str.substr(0,4) === 'blue'|| str.substr(str.length-5,4) === 'blue'){
        return 'blue';
        }else{
            return '';
        }
    }
}

function oddOnly(intArray){
    let odds =[];
    for(let i=0; i<intArray.length; i++){
        if(intArray[i] % 2 === 1){
            odds.push(intArray[i]);
        }
    }
    return odds;
}

function frontAgain(str){
    if(str.substr(0,2)=== str.substr(str.length-2,2)){
        return true;
    }else{
        return false;
    }
}

function cigarParty(numCigars, isWeekend){
    if(!isWeekend && numCigars >= 40 && numCigars <= 60){
        return true;
    }else{
        if(isWeekend && numCigars >= 40){
            return true;
        }else{
            return false;
        }
    }
}

function fizzBuzz(num){
    if(num % 3 === 0 && num % 5 === 0){
        return 'FizzBuzz';
    }else{
        if(num % 5 === 0){
            return 'Buzz';
        }else{
            if(num % 3 === 0){
                return 'Fizz';
            }else{
                return num;
            }
        }
    }
}
function filterEvens(intArray){
    let evens =[];
    for(let i=0; i<intArray.length; i++){
        if(intArray[i] % 2 === 0){
            evens.push(intArray[i]);
        }
    }
    return evens;
}

function filterBigNumbers(intArray){
    let biggerThan100 = [];
    for(let i=0;i<intArray.length;i++){
        if(intArray[i] >= 100){
            biggerThan100.push(intArray[i]);
        }
    }
    return biggerThan100;
}

function filterMultiplesOfX(intArray, x){
    let multiplesOfX = [];
    for(let i=0; i<intArray.length;i++){
        if (intArray[i] % x === 0){
            multiplesOfX.push(intArray[i]);
        }
    }
    return multiplesOfX;
}

function createObject(){
    const person = {
        firstName: 'Lex',
        lastName: 'Carkido',
        age: 31
    };
    return person;
}