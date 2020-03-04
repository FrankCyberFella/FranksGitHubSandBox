/* Rexx Exec to pull student repos */
Say 'Cohort Number'
pull cohortNum .
/**Say 'Enter Week Number'
pull weekNum .
*/
Say 'Enter Module Number'
pull modNum .
say '-----------------------------------------------------------------------------'
/*path='~/Cohort-Stuff/Cohort-'CohortNum'/Capstones/module-'modNum'/java-module-'modNum'-capstone-team-'  */    

do i=0 to 8  
/*    repoPath = path||i */
/*    say 'Cloning from 'repoPath  */
    'git clone https://FrankFella@bitbucket.org/te-cle-cohort-'cohortNum'/java-module-'modNum'-capstone-team-'i'.git'  
end  
say '-----------------------------------------------------------------------------'
