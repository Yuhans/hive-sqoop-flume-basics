CREATE TABLE IF NOT EXISTS airports (
	iata STRING, 
	airport STRING, 
	city STRING, 
	state STRING, 
	country STRING, 
	lat DECIMAL, 
	long DECIMAL
	) 
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
STORED AS textfile;

LOAD DATA INPATH '/user/root/hive/hw1/dataset/airports.csv' OVERWRITE INTO TABLE airports;