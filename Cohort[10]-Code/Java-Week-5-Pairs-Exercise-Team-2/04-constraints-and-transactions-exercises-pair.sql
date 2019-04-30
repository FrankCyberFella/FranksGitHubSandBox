-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)
BEGIN TRANSACTION;

INSERT INTO city
VALUES (DEFAULT, 'Smallville', 'USA', 'Kansas', 45001)
;

SELECT *
FROM city
WHERE district = 'Kansas'
;

COMMIT;

-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.

BEGIN TRANSACTION;

INSERT INTO countrylanguage
VALUES ('USA', 'Kryptonese', false, 0.0001)
;

SElECT language
FROM countrylanguage
WHERE countrycode = 'USA'
;

COMMIT;

-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.

BEGIN TRANSACTION;

UPDATE countrylanguage
SET language = 'Krypto-babble'
WHERE language = 'Kryptonese'
;

SElECT language
FROM countrylanguage
WHERE countrycode = 'USA'
;

COMMIT;


-- 4. Set the US captial to Smallville, Kansas in the country table.


BEGIN TRANSACTION;

UPDATE country
SET capital = (SELECT id from city where name = 'Smallville' and district = 'Kansas')
WHERE code = 'USA'
;


SELECT *
FROM country
WHERE code = 'USA'
;


COMMIT;

-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
BEGIN TRANSACTION;

DELETE FROM city 
WHERE name = 'Smallville' 
  and district = 'Kansas';
  
SELECT *
FROM city
WHERE district = 'Kansas'
;

COMMIT;

--It will not delete because to delete it violates foreign key contstraint


-- 6. Return the US captial to Washington.

BEGIN TRANSACTION;

UPDATE country
SET capital = (SELECT id from city where name = 'Washington' and district = 'District of Columbia')
WHERE code = 'USA'
;

SELECT *
FROM country
WHERE code = 'USA'
;


COMMIT;

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

BEGIN TRANSACTION;

DELETE FROM city 
WHERE name = 'Smallville' 
  and district = 'Kansas';
  
SELECT *
FROM city
WHERE district = 'Kansas'
;

COMMIT;

-- Yes, because USA changed its capital back to Washington, our country map was no longer a dependent on city providing the capital of USA

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)

BEGIN TRANSACTION;

UPDATE countrylanguage
SET isOfficial = false
WHERE isOfficial = true
AND countrycode IN (SELECT code from country where indepyear <= 1972 and indepyear >= 1800)
;

UPDATE countrylanguage
SET isOfficial = true
WHERE isOfficial = false
AND countrycode IN (SELECT code from country where indepyear <= 1972 and indepyear >= 1800)
;

COMMIT;

-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)
BEGIN TRANSACTION;

UPDATE city
SET population = round(population/1000)
;

SELECT *
FROM city;

COMMIT;


-- 10. Assuming a country's surfacearea is expressed in miles, convert it to 
-- meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)

BEGIN TRANSACTION;

UPDATE country 
SET surfacearea = surfacearea * 1609.344
WHERE code IN (SELECT countrycode from countrylanguage WHERE percentage >= 20.0 and language = 'French')
;

COMMIT;