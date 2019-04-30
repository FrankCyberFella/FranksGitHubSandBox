function sumDouble(a,b){
    if(a===b){
        return a*2+b*2;
    }
    return a+b;
}
function hasTeen(){
    for(let i=0;i<arguments.length;i++){
        if(arguments[i]>12&&arguments[i]<20){
            return true;
        }
    }
    return false;
}
function lastDigit(a, b){
    if(a%10==b%10){
        return true;
    }
    return false;
}
function seeColor(theString){
    if(theString.startsWith('red')){
        return "red";
    }
    if(theString.startsWith('blue')){
        return 'blue';
    }
    return '';
}
function oddOnly(intArray){
    return intArray.filter(isOdd);
}
function isOdd(a){
    return a%2==1;
}
function frontAgain(theString2){
    return theString2.substring(0,2)==theString2.substring(theString2.length-2,theString2.length);
}
function cigarParty(numCigars,isWeekend){
    return numCigars>=40&&(numCigars<=60||isWeekend);
}
function fizzBuzz(num){
    let returnValue=num;
    if(num%15==0){
        returnValue="FizzBuzz";
    } else if(num%5==0){
        returnValue="Buzz";
    } else if(num%3==0){
        returnValue="Fizz";
    }
    return returnValue;
}
function filterEvens(intArray){
    return intArray.filter(isEven);
}
function isEven(a){
    return a%2==0;
}
function isGreaterThan100(a){
    return a>=100;
}
function filterBigNumbers(intArray){
    return intArray.filter(isGreaterThan100);
}

function filterMultiplesOfX(intArray,X){
    return intArray.filter(num=>num%X==0);
}
function createObject(){
    let objCreated={firstName:"Jason",
                    lastName:"Lawrie",
                    age:32}
    return objCreated;
}