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
            if(marksValuesStack.size() == 0){
                break;
            }

            Double value = marksValuesStack.pop();

            Double entrance = Double.valueOf(studentsmarks.stream().filter(x -> x .getAverageMark()== value).count());
            Double percentageOfEntrance = (entrance / studentsmarks.size()) * 100;

            if(marksValuesStack.size() == 0 && percent - percentageOfEntrance < percentage){
                break;
            }

            percent -= percentageOfEntrance;

            studentsmarks
                    .stream()
                    .filter(mark -> mark.getAverageMark() == value).forEach(x -> result.add(x));

        }
        return result;
    }


}
