package com.tavisca.chatapplication;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientClass {

    private Socket socket;

    public ClientClass(Socket socket){
        this.socket = socket;
    }

    public BufferedInputStream getInputStream() throws IOException {
        return new BufferedInputStream(this.socket.getInputStream());
    }

    public BufferedOutputStream getOutputStream() throws IOException {
        return new BufferedOutputStream((this.socket.getOutputStream()));
    }

    public void write(String data) throws IOException {
        BufferedOutputStream bufferedOutputStream = getOutputStream();
        bufferedOutputStream.write(data.getBytes());
        bufferedOutputStream.flush();

    }

    public String read() throws IOException {
        byte[] byteArray = new byte[2048];
        getInputStream().read(byteArray);
        return new String(byteArray);
    }

    public void close() throws IOException {
        this.socket.close();
    }
}
