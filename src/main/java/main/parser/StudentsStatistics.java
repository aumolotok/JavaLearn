package main.parser;

import main.common.Subjects;
import main.student.Student;
import main.student.StudentAverageMarkInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class StudentsStatistics {

    private List<Student> students;

    public StudentsStatistics(List<Student> students){
        this.students = students;
    }

//    private List<Integer> getMarksValues(){
//
//    }

    private List<StudentAverageMarkInfo> getStudentsAverageMarkInfo(){
        return students.stream()
                .map(st -> new StudentAverageMarkInfo(st.getFullName(), st.getAverageForSubjectType(Subjects.SubjectType.Tech)))
                .collect(Collectors.toList());
    }

    public List<StudentAverageMarkInfo> getStudentsAverageMoreThanPersentageOfStudentsHas(Double percentage){
        List<StudentAverageMarkInfo> studentsmarks = getStudentsAverageMarkInfo();
        Stack<Double> marksValuesStack = new Stack<Double>();
        List<StudentAverageMarkInfo> result = new ArrayList<StudentAverageMarkInfo>();

        List<Double> marksValues =
                studentsmarks.stream()
                .map(st -> st.getAverageMark())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        marksValues.stream().forEach(val -> marksValuesStack.push(val));

        Double percent = 100.0d;
        while (percent > percentage){
            Double value = marksValuesStack.pop();

            Double entrance = Double.valueOf(marksValues.stream().filter(x -> x == value).count());
            Double percentageOfEntrance = (entrance / marksValues.size()) * 100;
            percent -= percentageOfEntrance;

            studentsmarks.stream().filter(x -> x.getAverageMark() == value).forEach(x -> result.add(x));

        }
        return result;
    }


}
