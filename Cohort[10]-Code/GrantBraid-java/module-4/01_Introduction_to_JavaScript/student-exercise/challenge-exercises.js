function iqTest(x) {
    if (x.length == 0){
        return 0;
    }
    let result = x.split(" ");
    let test = [];
    let countE = 0;
    let countO = 0;
    for (let i = 0; i < result.length; i++) {
        if (result[i] %2 == 0) {
            countE += 1;

        }
        if (result[i] % 2 == 1) {
            countO += 1;
        }
    }
    let tester = true;
    if (countE == 0 || countO == 0) {
        return 0;
    }
    if (countE <= countO) {
        tester = false;
    }
    let counter = 1;
    for (let i = 0 ; i < result.length; i++) {
        if (tester == true && result[i] %2 == 1){
            return counter;
        } else if (tester == false && result[i] % 2 == 0){
            return counter;
        }

        counter++;
    }
    return 0;
}

function titleCase(x,y) {
    if (!y) {
        x = x.toLowerCase();
        let re = x.split(" ");
        let theResult = re[0].substr(0,1).toUpperCase() + re[0].substring(1);
        for (let i = 1; i < re.length; i++) {
            theResult += " " + re[i].substr(0,1).toUpperCase() + re[i].substring(1);
        }
        console.log(theResult);
        return theResult;
    } 
        x = x.toLowerCase();
    y = y.toLowerCase();
    let resultTitle = x.split(" ");
    let resultLower = y.split(" ");
    
    

    for (let i = 0; i < resultTitle.length; i++) {
        
        resultTitle[i] = resultTitle[i].substr(0,1).toUpperCase() + resultTitle[i].substring(1);
        

        for (let j = 0; j < resultLower.length; j++){
            if (resultTitle[i].toLowerCase() == resultLower[j] && i > 0){
                resultTitle[i] = resultTitle[i].substr(0,1).toLowerCase() + resultTitle[i].substring(1);
            }
        }
       
    }
    let result = resultTitle[0];
    for (let i = 1; i < resultTitle.length; i++) {
        result += " " + resultTitle[i];
        console.log(result);
    }
    return result;
}