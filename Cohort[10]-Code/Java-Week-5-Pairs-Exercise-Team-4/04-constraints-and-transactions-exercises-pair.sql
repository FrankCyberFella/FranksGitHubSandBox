-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)
BEGIN TRANSACTION;

INSERT INTO city
(name, district, countrycode, population)
VALUES('Smallville', 'Kansas', 'USA', 45001)
;

SELECT *
FROM city
WHERE name = 'Smallville'
;


COMMIT;
-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.
BEGIN TRANSACTION;

INSERT INTO countrylanguage
(countrycode, language, isofficial, percentage)
VALUES ('USA', 'Kryptonese', false, 0.0001)
;

SELECT *
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
  AND countrycode = 'USA'
;

SELECT *
FROM countrylanguage
WHERE countrycode = 'USA'
;

COMMIT;

-- 4. Set the US captial to Smallville, Kansas in the country table.
BEGIN TRANSACTION;

UPDATE country
SET capital = (SELECT id from city WHERE name = 'Smallville')
WHERE code = 'USA'
;

COMMIT;

SELECT capital from country
WHERE code = 'USA'
;



-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

BEGIN TRANSACTION;

DELETE FROM city
WHERE id = 4086;

COMMIT;  -- Did not succeed because city id is still referenced in the country table!

-- 6. Return the US captial to Washington.
BEGIN TRANSACTION;

UPDATE country 
set capital = 3813
WHERE code = 'USA'
;

COMMIT;

SELECT *
from country
WHERE code = 'USA'
;


-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

--  It did work because Smallville id was no longer being referenced in the country table.
BEGIN TRANSACTION;

DELETE FROM city
WHERE id = 4086;

COMMIT;



-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)
BEGIN TRANSACTION;

UPDATE countrylanguage
SET isofficial = NOT isofficial 
WHERE countrycode IN (SELECT code from country WHERE indepyear > 1800 and indepyear < 1972)

;

COMMIT;

-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)
BEGIN TRANSACTION;

UPDATE city
SET population = round(population / 1000)
;

SELECT population
FROM city
;

ROLLBACK;

-- 10. Assuming a country's surfacearea is expressed in miles, convert it to 
-- meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)
BEGIN TRANSACTION;

UPDATE country
SET surfacearea = (surfacearea / .00062137)
WHERE code IN (SELECT countrycode from countrylanguage WHERE language = 'French' and percentage > 20)
;

SELECT surfacearea
FROM country
WHERE code IN (SELECT countrycode FROM countrylanguage WHERE language = 'French' and percentage > 20); 

ROLLBACK;

