/* Rexx Exec to pull student repos */
Say "Hi Frank"
cohortNumber=13
path='/Users/frankfella/Cohort-Stuff/Cohort-'cohortNumber'/StudentRepos/'
repoFile = path||'studentRepo'||cohortNumber'.txt'
repoFile = 'new.txt'
say 'Using repo file:' repoFile
/*trace i*/
do while lines(repoFile) > 0
/* trace i */
    lineIn = linein(repoFile) 
    say lineIn
   /* parse var lineIn repoName  .
    say 'Pulling from 'repoName '-------------------------------------------'
    'cd  'path'/'repoName '&& git pull origin master'  
    */
end  

