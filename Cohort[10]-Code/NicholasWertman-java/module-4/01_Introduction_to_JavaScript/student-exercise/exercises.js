function sumDouble(x, y){
    let sum=0;
    if(x==y) {
        sum = (x+y) * 2;
        return sum;
    }
            sum = x +y;
            return sum;
            }

function hasTeen(x, y, z) {
    if(x > 12 && x < 20|| y > 12 && y< 20 || z > 12 && z < 20) {
        return true;
    }
        return false;
}

function lastDigit(x, y){
    if(x%10=== y%10) {
        return true;
    }
        return false;
} // tried lastDigit and it didn't work

function seeColor(color){
    if(color.substring(0,3)=='red'){
        return 'red';
    }
    else {
        if(color.substring(0,4)=='blue'){
            return 'blue';
        }
    }
   return "";
}

function oddOnly(oddArray = []) {
    let num = [];
    let holder;
    for(let i=0;i<oddArray.length;i++){
        if(oddArray[i] % 2 != 0) {
            holder = oddArray[i];
            num.push(holder);
        }
    }
    return num;
}

function frontAgain(word){
    if(word.slice(0,2)==word.slice(word.length-2,word.length)){
    return true;}
    return false;
}
        
function cigarParty(cigars,weekend){
    if(cigars> 40 && weekend == true) {
        return true;}
    else{
        if(cigars >= 40 && cigars<=60 && weekend==false){
            return true;}
        }
        return false;
}

function fizzBuzz(number){
if(number%15==0){
    return 'FizzBuzz';
}
else if (number%5==0){
    return 'Buzz';
}
else if (number%3==0){
    return 'Fizz';
}
return number;
}

function filterEvens(wholeArray = []) {
evenArray = [];
for(let i=0; i<wholeArray.length;i++) {
    if(wholeArray[i]%2==0){
        evenArray.push(wholeArray[i])
    }
}
return evenArray;
}

function filterBigNumbers(wholeArray = []){
filteredArray = [];
for(let i=0;i<wholeArray.length;i++) {
    if(wholeArray[i]>=100){
        filteredArray.push(wholeArray[i])
    }
}
return filteredArray;
}

function filterMultiplesOfX(wholeArray=[],x){
    filteredArray =[];
    for(let i=0;i<wholeArray.length;i++){
        if(wholeArray[i]%x==0){
            filteredArray.push(wholeArray[i]);
        }
    }
    return filteredArray;
}

function createObject(){
const object = {firstName:'Nick',lastName:'Wertman',age:24};
return object;
}
