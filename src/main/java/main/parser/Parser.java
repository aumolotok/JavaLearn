package main.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class Parser {

    private String fileName;
    private String pattern = "((Ф|ф)амилия)(\\D+)((И|и)мя)(\\D+)((П|п)редмет)(\\D+)((О|о)ценка)";

    private List<String> read() throws IOException {
        List<String> lines =  Files.readAllLines(Paths.get(fileName));
        return lines;
    }

    public void Parse() throws IOException {
        List<String> lines = read().stream().filter( x -> !x.matches(pattern)).collect(Collectors.toList());
    }

    //

    public Parser(String fileName){
        this.fileName = fileName;
    }
}
