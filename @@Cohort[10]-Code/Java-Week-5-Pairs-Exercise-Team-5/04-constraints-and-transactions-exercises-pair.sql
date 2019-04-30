-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)
BEGIN TRANSACTION;

INSERT into city(id, name, countrycode, district, population)
           values(4080, 'Smallville', 'USA', 'Kansas', 45001);
           
SELECT *
FROM city
WHERE countrycode = 'USA'
ORDER BY district asc;

COMMIT;
-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.
BEGIN TRANSACTION;

INSERT into countrylanguage(countrycode, language, isofficial, percentage)
                     values('USA', 'Kryptonese', false, .0001);
           
SELECT *
FROM countrylanguage
WHERE countrycode = 'USA';

COMMIT;

-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.
BEGIN TRANSACTION;

UPDATE countrylanguage set language = 'Krypto-babble'
WHERE language = 'Kryptonese';
                     
SELECT *
FROM countrylanguage
WHERE countrycode = 'USA';

COMMIT;


-- 4. Set the US captial to Smallville, Kansas in the country table.
SELECT id
FROM city
WHERE name = 'Smallville';

BEGIN TRANSACTION;

UPDATE country set capital = (SELECT id FROM city WHERE id = 4080)
WHERE code = 'USA';

SELECT code, name, capital
FROM country
WHERE code = 'USA';

COMMIT;
-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
BEGIN TRANSACTION;

DELETE from city where name = 'Smallville';

SELECT name, district
FROM city
WHERE name = 'Smallville';

ROLLBACK;

-- This doesn't work because update or delete on table "city" violates foreign key constraint "country_capital_fkey" on table "country"
--  Detail: Key (id)=(4080) is still referenced from table "country".

-- 6. Return the US captial to Washington.
BEGIN TRANSACTION;

UPDATE country set capital = (select id FROM city where name = 'Washington' and district = 'District of Columbia');

SELECT name, capital
FROM country
WHERE code = 'USA';

COMMIT;

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
BEGIN TRANSACTION;

DELETE from city where name = 'Smallville';

SELECT name, district
FROM city
WHERE district = 'Kansas';

COMMIT;
-- This worked because the city id of 'Smallville' is no longer a parent to country,capital

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)

BEGIN TRANSACTION;

UPDATE countrylanguage set isofficial = NOT isofficial
         WHERE countrycode in (SELECT code
                  FROM country 
                 WHERE indepyear > 1800 and indepyear < 1972);

SELECT language, isofficial
FROM countrylanguage;

COMMIT;


-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)
BEGIN TRANSACTION;

UPDATE city set population = round(population, -3)/ 1000;

SELECT name, population
FROM city;

COMMIT;


-- 10. Assuming a country's surfacearea is expressed in miles, convert it to 
-- meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)
BEGIN TRANSACTION;

UPDATE country set surfacearea = surfacearea * 1609.34 
WHERE code in (SELECT countrycode
               FROM  countrylanguage
              WHERE language = 'French' and percentage > 20
              );

SELECT surfacearea, cl.language, name
FROM country 
        inner join
        countrylanguage cl
      on country.code = cl.countrycode
 WHERE cl.language = 'French'
 GROUP BY name, surfacearea, cl.language
 ORDER BY name;

COMMIT;





