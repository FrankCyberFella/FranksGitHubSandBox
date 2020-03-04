/* THIS REXX EXEC MUCT BE RUN USING THE REGINA COMMAND */
/* IN ORDER TO ACCESS UTILITY COMMANDS e.g. RegStemRead()*/

Call rxFuncAdd 'SysLoadFuncs', 'rexxutil', 'sysloadfuncs' 
call 'SysLoadFuncs'
rc = sysloadfuncs()
filePath='/Users/frankfella/BitBucketRepos/cyberginzo/rexxExecs/file1.txt'
rc = RegStemRead(filePath, repos)
say 'Num Stem Vars: 'repos.0
do i=1 to repos.0
say repos.i
out = lineout(GinzoFileOut.txt,repos.i) 
end