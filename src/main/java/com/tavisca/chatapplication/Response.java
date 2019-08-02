package com.tavisca.chatapplication;

public class Response {
    private byte[] content;
    private String header;

    public Response(byte[] content, String header) {
        this.content = content;
        this.header = header;
    }

    public byte[] getContent() {
        return content;
    }

    public String getHeader() {
        return header;
    }
}
