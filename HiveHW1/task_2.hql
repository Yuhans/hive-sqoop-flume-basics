SELECT COUNT(*) as cnt FROM flights_2007 f
JOIN airports a ON f.origin = a.iata
JOIN airports a2 ON f.dest = a2.iata
WHERE (a.city = 'New York' OR a2.city = 'New York') AND f.month = 6;