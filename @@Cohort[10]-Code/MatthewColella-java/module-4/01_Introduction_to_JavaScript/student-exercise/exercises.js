//1
		function sumDouble(x, y) {
			if(x==y){
                return (x+y)*2;
            }
			else return x + y;
        }

//2
        function hasTeen(x, y, z){
            if((x >= 13 && x<=19) || (y >= 13 && y<=19) || (z >= 13 && z<=19)){
                return true;
            }
            else return false;
        }
//3    
         function lastDigit(x, y){
         if(x % 10 == y % 10){
             return true;
         }
         else return false;
         }
//4
         function seeColor(color){
             if(color.substr(0, 4) == 'blue'){
                 return color.substr(0,4);
             }
             if(color.substr(0, 3) == 'red'){
                return color.substr(0,3);
            }
            else return '';
            }
//5
         function oddOnly(nums){
             let oddNums = [];
             for(let i = 0; i < nums.length; i++){
                 if(nums[i] % 2 == 1){
                     oddNums.push(nums[i])
                 }
             }
             return oddNums;
         }
//6
         function frontAgain(word){
             if(word.substr(0 , 2) == word.substr(word.length - 2, 2)){
                 return true;
             }
             else return false;
         }
//7
         function cigarParty(cigars, weekend){
             if (weekend == false){
                 if(cigars >= 40 && cigars <= 60){
                     return true;
                 }
                 else return false;
             }
             if(weekend == true){
                 if(cigars >= 40){
                     return true;
                 }
                 else return false;
             }
         }
//12
         function createObject(){
             me = {
                 firstName : 'Matt',
                 lastName: 'Colella',
                 age : 22

             }
             return me;
         }

