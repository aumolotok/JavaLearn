package main.student;

import org.jetbrains.annotations.NotNull;

public class StudentAverageMarkInfo implements Comparable<StudentAverageMarkInfo>{
    private String fullName;
    private Double averageMark;
    public double getAverageMark(){return averageMark;}
    public String getFullName(){return fullName;}

    public StudentAverageMarkInfo(String fullname, double averageMark/*, double percentage*/){
        this.fullName = fullname;
        this.averageMark = averageMark;
        //this.percentOfAll = percentage;
    }

    @Override
    public int compareTo(@NotNull StudentAverageMarkInfo studentAverageMarkInfo) {
        return averageMark.compareTo(studentAverageMarkInfo.getAverageMark());
    }
}
