SELECT uniquecarrier, c.description, count(c.description) FROM flights_2007
JOIN carriers c ON flights_2007.uniquecarrier = c.code 
GROUP BY c.description, uniquecarrier;