function iqTest(stringNums){
    let outlier=0;
    let nums=stringNums.split(" ");
    let evensOdds = [0,0];
    nums.forEach(function(num,i){
        evensOdds[num%2]++;
        nums[i]=num%2;
    })

    if(evensOdds[0]==1&&evensOdds[1]>1){
        outlier= nums.indexOf(0)+1;
    } else if(evensOdds[1]==1&&evensOdds[0]>1){
        outlier= nums.indexOf(1)+1;
    }    
    return outlier;
}
function titleCase(toTitle,minorWords){
    if(minorWords==null){
        minorWords="";
    }
    let words=toTitle.split(" ");
    let newWords=[];
    for(let i=0;i<words.length;i++){
        if(minorWords.toLowerCase().includes(words[i].toLowerCase())&&i!=0){
            let word=words[i].toLowerCase()
            newWords.push(word);
        } else{
            let word=words[i].substring(0,1).toUpperCase()+words[i].substring(1,words[i].length).toLowerCase();
            newWords.push(word);
        }
    };
    newWords=newWords.join(" ");
    return newWords;
}
