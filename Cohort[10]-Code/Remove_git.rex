/* Rexx Program */
Say "Hello from Rexx"
/* Main program */ 
do while lines(Repos_10.txt) > 0  
line_str = linein(Repos_10.txt) 
parse var line_str w1 w2 w3 w4 w4 w6 .
/* say w1 is 'length ' length(w1) */
if (length(w1) > 0 & w1 \= "Java" & substr(w1,1,4) \= "2019") then do
                                                      'rm -rf 'w1'/.git'
                                                      say '--------------------------------------------'
                                                    end
end  