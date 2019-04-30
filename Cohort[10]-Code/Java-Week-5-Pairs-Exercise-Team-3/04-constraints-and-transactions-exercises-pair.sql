-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)

BEGIN TRANSACTION;
INSERT INTO city (name, countrycode, district, population)
VALUES ('Smallville', 'USA', 'Kansas', 45001)
;
SELECT name, countrycode, district, population
FROM city
WHERE name = 'Smallville'
;

--ROLLBACK;

-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.

BEGIN TRANSACTION;
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
VALUES ('USA', 'Kryptonese', false, 0.0001)
;
SELECT *
FROM countrylanguage
WHERE countrycode = 'USA'
;
--ROLLBACK;

-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.

BEGIN TRANSACTION;
UPDATE countrylanguage
SET language = 'Krypto-babble'
WHERE language = 'Kryptonese'
AND countrycode = 'USA'
;
COMMIT;

-- 4. Set the US captial to Smallville, Kansas in the country table.

BEGIN TRANSACTION;
UPDATE country
SET capital = (SELECT id FROM city WHERE id = 4081)
WHERE code = 'USA'
;
COMMIT;

-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

--it failed because we made smallville the capital of the USA on the country table
BEGIN TRANSACTION;
DELETE FROM city
WHERE id = 4081
;
COMMIT;

-- 6. Return the US captial to Washington.

BEGIN TRANSACTION;
UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Washington')
WHERE code = 'USA'
;
COMMIT;

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

--it succeeded becasue smallville is no longer used elsewhere
BEGIN TRANSACTION;
DELETE FROM city
WHERE id = 4081
;
COMMIT;

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)

BEGIN TRANSACTION;

UPDATE countrylanguage

SET isofficial = NOT isofficial
WHERE countrycode IN (SELECT code FROM country WHERE indepyear > 1800 AND indepyear < 1972)
;

COMMIT;

-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)

BEGIN TRANSACTION;
UPDATE city
SET population = ROUND(population/1000)
;
COMMIT;

-- 10. Assuming a country's surfacearea is expressed in miles, convert it to 
-- meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)

BEGIN TRANSACTION;
UPDATE country
SET surfacearea = surfacearea/.00062137
WHERE code IN (SELECT countrycode FROM countrylanguage WHERE percentage > 20.0 AND language = 'French')
;
COMMIT;
