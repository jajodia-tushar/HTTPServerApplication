package com.tavisca.chatapplication;

import java.io.*;
import java.net.Socket;

public class ClientWrapper {
    private Socket socket;
    private HttpRequestWrapper requestData;

    public ClientWrapper(Socket socket) throws IOException {
        this.socket = socket;
        this.requestData = HttpRequestParser.parse(this.readHttpRequest());
    }

    private BufferedInputStream getInputStream() throws IOException {
        return new BufferedInputStream(this.socket.getInputStream());
    }

    private BufferedOutputStream getOutputStream() throws IOException {
        return new BufferedOutputStream((this.socket.getOutputStream()));
    }

    public void sendResponse(Response response) throws IOException{
        DataOutputStream dataOutputStream = new DataOutputStream(getOutputStream());
        dataOutputStream.writeBytes(response.getHeader());
        dataOutputStream.write(response.getContent());
        dataOutputStream.flush();
    }

    private String readHttpRequest() throws IOException {
        byte[] byteArray = new byte[2048];
        getInputStream().read(byteArray);
        return new String(byteArray);
    }

    public void close() throws IOException {
        this.socket.close();
    }

    public HttpRequestWrapper getHttpRequest()
    {
        return this.requestData;
    }
}
