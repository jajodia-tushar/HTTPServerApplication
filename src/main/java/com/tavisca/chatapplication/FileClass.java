package com.tavisca.chatapplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;

public class FileClass {
    private String fileName;

    public FileClass(String fileName){
        this.fileName = "files/"+fileName;
    }

    public boolean isValidPath(){
        File file  = new File(this.fileName);
        return file.exists();
    }

    public String getContents() {
        StringBuilder stringBuilder = new StringBuilder("");
        if(isValidPath()){
            try {
                File file  = new File(this.fileName);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public String getFileExtension(){
        int i = this.fileName.lastIndexOf(".");
        return this.fileName.substring(i+1);
    }

    public String getFileName(){
        return this.fileName;
    }
}
