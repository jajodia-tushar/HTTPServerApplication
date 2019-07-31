package com.tavisca.chatapplication;

import java.io.IOException;

public class MainClass {

    public static void main(String[] args) {
        try {
            ServerClass server = new ServerClass(8888);
            while(true){
                ClientClass client = server.listen();
                ClientHandlerThread clientHandlerThread = new ClientHandlerThread(client);
                clientHandlerThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
