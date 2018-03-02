package com.epam.bigdata.hive.udf;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetBrowserFromUserAgentTest {

    private static final String stringToTest = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)";
    private GetBrowserFromUserAgent getBrowser = new GetBrowserFromUserAgent();

    @Test
    public void test() {
        assertEquals("UNKNOWN_BROWSER", getBrowser.evaluate(null));
        assertEquals("Unknown", getBrowser.evaluate("random string"));
        assertEquals("Internet Explorer 6", getBrowser.evaluate(stringToTest));

    }

}