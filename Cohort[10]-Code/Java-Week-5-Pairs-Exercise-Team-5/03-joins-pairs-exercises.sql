-- Write queries to return the following:
-- The following queries utilize the "world" database.

-- 1. The city name, country name, and city population of all cities in Europe with population greater than 1 million
-- (36 rows) 
SELECT city.name, country.name, city.population
FROM city
        inner join
        country 
      on country.code = city.countrycode
WHERE country.continent = 'Europe' and city.population > 1000000;      
      
-- 2. The city name, country name, and city population of all cities in countries where French is an official language and the city population is greater than 1 million
-- (2 rows)
SELECT city.name, country.name, city.population
FROM city
     inner join
     country
   on country.code = city.countrycode
    inner join
    countrylanguage
  on country.code = countrylanguage.countrycode
WHERE countrylanguage.language = 'French' and city.population > 1000000 and countrylanguage.isofficial = true;
-- 3. The name of the countries and continents where the language Javanese is spoken
-- (1 row)
SELECT co.name, co.continent
FROM country co
        inner join
        countrylanguage cl
     on co.code = cl.countrycode
 WHERE language = 'Javanese'; 
-- 4. The names of all of the countries in Africa that speak French as an official language
-- (5 row)
SELECT co.name
FROM country co
        inner join
        countrylanguage cl
      on co.code = cl.countrycode
WHERE language = 'French' and isofficial = 'true' and continent = 'Africa';
-- 5. The average city population of cities in Europe
-- (average city population in Europe: 287,684)
SELECT round(avg(ci.population):: numeric, 0) as avg_Europe_City_Pop
FROM city ci
       inner join
       country co
     on ci.countrycode = co.code
WHERE continent = 'Europe';
-- 6. The average city population of cities in Asia
-- (average city population in Asia: 395,019)
SELECT round(avg(ci.population)::numeric, 0)
FROM city ci
        inner join
        country co
      on ci.countrycode = co.code
WHERE continent = 'Asia';
        
-- 7. The number of cities in countries where English is an official language
-- (number of cities where English is official language: 523)
SELECT count(*)
FROM city ci
        inner join
        country co
      on ci.countrycode = co.code
        inner join
        countrylanguage cl
      on co.code = cl.countrycode
WHERE language = 'English' and isofficial = 'true';
-- 8. The average population of cities in countries where the official language is English
-- (average population of cities where English is official language: 285,809)
SELECT round(avg(ci.population)::numeric, 0)
FROM city ci
         inner join
        country co
      on ci.countrycode = co.code
        inner join
        countrylanguage cl
      on co.code = cl.countrycode
WHERE language = 'English' and isofficial = 'true';
-- 9. The names of all of the continents and the population of the continent’s largest city
-- (6 rows, largest population for North America: 8,591,309)
SELECT max(ci.population), continent
FROM city ci
        inner join
       country co
      on co.code = ci.countrycode
GROUP BY continent
ORDER BY 1 desc;
-- 10. The names of all of the cities in South America that have a population of more than 1 million people and the official language of each city’s country
-- (29 rows)
SELECT ci.name, language
FROM city ci
        inner join
        country co
      on co.code = ci.countrycode
        inner join
        countrylanguage cl
      on cl.countrycode = co.code
WHERE continent = 'South America' and ci.population > 1000000 and isofficial;