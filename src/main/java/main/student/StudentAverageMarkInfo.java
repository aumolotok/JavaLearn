package main.student;

public class StudentAverageMarkInfo{
    private String fullName;
    private double averageMark;
   // double percentOfAll;
    public double getAverageMark(){return averageMark;}
    public String getFullName(){return fullName;}

    public StudentAverageMarkInfo(String fullname, double averageMark/*, double percentage*/){
        this.fullName = fullname;
        this.averageMark = averageMark;
        //this.percentOfAll = percentage;
    }
}
