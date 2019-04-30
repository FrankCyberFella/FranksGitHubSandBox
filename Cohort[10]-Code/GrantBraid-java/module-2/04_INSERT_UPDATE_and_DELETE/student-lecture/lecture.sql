---------------------------------------------------------------------------------------------------------------------------------------
-- Referential Integrity - Enforcement of the Parent-Dependent relatiohnship
--                         ie. Ensure that every foreign key value has a matching primary key
--
-- Constraints are rules regarding the data that must be complied with:
--
--  NOT NULL - Column must have a value
--
--  UNIQUE   - Column value must be unique with the table 
--
--  PRIMARY KEY - Column is part of the unique identifier for a row in the table
--                UNIQUE and NOT NULL are implied
--
--  FOREIGN KEY - Column is part of a foreign key for the table.  
--                Value must have a matching value in the primary key of the parent table
--                Establishes the parent-dependent relationship
--
--  CHECK  -  Specifies acceptable values for a column - any simple WHERE predicate is allowed
--
--  DEFAULT - Specify a default value for column if no value is supplied on INSER
---------------------------------------------------------------------------------------------------------------------------------------
-- Unit Of Work (UOW) - A recoverable sequence of operations within an application process
-- 
-- BEGIN TRANSACTION - Mark the start of a unit of work
-- 
-- COMMIT - End a unit of work and save changes - automatically done if no errors
-- 
-- ROLLBACK - End a unit of work and undo changes - automatically done if errors
---------------------------------------------------------------------------------------------------------------------------------------
--  INSERT - add a row to a table
--
--  Format 1: INSERT INTO table-name 
--            (column-list)           -- must contain all non-null columns
--            VALUES(value-list)      -- order of values must match order of columns specified
--
--
--  Format 2: INSERT INTO table-name 
--            VALUES(value-list)      -- order of values must match order of columns as defined in the table
--
--
--  Format 3: INSERT INTO table-name 
--            (SELECT statement)      -- order of columns in the SELECT must match the order of columns as defined in the table
--                                    -- () are optional
--                                            
---------------------------------------------------------------------------------------------------------------------------------------
--  UPDATE - change data in a table
--
--  UPDATE table-name
--  SET column = new-value
--  WHERE condition            -- scope of update - if omitted, all rows are updated                                         
---------------------------------------------------------------------------------------------------------------------------------------
--  DELETE - Remove rows from a table
--
--  DELETE FROM table-name
--  WHERE condition            -- scope of delete - if omitted, all rows are deleted                                        
---------------------------------------------------------------------------------------------------------------------------------------
-- INSERT

-- 1. Add Klingon as a spoken language in the USA
insert into countrylanguage 
(countrycode, language, isofficial, percentage)
values ('USA', 'Klingon', true, 100)
;
update country
SET capital = (select id from city where name = 'Houston') -- subquery to find code for Houston
where code = 'USA'
;
delete from country
where code = 'USA'
;
select *
from countrylanguage
where countrycode = 'USA'
;
ROLLBACK; -- undo any changes done since the last commit/rollback

BEGIN TRANSACTION;
insert into countrylanguage 
        (countrycode,  language, isofficial, percentage)
values  ('USA'      , 'Klingon',       true, 100)
;
select *
from countrylanguage
where countrycode = 'USA'
;
ROLLBACK;


BEGIN TRANSACTION;
insert into countrylanguage 
values  ('USA', 'Klingon', true, 100) -- values must be in the same orer as the columns in the table
;
select *
from countrylanguage
where countrycode = 'USA'
;
ROLLBACK;

--
--
--**************************************** Creating a new table 
drop table is exists USA_INFO;          -- elete the USA_INFO
create table USA_INFO (like country);   -- create a new table that looks like the country table
insert into USA_INFO                    -- add to the USA_INFO table
select * from country where code = 'USA'-- all the 'USA' rows from country
;


-- 2. Add Klingon as a spoken language in Great Britain
BEGIN TRANSACTION;
insert into countrylanguage
(countrycode, language, isofficial, percentage)
values ('GBR', 'Klingon', true, 75.2)
;
select *
from countrylanguage
where language ='Klingon'
;
commit;


-- UPDATE

-- 1. Update the capital of the USA to Houston
BEGIN TRANSACTION;

update country
SET capital = (select id from city where name = 'Houston') -- subquery to find code for Houston
where code = 'USA'
;
SELect capital
from  country
where code = 'USA'
;
rollback;


-- 2. Update the capital of the USA to Washington DC and the head of state
BEGIN TRANSaction;

update country
set capital = (select id from city where name = 'Washington')
,  headofstate = 'Jason Lawrie'
where code = 'USA'
;
select *
from country
where code = 'USA'
;
rollback;

-- DELETE
select *
from country
where code IN (select countrycode from countrylanguage where language = 'French' And percentage > 20)

;

-- 1. Delete English as a spoken language in the USA
BEGIN transaction;

delete from countrylanguage
where language = 'English' AND countrycode = 'USA'
;
rollback;

-- 2. Delete all occurrences of the Klingon language 
BEGIN TRANSACTION;
delete from countrylanguage
where language = 'Klingon'
;
rollback;

-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.
BEGIN TRANSACTION;
insert into countrylanguage
(countrycode, language, isofficial,percentage)
values('CHN', 'Elvish', true, 100)
;
SELECT *
from countrylanguage
where language = 'Elvish'
;
rollback;
-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?
insert into countrylanguage
(countrycode, language, isofficial,percentage)
values('ZZZ', 'Elvish', true, 100)
;

-- 3. Try deleting the country USA. What happens?
delete from country
where code = 'USA'
;

-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA
insert into countrylanguage
(countrycode,langauge,isofficial,pencentage)
values ('USA','English', true, 50)
;

-- 2. Try again. What happens?

-- 3. Let's relocate the USA to the continent - 'Outer Space'
update country
set continent = 'Outer Space'
where code = 'USA'
;

-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.

-- 2. Try updating all of the cities to be in the USA and roll it back
