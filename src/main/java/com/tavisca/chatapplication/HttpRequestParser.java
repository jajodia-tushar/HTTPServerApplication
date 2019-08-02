package com.tavisca.chatapplication;

public class HttpRequestParser {

    public static HttpRequestWrapper parse(String dataFromClient){
        String[] httpRequestParameters = dataFromClient.split(" ");
        return  new HttpRequestWrapper(httpRequestParameters[0],httpRequestParameters[1]);
    }
}
