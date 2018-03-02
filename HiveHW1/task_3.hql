SELECT COUNT(f.airport) as cnt, a.airport FROM (
	SELECT origin as airport FROM flights_2007
	WHERE month BETWEEN 6 AND 8 
	UNION ALL 
	SELECT dest as airport FROM flights_2007 
	WHERE month BETWEEN 6 AND 8
  ) f 
JOIN airports a ON f.airport = a.iata
WHERE a.country = "USA"
GROUP BY f.airport, a.airport
ORDER BY cnt DESC 
LIMIT 5;