SELECT c.description, COUNT(*) as cnt FROM flights_2007 f
JOIN carriers c ON f.uniquecarrier = c.code
GROUP BY c.description
ORDER BY cnt DESC 
LIMIT 1;