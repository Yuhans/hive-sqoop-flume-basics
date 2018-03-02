package com.epam.bigdata.hive.udf;

import eu.bitwalker.useragentutils.UserAgent;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.udf.UDFType;

@Description(name = "OsExtractor")
@UDFType(deterministic = false)
public class GetOSFromUserAgent extends UDF {

    public String evaluate(String userAgentString) {
        return userAgentString == null ? "UNKNOWN_OS" : UserAgent.parseUserAgentString(userAgentString).getOperatingSystem().getName();
    }
}
