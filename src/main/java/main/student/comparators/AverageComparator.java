package main.student.comparators;

import main.common.Subjects;
import main.student.Student;

import java.util.Comparator;

public class AverageComparator implements Comparator<Student> {

    Subjects.SubjectType comparedAverageType;

    public AverageComparator (Subjects.SubjectType type){
        this.comparedAverageType = type;
    }

    @Override
    public int compare(Student st1, Student st2) {
        if (st1.getAverageForSubjectType(comparedAverageType) > st2.getAverageForSubjectType(comparedAverageType)) {return 1;}
        if (st1.getAverageForSubjectType(comparedAverageType) < st2.getAverageForSubjectType(comparedAverageType)) {return -1;}
        return 0;
    }
}
