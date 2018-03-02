CREATE TABLE IF NOT EXISTS flights_2007 (
	year INT, month INT, dayOfMonth INT, dayOfWeek INT, depTime INT, CRSDepTime INT, arrTime INT, CRSArrTime INT, uniqueCarrier STRING, 
	flightNum INT, tailNum STRING, actualElapsedTime INT, CRSElapsedTime INT, airTime INT, arrDelay INT, depDelay INT, origin STRING, 
	dest STRING, distance INT, taxiIn INT, taxiOut INT, cancelled INT, cancellationCode STRING, diverted INT, carrierDelay INT, 
	weatherDelay INT, NASDelay INT, securityDelay INT, lateAircraftDelay INT
	) 
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
STORED AS textfile;

LOAD DATA INPATH '/user/root/hive/hw1/dataset/2007.csv.bz2' OVERWRITE INTO TABLE flights_2007;