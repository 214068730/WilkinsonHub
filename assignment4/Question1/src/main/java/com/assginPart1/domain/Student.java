package com.assginPart1.domain;

import com.assginPart1.services.StudentInfo;

/**
 * Created by student on 2016/03/20.
 */
public class Student extends Person{

    private String studNumber;
    private String course;

    public Student(){}

    public Student(String studNumber,String course,String name,String surname,String gender,int age){
        super(name,surname,gender,age);
        this.studNumber = studNumber;
        this.course = course;
    }


    public void setStudNumber(String studNumber) {
        this.studNumber = studNumber;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStudNumber() {
        return studNumber;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studNumber='" + studNumber + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    public void displayStudentRecord() {
        System.out.println("studNumber='" + studNumber + '\'' + ", course='" + course+"\t"+super.toString());
    }
}
