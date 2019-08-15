package com.tavisca.chatapplication;

import java.io.IOException;

public class ServerCommunicationApp {
    public static void main(String[] args) {
        Server server = null;
        try {
            server = new Server(8888);
            while(true){
                ClientWrapper client = server.listen();
                ClientHandlerThread clientHandlerThread = new ClientHandlerThread(client);
                clientHandlerThread.start();
            }
        } catch (IOException e) {
            try {
                server.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();

        }
    }
}
