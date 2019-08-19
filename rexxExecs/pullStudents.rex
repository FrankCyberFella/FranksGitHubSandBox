/* Rexx Exec to pull student repos */
Say 'Enter Cohort Number'
pull cohortNumber ,

path='/Users/frankfella/Cohort-Stuff/Cohort-'cohortNumber'/studentRepos/'
repoFile = path||'studentRepos'||cohortNumber'.txt'
say 'Using repo file:' repoFile
do while lines(repoFile) > 0
trace off
    lineIn = linein(repoFile) 
    parse var lineIn repoName  .
    say 'Pulling from 'repoName '-------------------------------------------'
    'cd  'path'/'repoName '&& git pull origin master'  
end  

