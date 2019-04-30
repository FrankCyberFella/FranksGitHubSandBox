-- Write queries to return the following:
-- The following queries utilize the "world" database.

-- 1. The city name, country name, and city population of all cities in Europe with population greater than 1 million
-- (36 rows)

SELECT city.name AS city_name, country.name AS country_name, city.population
FROM city
INNER JOIN country ON country.code = city.countrycode
WHERE city.population > 1000000
AND continent = 'Europe'
;

-- 2. The city name, country name, and city population of all cities in countries where French is an official language and the city population is greater than 1 million
-- (2 rows)

SELECT city.name AS city_name, country.name AS country_name, city.population
FROM city
INNER JOIN country ON country.code = city.countrycode
INNER JOIN countrylanguage ON countrylanguage.countrycode = city.countrycode
WHERE city.population > 1000000
AND language = 'French'
AND isofficial = true
;

-- 3. The name of the countries and continents where the language Javanese is spoken
-- (1 row)

SELECT country.name, continent
FROM country
INNER JOIN countrylanguage ON countrylanguage.countrycode = country.code
WHERE language = 'Javanese'
;

-- 4. The names of all of the countries in Africa that speak French as an official language
-- (5 row)

SELECT country.name
FROM country
INNER JOIN countrylanguage ON countrylanguage.countrycode = country.code
WHERE language = 'French'
AND isofficial = true
AND continent = 'Africa'
;

-- 5. The average city population of cities in Europe
-- (average city population in Europe: 287,684)

SELECT avg(city.population)
FROM city
INNER JOIN country ON country.code = city.countrycode
WHERE continent = 'Europe'
;

-- 6. The average city population of cities in Asia
-- (average city population in Asia: 395,019)

SELECT avg(city.population)
FROM city
INNER JOIN country ON country.code = city.countrycode
WHERE continent = 'Asia'
;

-- 7. The number of cities in countries where English is an official language
-- (number of cities where English is official language: 523)

SELECT count(*)
FROM city
INNER JOIN countrylanguage ON countrylanguage.countrycode = city.countrycode
WHERE language = 'English'
AND isofficial = true
;

-- 8. The average population of cities in countries where the official language is English
-- (average population of cities where English is official language: 285,809)

SELECT avg(city.population)
FROM city
INNER JOIN countrylanguage ON countrylanguage.countrycode = city.countrycode
WHERE language = 'English'
AND isofficial = true
;

-- 9. The names of all of the continents and the population of the continent’s largest city
-- (6 rows, largest population for North America: 8,591,309)

SELECT continent, max(city.population)
FROM country
INNER JOIN city ON country.code = city.countrycode
GROUP BY continent
ORDER BY 2 DESC
;

-- 10. The names of all of the cities in South America that have a population of more than 1 million people and the official language of each city’s country
-- (29 rows)

SELECT city.name, language
FROM city
INNER JOIN country ON country.code = city.countrycode
INNER JOIN countrylanguage ON countrylanguage.countrycode = country.code
WHERE continent = 'South America'
AND city.population > 1000000
AND isofficial = true
;
