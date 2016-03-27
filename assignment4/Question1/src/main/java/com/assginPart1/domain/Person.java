package com.assginPart1.domain;

/**
 * Created by student on 2016/03/20.
 */
public class Person {

    private String name;
    private String surname;
    private String gender;
    private int age;


    public Person(){}

    public Person(String name, String surname, String gender, int age) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", surname='" + surname + '\'' + ", gender='" + gender + '\'' + ", age=" + age;
    }
}
