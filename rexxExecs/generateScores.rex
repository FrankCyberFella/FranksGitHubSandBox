/* THIS REXX EXEC MUCT BE RUN USING THE REGINA COMMAND */
/* IN ORDER TO ACCESS UTILITY COMMANDS e.g. RegStemRead()*/

/* Call rxFuncAdd 'SysLoadFuncs', 'rexxutil', 'sysloadfuncs' 
call 'SysLoadFuncs'
rc = sysloadfuncs()
*/
outputFileName = 'BowlingScoresOut.txt'

rm outputfilename

maxDates=26
maxTeams=5
maxPlayers=4
maxGames=3

hiScore=300
loScore=30
do numDates = 1 to maxDates
    month = random(1,12)
    if length(month) < 2 then month = '0'month
    day   = random(1,28)
    if length(day) < 2   then day   = '0'day
    date = 2019'-'month'-'day
    do team=2 to maxTeams
        if team = 2 then do
                            startPlayer = 1
                            endPlayer   = 4
                         end  
        if team = 3 then do
                            startPlayer = 5
                            endPlayer   = 8
                         end     
        if team = 4 then do
                            startPlayer = 13
                            endPlayer   = 16
                         end 
        if team = 5 then do
                            startPlayer = 9
                            endPlayer   = 12
                         end                 
        do player=startPlayer to endPlayer
       
            do numScores=1 to maxGames
                num = random(loScore,hiScore) 
                outputLine= date team player num
                out = lineout(outputFileName,outputLine)                                   
            end
        end
    end
end
exit