/* Rexx Exec to pull student repos */
path='~/Cohort-Stuff/Cohort-11/studentRepos'
do while lines(studentRepos.txt) > 0  
    lineIn = linein(studentRepos.txt) 
    parse var lineIn repoName  .
    say 'Pulling from 'repoName '-----------------------'
    'cd  'path'/'repoName '&& git pull origin master'  
end  
