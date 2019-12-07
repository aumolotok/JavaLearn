package main.student;

import main.common.Subjects;

import java.util.Map;

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

    public Student(String name, String surname, Map<Subjects, Integer> marks){
        this.name = name;
        this.surname = surname;
        this.subjectsMarks = marks;
    }
}