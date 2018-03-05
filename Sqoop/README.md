### Tasks:

Sqoop:
    - Upload the weather data into your HDP sandbox's HDFS (Use the weather table dataset described [here](https://drive.google.com/drive/folders/1apQGvFWOUTBWYbUVuQ1BJi6udtqmm72t?usp=sharing)
    - Use sqoop to export all the data to MySQL (normally the credentials are root / hadoop. For more details and for specific version please refer to
    https://hortonworks.com/tutorial/learning-the-ropes-of-the-hortonworks-sandbox/#login-credentials )
    - Include a screenshot in your report with the result of the following queries run in MySQL:
    ```
            SELECT count(*) FROM weather;
            SELECT * FROM weather ORDER BY stationid, date LIMIT 10;
    ```

###	Solution:
Prepare MySQL with script from sqoop-mysql-prepare.sql (it creates db and tables).
Then execute shell script sqoop-start-export.sh (it starts sqoop job to exporting from local folder dataset into HDFS)
You can try to change number of mappers by providing -m 'number' flag to speed up export process. It depends on your machine, etc.
I tried export with 3 and 4 mappers, 4 mappers showed increasing of speed by 20 sec.