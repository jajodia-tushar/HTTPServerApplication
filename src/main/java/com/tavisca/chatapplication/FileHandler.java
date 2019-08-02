package com.tavisca.chatapplication;

import java.io.*;

public class FileHandler {
    private String fileName;

    public FileHandler(String fileName){
        this.fileName = "files/"+fileName;
    }

    public boolean exists(){
        java.io.File file  = new java.io.File(this.fileName);
        return file.exists();
    }

    public byte[] getFileContents() {
        byte[] bytes = null; // What to do in this type of Situation
        if(exists()){
            try {
                java.io.File file  = new java.io.File(this.fileName);
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
        int i = this.fileName.lastIndexOf(".");
        return this.fileName.substring(i+1);
    }
}
