package com.tavisca.chatapplication;

import java.io.IOException;

public class ClientHandlerThread extends Thread{
    ClientClass clientClass;
    RequestData requestData;

    public ClientHandlerThread(ClientClass clientClass,RequestData requestData) {
        this.clientClass = clientClass;
        this.requestData = requestData;
    }

    @Override
    public void run() {
        try {
            if(this.requestData.getReqeustResource().equals("/index.html")){
                this.clientClass.write("You are entering a Valid Resource");
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
