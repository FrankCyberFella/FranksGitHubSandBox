function sumDouble(x, y) {
    if (x===y) {
        return 2*(x+y);
    }
    return x + y;
}

function hasTeen(x, y, z) {
    if(x>=13 && x<=19) {
        return true;
    }
    if(y>=13 && y<=19) {
        return true;
    }
    if(z>=13 && z<=19) {
        return true;
    }
    return false;
}

function lastDigit(x, y) {
    if(x%10 === y%10) {
        return true;
    }
    return false;
}

function seeColor(x) {
    if(x.substring(0, 3) == 'red') {
        return 'red';
    }
    if(x.substring(0,4) == 'blue') {
        return 'blue';
    }
    return '';
}

function oddOnly(x) {
    let odd = [];
    for(let i=0; i<x.length; i++) {
        if(x[i]%2 != 0) {
            odd.push(x[i]);
        }
    }
    return odd;
}

function frontAgain(x) {
    if(x.substring(0,2) === x.substring(x.length-2)) {
        return true;
    }
    return false;
}

function cigarParty (x, y) {
    if (y==false) {
        if(x>=40 && x<=60) {
            return true;
        }
    }
    if(y==true) {
        if(x>=40) {
            return true;
        }
    }
    return false;
}

function fizzBuzz (x) {
    if(x%3 == 0 && x%5 == 0) {
        return 'FizzBuzz';
    }
    else if(x%3 == 0) {
        return 'Fizz';
    }
    else if(x%5 == 0) {
        return 'Buzz';
    }
    return x;
}

function filterEvens(x) {
    for(let i=0; i<x.length; i++) {
        if(x[i]%2 != 0) {
            x.splice(i,1);
            i--;
        }
    }
    return x;
}

function filterBigNumbers(x) {
    for(let i=0; i<x.length; i++) {
        if(x[i] < 100) {
            x.splice(i,1);
            i--;
        }
    }
    return x;
}

function filterMultiplesOfX (w, x) {
    let multiples = [];
    for(let i=0; i<w.length; i++) {
        if(w[i]%x==0) {
            multiples.push(w[i]);
        }
    }
    return multiples;
}

function createObject() {
    const i = {
        firstName: 'Cyrus',
        lastName: 'Fiete',
        age: '27'
    }
    return i;
}