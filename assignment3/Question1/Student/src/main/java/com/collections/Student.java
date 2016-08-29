package com.collections;

/**
 * Created by student on 2016/03/10.
 */
public class Student {

    private String studNumber;
    private String name;
    private String surname;
    private String course;


    public Student(){}

    public Student(String studNumber,String name,String surname,String course){
        this.studNumber = studNumber;
        this.name = name;
        this.surname = surname;
        this.course = course;

    }

    //Setters
    public void setStudNumber(String studNumber){
        this.studNumber = studNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    //Getters
    public String getStudNumber(){
        return this.studNumber;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getCourse() {
        return this.course;
    }


    public void display(){
        System.out.println("Student number:"+this.studNumber);
        System.out.println("Full name:"+this.name+"\t"+this.surname);
        System.out.println("Course:"+this.course);
    }


    public String toString()
    {

        return("Student Number:"+studNumber+"\t"+"Name:"+name+"Surname"+surname+"\t"+"Cousre"+course+"\n");
    }

}
