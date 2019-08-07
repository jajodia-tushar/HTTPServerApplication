package com.tavisca.chatapplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {

    @Test
    void canTellIfFileExistsOrNot(){

        FileHandler validFile = new FileHandler("index.html");
        assertTrue(validFile.exists());
        FileHandler inValidFile = new FileHandler("samsung.html");
        assertFalse(inValidFile.exists());
    }

    @Test
    void canGiveTheContentOfFile(){
        FileHandler fileHandler = new FileHandler("index.html");
        String contents = new String(fileHandler.getFileContents());
        assertFalse(contents.isEmpty());
    }

    @Test
    void canGiveTheTypeOfFile(){
        FileHandler fileHandler = new FileHandler("index.html");
        String fileType= fileHandler.getFileExtension();
        assertEquals("html",fileType);
    }
}
