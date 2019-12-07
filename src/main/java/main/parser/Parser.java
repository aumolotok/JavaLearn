package main.parser;

import main.common.Subjects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        List<PersonSubjectMark> marks = new ArrayList<PersonSubjectMark>();

        for(String line : lines){
            if(!validator.isValidPersonString(line)){
                continue;
            }
            List<String> studentChars = Arrays.asList(line.split("\\s*\\|\\s*"));
            marks.add(new PersonSubjectMark(studentChars));
        }
    }

    public void combineMarksForStudents(List<PersonSubjectMark> p){

    }

    public Parser(String fileName){
        this.fileName = fileName;
    }

    private class PersonSubjectMark {
        public String Name;
        public String Surname;
        public Subjects Subject;
        public int Mark;

        public PersonSubjectMark(List<String> personCharacteristics){
            this.Surname = personCharacteristics.get(0);
            this.Name = personCharacteristics.get(1);
            this.Subject = Subjects.getByTitle(personCharacteristics.get(2));
            this.Mark = Integer.parseInt(personCharacteristics.get(3));
        }
    }
}
