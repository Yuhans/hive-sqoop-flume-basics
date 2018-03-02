package com.epam.bigdata.hive.udf;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetOSFromUserAgentTest {

    private static final String stringToTest = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)";
    private GetOSFromUserAgent getOS = new GetOSFromUserAgent();

    @Test
    public void test() {
        assertEquals("UNKNOWN_OS", getOS.evaluate(null));
        assertEquals("Unknown", getOS.evaluate("random string"));
        assertEquals("Windows XP", getOS.evaluate(stringToTest));

    }
}