package com.tavisca.chatapplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static RequestData parse(String dataFromClient){
        String[] arr = dataFromClient.split(" ");
        return  new RequestData(arr[0],arr[1]);

        //In future Add Exception
    }
}
