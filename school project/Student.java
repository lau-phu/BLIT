package com.helloworld;


import java.util.Arrays;

public class Student {

    private int id;
    private String fname;
    private String lname;
    private int subjectNum;
    private int grade;
    private String[] course;

    public Student(){

    }

    public Student(int id, String fname, String lname, int subjectNum, int grade) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.subjectNum = subjectNum;
        this.grade = grade;
        this.course = new String[subjectNum];
        for(int i = 0; i < subjectNum; i++){
            course[i] = null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getSubjectNum() {
        return subjectNum;
    }

    public void setSubjectNum(int num) {

      subjectNum=num;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String[] getCourse() {
        return course;
    }

    public void setCourse(int location, String subject) {
        course[location] = subject;
    }
    public void setCourse(String[] subject) {
        course = subject;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", subjectNum=" + subjectNum +
                ", grade=" + grade +
                ", course=" + Arrays.toString(course) +
                '}';
    }
}

