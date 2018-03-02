CREATE TABLE IF NOT EXISTS carriers (
	code STRING, 
	description STRING
	) 
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde' 
STORED AS textfile;

LOAD DATA INPATH '/user/root/hive/hw1/dataset/carriers.csv' OVERWRITE INTO TABLE carriers;