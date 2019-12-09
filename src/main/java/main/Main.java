package main;

import main.common.Subjects;
import main.parser.Parser;
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

        List<Student> sortedByTechAverage = students.stream()
                .sorted(new AverageComparator(Subjects.SubjectType.Tech))
                .collect(Collectors.toList());

        Stack<Double> marksValues = new Stack<Double>();
        sortedByTechAverage.stream().map( x -> x.getAverageForSubjectType(Subjects.SubjectType.Tech)).distinct().forEach( x-> marksValues.push(x));

        List<StudentAverageMarkInfo> markInfos = sortedByTechAverage.stream().map(st -> new StudentAverageMarkInfo(st.getFullName(), st.getAverageForSubjectType(Subjects.SubjectType.Tech))).collect(Collectors.toList());

        List<StudentAverageMarkInfo> good = new ArrayList<StudentAverageMarkInfo>();

        Double percents = 1.00;
        while (percents > 0.70){
            Double value = marksValues.pop();

            Double entrance = Double.valueOf(markInfos.stream().filter(x -> x.getAverageMark() == value).count());
            Double percentage = entrance / markInfos.size();
            percents -= percentage;

            markInfos.stream().filter(x -> x.getAverageMark() == value).forEach(x -> good.add(x));
        }








//        sortedByTechAverage.stream()
//                .forEach( st ->  System.out.println(st.getFullName() + " averTech " + st.getAverageForSubjectType(Subjects.SubjectType.Tech) ));

    }
}



