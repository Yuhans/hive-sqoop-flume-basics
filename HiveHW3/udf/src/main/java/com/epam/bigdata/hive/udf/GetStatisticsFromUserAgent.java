package com.epam.bigdata.hive.udf;

import eu.bitwalker.useragentutils.UserAgent;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.UDFType;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.IntObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.StringObjectInspector;

import java.util.ArrayList;
import java.util.List;

@UDFType(deterministic = false)
@Description(name = "Statistics Extractor",
            value = "_FUNC_(cityid, useragent) - Explodes user_agent string to os, browser and device columns",
            extended = "Example:\n" +
                    "> SELECT statistics(cityid, useragent) from ipinyou_logs limit 1;" +
                    "1, Windows XP, IE8, Computer")
public class GetStatisticsFromUserAgent extends GenericUDTF {

    private final Object[] forwardObj = new Object[4];
    private ObjectInspector[] inputOIs;

    @Override
    @SuppressWarnings("deprecation")
    public StructObjectInspector initialize(ObjectInspector[] argOIs) throws UDFArgumentException {

        if (argOIs.length != 2) {
            throw new UDFArgumentException("UserAgent processor take two arguments -> cityId and user agent string");
        }
        inputOIs = argOIs;
        List<String> outFieldNames = new ArrayList<>();
        List<ObjectInspector> outFieldOIs = new ArrayList<>();
        outFieldNames.add("cityId");
        outFieldNames.add("os");
        outFieldNames.add("browser");
        outFieldNames.add("device");
        outFieldOIs.add(PrimitiveObjectInspectorFactory.javaIntObjectInspector);
        outFieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        outFieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        outFieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        return ObjectInspectorFactory.getStandardStructObjectInspector(outFieldNames, outFieldOIs);
    }

    @Override
    public void process(Object[] args) throws HiveException {
        Integer cityId = ((IntObjectInspector) inputOIs[0]).get(args[0]);
        String userAgentStr = ((StringObjectInspector) inputOIs[1]).getPrimitiveJavaObject(args[1]);
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentStr);
        forwardObj[0] = cityId;
        forwardObj[1] = userAgent.getOperatingSystem().getName();
        forwardObj[2] = userAgent.getBrowser();
        forwardObj[3] = userAgent.getOperatingSystem().getDeviceType().getName();

        forward(forwardObj);
    }

    @Override
    public void close() throws HiveException {

    }
}
