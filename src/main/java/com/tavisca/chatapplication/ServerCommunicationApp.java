package com.tavisca.chatapplication;

import java.io.IOException;

public class ServerCommunicationApp {

    public static void main(String[] args) {
        try {
            Server server = new Server(8888);
            while(true){
                ClientWrapper client = server.listen();
                ClientHandlerThread clientHandlerThread = new ClientHandlerThread(client);
                clientHandlerThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
