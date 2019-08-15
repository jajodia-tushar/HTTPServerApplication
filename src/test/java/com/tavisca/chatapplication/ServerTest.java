package com.tavisca.chatapplication;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServerTest {
    static Thread mainThread;

    @BeforeAll
   static void init(){
            mainThread = new Thread(()->{
                Server server = null;
                try {
                server = new Server(8888);
                while(true){
                    new ClientHandlerThread(server.listen()).start();
                }
            } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        server.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
        });
        mainThread.start();
    }

    @Test
    void canAcceptNewClient() throws Exception{
        URL url = new URL("http","localhost",8888,"index.html");
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
    }

    @Test
    void canAcceptMultipleClient(){
        try {
            for(int i = 0; i < 5 ;i++){
                URL url = new URL("http","localhost",8888,"index.html");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                assertEquals(200,urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void canRespondWithImages(){
        try {
            URL url = new URL("http","localhost",8888,"images/about.jpg");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            String expectedContentType = "image/jpg";
            String actualContentType = urlConnection.getHeaderField("Content-Type");

            assertEquals(expectedContentType,actualContentType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void canRespondClient(){
        try {
            URL url = new URL("http","localhost",8888,"index.html");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder content = new StringBuilder();
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                content.append(line);
            }
            assertTrue(content.toString().contains("html"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
