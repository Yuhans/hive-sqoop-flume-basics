#### DataSet
* [data](http://goo.gl/lwgoxw) 
    * Work only with this files:
        - imp.20131019.txt.bz2
        - imp.20131020.txt.bz2
        - imp.20131021.txt.bz2
        - imp.20131022.txt.bz2
        - imp.20131023.txt.bz2
        - imp.20131024.txt.bz2
        - imp.20131025.txt.bz2
        - imp.20131026.txt.bz2
        - imp.20131027.txt.bz2
        - city.en.txt

- [More detailed data description](http://contest.ipinyou.com/ipinyou-dataset.pdf)
    - The impression, click and conversion log data format.

    SN      |Column     |Example
    --------|-----------|--------:
    *1      |BidID          | 01530000008a77e7ac18823f5a4f5121   
    2       |Timestamp      | 20130218134701883
    3       |LogType        | 1
    *4      |iPinYouID      | 35605620124122340227135
    5       |User-Agent     | Mozilla/5.0 (compatible; MSIE 9.0;\Windows NT 6.1; WOW64; Trident/5.0)
    *6      |IP             | 118.81.189.
    *7      |RegionID       | 15
    8       |CityID         | 16
    9       |AdExchange     | 2
    *10     |Domain         | e80f4ec7f5bfbc9ca416a8c01cd1a049
    *11     |URL            | hz55b000008e5a94ac18823d6f275121
    12      |Anonymous URL  | null
    13      |Ad Slot ID     | 2147689...8764813
    14      |Ad Slot Width  | 300
    15      |Ad Slot Height | 250
    16      |Ad Slot Visibility| SecondView
    17      |Ad Slot Format |Fixed
    18      |Ad Slot Floor Price    |   0
    19      |Creative ID    | e39e178ffdf366606f8cab791ee56bcd
    *20     |Bidding Price  | 753
    *21     |Paying Price   | 15
    *22     |Landing Page URL   |   a8be178ffdf366606f8cab791ee56bcd
    23      |   Advertiser ID   |3358
    *24     |User Profile IDs   | 123,5678,3456
    
    - The city data format.
    
    SN      |Column     |Example
    --------|-----------|--------:
    *1      |id          | 206   
    2       |name        | shaoyang

Columns with * means the data in the column is hashed or modified before the log is released
### Tasks:
0. Write custom UDF which can parse any user agent (UA) string into separate fields 
1. Use data from you UDF and find most popular device, browser, OS for each city.

### Solution:
Firstly, you have to package attached project to jar, then move this jar to hdfs. Then you can just run attached script and get the result. One thing that you must specify path to jar in hql script.