package main.student;

import main.common.Subjects;
import main.utils.NumberUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Student {
    private String name, surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    private Map<Subjects, Integer> subjectsMarks;

    public Map<Subjects, Integer> getSubjectsMarks() {
        return subjectsMarks;
    }

    public double getAverageForSubjectType(Subjects.SubjectType type){
        List<Subjects> techSubjects = Subjects.getSubjectsByType(type);

        Double unroundValue = techSubjects.stream().map(x -> subjectsMarks.get(x)).collect(Collectors.averagingDouble(num -> num));

        return NumberUtils.roundDouble(unroundValue, 3);
    }

    public String getFullName(){
        return name + " " + surname;
    }

    public Student(String name, String surname, Map<Subjects, Integer> marks){
        this.name = name;
        this.surname = surname;
        this.subjectsMarks = marks;
    }
}