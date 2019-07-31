package com.tavisca.chatapplication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerClass {
        ServerSocket serverSocket;

        public ServerClass(int port) throws IOException{
            this.serverSocket = new ServerSocket(port);
            System.out.println("Server Started at Port "+port);
        }

        public ClientClass listen() throws IOException {
            Socket socket = this.serverSocket.accept();
            System.out.println("New Client Accepted");
            return new ClientClass(socket);
        }

        public void close() throws IOException {
            this.serverSocket.close();
        }
    }

