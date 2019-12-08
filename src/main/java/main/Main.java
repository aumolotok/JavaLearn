package main;

import main.common.Subjects;
import main.parser.Parser;
import main.student.Student;
import main.student.comparators.AverageComparator;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser("target.txt");
        List<Student> students =  parser.Parse();

        List<Student> sortedByTechAverage = students.stream()
                .sorted(new AverageComparator(Subjects.SubjectType.Tech))
                .collect(Collectors.toList());

//        sortedByTechAverage.stream()
//                .forEach( st ->  System.out.println(st.getFullName() + " averTech " + st.getAverageForSubjectType(Subjects.SubjectType.Tech) ));

    }
}



