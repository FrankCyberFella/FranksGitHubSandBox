delete from casino_backup;

drop table if exists frank;

INSERT INTO CASINO_BACKUP
(SELECT * FROM CASINO)  
;

select * from casino_backup;

create table frank (like casino);

INSERT INTO frank
(SELECT * FROM CASINO)  
;
select * from frank;