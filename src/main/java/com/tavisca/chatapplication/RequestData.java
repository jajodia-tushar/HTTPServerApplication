package com.tavisca.chatapplication;

public class RequestData {

    private String requestMethod;
    private String reqeustResource;

    public RequestData(String requestMethod, String reqeustResource) {
        this.requestMethod = requestMethod;
        this.reqeustResource = reqeustResource;
        if(reqeustResource.equals("/"))
            this.reqeustResource = "/index.html";
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getReqeustResource() {
        return reqeustResource;
    }

    @Override
    public String toString() {
        return "A client has made a "+this.requestMethod +" request for " + this.reqeustResource ;
    }
}
