function sumDouble(x, y) {
    // do logic here
    
    let result = x + y;
    if(x===y){
        result=result*2;
    }
     return result;
  }

function hasTeen(x, y, z){
    if(x>=13 && x<=19){
        return true;
    }
    if(y>=13 && y<=19){
        return true;
    }
    if(z>=13 && z<=19){
        return true;
    }
    return false;
}

function lastDigit(x, y) {
    if(x%10 === y%10){
        return true;
    }
    return false;
}

function seeColor(s1){
    if(s1.startsWith('red')){
        return 'red';
    } 
    if(s1.startsWith('blue')){
        return 'blue';
    } 
    return "";
}

function oddOnly (myArray) {
    let resultArray = [];
    myArray.forEach(element => {
        if(element % 2==1){
            resultArray.push(element)
        }
    });
    return resultArray;
}
 
function frontAgain (word) {
    const lastTwo = word.substring(word.length-2);
    const firstTwo = word.substring(0, 2);
    return firstTwo === lastTwo;
}

function cigarParty (numCigar, isWeekend){
    if(isWeekend){
        if(numCigar >= 40){
            return true;
        }else{
            return false;
        }
    }else{
        if(numCigar >= 40 && numCigar <= 60){
            return true;
        }else{
            return false;
        }
    }
    
}    