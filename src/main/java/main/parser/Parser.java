package main.parser;

import main.common.Subjects;
import main.student.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Parser {

    private String fileName;
    private String pattern = "((Ф|ф)амилия)(\\D+)((И|и)мя)(\\D+)((П|п)редмет)(\\D+)((О|о)ценка)";
    private PersonValidator validator = new PersonValidator();

    private List<String> read() throws IOException {
        List<String> lines =  Files.readAllLines(Paths.get(fileName));
        return lines;
    }

    public List<Student> Parse() throws IOException {
        List<String> lines = read().stream().filter( x -> !x.matches(pattern)).collect(Collectors.toList());

        List<PersonSubjectMark> marks = new ArrayList<PersonSubjectMark>();

        for(String line : lines){
            if(!validator.isValidPersonString(line)){
                continue;
            }
            List<String> studentChars = Arrays.asList(line.split("\\s*\\|\\s*"));
            marks.add(new PersonSubjectMark(studentChars));
        }

        return combineMarksForStudents(marks);
    }

    public List<Student> combineMarksForStudents(List<PersonSubjectMark> personSubjectMarks){
        List<Student> students = new ArrayList<Student>();

        List<String> surnames = personSubjectMarks.stream()
                .map(x -> x.Surname)
                .distinct()
                .collect(Collectors.toList());

        for(String surname : surnames) {
            List<PersonSubjectMark> currentPersonMarks = personSubjectMarks.stream()
                    .filter(x -> x.Surname.equalsIgnoreCase(surname))
                    .collect(Collectors.toList());

            String name = currentPersonMarks.get(0).Name;

            Map<Subjects, Integer> marks = new HashMap<Subjects, Integer>();

            currentPersonMarks.stream()
                    .forEach(x -> marks.put(x.Subject, x.Mark));

            students.add(new Student(name, surname, marks));
        }

        return students;
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
