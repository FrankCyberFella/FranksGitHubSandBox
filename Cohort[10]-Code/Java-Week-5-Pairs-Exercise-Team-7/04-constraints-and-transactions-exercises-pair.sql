-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)
Begin Transaction;
Insert into city (id, name,countrycode,district,population)
Values (5000,'Smallville','USA', 'Kansas', 45001);
Select * from city
Where district =  'Kansas'
;
-- Rollback ; 
commit;

-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.
Begin Transaction;
Insert into countrylanguage (countrycode,language, isofficial, percentage)
Values ('USA', 'Kryptonese', false, .0001);
Select * from countrylanguage
Where countrycode =  'USA'
;
---Rollback ; 
commit;
-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.
Begin Transaction;
update countrylanguage 
set language = 'Krypto-babble' Where language = 'Kryptonese';
Select * from countrylanguage
Where countrycode =  'USA'
;
--Rollback ; 
commit;
-- 4. Set the US captial to Smallville, Kansas in the country table.
Begin Transaction;
update country 
set capital = (select id from city where name = 'Smallville')
Where code = 'USA';
Select * from country
Where code =  'USA' 
;
commit ;

-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
Begin Transaction;
delete from city
where id = 5000;
select * from city where district = 'Kansas';
--Rollback;
commit;
-- no, Can not delete Smallville because you can not delete a parent that has dependents.

-- 6. Return the US captial to Washington.
Begin Transaction;
update country 
set capital = (select id from city where name = 'Washington')
Where code = 'USA';
Select * from country
Where code =  'USA' 
;
--Rollback;
commit;

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
Begin Transaction;
delete from city
where id = 5000;
select * from city where district = 'Kansas';
--Rollback;
commit;
--Yes! Capital is no longer tied to Smallville so we can delete the city without worring about orphan data. 

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)
Begin Transaction;
update countrylanguage
set isofficial = not isofficial
where countrycode in (select code from country where indepyear >= 1800 and indepyear <= 1972);
--Rollback;
commit;

-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)
Begin Transaction;
update city
set population = round(population / 1000)
where population is not null; 
select * from city where population is not null;
--Rollback;
commit;


-- 10. Assuming a country's surfacearea is expressed in miles, convert it to 
-- meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)
Begin Transaction;
update country 
set surfacearea = surfacearea *1609.34
where code in (select countrycode from countrylanguage where language = 'French' and percentage > 20); 
select * from country where name = 'France';
commit;