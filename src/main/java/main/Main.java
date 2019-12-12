package main;

import main.common.Subjects;
import main.parser.Parser;
import main.parser.StudentsStatistics;
import main.student.Student;
import main.student.StudentAverageMarkInfo;
import main.student.comparators.AverageComparator;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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



