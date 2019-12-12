package main;

import main.parser.Parser;
import main.parser.StudentsStatistics;
import main.student.Student;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser("target.txt");
        List<Student> students =  parser.Parse();

        StudentsStatistics statictic = new StudentsStatistics(students);

        System.out.println("Имя : Оценка");

        statictic.getStudentsAverageMoreThanPersentageOfStudentsHas(70.0)
                .stream()
                .forEach(x-> System.out.println(x.getFullName()+" : " + x.getAverageMark()));
    }
}



