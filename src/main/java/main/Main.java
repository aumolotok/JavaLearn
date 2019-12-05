package main;

import main.parser.Parser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser("target.txt");

        parser.Parse();
    }
}
