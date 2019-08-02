package com.tavisca.chatapplication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
        private ServerSocket serverSocket;
        public Server(int port) throws IOException{
            this.serverSocket = new ServerSocket(port);
            System.out.println("Server Started at Port "+port);
        }

        public ClientWrapper listen() throws IOException {
            Socket socket = this.serverSocket.accept();
            System.out.println("New Client Accepted");
            return new ClientWrapper(socket);
        }

        public void close() throws IOException {// see where thsi can be consumed or else remove this
            this.serverSocket.close();
        }
    }

