/* Rexx Exec to pull student repos */
Say 'Cohort Number'
pull cohortNum .
Say 'Enter Week Number'
pull weekNum .
say '-----------------------------------------------------------------------------'
path='~/Cohort-Stuff/Cohort-'CohortNum'/Pairs-Exercises/Week-'weekNum'/java-week-'weekNum'-exercise-pair-team-'      

do i=0 to 9  
    repoPath = path||i
    say 'Pulling from 'repoPath 
    'cd  'repoPath'&& git pull origin master'  
end  
say '-----------------------------------------------------------------------------'
