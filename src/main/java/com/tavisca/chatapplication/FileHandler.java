package com.tavisca.chatapplication;

import java.io.*;

public class FileHandler {
    private String nameOfFile;

    public FileHandler(String nameOfFile){
        this.nameOfFile = "files/"+ nameOfFile;
    }

    public boolean exists(){
        java.io.File file  = new java.io.File(this.nameOfFile);
        return file.exists();
    }

    public byte[] getFileContents() {
        byte[] bytes = null; // What to do in this type of Situation
        if(exists()){
            try {
                java.io.File file  = new java.io.File(this.nameOfFile);
                FileInputStream fileInputStream = new FileInputStream(file);
                bytes = new byte[(int)file.length()];
                fileInputStream.read(bytes);
                return bytes;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                java.io.File file  = new java.io.File("files/errorFile.html");
                FileInputStream fileInputStream = new FileInputStream(file);
                bytes = new byte[(int)file.length()];
                fileInputStream.read(bytes);
                return bytes;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    public String getFileExtension(){
        int i = this.nameOfFile.lastIndexOf(".");
        return this.nameOfFile.substring(i+1);
    }
}
