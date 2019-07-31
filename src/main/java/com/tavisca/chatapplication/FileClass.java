package com.tavisca.chatapplication;

import java.io.*;

public class FileClass {
    private String fileName;

    public FileClass(String fileName){
        this.fileName = fileName;
    }

    public boolean isValidPath(){
        File file  = new File("files/"+this.fileName);
        return file.exists();
    }

    public String getContents() {
        StringBuilder stringBuilder = new StringBuilder("");
        if(isValidPath()){
            try {
                File file  = new File("files/"+this.fileName);
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
}
