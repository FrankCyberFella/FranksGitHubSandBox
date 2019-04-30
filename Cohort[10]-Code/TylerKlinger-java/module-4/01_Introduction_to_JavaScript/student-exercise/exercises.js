function sumDouble(a, b) {
  
    if (a == b) {
      return (a + b) * 2;  
    }
    else {
    console.log('a + b equals ${a + b}');
    return a + b;
    }
}

function hasTeen(c, d, e) {
    if ((c <= 19 && c >= 13) || (d <=19 && d >= 13) || (e <=19 && e >= 13)) {
        return true;
    }
    else {
        return false;
    }
}

function lastDigit (f, g) {
    if (f % 10 == g % 10) {
        return true;
    }
    else {
        return false;
    }
}

function seeColor (h) {
    if (h.startsWith('red')) {
        return 'red';
    }
    else if (h.startsWith('blue')) {
        return 'blue';
    }
    else {
        return '';//space counts as a character; no space
    }
}

function oddOnly (i) {
    let array = [];
    for (let j = 0; j < i.length; j++) {
        if (i[j] % 2 == 1) {
            array.push(i[j]);
        }
    }
    return array;
}

function frontAgain (k) {
    if ((k.substring(0,2)) == (k.substring(k.length-2))) {
        return true;
    }
        return false;
}

function cigarParty (l, m) {
    if ((m === false) && ((l >= 40) && (l <= 60))) {
        return true;
    }
    if ((m === true) && (l >= 40)) { 
        return true;
    }
    return false;
}

function fizzBuzz (n) {
    if ((n % 3 == 0) && (n % 5 == 0)) {
        return "FizzBuzz";
    }
    else if (n % 3 == 0) {
        return "Fizz";
    }
    else if (n % 5 == 0) {
        return "Buzz";
    }
    return n;
}

