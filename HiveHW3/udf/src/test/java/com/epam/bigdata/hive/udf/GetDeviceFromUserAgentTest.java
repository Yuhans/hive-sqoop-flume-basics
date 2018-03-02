package com.epam.bigdata.hive.udf;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetDeviceFromUserAgentTest {

    private static final String stringToTest = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)";
    private GetDeviceFromUserAgent getDevice = new GetDeviceFromUserAgent();

    @Test
    public void test() {
        assertEquals("UNKNOWN_DEVICE", getDevice.evaluate(null));
        assertEquals("Unknown", getDevice.evaluate("random string"));
        assertEquals("Computer", getDevice.evaluate(stringToTest));

    }

}