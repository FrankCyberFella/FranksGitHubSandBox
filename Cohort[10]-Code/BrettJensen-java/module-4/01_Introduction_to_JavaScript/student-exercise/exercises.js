function sumDouble(value1, value2){
    if(value1 == value2){
        return (value1 + value2) * 2;
    }
    return value1 + value2;
}

function hasTeen(value1, value2, value3){
    if(value1 > 12 && value1 < 20){
        return true;
    }
    if(value2 > 12 && value2 < 20){
        return true;
    }
    if(value3 > 12 && value3 < 20){
        return true;
    }

    return false;
}

function lastDigit(value1, value2){
    const lastDigitValue1 = value1.toString().split('').pop();
    const lastDigitValue2 = value2.toString().split('').pop();
    if(lastDigitValue1 === lastDigitValue2){
        return true;
    }
    return false;
}

function seeColor(colorString){
    if(colorString.substr(0,3) == "red"){
        return "red";
    }
    if(colorString.substr(0,4) == "blue"){
        return "blue";
    }
    return "";
}

function oddOnly(arr){
    let newArr = [];
    for(let i = 0; i < arr.length; i++){
        if(arr[i]%2 != 0){
            newArr.push(arr[i]);
        }
    }
    return newArr;
}

function frontAgain(word){
    if(word.length == 2){
        return true;
    }
    const firstTwo = word.substr(0,2);
    const lastTwo = word.substr(word.length-2, word.length-1);
    if(firstTwo == lastTwo){
        return true;
    }
    return false;
}

function cigarParty(cigars, isWeekend){
    if(cigars >= 40 && isWeekend){
        return true;
    }
    if(cigars >= 40 && cigars <= 60){
        return true;
    }
    return false;
}

function fizzBuzz(value){
    if(value%3==0 && value%5==0){
        return "FizzBuzz";
    }
    if(value%3==0){
        return "Fizz";
    }
    if(value%5==0){
        return "Buzz";
    }
    return value;
}

function filterEvens(arr){
    let newArr = [];
    for(let i = 0; i < arr.length; i++){
        if(arr[i]%2 == 0){
            newArr.push(arr[i]);
        }
    }
    return newArr;
}

function filterBigNumbers(arr){
    let newArr = [];
    for(let i = 0; i < arr.length; i++){
        if(arr[i] >= 100){
            newArr.push(arr[i]);
        }
    }
    return newArr;
}

function filterMultiplesOfX(arr, x){
    let newArr = [];
    for(let i = 0; i < arr.length; i++){
        if(arr[i]%x==0){
            newArr.push(arr[i]);
        }
    }
    return newArr;
}

function createObject(){  
    const person = {   
    firstName: "Brett", 
    lastName: "Jensen",
    age: 28
    }   
    return person;
}