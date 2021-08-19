package com.example.schoolmanagement;

public class Student {
    String regNo;
    String name;
    String branch;
    int marks;
    int percentage;

    public Student(){}

    public Student(String regNo, String name, String branch, int marks, int percentage) {
        this.regNo = regNo;
        this.name = name;
        this.branch = branch;
        this.marks = marks;
        this.percentage = percentage;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
