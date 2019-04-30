-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)

BEGIN TRANSACTION;
INSERT INTO city
(id, name, countrycode, district, population)
VALUES (4080, 'Smallville', 'USA', 'Kansas', 45001)
;

SELECT *
FROM city
WHERE name = 'Smallville';
COMMIT;


-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.

BEGIN TRANSACTION;
INSERT INTO countrylanguage
(countrycode, language, isofficial, percentage)
VALUES ('USA', 'Kryptonese', true, 0.0001);

SELECT *
FROM countrylanguage
WHERE language = 'Kryptonese';
COMMIT;

-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.

BEGIN TRANSACTION;
UPDATE countrylanguage
SET language = 'Krypto-babble'
WHERE language = 'Kryptonese';

SELECT *
FROM countrylanguage
WHERE language = 'Krypto-babble';
COMMIT;

-- 4. Set the US captial to Smallville, Kansas in the country table.

BEGIN TRANSACTION;
UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Smallville')
WHERE code = 'USA';

SELECT *
FROM country
WHERE code = 'USA';
COMMIT;

-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
BEGIN TRANSACTION;
DELETE FROM city
WHERE name = 'Smallville';
ROLLBACK;

--***Failed because of foreign key constraint, USA references it, aka Referential Integrity***

-- 6. Return the US captial to Washington.

BEGIN TRANSACTION;
UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Washington')
WHERE code = 'USA';

SELECT *
FROM country
WHERE code = 'USA';
COMMIT;

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

BEGIN TRANSACTION;
DELETE FROM city
WHERE name = 'Smallville';
COMMIT;

--***Succeeded because of an absence of dependency***

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)

BEGIN TRANSACTION;

UPDATE countrylanguage
SET isofficial = NOT isofficial
WHERE countrycode IN (SELECT code FROM country WHERE indepyear BETWEEN 1800 AND 1972);
COMMIT;

-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)
BEGIN transaction;

UPDATE city
SET population = (population::numeric/1000)::integer
;

SELECT population
FROM city
ORDER BY population DESC;

COMMIT;


-- 10. Assuming a country's surfacearea is expressed in miles, convert it to 
-- meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)

BEGIN TRANSACTION;

UPDATE country
SET surfacearea = (surfacearea * 1609.34)
WHERE code IN (SELECT countrycode FROM countrylanguage WHERE language = 'French' AND percentage > 20);

SELECT *
FROM country
WHERE code IN (SELECT countrycode FROM countrylanguage WHERE language = 'French' AND percentage > 20);
COMMIT;

