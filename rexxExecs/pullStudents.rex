/* Rexx Exec to pull student repos */
Say "Hi Frank"
Say 'Enter Cohort Number'
pull cohortNumber .
path='/Users/student/Cohort-Stuff/Cohort-'cohortNumber'/StudentRepos/'
repoFile = path||'studentRepo'||cohortNumber'.txt'
/* repoFile = path||'new.txt'
repoFile=new.txt */
say 'Using repo file:' repoFile
/*trace i*/
say 'Lines in 'repoFile' are 'lines(repoFile)
do while lines(repoFile) > 0
/* trace i */
    lineIn = linein(repoFile) 
    parse var lineIn repoName  .
    say 'Pulling from 'repoName '-------------------------------------------'
    'cd  'path'/'repoName '&& git pull origin master'  
end  

