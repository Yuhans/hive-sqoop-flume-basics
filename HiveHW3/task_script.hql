ADD jar hdfs:///user/root/hive-udf.jar;
CREATE TEMPORARY FUNCTION stat AS 'com.epam.bigdata.hive.udf.GetStatisticsFromUserAgent';

CREATE TEMPORARY TABLE IF NOT EXISTS city_to_stats AS SELECT stat(cityid, useragent) FROM ipinyou_logs;

CREATE TEMPORARY TABLE IF NOT EXISTS city_os AS 
	SELECT c.name AS city, temp.os AS most_popular_os FROM (
		SELECT cityid, 
			os, 
			os_count, 
			RANK() OVER (PARTITION BY cityid ORDER BY os_count DESC) AS rnk
		FROM (
			SELECT cityid, 
				os, 
				count(cts.os) AS os_count 
			FROM city_to_stats cts 
			GROUP BY cityid, os
		) t
	) temp 
	JOIN citydict c ON temp.cityid = c.id 
	WHERE rnk = 1;
	
CREATE TEMPORARY TABLE IF NOT EXISTS city_browser AS 
	SELECT c.name AS city, temp.browser AS most_popular_browser FROM (
		SELECT cityid, 
			browser, 
			browser_count, 
			RANK() OVER (PARTITION BY cityid ORDER BY browser_count DESC) AS rnk
		FROM (
			SELECT cityid, 
				browser, 
				count(cts.browser) AS browser_count 
			FROM city_to_stats cts 
			GROUP BY cityid, browser
		) t
	) temp 
	JOIN citydict c ON temp.cityid = c.id 
	WHERE rnk = 1;

CREATE TEMPORARY TABLE IF NOT EXISTS city_device AS 
	SELECT c.name AS city, temp.device AS most_popular_device FROM (
		SELECT cityid, 
			device, 
			device_count, 
			RANK() OVER (PARTITION BY cityid ORDER BY device_count DESC) AS rnk
		FROM (
			SELECT cityid, 
				device, 
				count(cts.device) AS device_count 
			FROM city_to_stats cts 
			GROUP BY cityid, device
		) t
	) temp 
	JOIN citydict c ON temp.cityid = c.id 
	WHERE rnk = 1;
	
SELECT pos.city AS city, 
		pos.most_popular_os AS os, 
		b.most_popular_browser AS browser, 
		d.most_popular_device AS device 
FROM city_os pos 
JOIN city_browser b ON pos.city = b.city 
JOIN city_device d ON pos.city = d.city;
