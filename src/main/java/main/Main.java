package main;

import main.parser.Parser;
import main.student.Student;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser("target.txt");
        List<Student> students =  parser.Parse();
    }
}
