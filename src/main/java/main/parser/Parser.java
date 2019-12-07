package main.parser;

import main.common.Subjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class Parser {

    private String fileName;
    private String pattern = "((Ф|ф)амилия)(\\D+)((И|и)мя)(\\D+)((П|п)редмет)(\\D+)((О|о)ценка)";
    private PersonValidator validator = new PersonValidator();

    private List<String> read() throws IOException {
        List<String> lines =  Files.readAllLines(Paths.get(fileName));
        return lines;
    }

    public void Parse() throws IOException {
        List<String> lines = read().stream().filter( x -> !x.matches(pattern)).collect(Collectors.toList());

        List<List<String>> characteristics = new ArrayList<List<String>>();

        for(String line : lines){
            List<String> studentChars = Arrays.asList(line.split("\\s*\\|\\s*"));
            if(studentChars.size() == 4) {
                characteristics.add(studentChars);
            }
        }

        List<String> surnamesWithNames =  characteristics.stream().map( x -> x.get(0)+x.get(1)).distinct().collect(Collectors.toList());

        for(String person : surnamesWithNames){

        }

    }



    public Parser(String fileName){
        this.fileName = fileName;
    }


}
