/* Rexx Exec to pull student repos */
Say 'Cohort Number'
pull cohortNum .
/**Say 'Enter Week Number'
pull weekNum .
*/
Say 'Enter Module Number'
pull modNum .
say '-----------------------------------------------------------------------------'
path='~/Cohort-Stuff/Cohort-'CohortNum'/Capstones/module-'modNum'/java-module-'modNum'-capstone-team-'      

do i=0 to 8  
    repoPath = path||i
    say 'Pulling from 'repoPath 
    'cd  'repoPath'&& git pull origin master'  
end  
say '-----------------------------------------------------------------------------'
