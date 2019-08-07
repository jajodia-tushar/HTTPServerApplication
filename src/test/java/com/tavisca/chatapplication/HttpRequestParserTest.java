package com.tavisca.chatapplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpRequestParserTest {

    @Test
    void canParseHttpRequest(){

        String httpRequest = "GET /index.html HTTP/1.1\n" +
                "User-Agent: Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\n" +
                "Host: www.tutorialspoint.com\n" +
                "Accept-Language: en-us\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Connection: Keep-Alive";

        HttpRequestWrapper httpRequestWrapper = HttpRequestParser.parse(httpRequest);
        assertEquals(httpRequestWrapper.getHttpRequestMethod(),"GET");
        assertEquals(httpRequestWrapper.getHttpRequestResource(),"/index.html");
    }
}
