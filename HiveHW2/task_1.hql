CREATE TEMPORARY TABLE IF NOT EXISTS cancelled_flights AS
	SELECT f.uniquecarrier AS carrier, COUNT(f.cancelled) AS cnt, a.city AS city FROM flights_2007 f
	JOIN airports a ON f.origin = a.iata
	WHERE f.cancelled <> 0
	GROUP BY f.uniquecarrier, a.city;
SELECT c.description AS carrier, SUM(cf.cnt) AS count, collect_list(cf.city) AS cities FROM cancelled_flights cf
JOIN carriers c ON cf.carrier = c.code
GROUP BY c.description
ORDER BY count DESC;