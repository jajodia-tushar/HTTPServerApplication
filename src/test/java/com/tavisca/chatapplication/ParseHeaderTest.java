package com.tavisca.chatapplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ParseHeaderTest {

    @Test
    void canParse(){
        int contentLength = 2048;
        String type = "html";
        int status = 200;

        String expectedHeader = "HTTP/1.1 200 OK \r\nContent-Type: text/html \r\nContent-Length: 2048\r\n\r\n";
        String actualHeader = PrepareHeader.prepare(contentLength,status,type);
        assertArrayEquals(expectedHeader.toLowerCase().toCharArray(),actualHeader.toLowerCase().toCharArray());
    }

}
