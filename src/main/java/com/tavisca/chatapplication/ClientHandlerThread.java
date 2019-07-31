package com.tavisca.chatapplication;
import java.io.IOException;

public class ClientHandlerThread extends Thread{
    private static final String OUTPUT_HEADERS = "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html\r\n" +
            "Content-Length: ";
    private static final String OUTPUT_END_OF_HEADERS = "\r\n\r\n";

    ClientClass clientClass;
    RequestData requestData;

    public ClientHandlerThread(ClientClass clientClass) {
        this.clientClass = clientClass;
        this.requestData = this.clientClass.getRequestedData();
    }

    @Override
    public void run() {
        try {
            FileClass file = new FileClass(this.requestData.getReqeustResource());
            if(file.isValidPath()){
                this.clientClass.write(OUTPUT_HEADERS + file.getContents().length() + OUTPUT_END_OF_HEADERS + file.getContents());
            }
            else{
                this.clientClass.write("You are not entering a Valid Resource");
            }
            this.clientClass.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
