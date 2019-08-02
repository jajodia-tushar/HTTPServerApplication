package com.tavisca.chatapplication;

public class HttpRequestWrapper {
    private String httpRequestMethod;
    private String httpRequestResource;

    public HttpRequestWrapper(String httpRequestMethod, String httpRequestResource) {
        this.httpRequestMethod = httpRequestMethod;
        this.httpRequestResource = httpRequestResource;
        if(httpRequestResource.equals("/"))
            this.httpRequestResource = "/index.html";
    }

    public String getHttpRequestMethod() {// remove unused methods
        return httpRequestMethod;
    }

    public String getHttpRequestResource() {
        return httpRequestResource;
    }

}
