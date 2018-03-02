package com.epam.bigdata.hive.udf;

import eu.bitwalker.useragentutils.UserAgent;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.udf.UDFType;

@Description(name = "DeviceExtractor")
@UDFType(deterministic = false)
public class GetDeviceFromUserAgent extends UDF {

    public String evaluate(String userAgentString) {
        return userAgentString == null ? "UNKNOWN_DEVICE" : UserAgent.parseUserAgentString(userAgentString).getOperatingSystem().getDeviceType().getName();
    }
}
