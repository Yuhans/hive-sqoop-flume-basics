create database sqoopTask;
use sqoopTask;
create table weather (stationId varchar(255), wdate date, tmin INT, tmax INT, snow INT, snwd INT, prop INT);
create table weather_interim (stationId varchar(255), wdate date, tmin INT, tmax INT, snow INT, snwd INT, prop INT);