package com.tavisca.chatapplication;
import java.io.IOException;

public class ClientHandlerThread extends Thread{
    private ClientWrapper client;
    private static final int STATUS_OK = 200;
    private static final int STATUS_NOT_FOUND= 404;

    public ClientHandlerThread(ClientWrapper client) {
        this.client = client;
    }

    @Override
    public void run() {
        try
        {
            Response response = prepareResponse();
            this.client.sendResponse(response);
            this.client.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Response prepareResponse(){
        FileHandler fileHandler = new FileHandler(this.client.getHttpRequest().getHttpRequestResource());
        byte[] contents = fileHandler.getFileContents();
        if(fileHandler.exists()){
            String header = PrepareHeader.prepare(contents.length,STATUS_OK, fileHandler.getFileExtension());
            return new Response(contents,header);
        }
        else{
            String header = PrepareHeader.prepare(contents.length,STATUS_NOT_FOUND, fileHandler.getFileExtension());
            return new Response(contents,header);
        }

    }
}
