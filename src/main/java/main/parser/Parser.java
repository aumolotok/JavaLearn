package main.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parser {

    private static String read(String fileName){
        String result = new String();
        try {
           result = new String(Files.readAllBytes(Paths.get(fileName)));
        }
        catch(IOException exception) {
            System.out.println("Error while reading file");
        }
        return result;
    }
}
