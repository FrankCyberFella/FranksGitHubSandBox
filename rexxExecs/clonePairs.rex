/* Rexx Exec to pull student repos */
Say 'Cohort Number'
pull cohortNum .
Say 'Enter Week Number'
pull weekNum .
say '-----------------------------------------------------------------------------'
path='~/Cohort-Stuff/Cohort-'CohortNum'/Pairs-Exercises/Week-'weekNum     

do i=0 to 8  
    repoPath = path||i
    say 'Cloning te-cle-cohort-'CohortNum'/java-week-'weeknum'-exercise-pair-team-'i
    'git clone https://FrankFella@bitbucket.org/te-cle-cohort-'CohortNum'/java-week-'weeknum'-exercise-pair-team-'i'.git'  
say '-----------------------------------------------------------------------------'
end  
