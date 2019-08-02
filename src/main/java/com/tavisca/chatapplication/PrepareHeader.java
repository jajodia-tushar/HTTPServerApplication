package com.tavisca.chatapplication;

public class PrepareHeader {

    private static final String header = "HTTP/1.1 " + "status" + "\r\n" +
            "Content-Type: type/extension \r\n" +
            "Content-Length: " + "length" + "\r\n" +
            "\r\n";

    public static String prepare(int contentLength,int status, String fileType){

        String finalString;

        if(status == 200)
            finalString = header.replace("status",status+" OK ");
        else
            finalString = header.replace("status",status+" Not Found ");

        if(fileType.equals("jpg") || fileType.equals("png") || fileType.equals("gif") || fileType.equals("jpeg"))
            finalString = finalString.replace("type/extension","image/"+fileType);
        else
            finalString = finalString.replace("type/extension","text/"+fileType);

        return finalString.replace("length",contentLength+"");
    }
}
