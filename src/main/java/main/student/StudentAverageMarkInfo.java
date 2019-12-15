package main.student;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class StudentAverageMarkInfo implements Comparable<StudentAverageMarkInfo>{
    private String fullName;
    private Double averageMark;
    public double getAverageMark(){return averageMark;}
    public String getFullName(){return fullName;}

    public StudentAverageMarkInfo(String fullname, double averageMark/*, double percentage*/){
        this.fullName = fullname;
        this.averageMark = averageMark;
    }

    @Override
    public int compareTo(@NotNull StudentAverageMarkInfo studentAverageMarkInfo) {
        return averageMark.compareTo(studentAverageMarkInfo.getAverageMark());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAverageMarkInfo that = (StudentAverageMarkInfo) o;
        return Objects.equals(fullName, that.fullName) &&
                Objects.equals(averageMark, that.averageMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, averageMark);
    }

    @Override
    public String toString(){
        return fullName + " " +  averageMark;
    }
}
