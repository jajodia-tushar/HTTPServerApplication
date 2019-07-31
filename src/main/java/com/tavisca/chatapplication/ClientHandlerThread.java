package com.tavisca.chatapplication;
import java.io.IOException;

public class ClientHandlerThread extends Thread{
    private static  final String STATUS_LINE_OK = "HTTP/1.1 200 OK\r\n";
    private static  final String STATUS_LINE_ERROR = "HTTP/1.1 404 Not Found\r\n";

    private static  final String STATUS_SERVER_DETAILS = "Server: Java HTTPServer \r\n";


    private static  final String STATUS_CONTENT_TYPE= "Content-Type: text/html\r\n";

    private static final String STATUS_CONTENT_LENGTH = "Content-Length: ";

    private static final String STATUS_END_OF_HEADERS = "\r\n\r\n";

    private ClientClass clientClass;
    private RequestData requestData;

    public ClientHandlerThread(ClientClass clientClass) {
        this.clientClass = clientClass;
        this.requestData = this.clientClass.getRequestedData();
    }

    @Override
    public void run() {
        try {
            FileClass file = new FileClass(this.requestData.getReqeustResource());
            if(file.isValidPath()){
                String outputString = prepareResponse(file.getContents(),200,file.getFileExtension());
                System.out.println(outputString);
                this.clientClass.write(outputString);
            }
            else{
                String outputString = prepareResponse("Error Requested File Not Found",404,"");
                this.clientClass.write(outputString);
            }
            this.clientClass.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String prepareResponse(String content, int statusCode, String fileType){
        String finalString = "";
        if(statusCode == 200)
            finalString += STATUS_LINE_OK;
        else
            finalString += STATUS_LINE_ERROR;
        finalString += STATUS_SERVER_DETAILS;
        finalString += STATUS_CONTENT_TYPE.replace("html",fileType);
        finalString += STATUS_CONTENT_LENGTH + content.length() +"\r\n";
        finalString += STATUS_END_OF_HEADERS;
        finalString += content;
        return finalString;
    }
}
