select gip.gameid, p.name, '$' || go.amount as amount, go.type, go.name, gip.survivor, sv.name 
from gamesinplay GIP
     inner join
     players  P
on GIP.playerid = P.playerid
     inner join
     games gm
on GIP.gameid = gm.gameid
     inner join
     gameoptions go
 on  gm.gameoptionid = go.gameoptionid
     inner join
     survivors  sv
 on  gip.survivor = sv.survivorid
     
     
;