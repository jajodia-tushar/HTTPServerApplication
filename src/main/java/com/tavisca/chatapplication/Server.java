package com.tavisca.chatapplication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.*;
import java.util.logging.FileHandler;

public class Server {
    static Logger logger;
    FileHandler fileHandler;
        private ServerSocket serverSocket;
        public Server(int port) throws IOException{
            this.serverSocket = new ServerSocket(port);
            logger = Logger.getLogger(Server.class.getName());
            logger.info("Server has been started at port --->"+port);
            fileHandler = new FileHandler("default.log",true);
        }

        public ClientWrapper listen() throws IOException {
            Socket socket = this.serverSocket.accept();
            logger.addHandler(fileHandler);
            logger.info("A new Client has been Accepted");
            return new ClientWrapper(socket);
        }

        public void close() throws IOException {// see where thsi can be consumed or else remove this
            this.serverSocket.close();
        }
    }

